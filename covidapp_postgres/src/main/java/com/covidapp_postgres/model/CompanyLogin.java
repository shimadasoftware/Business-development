package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the CompanyLogin database table.
 * 
 */
@Entity
@Table(name="companylogin")
public class CompanyLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "CompanyLogin.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="companyloginid")
	private Integer companyLoginID;
	
	@Column(name="companyid")
	private Integer companyID;
	
	@Column(name="creationdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name="loginid")
	private Integer loginID;

	@Column(name="retirementdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentProDate;

	private Integer status;

	/**
	 * Constructor
	 */
	public CompanyLogin() {
	}

	/**
	 * Getter for companyLoginID
	 * @return companyLoginID
	 */
	public Integer getCompanyLoginID() {
		return companyLoginID;
	}
	
	/**
	 * Setter for companyLoginID
	 * @param companyLoginID
	 */
	public void setCompanyLoginID(Integer companyLoginID) {
		this.companyLoginID = companyLoginID;
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
	 * Getter for creationDate
	 * @return creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
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
	public Integer getLoginID() {
		return loginID;
	}

	/**
	 * Setter for loginID
	 * @param loginID
	 */
	public void setLoginID(Integer loginID) {
		this.loginID = loginID;
	}

	/**
	 * Getter for paymentProDate
	 * @return paymentProDate
	 */
	public Date getPaymentProDate() {
		return paymentProDate;
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
	public Integer getStatus() {
		return status;
	}

	/**
	 * Setter for status
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Getter for serialVersionUID
	 * @return serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}