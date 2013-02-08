package com.sharad.quizbowlclassifier.util;

import java.util.Collection;

public class StatsUtil {
	public static double mean(Collection<Double> c) {
		double sum = 0;
		Double[] list = new Double[c.size()];
		for (int i = 0; i < c.size(); i++) {
			sum += c.toArray(list)[i];
		}
		return sum / c.size();
	}

	public static double stdev(Collection<Double> c) {
		double mean = mean(c);
		double sum = 0;
		Double[] list = new Double[c.size()];
		for (int i = 0; i < c.size(); i++) {
			sum += Math.pow((c.toArray(list)[i] - mean), 2);
		}
		return Math.sqrt(sum / (c.size() - 1));
	}
}
