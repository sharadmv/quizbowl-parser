package com.sharad.quizbowlclassifier.parser;

import java.io.File;
import java.util.List;

import com.sharad.quizbowlclassifier.parser.question.Tossup;

public class Main {

	static final String userid = "tpclubsc_quiz";
	static final String password = "tpat";
	static final String url = "jdbc:mysql://74.220.207.141:3306/tpclubsc_quizbowl";

	/**
	 * @param args
	 * @throws Throwable
	 */
	static List<Tossup> tossups;

	public static void main(String[] args) throws Throwable {
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
					if (files[i].listFiles()[j].isDirectory()) {
						for (int j2 = 0; j2 < files[i].listFiles()[j]
								.listFiles().length; j2++) {

							System.out.println(files[i].listFiles()[j]
									.listFiles()[j2].getName());
							tossups = parser.parseAndAddToDB(files[i]
									.listFiles()[j].listFiles()[j2], tour,
									year,
									files[i].listFiles()[j].listFiles()[j2]
											.getName(), dif, false, false);
						}
					}

				}
			}
		}

		System.out.println(tossups);
	}
}
