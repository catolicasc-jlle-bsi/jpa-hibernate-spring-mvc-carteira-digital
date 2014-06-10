package br.org.pucsc.carteira.dao;


import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.org.pucsc.carteira.entity.User;

@Component
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {

	@Override
	public User getUserByEmail(String email) {
		Query query = getEntityManager().createQuery("SELECT o FROM User o WHERE o.email = :email");
		query.setParameter("email", email);
		return query.getSingleResult() != null ? (User) query.getSingleResult() : null;
	}

}
