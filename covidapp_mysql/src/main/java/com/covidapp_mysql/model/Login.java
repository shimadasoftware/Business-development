package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Login database table.
 * 
 */
@Entity
@Table(name = "Login")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Login.FIND_ALL";
	
	public static final String FIND_USER_CREDENTIALS_MYSQL = "Login.FIND_USER_CREDENTIALS_MYSQL";
	
	public static final String FIND_USER = "Login.FIND_USER";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loginID;

	private String password;

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
	 * Getter for password
	 * @return password
	 */
	public String getPassword() {
		return this.password;
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
		return this.user;
	}

	/**
	 * Setter for user
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

}