package com.usta.cmapp.control;

import java.io.Serializable;
import java.util.Properties;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.covidapp_mysql.model.Login;
import com.usta.cmapp.constants.EnumDataBase;
import com.usta.covid_app.service.ServicesDao;

@ManagedBean(name = "login")
@SessionScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String AUTHENTICATION_USER = "user.app";
	
	public static final String AUTH_KEY = "app.user.name";
	
	private Properties properties; //read file messages.properties
	
	private String user;
	
	private String password;
	
	@EJB
	private ServicesDao<Login> servicesDaoMysql;
	
	@EJB
	private ServicesDao<com.covidapp_postgres.model.Login> servicesDaoPostgres;
	
	
	/**
	 * Constructor method from class
	 */
	public LoginController() {
		super();
		properties = new Properties();
		try {
			properties.load(LoginController.class.getResourceAsStream("messages.properties"));
		} catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null, 
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"ERROR:",
							"the properties file couldn't be read"
			));
		}
	}
	
	/**
	 * Method to confirm access
	 * @return access
	 */
	@SuppressWarnings("unused")
	public String accessCheck() {
		String access = null;
		try {
			
			Login loginMysql = servicesDaoMysql.searchUser(
					user, 
					password,
					EnumDataBase.MYSQL.getId()
					);
			
			if (loginMysql.getLoginID() > 0) {
				access = "/pages/principal";
				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
						AUTH_KEY,
						user
						);
				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
						AUTHENTICATION_USER,
						loginMysql.getUser().trim()
						);
				
			} else if (loginMysql == null) {
				com.covidapp_postgres.model.Login loginPostgres = new com.covidapp_postgres.model.Login();
				
				loginPostgres = servicesDaoPostgres.searchUser(
						user,
						password,
						EnumDataBase.POSTGRESQL.getId()
				);
				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
						AUTH_KEY,
						user
						);
				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
						AUTHENTICATION_USER,
						loginPostgres.getUser().trim()
						);
				
				access = "/pages/principal";
			 
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_WARN,
								properties.getProperty("generalError"),
								properties.getProperty("existenceError")
				));
						
				access = "/login/failLogin";
			}
		
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							properties.getProperty("generalError"),
							properties.getProperty("authenticationError")
			));
			access = "/login/failLogin";
		}
		return access;
	}
	
	/**
	 * Method to recover password
	 */
	public void forgotPassword() {
		try {
			Login login = servicesDaoMysql.searchUserByPassword(
						user,
						EnumDataBase.MYSQL.getId()
						);
			if (login != null) {
				password = login.getPassword().trim();
				setPassword(login.getPassword().trim());
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_INFO,
								properties.getProperty("messagePassword"),
								properties.getProperty("recoverPassword")
										.concat("Your password is: ").concat(password)
				));
			} else {
				com.covidapp_postgres.model.Login loginPostgres = servicesDaoPostgres.searchUserByPassword(
						user,
						EnumDataBase.POSTGRESQL.getId()
						);
				if (loginPostgres != null) {
					password = loginPostgres.getPassword().trim();
					setPassword(loginPostgres.getPassword().trim());
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_INFO,
									properties.getProperty("messagePassword"),
									properties.getProperty("recoverPassword")
											.concat("Your password is: ").concat(password)
					));
				} else {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_WARN,
									properties.getProperty("messagePassword"),
									properties.getProperty(properties.getProperty("existenceError"))
					));
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Getter for user
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Setter for user
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Getter for password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
