package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@Table(name="login")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Login.FIND_ALL";
	
	public static final String FIND_USER_CREDENTIALS_POSTGRES = "Login.FIND_USER_CREDENTIALS_POSTGRES";

	public static final String FIND_USER = "Login.FIND_USER";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loginid")
	private Integer loginID;

	private String password;

	@Column(name="userlogin")
	private String user;

	/**
	 * Constructor
	 */
	public Login() {
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
	 * Getter for password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter for user
	 * @return user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Setter for user
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

}