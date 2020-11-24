package com.usta.covid_app.interfaces;

import java.util.List;

import javax.ejb.Remote;

/**
 * Bean-type interface that is responsible for defining the methods to perform the CRUD
 * @author juana
 * @param <T> type of object it receives
 * 
*/
@Remote
public interface IObjectQueryPostgres<T> {

	/**
	 * method that is responsible for creating the object to persist
	 * @param t
	 * @throws Exception
	 */
	public void create(T t) throws Exception; 
	
	/**
	 * method in charge of searching and listing all the objects of the desired query
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public List<T> findAll(Class<T> t) throws Exception; 
	
	/**
	 * method in charge of finding the object searched by means of the id 
	 * @param id
	 * @param object
	 * @throws Exception
	 */
	public T findById(Integer id, Class<T> object) throws Exception; 
	
	/**
	 * method to make any change or modification on a data of an object
	 * @param t
	 * @throws Exception
	 */
	public void update(T t) throws Exception; 
	
	/**
	 * delete an object depending on the ID requested to delete
	 * @param id
	 * @param object
	 * @throws Exception
	 */
	public void delete(Integer id, Class<T> object) throws Exception; 
	
	/**
	 * search user by credentials
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public T searchUser(String user, String password) throws Exception;
	
	/**
	 * Recover user password
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public T recoverPassword(String user) throws Exception;
	
	/**
	 * Search person by the document number
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public T searchPersonByDocument(String document) throws Exception;
}
