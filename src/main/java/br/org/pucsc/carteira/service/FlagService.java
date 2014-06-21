package br.org.pucsc.carteira.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.pucsc.carteira.dao.FlagDAOImpl;
import br.org.pucsc.carteira.entity.Flag;

@Service
public class FlagService {

	Logger LOG = Logger.getLogger(FlagService.class);

	@Autowired
	FlagDAOImpl flagDAO;

	@Transactional
	public Flag save(Flag entity) {
		flagDAO.save(entity);
		return entity;
	}

	@Transactional
	public void remove(Flag entity) {
		flagDAO.remove(entity);
	}

	public Flag getById(Long id) {
		return flagDAO.getById(Flag.class, id);
	}

	public List<Flag> getAll() {
		return flagDAO.getAll(Flag.class);
	}

}
