package Esamesettembre.Univpm.controller;

import Esamesettembre.Univpm.model.Vegetablesproducts;
import Esamesettembre.Univpm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@RestController
public class Controller {
	 //creo una variabile della classe Service
		@Autowired  //il controllore dipende da service, stiamo dunque iniettando una dipendenza
		private VegetablesService service;
		/**
	     * Costruttore che con l'annotazione @Autowired viene lanciato automaticamente all'avvio da Spring e esegue il collegamento al Service
	     *
	     * @param service riferimento all'istanza del service inizializzata da Spring
	     */
			  public Controller (VegetablesService service) {
	    this.service = service;
	  }
	//metodi per la comunicazione con il client che gestiscono le richieste GET e POST

	/**
	 * Metodo che gestisce la richiesta GET alla rotta "/data", restituisce l'intero dataset
	 *
	 * @return lista di tutti gli oggetti del dataset
	 */
	//esempio: localhost:8080/data
		@GetMapping("/data")
	    public List getAllData() {
	        return service.getData();
	    }
		
	    /**
	     * Metodo che gestisce la richiesta GET alla rotta "/metadata", restituisce i metadata
	     *
	     * @return lista dei metadata
	     */
	    @GetMapping("/metadata")
	    public List<Map> getMetadata() {
	        return service.getMetadata();
	    }
		
	    /**
	     * Metodo che gestisce la richiesta GET alla rotta "/stats" e che restituisce le statistiche
	     * 
	     * @param fieldName nome del campo del quale si vogliono calcolare le statistiche
	     * @return lista delle statistiche
	     */
	    @GetMapping("/stats")
	    public List<Map> getStats(@RequestParam(value = "field", defaultValue = "") String fieldName) {
	    	Field[] fields = Vegetablesproducts.class.getDeclaredFields();
	    	List<Map> list = new ArrayList<>();
	    	if(fieldName.equals("")) {  // se non viene specificato il campo calcola le statistiche di ogni attributo
	    		for(int i=0; i < fields.length; i++) {
	    			list.add(service.getStatistiche(fields[i].getName()));		
	    		}
	    		return list;
	    	}
	    	else {  // altrimenti calcola le statistiche del solo campo specificato
	    		list.add(service.getStatistiche(fieldName));
	    		return list;
	    	}
		}
	}



