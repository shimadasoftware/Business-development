package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@Table(name="city")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "City.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cityid")
	private Integer cityID;
	
	@Column(name = "cityname")
	private String cityName;
	
	@Column(name = "departamentid")
	private Integer departamentID;

	/**
	 * Constructor
	 */
	public City() {
	}

	/**
	 * Getter for cityID
	 * @return cityID
	 */
	public Integer getCityID() {
		return cityID;
	}

	/**
	 * Setter for cityID
	 * @param cityID
	 */
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	/**
	 * Getter for cityName
	 * @return cityName
	 */
	public String getCityName() {
		return cityName;
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
}