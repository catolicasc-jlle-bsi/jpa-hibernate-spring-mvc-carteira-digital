package br.org.pucsc.carteira.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManagerSession {
	
	private static EntityManagerSession instance;
	
	private EntityManagerFactory factory;
	
	private EntityManager manager;
	
	private EntityTransaction transaction;
	
	private EntityManagerSession() { 
		factory = Persistence.createEntityManagerFactory("meuscartoes_pu");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	public static EntityManagerSession getInstance() {
		if ( instance == null ) {
			instance = new EntityManagerSession();
		}
		return instance;
	}
	
	public EntityTransaction getTransaction() {
		return transaction;
	}
	
	public EntityManager getManager() {
		return manager;
	}
}
