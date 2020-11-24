package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DocumentType database table.
 * 
 */
@Entity
@Table(name = "DocumentType")
public class DocumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "DocumentType.FIND_ALL";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int documentTypeID;

	private String description;

	/**
	 * Constructor
	 */
	public DocumentType() {
	}

	/**
	 * Getter for documentTypeID
	 * @return documentTypeID
	 */
	public int getDocumentTypeID() {
		return this.documentTypeID;
	}

	/**
	 * Setter for documentTypeID
	 * @param documentTypeID
	 */
	public void setDocumentTypeID(int documentTypeID) {
		this.documentTypeID = documentTypeID;
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