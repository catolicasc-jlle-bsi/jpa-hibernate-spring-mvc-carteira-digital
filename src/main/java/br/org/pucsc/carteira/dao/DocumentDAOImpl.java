package br.org.pucsc.carteira.dao;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import br.org.pucsc.carteira.entity.Document;

@Component
public class DocumentDAOImpl extends GenericDAOImpl<Document, Long> implements DocumentDAO {
	
	@Override
	public Document getDocumentByNameCard(String nameCard) {
		Query query = getSession().createQuery("SELECT o FROM Document o WHERE o.cardName = :nameCard");
		query.setParameter("nameCard", nameCard);
		return query.uniqueResult() != null ? (Document) query.uniqueResult() : null;
	}

}
