package com.sinervis.webapp.ortolano.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinervis.webapp.ortolano.model.Mese;
import com.sinervis.webapp.ortolano.repository.MeseRepositoryInterface;

@Component
public class AppConfig {
	public List<String> mesi = new ArrayList<String>(Arrays.asList("Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"));
	
	@Autowired
	MeseRepositoryInterface meseRepository;
	
	@PostConstruct //dopo aver eseguito il costruttore carica questo metodo
	public void init(){
		//serve per rendere persistente il contenuto della tabella mesi
		//dopo la prima inizializzazione, la tabella non va ricaricata, quindi occorre aggiungere un controllo: findAll()
		//se è vuoto, la tabella non è mai stata inizializzata
		for (String nomeMese:mesi) {
			Mese mese = new Mese();
			mese.setNomeMese(nomeMese);
			meseRepository.save(mese);
		}
	}
}
