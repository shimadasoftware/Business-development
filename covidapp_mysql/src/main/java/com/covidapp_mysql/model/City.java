package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the City database table.
 * 
 */
@Entity
@Table(name = "City")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "City.FIND_ALL";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cityID;

	private String cityName;

	private int departamentID;

	/**
	 * Constructor
	 */
	public City() {
	}

	/**
	 * Getter for cityID
	 * @return cityID
	 */
	public int getCityID() {
		return this.cityID;
	}

	/**
	 * Setter for cityID
	 * @param cityID
	 */
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	/**
	 * Getter for cityName
	 * @return cityName
	 */
	public String getCityName() {
		return this.cityName;
	}

	/**
	 * Setter for cityName
	 * @param cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
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

}