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
@Table(name="card")
public class AbstractCard implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	public static final Integer TYPE_DOCUMENT_CARD = 1;
	
	public static final Integer TYPE_DOCUMENT_IDENTITY = 2;
	
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(length=255, nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Integer type;

	@Column(nullable=false)
	private Long idUser;

	@ManyToOne
	@JoinColumn(name="idUser",insertable=false,updatable=false)
	private User user;
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
