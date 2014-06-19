package br.org.pucsc.carteira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.pucsc.carteira.dao.DocumentDAOImpl;
import br.org.pucsc.carteira.entity.Document;

@Service
public class DocumentService {

	@Autowired
	DocumentDAOImpl documentCardDAO;

	@Transactional
	public Document save(Document entity) {
		documentCardDAO.save(entity);
		return entity;
	}

	@Transactional
	public void remove(Document entity) {
		documentCardDAO.remove(entity);
	}

	public Document getById(Long id) {
		return documentCardDAO.getById(Document.class, id);
	}

	public List<Document> getAll() {
		return documentCardDAO.getAll(Document.class);
	}

}
