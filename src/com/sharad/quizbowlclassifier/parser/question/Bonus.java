package com.sharad.quizbowlclassifier.parser.question;

import java.util.List;

public abstract class Bonus {
	protected List<BonusPart> parts;
	private String lead;

	public abstract String toString();

	public abstract void setParts(List<BonusPart> parts);

	public List<BonusPart> getParts() {
		return parts;
	}

	public void setLead(String lead) {
		this.lead = lead;
	}

	public String getLead() {
		return lead;
	}
}
