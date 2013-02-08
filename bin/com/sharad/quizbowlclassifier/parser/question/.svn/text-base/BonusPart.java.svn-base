package com.sharad.quizbowlclassifier.parser.question;

public class BonusPart {
	private int value;
	private String body;
	private Answer answer;
	public BonusPart(){
		this(10,"",new Answer(""));
	}
	public BonusPart(int value, String body, Answer answer) {
		this.value = value;
		this.body = body;
		this.answer = answer;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public String toString(){
		return "["+value+"] "+body+"\n"+"ANSWER: "+answer;
	}
}
