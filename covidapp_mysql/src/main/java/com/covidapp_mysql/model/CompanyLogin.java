package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CompanyLogin database table.
 * 
 */
@Entity
@Table(name = "CompanyLogin")
public class CompanyLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "CompanyLogin.FIND_All";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyLoginID;

	private int companyID;

	@Temporal(TemporalType.DATE)
	private Date creationDate;

	private int loginID;

	@Temporal(TemporalType.DATE)
	private Date paymentProDate;

	private int status;

	/**
	 * Constructor
	 */
	public CompanyLogin() {
	}

	/**
	 * Getter for companyLoginID
	 * @return companyLoginID
	 */
	public int getCompanyLoginID() {
		return this.companyLoginID;
	}

	/**
	 * Setter for companyLoginID
	 * @param companyLoginID
	 */
	public void setCompanyLoginID(int companyLoginID) {
		this.companyLoginID = companyLoginID;
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
	 * Getter for creationDate
	 * @return creationDate
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Setter for creationDate
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Getter for loginID
	 * @return loginID
	 */
	public int getLoginID() {
		return this.loginID;
	}

	/**
	 * Setter for loginID
	 * @param loginID
	 */
	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	/**
	 * Getter for paymentProDate
	 * @return paymentProDate
	 */
	public Date getPaymentProDate() {
		return this.paymentProDate;
	}

	/**
	 * Setter for paymentProDate
	 * @param paymentProDate
	 */
	public void setPaymentProDate(Date paymentProDate) {
		this.paymentProDate = paymentProDate;
	}

	/**
	 * Getter for status
	 * @return status
	 */
	public int getStatus() {
		return this.status;
	}

	/**
	 * Setter for status
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

}