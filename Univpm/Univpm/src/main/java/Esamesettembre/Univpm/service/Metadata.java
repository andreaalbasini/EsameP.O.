package Esamesettembre.Univpm.service;
import Esamesettembre.Univpm.model.Vegetablesproducts;
import java.lang.reflect.*;
import java.util.ArrayList;

import java.util.List;

/**
 * Classe utile per la gestione dei matadati quando vengono richiesti
 */
public class Metadata {
	
	
	
	
		private Object metadata = new ArrayList<>();
			
			public Metadata() {
				
				Field[] fields = Vegetablesproducts.class.getDeclaredFields();//estrae gli attributi della classe Vegetablesproducts

		        for (Field f : fields) {
		        	 List<String> lst = new ArrayList<String>();
		             lst.add("alias:"+ f.getName());
		             lst.add("sourceField:" +f.getName().toUpperCase());
		             lst.add("type:" + f.getType().getSimpleName());
		             Object[] strArray1  =  lst.toArray();
		             
		             ((ArrayList<Object>) metadata).add(strArray1);
		             
		             }
		        
		      
		        
		        }
		        	
		 
			   /**
			 * Metodo che ritorna la lista di mappe contenente i metadati
			 * 
			 * @return lista dei metadati
			 */
			public Object getMetadata() {
				return metadata;
				}

			}
		
		


		

