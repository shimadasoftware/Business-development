package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the disease database table.
 * 
 */
@Entity
@Table(name="disease")
public class Disease implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Disease.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="diseaseid")
	private Integer diseaseID;

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
	public Integer getDiseaseID() {
		return diseaseID;
	}

	/**
	 * Setter for diseaseID
	 * @param diseaseID
	 */
	public void setDiseaseID(Integer diseaseID) {
		this.diseaseID = diseaseID;
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