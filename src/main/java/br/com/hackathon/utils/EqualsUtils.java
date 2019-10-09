package br.com.hackathon.utils;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public abstract class EqualsUtils {
	private EqualsUtils() {
	}

	public static boolean equals(Object objectOne, Object objectTwo) {
		return EqualsBuilder.reflectionEquals(objectOne, objectTwo);
	}
}
