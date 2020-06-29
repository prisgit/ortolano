package com.sinervis.webapp.ortolano.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@FullArgsConstructor
public class Mese {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int idMese;
	
	@Column(unique=true)
	private String nomeMese;

	public int getIdMese() {
		return idMese;
	}

	public int getIdMese(String nomeMese) {
		int idMese = 0;
		switch (nomeMese) {
		case "Gennaio":	{
			idMese = 1;
			break;
		}
		case "Febbraio": {
			idMese = 2;
			break;
		}
		case "Marzo": {
			idMese = 3;
			break;
		}
		case "Aprile": {
			idMese = 4;
			break;
		}
		case "Maggio": {
			idMese = 5;
			break;
		}
		case "Giugno": {
			idMese = 6;
			break;
		}
		case "Luglio": {
			idMese = 7;
			break;
		}
		case "Agosto": {
			idMese = 8;
			break;
		}
		case "Settembre": {
			idMese = 9;
			break;
		}
		case "Ottobre": {
			idMese = 10;
			break;
		}
		case "Novembre": {
			idMese = 11;
			break;
		}
		case "Dicembre": {
			idMese = 12;
			break;
		}
		}
		return idMese;
	}
	
	public void setIdMese(int idMese) {
		this.idMese = idMese;
	}

	public String getNomeMese() {
		return nomeMese;
	}

	public void setNomeMese(String nomeMese) {
		this.nomeMese = nomeMese;
	}

	
}
