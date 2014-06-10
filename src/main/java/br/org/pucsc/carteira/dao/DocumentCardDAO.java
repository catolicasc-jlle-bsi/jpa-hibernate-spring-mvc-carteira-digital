package br.org.pucsc.carteira.dao;

import br.org.pucsc.carteira.entity.DocumentCard;

public interface DocumentCardDAO extends GenericDAO<DocumentCard, Long> {
	
	public DocumentCard getDocumentCardByNameCard(String nameCard);
	
}
