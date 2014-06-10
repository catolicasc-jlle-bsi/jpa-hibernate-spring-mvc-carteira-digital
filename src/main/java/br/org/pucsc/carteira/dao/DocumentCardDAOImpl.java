package br.org.pucsc.carteira.dao;



import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.org.pucsc.carteira.entity.DocumentCard;

@Component
public class DocumentCardDAOImpl extends GenericDAOImpl<DocumentCard, Long> implements DocumentCardDAO {

	@Override
	public DocumentCard getDocumentCardByNameCard(String nameCard) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT o FROM DocumentCard o WHERE o.cardName = :nameCard");
		query.setParameter("nameCard", nameCard);
		return query.uniqueResult() != null ? (DocumentCard) query.uniqueResult() : null;
	}

}
