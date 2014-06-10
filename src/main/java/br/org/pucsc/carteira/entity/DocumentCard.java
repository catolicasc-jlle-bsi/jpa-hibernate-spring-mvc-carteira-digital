package br.org.pucsc.carteira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class DocumentCard extends AbstractCard {
	
	public DocumentCard() {
		super();
		setType(TYPE_DOCUMENT_CARD);
	}
	
	private static final long serialVersionUID = 1L;
	
	@Column(length=255)
	private String cardName;
	
	@Column(length=16)
	private String cardNumber;
	
	@Column(length=2)
	private String dateValidatedMounth;
	
	@Column(length=4)
	private String dateValidatedYear;
	
	@Column(length=3)
	private String verifyCode;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDateValidatedMounth() {
		return dateValidatedMounth;
	}

	public void setDateValidatedMounth(String dateValidatedMounth) {
		this.dateValidatedMounth = dateValidatedMounth;
	}

	public String getDateValidatedYear() {
		return dateValidatedYear;
	}

	public void setDateValidatedYear(String dateValidatedYear) {
		this.dateValidatedYear = dateValidatedYear;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	

}
