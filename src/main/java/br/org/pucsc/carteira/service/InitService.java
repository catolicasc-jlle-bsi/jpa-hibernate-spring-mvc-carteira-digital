package br.org.pucsc.carteira.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.pucsc.carteira.dao.RoleDAOImpl;
import br.org.pucsc.carteira.entity.Role;

@Service
public class InitService {
	
	@Autowired
	RoleDAOImpl roleDAO;
		
	@Transactional
	@PostConstruct
	private void init() {
				
		Role roleUser = roleDAO.getById(Role.class, 1L);
		if (roleUser == null) {
			roleUser = new Role();
			roleUser.setId(1L);
			roleUser.setRoleName(Role.ROLE_USER);
			
			roleDAO.save(roleUser);
		}
		
		Role roleManager = roleDAO.getById(Role.class, 2L);
		if (roleManager == null) {
			roleManager = new Role();
			roleManager.setId(2L);
			roleManager.setRoleName(Role.ROLE_MANAGER);
			
			roleDAO.save(roleManager);
		}
	}
}
