package com.covidapp_mysql.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HistoricDecree database table.
 * 
 */
@Entity
@Table(name = "HistoricDecree")
public class HistoricDecree implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "HistoricDecree.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int historicID;

	private int cityID;

	@Temporal(TemporalType.DATE)
	private Date decreeDate;

	private int decreeID;

	private String description;

	private String url;

	/**
	 * Constructor
	 */
	public HistoricDecree() {
	}

	/**
	 * Getter for historicID
	 * @return historicID
	 */
	public int getHistoricID() {
		return this.historicID;
	}

	/**
	 * Setter for historicID
	 * @param historicID
	 */
	public void setHistoricID(int historicID) {
		this.historicID = historicID;
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
	 * Getter for decreeDate
	 * @return decreeDate
	 */
	public Date getDecreeDate() {
		return this.decreeDate;
	}

	/**
	 * Setter for decreeDate
	 * @param decreeDate
	 */
	public void setDecreeDate(Date decreeDate) {
		this.decreeDate = decreeDate;
	}

	/**
	 * Getter for decreeID
	 * @return decreeID
	 */
	public int getDecreeID() {
		return this.decreeID;
	}

	/**
	 * Setter for decreeID
	 * @param decreeID
	 */
	public void setDecreeID(int decreeID) {
		this.decreeID = decreeID;
	}

	/**
	 * Getter for description
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Setter for description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter for url
	 * @return url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Setter for url
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}