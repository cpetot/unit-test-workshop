package com.cpetot.enums;

public enum ContentRating {

	TOUT_PUBLIC(0),
	PG_12(12),
	PG_16(16),
	PG_18(18);

	private final Integer minAge;

	ContentRating(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer minAge() {
		return this.minAge;
	}

}
