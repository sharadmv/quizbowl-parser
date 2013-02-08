package com.sharad.quizbowlclassifier.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sharad.quizbowlclassifier.cloud.Tag;
import com.sharad.quizbowlclassifier.cloud.TagCloud;

public class CloudUtil {
	public static TagCloud<Tag<String>> joinTagCloud(TagCloud<Tag<String>> a,
			TagCloud<Tag<String>> b) {
		for (Tag<String> tag : b) {
			a.add(tag);
		}
		return a;
	}

	public static double getTagCloudDistance(TagCloud<Tag<String>> a,
			TagCloud<Tag<String>> b) {
		List<Double> leven = new ArrayList<Double>(), temp = new ArrayList<Double>();
		for (Tag<String> tag1 : a) {
			int freq = 0;
			for (Tag<String> tag2 : b) {
				freq = tag2.getFrequency();
				temp.add(StringUtil.levenshteinDistance(tag1.getT(),
						tag2.getT()));
			}
			if (temp.size() != 0)
				leven.add(Collections.min(temp)
						/** Math.abs(tag1.getFrequency() - freq)*/);
			else
				leven.add(10.);
			temp = new ArrayList<Double>();
		}
		return StatsUtil.mean(leven);
	}

}
