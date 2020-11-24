package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@Table(name="department")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "Department.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="departamentid")
	private Integer departamentID;

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
	public Integer getDepartamentID() {
		return departamentID;
	}

	/**
	 * Setter for departamentID
	 * @param departamentID
	 */
	public void setDepartamentID(Integer departamentID) {
		this.departamentID = departamentID;
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
}