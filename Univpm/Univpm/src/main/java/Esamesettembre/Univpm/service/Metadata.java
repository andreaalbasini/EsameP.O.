package Esamesettembre.Univpm.service;
import Esamesettembre.Univpm.model.Vegetablesproducts;
import java.lang.reflect.*;
import java.util.ArrayList;

import java.util.List;

/**
 * Classe utile per la gestione dei metadati 
 */
public class Metadata {
	
	
	
	
		private Object metadata = new ArrayList<>();
			
			public Metadata() {
				
				Field[] fields = Vegetablesproducts.class.getDeclaredFields();//estrae gli attributi della classe Vegetablesproducts

		        for (Field f : fields) {
		        	 List<String> lst = new ArrayList<String>(); //inizializzo la lista in cui andrò a mettere i metadata
		             lst.add("alias:"+ f.getName());
		             lst.add("sourceField:" +f.getName().toUpperCase());
		             lst.add("type:" + f.getType().getSimpleName());
		             Object[] strArray1  =  lst.toArray();
		            
		             ((ArrayList<Object>) metadata).add(strArray1);
		             //Crea una lista e ci va ad aggiungere tutti gli attributi con i propri tipi
		             }
		        
		      
		        
		        }
		        	
		 
			   /**
			 * Metodo che ritorna la lista contenente i metadati
			 * 
			 * @return object contenente i metadati
			 */
			public Object getMetadata() {
				return metadata;
				}

			}
		
		


		

