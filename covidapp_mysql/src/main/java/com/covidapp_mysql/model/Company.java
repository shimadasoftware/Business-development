package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the Company database table.
 * 
 */
@Entity
@Table(name = "Company")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Company.FIND_ALL";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyID;

	private String address;

	private BigDecimal cellPhone;

	private Integer checkNit;

	private String email;

	private String legalRepresentative;

	private String name;

	private BigInteger nit;

	private int quantityEmployees;

	/**
	 * Constructor class
	 */
	public Company() {
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
	 * Getter for address
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Setter for address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * Getter for checkNit
	 * @return checkNit
	 */
	public Integer getCheckNit() {
		return this.checkNit;
	}

	/**
	 * Setter for checkNit
	 * @param checkNit
	 */
	public void setCheckNit(Integer checkNit) {
		this.checkNit = checkNit;
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
	 * Getter for legalRepresentative
	 * @return legalRepresentative
	 */
	public String getLegalRepresentative() {
		return this.legalRepresentative;
	}

	/**
	 * Setter for legalRepresentative
	 * @param legalRepresentative
	 */
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	/**
	 * Getter for name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for nit
	 * @return nit
	 */
	public BigInteger getNit() {
		return this.nit;
	}

	/**
	 * Setter for nit
	 * @param nit
	 */
	public void setNit(BigInteger nit) {
		this.nit = nit;
	}

	/**
	 * Getter for quantityEmployees
	 * @return quantityEmployees
	 */
	public int getQuantityEmployees() {
		return this.quantityEmployees;
	}

	/**
	 * Setter for quantityEmployees
	 * @param quantityEmployees
	 */
	public void setQuantityEmployees(int quantityEmployees) {
		this.quantityEmployees = quantityEmployees;
	}

}