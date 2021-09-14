package com.usta.cmapp.control;

import java.io.IOException;
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
import com.covidapp_mysql.model.Person;
import com.covidapp_mysql.model.TypeDocument;
import com.usta.cmapp.constants.EnumDataBase;
import com.usta.cmapp.constants.EnumRhBlood;
import com.usta.covid_app.service.ServicesDao;

@ManagedBean(name = "prin")
@SessionScoped
public class PrincipalController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String PAGE_PRINCIPAL = "../login/login.faces";
	
	private Properties properties;
	private String usLoged;
	private String userAcces;
	private Person newPerson;
	private List<TypeDocument> typesDocuments;
	private List<City> listCities;
	private List<EnumRhBlood> rhlist;
	private TypeDocument documentType;
	private City city;
	private String phone;
	
	@EJB
	private ServicesDao<Object> servicesDao;

	
	
	/**
	 * constructor class
	 */
	public PrincipalController() {
		
		try {
			properties = new Properties(); 
			userAcces = null;
			newPerson = new Person();
			city = new City();
			documentType = new TypeDocument();
			typesDocuments = new ArrayList<TypeDocument>();
			listCities = new ArrayList<City>();
			rhlist = new ArrayList<EnumRhBlood>();
			chargeProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * init variables 
	 */
	private void chargeProperties() {
		try {
			properties.load(PrincipalController.class.getResourceAsStream("messages.properties"));
			userAcces = ((String) FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().get(LoginController.USER_AUTENTICH)).toUpperCase();
			usLoged=((String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(LoginController.AUTH_KEY)).toUpperCase();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, properties.getProperty("errorGeneral")
							, properties.getProperty("errorCargaPropiedades")));
		}
	}
	
	/**
	 * este metodo se inicializa tan pronto se carga la clase
	 * y despues que crea el constructor 
	 * No recibi de ningun cliente, el cliente es el mismo servidor
	 * cuando la aplicacion es inicializada.
	 */
	@PostConstruct
	public void chargeData() {
		try {
			List<Object> d = servicesDao.findAll(TypeDocument.class, EnumDataBase.MYSQL.getId());
			for(Object o :d) {
				typesDocuments.add((TypeDocument) o);
			}
			
			List<Object> c =servicesDao.findAll(City.class, EnumDataBase.MYSQL.getId());
			for(Object o :c) {
				listCities.add((City)o);
			}
			
			
			rhlist.add(EnumRhBlood.ABPOS);
			rhlist.add(EnumRhBlood.ABNEG);
			rhlist.add(EnumRhBlood.APOS);
			rhlist.add(EnumRhBlood.ANEG);
			rhlist.add(EnumRhBlood.BPOS);
			rhlist.add(EnumRhBlood.BNEGA);
			rhlist.add(EnumRhBlood.OPOS);
			rhlist.add(EnumRhBlood.ONGE);
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, properties.getProperty("errorGeneral")
							, properties.getProperty("errorCargaPropiedades")));
		}
	}
	
	/**
	 * valida para hacer el paso a la siguiente pestania
	 * @param event
	 * @return
	 */
	public String onFlowProcess(FlowEvent event) {
		String result = null;
		
		if(validateDataPerson()) {
			result = event.getNewStep();
		}else {
			result = event.getOldStep();
		}
		
		return result;
	}
	
	/**
	 * valida los registros que sean de caracter obligatorio y valida que la fecha
	 * de nacimiento sea menor a la dia de hoy 
	 * @return
	 */
	private boolean validateDataPerson() {
		boolean flag = false;
		if((newPerson.getDocument()!=null && !newPerson.getDocument().equals(""))
				&& (newPerson.getFirstName()!=null && !newPerson.getFirstName().equals(""))
				&& (newPerson.getLastName()!= null && !newPerson.getLastName().equals(""))
				&& (newPerson.getBirthday()!=null && !newPerson.getBirthday().equals("")) 
				&& (phone!=null && !phone.equals(""))) {
				
				Date today = new Date();
				if(newPerson.getBirthday().before(today)) {
					flag = true;
				}else {
					flag = false;
				}
			
		}else {
			flag = false;
		}
		
		return flag;
	}
	
	
	/**
	 * metodo que crea la persona desde el formulario
	 */
	public void createPerson() {
		try {
			if(validateDataPerson()) {
				newPerson.setCellPhone(new BigDecimal(phone));
				 servicesDao.create(newPerson, EnumDataBase.MYSQL.getId());
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, properties.getProperty(""), properties.getProperty("")));
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, properties.getProperty(""), properties.getProperty("")));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, properties.getProperty(""), properties.getProperty("")));
		}
	}
	
	
	public String logut() {
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("prin");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pesoncontroller");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(LoginController.USER_AUTENTICH);
			FacesContext.getCurrentInstance().getExternalContext().redirect(PAGE_PRINCIPAL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return  null;
	}
	
	
	/*setter and getter*/
	public String getUserAcces() {
		return userAcces;
	}

	public void setUserAcces(String userAcces) {
		this.userAcces = userAcces;
	}

	public Person getNewPerson() {
		return newPerson;
	}

	public void setNewPerson(Person newPerson) {
		this.newPerson = newPerson;
	}

	public List<TypeDocument> getTypesDocuments() {
		return typesDocuments;
	}

	public void setTypesDocuments(List<TypeDocument> typesDocuments) {
		this.typesDocuments = typesDocuments;
	}

	public List<City> getListCities() {
		return listCities;
	}

	public void setListCities(List<City> listCities) {
		this.listCities = listCities;
	}

	public List<EnumRhBlood> getRhlist() {
		return rhlist;
	}

	public void setRhlist(List<EnumRhBlood> rhlist) {
		this.rhlist = rhlist;
	}

	public String getUsLoged() {
		return usLoged;
	}

	public void setUsLoged(String usLoged) {
		this.usLoged = usLoged;
	}

	public TypeDocument getDocumentType() {
		return documentType;
	}

	public void setDocumentType(TypeDocument documentType) {
		this.documentType = documentType;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
