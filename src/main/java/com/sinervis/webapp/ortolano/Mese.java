package com.sinervis.webapp.ortolano;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mese {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id_mese;
	
	@Column
	private String nomeMese;
		
	public String getName() {
		return nomeMese;
	}
	
	public void setName(String name) {
		this.nomeMese = name;
	}

}
