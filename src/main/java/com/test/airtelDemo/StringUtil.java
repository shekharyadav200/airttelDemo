package com.test.airtelDemo;

public class StringUtil {

	public static String replaceSpecialCharcter(String word) {
		if (word != null && !word.isEmpty()) {
			return word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		}
		return "";

	}
}