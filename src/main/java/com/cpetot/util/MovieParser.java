package com.cpetot.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class MovieParser {

	private MovieParser() {
		// Util
	}

	public static List<String> parse(String movies) {
		return Arrays.asList(movies.split(","));
	}

	public static String toString(List<String> movies) {
		return StringUtils.join(movies, ",");
	}
}
