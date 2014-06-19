package br.org.pucsc.carteira.dao;

import br.org.pucsc.carteira.entity.Document;

public interface DocumentDAO extends GenericDAO<Document, Long> {
	
	public Document getDocumentByNameCard(String nameCard);
	
}
