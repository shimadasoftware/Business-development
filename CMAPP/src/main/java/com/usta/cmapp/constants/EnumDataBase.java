package com.usta.cmapp.constants;

public enum EnumDataBase {

	MYSQL(1, "Mysql"),
	POSTGRESQL(2, "Postgresql");
	
	private int id;
	
	private String description;

	/**
	 * Constructor
	 * @param id
	 * @param description
	 */
	private EnumDataBase(int id, String description) {
		this.id = id;
		this.description = description;
	}

	/**
	 * Getter for id
	 * @return
	 */
	public int getId() {
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
