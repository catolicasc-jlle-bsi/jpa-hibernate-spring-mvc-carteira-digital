package br.org.pucsc.carteira.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.org.pucsc.carteira.config.EntityManagerSession;

public class GenericDAOImpl<T, I extends Serializable> implements GenericDAO<T, I> {
	
	@Override
	public T save(T entity) {

		getEntityManager().getTransaction().begin();
		entity = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return entity;
	}

	@Override
	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();

	}

	@Override
	public T getById(Class<T> classe, I pk) {

		try {
			return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {
		return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}
	
	@Override
	public EntityManager getEntityManager() {
		return EntityManagerSession.getInstance().getManager();
	}

}
