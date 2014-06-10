package br.org.pucsc.carteira.dao;

import br.org.pucsc.carteira.entity.User;

public interface UserDAO extends GenericDAO<User, Long> {
	
	public User getUserByEmail(String email);

}
