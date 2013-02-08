package com.sharad.quizbowlclassifier.parser.question;

import java.util.List;

public class ThreePartBonus extends Bonus {
	private BonusPart one, two, three;

	public ThreePartBonus(String lead, BonusPart one, BonusPart two,
			BonusPart three) {
		this(lead,one,two,three,"",0,"","",0);
	}
	
	public ThreePartBonus(String lead, BonusPart one, BonusPart two,
			BonusPart three, String tour, int year,
			String round, String dif,int count) {
		setLead(lead);
		this.one = one;
		this.two = two;
		this.three = three;
	}

	public ThreePartBonus() {
		
	}

	@Override
	public String toString() {
		return getLead() + "\n" + one + "\n" + two + "\n" + three + "\n";
	}

	public BonusPart getOne() {
		return one;
	}

	public BonusPart getTwo() {
		return two;
	}

	public BonusPart getThree() {
		return three;
	}

	@Override
	public void setParts(List<BonusPart> parts) {
		this.parts = parts;
		one = parts.get(0);
		two = parts.get(1);
		three = parts.get(2);
	}
}
