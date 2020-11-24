package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Person database table.
 * 
 */
@Entity
@Table(name = "Person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Person.FIND_ALL";
	public static final String FIND_BY_DOCUMENT = "Person.FIND_BY_DOCUMENT";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int personID;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private BigDecimal cellPhone;

	private int cityID;

	private String document;

	private int documentTypeID;

	private String email;

	private String firstName;

	private String gender;

	private float height;

	private String lastName;

	private String lastName2;

	private String middleName;

	private String rhBlood;

	private float weight;

	/**
	 * Constructor
	 */
	public Person() {
	}

	/**
	 * Getter for personID
	 * @return personID
	 */
	public int getPersonID() {
		return this.personID;
	}

	/**
	 * Setter for personID
	 * @param personID
	 */
	public void setPersonID(int personID) {
		this.personID = personID;
	}

	/**
	 * Getter for birthday
	 * @return birthday
	 */
	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * Setter for birthday
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * Getter for cellPhone
	 * @return cellPhone
	 */
	public BigDecimal getCellPhone() {
		return this.cellPhone;
	}

	/**
	 * Setter for cellPhone
	 * @param cellPhone
	 */
	public void setCellPhone(BigDecimal cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * Getter for cityID
	 * @return cityID
	 */
	public int getCityID() {
		return this.cityID;
	}

	/**
	 * Setter for cityID
	 * @param cityID
	 */
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	/**
	 * Getter for document
	 * @return document
	 */
	public String getDocument() {
		return this.document;
	}

	/**
	 * Setter for document
	 * @param document
	 */
	public void setDocument(String document) {
		this.document = document;
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
	 * Getter for email
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Setter for email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for firstName
	 * @return firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Setter for firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter for gender
	 * @return gender
	 */ 
	public String getGender() {
		return this.gender;
	}

	/**
	 * Setter for gender
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Getter for height
	 * @return height
	 */
	public float getHeight() {
		return this.height;
	}

	/**
	 * Setter for height
	 * @param height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * Getter for lastName
	 * @return lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Setter for lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for lastName2
	 * @return lastName2
	 */
	public String getLastName2() {
		return this.lastName2;
	}

	/**
	 * Setter for lastName2
	 * @param lastName2
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	/**
	 * Getter for middleName
	 * @return middleName
	 */
	public String getMiddleName() {
		return this.middleName;
	}

	/**
	 * Setter for middleName
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Getter for rhBlood
	 * @return rhBlood
	 */
	public String getRhBlood() {
		return this.rhBlood;
	}

	/**
	 * Setter for rhBlood
	 * @param rhBlood
	 */
	public void setRhBlood(String rhBlood) {
		this.rhBlood = rhBlood;
	}

	/**
	 * Getter for weight
	 * @return weight
	 */
	public float getWeight() {
		return this.weight;
	}

	/**
	 * Setter for weight 
	 * @param weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

}