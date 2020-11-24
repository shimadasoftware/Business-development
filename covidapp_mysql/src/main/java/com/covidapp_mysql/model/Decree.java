package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Decree database table.
 * 
 */
@Entity
@Table(name = "Decree")
public class Decree implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Decree.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int decreeID;

	private String decreeNumber;

	private String description;

	/**
	 * Constructor
	 */
	public Decree() {
	}

	/**
	 * Getter for decreeID
	 * @return decreeID
	 */
	public int getDecreeID() {
		return this.decreeID;
	}

	/**
	 * Setter for decreeID
	 * @param decreeID
	 */
	public void setDecreeID(int decreeID) {
		this.decreeID = decreeID;
	}

	/**
	 * Getter for decreeNumber
	 * @return decreeNumber
	 */
	public String getDecreeNumber() {
		return this.decreeNumber;
	}

	/**
	 * Setter for decreeNumber
	 * @param decreeNumber
	 */
	public void setDecreeNumber(String decreeNumber) {
		this.decreeNumber = decreeNumber;
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