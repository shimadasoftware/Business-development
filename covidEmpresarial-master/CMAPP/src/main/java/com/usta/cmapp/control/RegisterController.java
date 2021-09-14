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

@ManagedBean(name = "regis")
@SessionScoped
public class RegisterController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Properties properties;
	private Register registerPerson;
	private String userAcces;
	private String usLoged;
	private List<Disease> listDisease;
	private List<Company> listCompany;
	private String document;
	private boolean visiblePanel;
	private Person personRegis;
	private Float imc;
	private String resultaImc;
	
	@EJB
	private ServicesDao<Object> servicesDao;

	public RegisterController() {
		properties = new Properties(); 
		userAcces = null;
		registerPerson = new Register();
		listDisease = new ArrayList<Disease>();
		listCompany = new ArrayList<Company>();
		document = null;
		visiblePanel = false;
		imc = 0.0F;
		resultaImc = null;
		personRegis = new Person();
		chargeProperties();
	}
	
	/**
	 * init variables 
	 */
	private void chargeProperties() {
		try {
			properties.load(RegisterController.class.getResourceAsStream("messages.properties"));
			userAcces = ((String) FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().get(LoginController.USER_AUTENTICH)).toUpperCase();
			usLoged=((String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LoginController.AUTH_KEY)).toUpperCase();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, properties.getProperty("errorGeneral")
							, properties.getProperty("errorCargaPropiedades")));
		}
	}
	
	@PostConstruct
	public void chargeData() {
		try {
			List<Object> diseaseTemp= servicesDao.findAll(Disease.class, EnumDataBase.MYSQL.getId());
			for(Object o : diseaseTemp) {
				listDisease.add((Disease) o);
			}
			
			List<Object> companyTemp = servicesDao.findAll(Company.class, EnumDataBase.MYSQL.getId());
			for(Object o : diseaseTemp) {
				listCompany.add((Company) o);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void validatePerson() {
		try {
			if(document!=null && !document.equals("") 
					&& (registerPerson.getDiseaseID()>0)
					&& (registerPerson.getCompanyID()>0)) {
				personRegis =(Person)servicesDao.searchPersonByDocument(document, EnumDataBase.MYSQL.getId());
				if(personRegis!=null && !personRegis.equals("")) {
					registerPerson.setPersonID(personRegis.getPersonID());
					visiblePanel = true;
				}else {
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage(FacesMessage.SEVERITY_WARN, properties.getProperty(""), properties.getProperty("")));
				}
				
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, properties.getProperty(""),properties.getProperty("")));
		}
	}
	
	public void regisInto() {
		
		try {
			if(personRegis.getWeight()>0 && registerPerson.getTemperature()>0) {
				if(registerPerson.getTemperature()<38 && registerPerson.getTemperature()>35) {
					registerPerson.setIngress(Byte.valueOf("0"));
					registerPerson.setEntryDate(new Date());
					registerPerson.setSymptom(Byte.valueOf("0"));
					servicesDao.create(registerPerson, EnumDataBase.MYSQL.getId());
					imc = Float.valueOf(personRegis.getWeight())/ Float.valueOf((float) Math.pow(Double.valueOf(personRegis.getHeight()), 2));
					
					resultaImc = personRegis.getGender().equals("male") ? (imc > 25 ? 
							"SOBREPESO".concat(imc.toString()) : "NORMAL".concat(imc.toString())) 
							: (imc > 24 ? "SOBREPESO".concat(imc.toString()) : "NORMAL".concat(imc.toString()));
					
				}
			}
		} catch (Exception e) {
			
		}
	}

	public Register getRegisterPerson() {
		return registerPerson;
	}

	public void setRegisterPerson(Register registerPerson) {
		this.registerPerson = registerPerson;
	}

	public String getUserAcces() {
		return userAcces;
	}

	public void setUserAcces(String userAcces) {
		this.userAcces = userAcces;
	}

	public String getUsLoged() {
		return usLoged;
	}

	public void setUsLoged(String usLoged) {
		this.usLoged = usLoged;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public boolean isVisiblePanel() {
		return visiblePanel;
	}

	public void setVisiblePanel(boolean visiblePanel) {
		this.visiblePanel = visiblePanel;
	}

	public Person getPersonRegis() {
		return personRegis;
	}

	public void setPersonRegis(Person personRegis) {
		this.personRegis = personRegis;
	}

	public List<Disease> getListDisease() {
		return listDisease;
	}

	public void setListDisease(List<Disease> listDisease) {
		this.listDisease = listDisease;
	}

	public List<Company> getListCompany() {
		return listCompany;
	}

	public void setListCompany(List<Company> listCompany) {
		this.listCompany = listCompany;
	}

	public Float getImc() {
		return imc;
	}

	public void setImc(Float imc) {
		this.imc = imc;
	}

	public String getResultaImc() {
		return resultaImc;
	}

	public void setResultaImc(String resultaImc) {
		this.resultaImc = resultaImc;
	}

}
