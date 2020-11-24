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

import com.usta.covid_app.interfaces.IObjectQueryPostgres;

/**
 * 
 * @author juana
 *
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DaoObjectPostgresql<T> implements IObjectQueryPostgres<T> {
	
	@PersistenceContext(unitName = "covidapp_postgres") //define which data base motor
	EntityManager postgresqlEntity; //define the methods that allow transactions
	
	@Override
	public void create(T t) throws Exception {
		postgresqlEntity.persist(t);
	}

	@Override
	public List<T> findAll(Class<T> t) throws Exception {
		List<T> object = new ArrayList<T>();
		Query querySql = postgresqlEntity.createNamedQuery(
				t.getSimpleName() +
				".FIND_ALL"
				);//set up a query
		object = querySql.getResultList();//bring the query data 
		
		return object;
	}

	@Override
	public T findById(Integer id, Class<T> object) throws Exception {
		T t = null;
		t = (T) postgresqlEntity.find(Object.class, id);
		
		return t;
	}

	@Override
	public void update(T t) throws Exception {
		postgresqlEntity.merge(t);
	}

	@Override
	public void delete(Integer id, Class<T> object) throws Exception {
		T t = findById(id, object);
		
		if (t != null) {
			postgresqlEntity.remove(t);
		}	
	}

	@Override
	public T searchUser(String user, String password) throws Exception {
		T t = null;
		Query q = postgresqlEntity.createNamedQuery(
				com.covidapp_postgres.model.Login.FIND_USER_CREDENTIALS_POSTGRES
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
		Query q = postgresqlEntity.createNamedQuery(
				com.covidapp_postgres.model.Login.FIND_USER
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
		Query q = postgresqlEntity.createNamedQuery(
				com.covidapp_postgres.model.Person.FIND_BY_DOCUMENT
				);
		q.setParameter("doc", document);
		try {
			t = (T) q.getSingleResult();
		} catch (NoResultException e) {
			t = null;
		}
		
		return null;
	}
}
