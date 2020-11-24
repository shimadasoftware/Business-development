package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Disease database table.
 * 
 */
@Entity
@Table(name = "Disease")
public class Disease implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Disease.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int diseaseID;

	private String description;

	/**
	 * Constructor
	 */
	public Disease() {
	}

	/**
	 * Getter for diseaseID
	 * @return diseaseID
	 */
	public int getDiseaseID() {
		return this.diseaseID;
	}

	/** 
	 * Setter for diseaseID
	 * @param diseaseID
	 */
	public void setDiseaseID(int diseaseID) {
		this.diseaseID = diseaseID;
	}

	/**
	 * Getter for description
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Setter for description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}