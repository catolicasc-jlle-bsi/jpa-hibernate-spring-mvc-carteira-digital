package br.org.pucsc.carteira.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.pucsc.carteira.dao.BankDAOImpl;
import br.org.pucsc.carteira.entity.Bank;

@Service
public class BankService {

	Logger LOG = Logger.getLogger(BankService.class);

	@Autowired
	BankDAOImpl bankDAO;

	@Transactional
	public Bank save(Bank entity) {
		bankDAO.save(entity);
		return entity;
	}

	@Transactional
	public void remove(Bank entity) {
		bankDAO.remove(entity);
	}

	public Bank getById(Long id) {
		return bankDAO.getById(Bank.class, id);
	}

	public List<Bank> getAll() {
		return bankDAO.getAll(Bank.class);
	}

}
