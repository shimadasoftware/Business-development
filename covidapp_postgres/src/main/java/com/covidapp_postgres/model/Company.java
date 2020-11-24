package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Company.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "companyid")
	private Integer companyID;

	private String address;
	
	@Column(name = "cellphone")
	private BigDecimal cellPhone;

	@Column(name = "checknit")
	private Integer checkNit;

	private String email;
	
	@Column(name = "legalrepresentative")
	private String legalRepresentative;

	private String name;

	private BigDecimal nit;

	@Column(name = "quantityemployees")
	private Integer quantityEmployees;

	/**
	 * Constructor
	 */
	public Company() {
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
	 * Getter for address
	 * @return address
	 */
	public String getAddress() {
		return address;
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
	 * Getter for checkNit
	 * @return checkNit
	 */
	public Integer getCheckNit() {
		return checkNit;
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
	 * Getter for legalRepresentative
	 * @return legalRepresentative
	 */
	public String getLegalRepresentative() {
		return legalRepresentative;
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
		return name;
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
	public BigDecimal getNit() {
		return nit;
	}

	/**
	 * Setter for nit
	 * @param nit
	 */
	public void setNit(BigDecimal nit) {
		this.nit = nit;
	}

	/**
	 * Getter for quantityEmployees
	 * @return quantityEmployees
	 */
	public Integer getQuantityEmployees() {
		return quantityEmployees;
	}

	/**
	 * Setter for quantityEmployees
	 * @param quantityEmployees
	 */
	public void setQuantityEmployees(Integer quantityEmployees) {
		this.quantityEmployees = quantityEmployees;
	}

}