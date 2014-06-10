package br.org.pucsc.carteira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.pucsc.carteira.dao.DocumentCardDAOImpl;
import br.org.pucsc.carteira.entity.DocumentCard;

@Service
public class DocumentCardServiceImpl implements DocumentCardService {

	@Autowired
	DocumentCardDAOImpl documentCardDAO;
	
	public DocumentCard save(DocumentCard entity) {
		documentCardDAO.save(entity);
		return entity;
	}

	public void remove(DocumentCard entity) {
		documentCardDAO.remove(entity);
	}

	public DocumentCard getById(Long id) {
		return documentCardDAO.getById(DocumentCard.class, id);
	}

	public List<DocumentCard> getAll() {
		return documentCardDAO.getAll(DocumentCard.class);
	}

}
