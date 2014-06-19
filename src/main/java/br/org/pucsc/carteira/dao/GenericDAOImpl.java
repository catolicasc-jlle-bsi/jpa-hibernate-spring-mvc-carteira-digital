package br.org.pucsc.carteira.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericDAOImpl<T, I extends Serializable> implements GenericDAO<T, I> {

	Logger LOG = Logger.getLogger(GenericDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public Session getSession() throws HibernateException {
		Session sess = null;
		
		try {
			sess = this.sessionFactory.getCurrentSession();
		} catch (Exception e) {
			LOG.debug("Não foi possível utilizar a CurrentSession: " + e.getMessage());
		} finally {
			if (sess == null) {
				sess = this.sessionFactory.openSession();
			}
		}
		
		return sess;
	}

	@Override
	public T save(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void remove(T entity) {
		getSession().delete(entity);
	}

	@Override
	public T getById(Class<T> classe, I pk) {

		try {
			return (T) getSession().createQuery(
							"select o from "
									+ classe.getSimpleName().toString()
									+ " o where o.id = " + pk.toString())
					.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {
		return getSession().createQuery(
				"select o from " + classe.getSimpleName() + " o").list();
	}

}
