package br.org.pucsc.carteira.service;

import java.util.List;

import br.org.pucsc.carteira.entity.DocumentCard;

public interface DocumentCardService {

	public DocumentCard save(DocumentCard entity);

	public void remove(DocumentCard entity);

	public DocumentCard getById(Long id);

	public List<DocumentCard> getAll();

}
