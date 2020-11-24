package com.covidapp_postgres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historicDecree database table.
 * 
 */
@Entity
@Table(name="historicdecree")
public class HistoricDecree implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "HistoricDecree.FIND_ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "historicid")
	private Integer historicID;

	@Column(name = "cityid")
	private Integer cityID;

	@Column(name = "decreedate")
	@Temporal(TemporalType.DATE)
	private Date decreeDate;

	@Column(name = "decreeid")
	private Integer decreeID;

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
	public Integer getHistoricID() {
		return historicID;
	}

	/**
	 * Setter for historicID
	 * @param historicID
	 */
	public void setHistoricID(Integer historicID) {
		this.historicID = historicID;
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
	 * Getter for decreeDate
	 * @return decreeDate
	 */
	public Date getDecreeDate() {
		return decreeDate;
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
	public Integer getDecreeID() {
		return decreeID;
	}

	/**
	 * Setter for decreeID
	 * @param decreeID
	 */
	public void setDecreeID(Integer decreeID) {
		this.decreeID = decreeID;
	}

	/**
	 * Getter for description
	 * @return description
	 */
	public String getDescription() {
		return description;
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
		return url;
	}

	/**
	 * Setter for url
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}