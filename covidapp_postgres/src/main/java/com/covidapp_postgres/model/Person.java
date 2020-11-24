package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name="person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Person.FIND_ALL";
	public static final String FIND_BY_DOCUMENT = "Person.FIND_BY_DOCUMENT";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personid")
	private Integer personID;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="cellphone")
	private BigDecimal cellPhone;

	@Column(name="cityid")
	private Integer cityID;

	private String document;

	@Column(name="documenttypeid")
	private Integer documentTypeID;

	private String email;

	@Column(name="firstname")
	private String firstName;

	private Integer gender;

	private Integer height;

	@Column(name="lastname")
	private String lastName;

	@Column(name="lastname2")
	private String lastName2;

	@Column(name="middlename")
	private String middleName;

	@Column(name="rhblood")
	private String rhBlood;

	private Integer weight;

	/**
	 * Constructor
	 */
	public Person() {
	}

	/**
	 * Getter for personID
	 * @return personID
	 */
	public Integer getPersonID() {
		return personID;
	}

	/**
	 * Setter for personID
	 * @param personID
	 */
	public void setPersonID(Integer personID) {
		this.personID = personID;
	}

	/**
	 * Getter for birthday
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
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
		return cellPhone;
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
	public Integer getCityID() {
		return cityID;
	}

	/**
	 * Setter for cityID
	 * @param cityID
	 */
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	/**
	 * Getter for document
	 * @return document
	 */
	public String getDocument() {
		return document;
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
	 * Getter for email
	 * @return email
	 */
	public String getEmail() {
		return email;
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
		return firstName;
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
	public Integer getGender() {
		return gender;
	}

	/**
	 * Setter for gender
	 * @param gender
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * Getter for height
	 * @return height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * Setter for height
	 * @param height
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * Getter for lastName
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
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
		return lastName2;
	}

	/**
	 * Setter for lastName2
	 * @param lastName2
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	/**
	 * Getter for rhBlood
	 * @return rhBlood
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Setter for rhBlood
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
		return rhBlood;
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
	public Integer getWeight() {
		return weight;
	}

	/**
	 * Setter for weight 
	 * @param weight
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}