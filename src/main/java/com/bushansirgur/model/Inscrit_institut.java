package com.bushansirgur.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inscription_institut")
public class Inscrit_institut {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "valide")
	private  boolean valide =false ; 
	
	@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	 private User user_i;
	 
	 @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	 private Institut institut_p;

	public Inscrit_institut() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public User getUser_i() {
		return user_i;
	}

	public void setUser_i(User user_i) {
		this.user_i = user_i;
	}

	public Institut getInstitut_p() {
		return institut_p;
	}

	public void setInstitut_p(Institut institut_p) {
		this.institut_p = institut_p;
	}

	
	 
	 
	 
	
	

}
