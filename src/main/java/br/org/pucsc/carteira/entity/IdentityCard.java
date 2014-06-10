package br.org.pucsc.carteira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class IdentityCard extends AbstractCard {
	
	public IdentityCard() {
		super();
		setType(TYPE_DOCUMENT_IDENTITY);
	}

	private static final long serialVersionUID = 1L;
	

	@Column(length=7)
	private String identityNumber;

	@Column(length=2)
	private String uf;

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
