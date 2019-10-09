package br.com.hackathon.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author alexiadorneles
 * @email alexiadorneles02@gmail.com
 */

public abstract class PaginatedSearchUtils {
	private PaginatedSearchUtils() {
	}

	public static Sort getDescendentSorter(String property) {
		return new Sort(new Sort.Order(Sort.Direction.DESC, property));
	}

	public static PageRequest getDescendentPageRequest(int page, int size, String property) {
		return new PageRequest(page, size, getDescendentSorter(property));
	}
}
