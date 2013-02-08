package com.sharad.quizbowlclassifier.parser.question;

public class Answer {
	private String answer;

	public Answer() {

	}

	public Answer(String answer) {
		this.setAnswer(answer);
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public String toString() {
		return answer;
	}
}
