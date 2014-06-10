package br.org.pucsc.carteira.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.org.pucsc.carteira.dao.RoleDAO;
import br.org.pucsc.carteira.dao.RoleDAOImpl;
import br.org.pucsc.carteira.entity.Role;

@Service
public class InitService {
	
	@PostConstruct
	private void init() {
		
		RoleDAO roleDAO = new RoleDAOImpl();
		
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
