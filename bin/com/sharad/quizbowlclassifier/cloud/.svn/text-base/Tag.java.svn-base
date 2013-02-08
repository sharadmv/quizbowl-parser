package com.sharad.quizbowlclassifier.cloud;

public class Tag<T> {
	private T t;
	private int frequency;

	public Tag(T t, int frequency) {
		this.t = t;
		this.frequency = frequency;
	}

	public T getT() {
		return t;
	}

	public int getFrequency() {
		return frequency;
	}

	public boolean equals(Tag<?> t) {
		return getT().equals(t.getT());
	}

	public String toString() {
		return "[" + t.toString() + "," + frequency + "]";
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
