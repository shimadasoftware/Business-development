package com.usta.cmapp.constants;

public enum EnumRHBlood {
	
	ABPOSITIVE("AB+", "ABPOSITIVE"),
	ABNEGATIVE("AB-", "ABNEGATIVE"),
	APOSITIVE("A+", "APOSITIVE"),
	ANEGATIVE("A-", "ANEGATIVE"),
	BPOSITIVE("B+", "BPOSITIVE"),
	BNEGATIVE("B-", "BNEGATIVE"),
	OPOSITIVE("O+", "OPOSITIVE"),
	ONEGATIVE("O-", "ONEGATIVE");
	
	private String id;
	private String description;
	
	/**
	 * Constructor
	 * @param id
	 * @param description
	 */
	private EnumRHBlood(String id, String description) {
		this.id = id;
		this.description = description;
	}

	/**
	 * Getter for id
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter for description
	 * @return
	 */
	public String getDescription() {
		return description;
	}
}
