package br.org.pucsc.carteira.dao;


import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.org.pucsc.carteira.entity.DocumentCard;

@Component
public class DocumentCardDAOImpl extends GenericDAOImpl<DocumentCard, Long> implements DocumentCardDAO {

	@Override
	public DocumentCard getDocumentCardByNameCard(String nameCard) {
		Query query = getEntityManager().createQuery("SELECT o FROM DocumentCard o WHERE o.cardName = :nameCard");
		query.setParameter("nameCard", nameCard);
		return query.getSingleResult() != null ? (DocumentCard) query.getSingleResult() : null;
	}

}
