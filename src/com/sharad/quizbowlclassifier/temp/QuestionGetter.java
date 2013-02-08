package com.sharad.quizbowlclassifier.temp;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sharad.quizbowlclassifier.category.CategoryList;
import com.sharad.quizbowlclassifier.category.Supercategory;
import com.sharad.quizbowlclassifier.cloud.Tag;
import com.sharad.quizbowlclassifier.cloud.TagCloud;
import com.sharad.quizbowlclassifier.parser.QuestionParser;
import com.sharad.quizbowlclassifier.parser.question.Answer;
import com.sharad.quizbowlclassifier.parser.question.Tossup;
import com.sharad.quizbowlclassifier.util.CloudUtil;

public class QuestionGetter {
	static final String userid = "sharad";
	static final String password = "password";
	static final String url = "jdbc:mysql://23.23.188.247:3306/quizbowl";
	static List<Tossup> tossups, questions;
	static CategoryList cats = new CategoryList();

	public static void main(String[] args) throws Throwable {
		tossups = new ArrayList<Tossup>();
		questions = new ArrayList<Tossup>();
		QuestionParser parser = new QuestionParser(url, userid, password);
		String tour = "";
		int year = 0;
		String dif = "";
		File directory = new File("questions/");
		File[] files = directory.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				dif = files[i].getName();

				for (int j = 0; j < files[i].listFiles().length; j++) {
					year = Integer.parseInt(files[i].listFiles()[j].getName()
							.substring(0, 4));
					tour = files[i].listFiles()[j].getName().substring(5);
					Connection con = getOracleJDBCConnection();
					PreparedStatement stmt = null;
					String query = "insert into tournament(name, year) values('"
							+ tour + "', " + year + ")";
					try {
						stmt = (PreparedStatement) con.prepareStatement(query);
						stmt.execute();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (files[i].listFiles()[j].isDirectory()) {
						for (int j2 = 0; j2 < files[i].listFiles()[j]
								.listFiles().length; j2++) {
							String round = files[i].listFiles()[j].listFiles()[j2]
									.getName();
							query = "insert into round(round, tournament) values('"
									+ round
									+ "', (select id from tournament where year="
									+ year + " and name='" + tour + "'))";
							try {
								stmt = (PreparedStatement) con
										.prepareStatement(query);
								stmt.execute();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							System.out.println(query);
							questions.addAll(parser.parseAndAddToDB(files[i]
									.listFiles()[j].listFiles()[j2], tour,
									year,
									files[i].listFiles()[j].listFiles()[j2]
											.getName(), dif, false, false));
							System.out.println("Round done!");

						}

					}
					con.close();

				}
			}
		}

		// System.out.println(questions);
		Connection con = null;
		try {
			con = getOracleJDBCConnection();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		if (con != null) {
			List<Supercategory> categories = new ArrayList<Supercategory>();
			String q = "select distinct category from tossups";
			Statement s = (Statement) con.createStatement();
			System.out.println("Querying...");
			ResultSet result = s.executeQuery(q);
			while (result.next()) {
				System.out.println(result.getString("category"));
				categories.add(new Supercategory(result.getString("category")));
			}
			q = "select count(*) from tossups";
			s = (Statement) con.createStatement();
			System.out.println("Querying...");
			result = s.executeQuery(q);
			double dbCount = 0;
			while (result.next()) {
				dbCount = result.getInt(1);
				System.out.println(dbCount);
			}
			tossups = new ArrayList<Tossup>();
			for (Supercategory sc : categories) {
				q = "select * from tossups where category like '"
						+ sc.getName() + "' order by rand() limit 400";
				System.out.println(q);
				s = (Statement) con.createStatement();
				System.out.println("Querying...");
				result = s.executeQuery(q);
				while (result.next()) {
					Tossup t = new Tossup(result.getString("question"),
							new Answer(result.getString("answer")),
							result.getString("tournament"),
							result.getInt("year"), result.getString("round"),
							result.getString("difficulty"),
							result.getInt("question_num"), new Supercategory(
									result.getString("category")));
					tossups.add(t);
				}
			}
			for (int i = 0; i < questions.size(); i++) {
				try {
					String query = "insert into tossup(tournament,question,answer,round,difficulty,question_num,category) values("
							+ "(select id from tournament where year="
							+ questions.get(i).getYear()
							+ " and name='"
							+ replaceInvalidCharacters(questions.get(i)
									.getTour())
							+ "')"

							+ ",'"
							+ replaceInvalidCharacters(questions.get(i)
									.getBody())
							+ "','"
							+ replaceInvalidCharacters(questions.get(i)
									.getAnswer().getAnswer())
							+ "',"
							+ "(select id from round where round='"
							+ replaceInvalidCharacters(questions.get(i)
									.getRound())
							+ "' and tournament="
							+ "(select id from tournament where year="
							+ questions.get(i).getYear()
							+ " and name='"
							+ replaceInvalidCharacters(questions.get(i)
									.getTour())
							+ "'))"
							+ ",'"
							+ questions.get(i).getDif()
							+ "','"
							+ questions.get(i).getCount()
							+ "','"
							+ getSupercategory(questions.get(i)) + "')";
					System.out.println(query);

					if (true) {
						PreparedStatement stmt = null;
						try {
							stmt = (PreparedStatement) con
									.prepareStatement(query);
							stmt.execute();

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				} catch (Throwable e) {
					// System.out.println(tossups.get(i).getBody());
				}
			}
		}

	}

	public static Connection getOracleJDBCConnection() throws Throwable {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(url, userid, password);
		return con;
	}

	public static TagCloud<Tag<String>> getTagCloud(String s) {
		String[] words = { "a", "on", "one", "of", "and", "this", "the", "at",
				"as", "its", "he", "for", "in", "to", "an", "was", "about",
				"by", "are", "am", "is", "after", "were", "can", "it", "with",
				"that", "or", "which", "this", "more" };
		String string = s.toLowerCase().replaceAll("[,]", "")
				.replaceAll("[/]", " ").replaceAll("'s", "")
				.replaceAll("�s", "").replaceAll("[\"]", "")
				.replaceAll("[�]", "").replaceAll("[�]", "")
				.replaceAll("[.]", " ").replaceAll("[?]", "");
		for (int i = 0; i < words.length; i++) {
			string = string.replaceAll(" " + words[i] + " ", " ");
		}

		String[] temp = string.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (temp[0].equals(words[i])) {
				string = string.substring(temp[0].length()).trim();
				temp = string.split(" ");
			}
		}
		temp = string.split(" ");

		TagCloud<Tag<String>> cloud = new TagCloud<Tag<String>>();
		for (int i = 0; i < temp.length; i++) {
			if (!temp[i].equals(""))
				cloud.add(new Tag<String>(temp[i], 1));
		}

		return cloud;
	}

	public static Supercategory getSupercategory(Tossup s) {
		List<List<Tossup>> toss = new ArrayList<List<Tossup>>();
		List<List<Double>> ds = new ArrayList<List<Double>>();
		for (Supercategory cat : cats.getSupers()) {
			List<Tossup> temp = new ArrayList<Tossup>();
			for (Tossup t : tossups) {
				if (t.getCategory().equals(cat)) {
					temp.add(t);

				}
			}
			toss.add(temp);
		}
		for (List<Tossup> l : toss) {
			List<Double> temp = new ArrayList<Double>();
			for (Tossup t : l) {
				temp.add(CloudUtil.getTagCloudDistance(
						getTagCloud(s.getBody()), getTagCloud(t.getBody())));

			}
			ds.add(temp);
		}

		List<Double> finaldis = new ArrayList<Double>();
		for (List<Double> lis : ds) {
			Collections.sort(lis);
			double weight = 0;
			for (int i = 0; i < 3; i++) {
				weight += lis.get(i) * 1 / Math.pow(2, i);
			}
			finaldis.add(weight);
		}
		System.out.println(cats.getSupers().get(
				finaldis.indexOf(Collections.min(finaldis))));
		return cats.getSupers()
				.get(finaldis.indexOf(Collections.min(finaldis)));
	}

	public static String replaceInvalidCharacters(String s) {
		return s.replaceAll("�", "\'").replaceAll("[']", "''");

	}

}
