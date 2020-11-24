package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Register database table.
 * 
 */
@Entity
@Table(name = "Register")
public class Register implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Register.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int registerID;

	private int companyID;

	private int diseaseID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date entryDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date exitDate;

	private byte ingress;

	private int personID;

	private byte symptom;

	private int temperature;

	/**
	 * Constructor
	 */
	public Register() {
	}

	/**
	 * Getter for registerID
	 * @return registerID
	 */
	public int getRegisterID() {
		return this.registerID;
	}

	/**
	 * Setter for registerID
	 * @param registerID
	 */
	public void setRegisterID(int registerID) {
		this.registerID = registerID;
	}

	/**
	 * Getter for companyID
	 * @return companyID
	 */
	public int getCompanyID() {
		return this.companyID;
	}

	/**
	 * Setter for companyID
	 * @param companyID
	 */
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
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
	 * Getter for entryDate
	 * @return entryDate
	 */
	public Date getEntryDate() {
		return this.entryDate;
	}

	/**
	 * Setter for entryDate
	 * @param entryDate
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * Getter for exitDate
	 * @return exitDate
	 */
	public Date getExitDate() {
		return this.exitDate;
	}

	/**
	 * Setter for exitDate
	 * @param exitDate
	 */
	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	/**
	 * Getter for ingress
	 * @return ingress
	 */
	public byte getIngress() {
		return this.ingress;
	}

	/**
	 * Setter for ingress
	 * @param ingress
	 */
	public void setIngress(byte ingress) {
		this.ingress = ingress;
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
	 * Getter for symptom
	 * @return symptom
	 */
	public byte getSymptom() {
		return this.symptom;
	}

	/**
	 * Setter for symptom
	 * @param symptom
	 */
	public void setSymptom(byte symptom) {
		this.symptom = symptom;
	}

	/**
	 * Getter for temperature
	 * @return temperature
	 */
	public int getTemperature() {
		return this.temperature;
	}

	/**
	 * Setter for temperature
	 * @param temperature
	 */
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

}