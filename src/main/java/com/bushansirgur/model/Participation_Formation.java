package com.bushansirgur.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "participation_formation")
public class Participation_Formation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
	    private Date date;
	 
	 @Column(name = "valide")
	    private boolean valide = false;
	 
	 @Column(name = "presence")
	    private boolean presence = false;
	 
	 @Column(name = "note")
	    private int note ;
	 
	 @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	 private User user_p;
	 
	 @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	 private Formation formation_p;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}
	
	

	public Formation getFormation_p() {
		return formation_p;
	}

	public void setFormation_p(Formation formation_p) {
		this.formation_p = formation_p;
	}

	public User getUser_p() {
		return user_p;
	}

	public void setUser_p(User user_p) {
		this.user_p = user_p;
	}

	public Participation_Formation() {
		super();
	}
	 
	 
	 
	
	

}
