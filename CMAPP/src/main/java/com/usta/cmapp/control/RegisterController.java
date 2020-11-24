package com.usta.cmapp.control;

import java.io.Serializable;
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

import com.covidapp_mysql.model.Company;
import com.covidapp_mysql.model.Disease;
import com.covidapp_mysql.model.Person;
import com.covidapp_mysql.model.Register;
import com.usta.cmapp.constants.EnumDataBase;
import com.usta.covid_app.service.ServicesDao;

@ManagedBean(name = "register")
@SessionScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Person person;
	private Properties properties;
	private Register register;
	private String document;
	private String imcResult;
	private String userAccess;
	private String userLoged;
	private Float imc;
	private boolean visiblePanel;
	
	private List<Company> companies;
	private List<Disease> diseases;
	
	@EJB
	private ServicesDao<Object> servicesDao;
	
	/**
	 * Constructor class
	 */
	public RegisterController() {
		super();
		try {
			person = new Person();
			properties = new Properties();
			register = new Register();
			document = null;
			imcResult = null;
			userAccess = null;
			imc = 0.0F;
			visiblePanel = false;
			companies = new ArrayList<Company>();
			diseases = new ArrayList<Disease>();
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
					RegisterController.class.getResourceAsStream("messages.properties")
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
			
			List<Object> temporalCompany = servicesDao.findAll(Company.class, EnumDataBase.MYSQL.getId());
			for (Object o: temporalCompany) {
				companies.add((Company) o);
			}
			
			List<Object> temporalDisease = servicesDao.findAll(Disease.class, EnumDataBase.MYSQL.getId());
			for (Object o: temporalDisease) {
				diseases.add((Disease) o);
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
	 * Method for validates that the registrations are mandatory and that the birthday date
	 * is less than today's.
	 * @return flag
	 */
	public void validatePerson() {
		try {
			if (document != null && !document.equals("") 
				&& (register.getDiseaseID() > 0) 
				&& (register.getCompanyID( ) > 0)) {
				
				person = (Person)servicesDao.searchUserByDocument(document, EnumDataBase.MYSQL.getId());
				if (person != null && !person.equals("")) {
					register.setPersonID(person.getPersonID());
					visiblePanel = true;
				} else {
					FacesContext.getCurrentInstance().addMessage(
							null, 
							new FacesMessage(
									FacesMessage.SEVERITY_WARN,
									properties.getProperty(""),
									properties.getProperty("")
					));
				}
				
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							properties.getProperty(""),
							properties.getProperty("")
			));
		}
	}
	
	/**
	 * Method for screening record
	 */
	public void screeningRegister() {
		try {
			if (person.getWeight() > 0 && register.getTemperature() > 0) {
				if (register.getTemperature() < 38 && register.getTemperature() > 35) {
					register.setIngress(Byte.valueOf("0"));
					register.setEntryDate(new Date());
					register.setSymptom(Byte.valueOf("0"));
					servicesDao.create(register, EnumDataBase.MYSQL.getId());
					imc = Float.valueOf(person.getWeight()) 
							/ Float.valueOf((float) Math.pow(Double.valueOf(
													person.getHeight()),
													2
					));
					
					imcResult = person.getGender().equals("male") 
							? (imc > 25 ? "SOBREPESO".concat(imc.toString())
							: "NORMAL".concat(imc.toString())) 
							: (imc > 24 ? "SOBREPESO".concat(imc.toString()) 
							: "NORMAL".concat(imc.toString()));
					
				}
			}
		} catch (Exception e) {
			
		}
	}

	/**
	 * Getter for person
	 * @return
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Setter for person
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;
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
	 * Getter for register
	 * @return
	 */
	public Register getRegister() {
		return register;
	}

	/**
	 * Setter for register
	 * @param register
	 */
	public void setRegister(Register register) {
		this.register = register;
	}

	/**
	 * Getter for document
	 * @return
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * Setter for document
	 * @param document
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * Getter for imcResult
	 * @return
	 */
	public String getImcResult() {
		return imcResult;
	}

	/**
	 * Setter for imcResult
	 * @param imcResult
	 */
	public void setImcResult(String imcResult) {
		this.imcResult = imcResult;
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
	 * Getter for IMC
	 * @return
	 */
	public Float getImc() {
		return imc;
	}

	/**
	 * Setter for IMC
	 * @param imc
	 */
	public void setImc(Float imc) {
		this.imc = imc;
	}

	/**
	 * Getter for visiblePanel
	 * @return
	 */
	public boolean isVisiblePanel() {
		return visiblePanel;
	}

	/**
	 * Setter for visiblePanel
	 * @param visiblePanel
	 */
	public void setVisiblePanel(boolean visiblePanel) {
		this.visiblePanel = visiblePanel;
	}

	/**
	 * Getter for company list
	 * @return
	 */
	public List<Company> getCompanies() {
		return companies;
	}

	/**
	 * Setter for company list
	 * @param companies
	 */
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	/**
	 * Getter for disease list
	 * @return
	 */
	public List<Disease> getDiseases() {
		return diseases;
	}

	/**
	 * Setter for disease list
	 * @param diseases
	 */
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	/**
	 * Getter for servicesDao
	 * @return
	 */
	public ServicesDao<Object> getServicesDao() {
		return servicesDao;
	}

	/**
	 * Setter for servicesDao
	 * @param servicesDao
	 */
	public void setServicesDao(ServicesDao<Object> servicesDao) {
		this.servicesDao = servicesDao;
	}
}
