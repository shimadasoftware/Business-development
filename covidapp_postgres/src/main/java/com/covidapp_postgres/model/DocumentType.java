package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documentType database table.
 * 
 */
@Entity
@Table(name="documenttype")
public class DocumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "DocumentType.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="documenttypeid")
	private Integer documentTypeID;

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
	public Integer getDocumentTypeID() {
		return documentTypeID;
	}

	/**
	 * Setter for documentTypeID
	 * @param documentTypeID
	 */
	public void setDocumentTypeID(Integer documentTypeID) {
		this.documentTypeID = documentTypeID;
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