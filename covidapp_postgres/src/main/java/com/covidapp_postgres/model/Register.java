package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the register database table.
 * 
 */
@Entity
@Table(name="register")
public class Register implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Register.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="registerid")
	private Integer registerID;

	@Column(name="companyid")
	private Integer companyID;

	@Column(name="diseaseid")
	private Integer diseaseID;

	@Column(name="entrydate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryDate;

	@Column(name="exitdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date exitDate;

	private Boolean ingress;

	@Column(name="personID")
	private Integer personid;

	private Boolean symptom;

	private Integer temperature;

	/**
	 * Constructor
	 */
	public Register() {
	}

	/**
	 * Getter for registerID
	 * @return registerID
	 */
	public Integer getRegisterID() {
		return registerID;
	}

	/**
	 * Setter for registerID
	 * @param registerID
	 */
	public void setRegisterID(Integer registerID) {
		this.registerID = registerID;
	}

	/**
	 * Getter for companyID
	 * @return companyID
	 */
	public Integer getCompanyID() {
		return companyID;
	}

	/**
	 * Setter for companyID
	 * @param companyID
	 */
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
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
	 * Getter for entryDate
	 * @return entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
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
	 * @return
	 */
	public Date getExitDate() {
		return exitDate;
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
	public Boolean getIngress() {
		return ingress;
	}

	/**
	 * Setter for ingress
	 * @param ingress
	 */
	public void setIngress(Boolean ingress) {
		this.ingress = ingress;
	}

	/**
	 * Getter for personid
	 * @return personid
	 */
	public Integer getPersonid() {
		return personid;
	}

	/**
	 * Setter for personid
	 * @param personid
	 */
	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	/**
	 * Getter for symptom
	 * @return symptom
	 */
	public Boolean getSymptom() {
		return symptom;
	}

	/**
	 * Setter for symptom
	 * @param symptom
	 */
	public void setSymptom(Boolean symptom) {
		this.symptom = symptom;
	}

	/**
	 * Getter for temperature
	 * @return temperature
	 */
	public Integer getTemperature() {
		return temperature;
	}

	/**
	 * Setter for temperature
	 * @param temperature
	 */
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

}