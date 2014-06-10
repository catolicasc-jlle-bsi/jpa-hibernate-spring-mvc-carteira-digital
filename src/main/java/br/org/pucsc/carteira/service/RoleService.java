package br.org.pucsc.carteira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.pucsc.carteira.dao.RoleDAO;
import br.org.pucsc.carteira.entity.Role;

@Service
public class RoleService {

	@Autowired
	RoleDAO roleDAO;
	
	public Role save(Role entity) {
		roleDAO.save(entity);
		return entity;
	}

	public void remove(Role entity) {
		roleDAO.remove(entity);
	}
	
	public Role getById(Long id) {
		return roleDAO.getById(Role.class, id);
	}

	public List<Role> getAll() {
		return roleDAO.getAll(Role.class);
	}

}
