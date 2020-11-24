package com.usta.cmapp.control;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import com.covidapp_mysql.model.City;
import com.covidapp_mysql.model.DocumentType;
import com.covidapp_mysql.model.Person;
import com.usta.cmapp.constants.EnumDataBase;
import com.usta.cmapp.constants.EnumRHBlood;
import com.usta.covid_app.service.ServicesDao;

@ManagedBean(name = "principal")
@SessionScoped
public class PrincipalController implements Serializable {

	/**
	 * constructor class
	 */
	private static final long serialVersionUID = 1L;
	private static final String PAGE_PRINCIPAl = "../login/login.faces";
	
	private City city;
	private DocumentType documentType;
	private Person newPerson;
	private Properties properties;
	private String userAccess;
	private String userLoged;
	private String phone;
	
	private List<City> cities;
	private List<DocumentType> documentTypes;
	private List<EnumRHBlood> rhBloodTypes;
	
	@EJB
	private ServicesDao<Object> servicesDao;
	
	/**
	 * Constructor class
	 */
	public PrincipalController() {
		super();
		try {
			city = new City();
			documentType = new DocumentType();
			newPerson = new Person();
			properties = new Properties();
			userAccess = null;
			cities = new ArrayList<City>();
			documentTypes = new ArrayList<DocumentType>();
			rhBloodTypes = new ArrayList<EnumRHBlood>();
			chargeProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * initialize variables
	 */
	private void chargeProperties() {
		try {
			properties.load(
					PrincipalController.class.getResourceAsStream("messages.properties")
		    );
			
			userAccess = ((String) FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().get(LoginController.AUTHENTICATION_USER)).toUpperCase();
			
			userLoged = ((String) FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().get(LoginController.AUTH_KEY)).toUpperCase();
					
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null, 
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							properties.getProperty("generalError"),
							properties.getProperty("ChargePropertiesError")
						));
		}
	}
	
	/**
	 * This method is initialized as soon as the class is loaded 
	 * and after the constructor is created.
	 * No client is received, 
	 * the client is the server 
	 * when the application is initialized.
	 */
	@PostConstruct
	public void chargeData() {
		try {
			
			List<Object> d = servicesDao.findAll(DocumentType.class, EnumDataBase.MYSQL.getId());
			for (Object o: d) {
				documentTypes.add((DocumentType) o);
			}
			
			List<Object> c = servicesDao.findAll(City.class, EnumDataBase.MYSQL.getId());
			for (Object o: c) {
				cities.add((City) o);
			}
		
			rhBloodTypes.add(EnumRHBlood.ABPOSITIVE);
			rhBloodTypes.add(EnumRHBlood.ABNEGATIVE);
			rhBloodTypes.add(EnumRHBlood.APOSITIVE);
			rhBloodTypes.add(EnumRHBlood.ANEGATIVE);
			rhBloodTypes.add(EnumRHBlood.BPOSITIVE);
			rhBloodTypes.add(EnumRHBlood.BNEGATIVE);
			rhBloodTypes.add(EnumRHBlood.OPOSITIVE);
			rhBloodTypes.add(EnumRHBlood.ONEGATIVE);
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null, 
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							properties.getProperty("generateError"),
							properties.getProperty("ChargePropertiesError")
						));
		}
	}
	
	/**
	 * validate to allow the passage to the next window
	 * @param event
	 * @return
	 */
	public String onFlowProcess(FlowEvent event) {
		String result = null;
		
		if (validateDataPerson()) {
			result = event.getNewStep();
		} else {
			result = event.getOldStep();
		}
		
		return result;
	}
	
	/**
	 * Method for validates that the registrations are mandatory and that the birthday date
	 * is less than today's.
	 * @return flag
	 */
	private boolean validateDataPerson() {
		boolean flag = false;
		if ((newPerson.getDocument() != null && !newPerson.getDocument().equals(""))
				&& (newPerson.getFirstName() != null && !newPerson.getFirstName().equals(""))
				&& (newPerson.getLastName() != null && !newPerson.getLastName().equals(""))
				&& (newPerson.getBirthday() != null && !newPerson.getBirthday().equals(""))
				&& (phone != null && !phone.equals(""))) {
			
			Date today = new Date();
			if (newPerson.getBirthday().before(today)) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			flag = false;	
		}
		
		return flag;
	}
	
	/**
	 * Method for create person from the form
	 */
	public void createPerson() {
		try {
			if (validateDataPerson()) {
				newPerson.setCellPhone(new BigDecimal(phone));
				servicesDao.create(newPerson, EnumDataBase.MYSQL.getId());
				
				FacesContext.getCurrentInstance().addMessage(
						null, 
						new FacesMessage(
								FacesMessage.SEVERITY_INFO,
								properties.getProperty(""),
								properties.getProperty("")
							));
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null, 
						new FacesMessage(
								FacesMessage.SEVERITY_WARN,
								properties.getProperty(""),
								properties.getProperty("")
							));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null, 
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							properties.getProperty("generateError"),
							properties.getProperty("ChargePropertiesError")
						));
		}
	}
	
	/**
	 * Method for download all sessions that are loaded
	 */
	public void logOut() {
		
		try {
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("principal");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(
					LoginController.AUTHENTICATION_USER);
			FacesContext.getCurrentInstance().getExternalContext().redirect(PAGE_PRINCIPAl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Getter for city
	 * @return city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * Setter for city
	 * @param city
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * Getter for documentType
	 * @return documentType
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}

	/**
	 * Setter for documentType
	 * @param documentType
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	/**
	 * Getter for newPerson
	 * @return newPerson
	 */
	public Person getNewPerson() {
		return newPerson;
	}

	/**
	 * Setter for newPerson
	 * @param newPerson
	 */
	public void setNewPerson(Person newPerson) {
		this.newPerson = newPerson;
	}

	/**
	 * Getter for properties
	 * @return
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * Setter for properties
	 * @param properties
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * Getter for userAccess
	 * @return
	 */
	public String getUserAccess() {
		return userAccess;
	}

	/**
	 * Setter for userAccess
	 * @param userAccess
	 */
	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	/**
	 * Getter for userLoged
	 * @return
	 */
	public String getUserLoged() {
		return userLoged;
	}

	/**
	 * Setter for userLoged
	 * @param userLoged
	 */
	public void setUserLoged(String userLoged) {
		this.userLoged = userLoged;
	}

	/**
	 * Getter for phone
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Setter for phone
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Getter for cities
	 * @return
	 */
	public List<City> getCities() {
		return cities;
	}

	/**
	 * Setter for cities
	 * @param cities
	 */
	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	/**
	 * Getter for documentTypes
	 * @return
	 */
	public List<DocumentType> getDocumentTypes() {
		return documentTypes;
	}

	/**
	 * Setter for documentTypes
	 * @param documentTypes
	 */
	public void setDocumentTypes(List<DocumentType> documentTypes) {
		this.documentTypes = documentTypes;
	}

	/**
	 * Getter for rhBloodTypes
	 * @return
	 */
	public List<EnumRHBlood> getRhBloodTypes() {
		return rhBloodTypes;
	}

	/**
	 * Setter for rhBloodTypes
	 * @param rhBloodTypes
	 */
	public void setRhBloodTypes(List<EnumRHBlood> rhBloodTypes) {
		this.rhBloodTypes = rhBloodTypes;
	}
	
}
