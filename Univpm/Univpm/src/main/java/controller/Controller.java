package controller;

import model.Vegetablesproducts;
import Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
	private VegetablesService service;


	/**
     * Costruttore che con l'annotazione @Autowired viene lanciato automaticamente all'avvio da Spring e esegue il collegamento al Service
     *
     * @param service riferimento all'istanza del service inizializzata da Spring
     */
public Controller(VegetablesService service) {
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
	
	
}
