package br.org.pucsc.carteira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.pucsc.carteira.dao.UserDAOImpl;
import br.org.pucsc.carteira.entity.User;

@Service
public class UserService {

	@Autowired
	UserDAOImpl userDAO;
	
	@Transactional
	public User save(User entity) {
		userDAO.save(entity);
		return entity;
	}

	@Transactional
	public void remove(User entity) {
		userDAO.remove(entity);
	}
	
	public User getByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

	public User getById(Long id) {
		return userDAO.getById(User.class, id);
	}

	public List<User> getAll() {
		return userDAO.getAll(User.class);
	}

}
