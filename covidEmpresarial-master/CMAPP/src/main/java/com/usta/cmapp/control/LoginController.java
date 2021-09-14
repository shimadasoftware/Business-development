package com.usta.cmapp.control;

import java.io.Serializable;
import java.util.Properties;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.covidapp_mysql.model.Login;
import com.covidapp_postgres.model.LoginPostgres;
import com.usta.cmapp.constants.EnumDataBase;
import com.usta.covid_app.service.ServicesDao;

@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String USER_AUTENTICH = "user.app";

	public static final String AUTH_KEY = "app.user.name";
	


	private Properties properties;// leer el archivo messages.properties.

	private String user;

	private String password;

	@EJB
	private ServicesDao<Login> servicesDaoMysql;

	@EJB
	private ServicesDao<LoginPostgres> servicesDaoPostgres;

	/**
	 * method constructor from class
	 */
	public LoginController() {
		super();
		properties = new Properties();
		try {
			properties.load(LoginController.class.getResourceAsStream("messages.properties"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR: ", "NO PUEDE LEER ARCHIVOS DE PROPIEDADES"));
		}
	}

	@SuppressWarnings("unused")
	public String acessCheck() {
		String acces = null;
		
		try {

			Login login = servicesDaoMysql.searchUser(user, password, EnumDataBase.MYSQL.getId());
			
			if(login.getLoginID()>0) {
				acces = "/pages/principal";
				//FacesContext.getCurrentInstance().getExternalContext().redirect(acces);
				//subir a session las variables
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY,user);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(USER_AUTENTICH, login.getUser().trim());
				
			}else if (login == null){
				LoginPostgres lpos = new com.covidapp_postgres.model.LoginPostgres();

				lpos = servicesDaoPostgres.searchUser(user, password, EnumDataBase.POSTGRESQL.getId());
				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY,user);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(USER_AUTENTICH, lpos.getUser().trim());
				
				acces = "/pages/principal";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						properties.getProperty("errorGeneral"), properties.getProperty("erroExitenciaUsuario")));
				
				acces = "/login/loginFail";
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					properties.getProperty("errorGeneral"), properties.getProperty("errorAutenticacion")));
			acces = "/login/loginFail";
		}
		
		return acces;
	}

	
	public void forgotPass() {
		try {
			Login login = servicesDaoMysql.searchUser(user, EnumDataBase.MYSQL.getId());
			
			if(login!=null) {
				password = login.getPassword().trim();
				setPassword(login.getPassword().trim());
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO, 
								properties.getProperty("passMess"), properties.getProperty("passRecupera").
									concat("TU CONTRASENA ES: ").concat(password)));
			}else {
				LoginPostgres loginPostgres = servicesDaoPostgres.searchUser(user, EnumDataBase.POSTGRESQL.getId());
				if(loginPostgres!=null) {
					password = loginPostgres.getPassword().trim();
					setPassword(loginPostgres.getPassword().trim());
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage(FacesMessage.SEVERITY_INFO, 
									properties.getProperty("passMess"), properties.getProperty("passRecupera").
									concat("TU CONTRASENA ES: ").concat(password)));
				}else {
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage(FacesMessage.SEVERITY_WARN, 
									properties.getProperty("passMess"), properties.getProperty("erroExitenciaUsuario")));
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
