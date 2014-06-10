package br.org.pucsc.carteira.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDAOImpl<T, I extends Serializable> implements GenericDAO<T, I> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	@Override
	public T save(T entity) {

		try {
			sessionFactory.getCurrentSession().getTransaction().begin();

			entity = (T) sessionFactory.getCurrentSession().save(entity);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}

		return entity;
	}

	@Override
	public void remove(T entity) {

		try {
			sessionFactory.getCurrentSession().getTransaction().begin();

			sessionFactory.getCurrentSession().delete(entity);
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
	}

	@Override
	public T getById(Class<T> classe, I pk) {

		try {
			return (T) sessionFactory.getCurrentSession().createQuery("select o from " + classe.getSimpleName().toString() + " o where o.id = "+pk.toString()).uniqueResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {
		return sessionFactory.getCurrentSession().createQuery("select o from " + classe.getSimpleName() + " o").list();
	}
	
}
