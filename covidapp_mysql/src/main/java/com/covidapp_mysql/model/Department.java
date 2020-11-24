package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Department database table.
 * 
 */
@Entity
@Table(name = "Department")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Department.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departamentID;

	private String name;

	/**
	 * Constructor
	 */
	public Department() {
	}

	/**
	 * Getter for departamentID
	 * @return departamentID
	 */
	public int getDepartamentID() {
		return this.departamentID;
	}

	/**
	 * Setter for departamentID
	 * @param departamentID
	 */
	public void setDepartamentID(int departamentID) {
		this.departamentID = departamentID;
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
}