package com.sharad.quizbowlclassifier.parser.question;

import com.sharad.quizbowlclassifier.category.Category;
import com.sharad.quizbowlclassifier.category.Supercategory;
import com.sharad.quizbowlclassifier.cloud.Tag;
import com.sharad.quizbowlclassifier.cloud.TagCloud;

public class Tossup {
	private Answer answer;
	private String body;
	private String tour;
	private int year;
	private String round;
	private String dif;
	private int count;
	private Supercategory category;
	private TagCloud<Tag<String>> cloud;

	public Tossup() {
		this("", new Answer());
	}

	public Tossup(String body, Answer answer) {
		this(body, answer, "", 0, "", "", 0, null);
	}

	public Tossup(String body, Answer answer, String tour, int year,
			String round, String dif) {
		this(body, answer, tour, year, round, dif, 0, null);

	}

	public Tossup(String body, Answer answer, String tour, int year,
			String round, String dif, int count, Supercategory category) {
		this(body, answer, tour, year, round, dif, count, category, null);
	}

	public Tossup(String body, Answer answer, String tour, int year,
			String round, String dif, int count, Supercategory category,
			TagCloud<Tag<String>> cloud) {
		this.body = body;
		this.answer = answer;
		this.tour = tour;
		this.year = year;
		this.round = round;
		this.dif = dif;
		this.count = count;
		this.cloud = cloud;
		this.setCategory(category);
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public TagCloud<Tag<String>> getCloud() {
		return cloud;
	}

	public void setCloud(TagCloud<Tag<String>> cloud) {
		this.cloud = cloud;
	}

	public Answer getAnswer() {
		return answer;
	}

	public String toString() {
		return count + ". " + body + "\n" + "ANSWER: " + answer+" ["+category+"]";
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTour() {
		return tour;
	}

	public void setTour(String tour) {
		this.tour = tour;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public String getDif() {
		return dif;
	}

	public int getCount() {
		return count;
	}

	/**
	 * @param supercategory
	 *            the category to set
	 */
	public void setCategory(Supercategory supercategory) {
		this.category = supercategory;
	}

	/**
	 * @return the category
	 */
	public Supercategory getCategory() {
		return category;
	}

	public void setDif(String dif) {
		this.dif = dif;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
