package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the decree database table.
 * 
 */
@Entity
@Table(name="decree")
public class Decree implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Decree.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="decreeid")
	private Integer decreeID;

	@Column(name="decreenumber")
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
	public Integer getDecreeID() {
		return decreeID;
	}

	/**
	 * Setter for decreeID
	 * @param decreeID
	 */
	public void setDecreeID(Integer decreeID) {
		this.decreeID = decreeID;
	}

	/**
	 * Getter for decreeNumber
	 * @return decreeNumber
	 */
	public String getDecreeNumber() {
		return decreeNumber;
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
		return description;
	}

	/**
	 * Setter for description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}