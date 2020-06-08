package com.sinervis.webapp.ortolano;

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
