package br.org.pucsc.carteira.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="document")
public class Document implements Serializable {
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;

	@Column(length=255, nullable=false)
	private String name;
		
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
	
	@ManyToOne
	@JoinColumn(name="idFlag", referencedColumnName = "id", insertable=false,updatable=false)
	private Flag flag;
	
	@ManyToOne
	@JoinColumn(name="idBank", referencedColumnName = "id", insertable=false,updatable=false)
	private Bank bank;

	@ManyToOne
	@JoinColumn(name="idUser", referencedColumnName = "id", insertable=false,updatable=false)
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
}
