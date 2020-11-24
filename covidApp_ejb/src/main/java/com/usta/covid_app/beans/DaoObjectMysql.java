package com.usta.covid_app.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.covidapp_mysql.model.Login;
import com.covidapp_mysql.model.Person;
import com.usta.covid_app.interfaces.IObjectQueryMysql;

/**
 * 
 * @author juana
 *
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DaoObjectMysql<T> implements IObjectQueryMysql<T> {
	
	@PersistenceContext(unitName = "covidapp_mysql") //define which data base motor
	EntityManager mysqlEntity; //define the methods that allow transactions
	
	@Override
	public void create(T t) throws Exception {
		mysqlEntity.persist(t);
	}

	@Override
	public List<T> findAll(Class<T> t) throws Exception {
		List<T> object = new ArrayList<T>();
		Query querySql = mysqlEntity.createNamedQuery(
				t.getSimpleName() + 
				".FIND_ALL"
				); //set up a query
		object = querySql.getResultList();//bring the query data 
		
		return object;
	}

	@Override
	public T findById(Integer id, Class<T> object) throws Exception {
		T t = null;
		t = (T) mysqlEntity.find(Object.class, id);
		
		return t;
	}

	@Override
	public void update(T t) throws Exception {
		mysqlEntity.merge(t);
	}

	@Override
	public void delete(Integer id, Class<T> object) throws Exception {
		T t = findById(id, object);
		
		if (t != null) {
			mysqlEntity.remove(t);
		}	
	}

	@Override
	public T searchUser(String user, String password) throws Exception {
		T t = null;
		Query q = mysqlEntity.createNamedQuery(
				Login.FIND_USER_CREDENTIALS_MYSQL
				);
		q.setParameter("us", user);
		q.setParameter("ps", password);
		
		try {
			t = (T) q.getSingleResult();
		} catch (NoResultException e) {
			t = null;
		}
		
		return t;
	}

	@Override
	public T recoverPassword(String user) throws Exception {
		T t = null;
		Query q = mysqlEntity.createNamedQuery(
				Login.FIND_USER
				);
		q.setParameter("us", user);
		try {
			t = (T) q.getSingleResult();
		} catch (NoResultException e) {
			t = null;
		}
		
		return t;
	}

	@Override
	public T searchPersonByDocument(String document) throws Exception {
		T t = null;
		Query q = mysqlEntity.createNamedQuery(
				Person.FIND_BY_DOCUMENT
				);
		q.setParameter("doc", document);
		try {
			t = (T) q.getSingleResult();
		} catch (NoResultException e) {
			t = null;
		}
		
		return t;
	}
}
