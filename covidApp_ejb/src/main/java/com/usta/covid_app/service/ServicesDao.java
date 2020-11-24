package com.usta.covid_app.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import com.usta.covid_app.interfaces.IObjectQueryMysql;
import com.usta.covid_app.interfaces.IObjectQueryPostgres;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ServicesDao<T> {
	
	@EJB
	IObjectQueryMysql<T> mysqlDao;
	
	@EJB
	IObjectQueryPostgres<T> postgresDao;
	/**
	 * method that is responsible for creating the object to persist
	 * @param t
	 * @throws Exception
	 */
	public void create(T t, int db) throws Exception {
		switch (db) {
			case 1: //persistence mysql
				mysqlDao.create(t);
				
				break;
			case 2: //persistence postgress
				postgresDao.create(t);
				break;	
	
			default:
				break;
		}
		
	}
	
	/**
	 * method in charge of searching and listing all the objects of the desired query
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public List<T> findAll(T t, int db) throws Exception {
		
		List<T> object = new ArrayList<T>();
		
		switch (db) {
			case 1: //persistence mysql
				object = mysqlDao.findAll((Class<T>) t);
				break;
			case 2: //persistence postgress
				object = postgresDao.findAll((Class<T>) t);
				break;	
	
			default:
				break;
		}
		return object;
	}
	
	/**
	 * method in charge of finding the object searched by means of the id 
	 * @param id
	 * @param object
	 * @throws Exception
	 */
	public T findById(Integer id, Class<T> object, int db) throws Exception {
		T o = null;
		switch (db) {
		case 1: //persistence mysql
			o = mysqlDao.findById(id, object);
			
			break;
		case 2: //persistence postgress
			o = postgresDao.findById(id, object);
			break;	

		default:
			break;
		}
		return o;
	}
	
	/**
	 * method to make any change or modification on a data of an object
	 * @param t
	 * @throws Exception
	 */
	public void update(T t, int db) throws Exception {
		switch (db) {
		case 1: //persistence mysql
			mysqlDao.update(t);
			break;
		case 2: //persistence postgress
			postgresDao.update(t);
			break;	

		default:
			break;
		}
		
	}
	
	/**
	 * delete an object depending on the ID requested to delete
	 * @param id
	 * @param object
	 * @throws Exception
	 */
	public void delete(Integer id, Class<T> object,  int db) throws Exception {
		switch (db) {
		case 1: //persistence mysql
			mysqlDao.delete(id, object);
			break;
		case 2: //persistence postgress
			postgresDao.delete(id, object);
			break;	
			
		default:
			break;
		}
		
	}
	
	/**
	 * search user by credentials
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public T searchUser(String user, String password, int db) throws Exception {
		T t = null;
		
		switch (db) {
		case 1: //persistence mysql
			t = mysqlDao.searchUser(user, password);
			break;
		case 2: //persistence postgress
			t = postgresDao.searchUser(user, password);
			break;	
			
		default:
			break;
		}
		
		return t;
	}
	
	/**
	 * Recover user password
	 * @param user
	 * @param db
	 * @return
	 * @throws Exception
	 */
	public T searchUserByPassword(String user, int db) throws Exception {
		T t = null;
		switch (db) {
		case 1: //persistence mysql
			t = mysqlDao.recoverPassword(user);	
			break;
		case 2: //persistence postgress
			t = postgresDao.recoverPassword(user);
			break;	
			
		default:
			break;
		}
		return t;
	}
	
	public T searchUserByDocument(String document, int db) throws Exception {
		T t = null;
		switch (db) {
		case 1: //persistence mysql
			t = mysqlDao.searchPersonByDocument(document);
			break;
		case 2: //persistence postgress
			t = postgresDao.searchPersonByDocument(document);
			break;	
			
		default:
			break;
		}
		return t;
	}
}
