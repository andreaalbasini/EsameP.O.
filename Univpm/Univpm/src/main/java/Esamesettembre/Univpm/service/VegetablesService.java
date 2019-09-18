package Esamesettembre.Univpm.service;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import org.springframework.stereotype.Service;

import Esamesettembre.Univpm.utilities.*;
import Esamesettembre.Univpm.model.*;


/**
 * 
 *  Classe che gestisce le operazioni di download e carica del dataset e che mette in comunicazione tutte le le classi con il controller
 * attraverso metodi opportunamente costruiti
 *
 */

@Service
public class VegetablesService {
	
			private String url = " http://data.europa.eu/euodp/data/api/3/action/package_show?id=b8c13971-e315-470e-a125-40d67fe7067b";
			private DownloadandParsing utilities;
			private Metadata serviceMeta;
			private Statistiche serviceStatistiche;
			private List<Vegetablesproducts> lista;
			
			/**
			 * Costruttore che effettua al primo avvio dell'applicazione il download e il parsing dei dati che restituiscono i valori del file csv
			 */
			
			 
			 
			public VegetablesService() {
				
				this.utilities = new DownloadandParsing();
				this.serviceMeta = new Metadata();
				this.serviceStatistiche = new Statistiche();
		
				
				String link="";
				
				link = utilities.download(url);
			    lista = utilities.parsing(link);
			}
		
			/**
			 * * Metodo che restituisce i metadati del file CSV
			 * 
			 * @return	la lista contenente i metadati
			 */
			
			public List<Map> getMetadata() {
				return serviceMeta.getMetadata();
			}
			
		/**
		 * Metodo che restituisce i dati del file csv
			
		 * @return  lista dei dati csv
		 */
			public List<Vegetablesproducts> getData() {
		 		return this.lista;
			}
			
			/**
			 * Metodo che restituisce le statistiche di un dato attributo
			 
			 * @param nomeCampo contiene il valore dell'attributo del quale si vogliono calcolare le statistiche
			 * @return map delle statistiche desiderate
			 */
		public Map<String, Object> getStatistiche(String nomeCampo) {
				Map<String, Object> map = new HashMap<>();
				Map<String, Object> mapError = new HashMap<>();
				mapError.put("Errore", "Campo inesistente");
				Field[] fields = Vegetablesproducts.class.getDeclaredFields();
				for (Field f : fields) {
					if(nomeCampo.equals(f.getName()))
						map = serviceStatistiche.getStats(nomeCampo, fieldValues(nomeCampo, getData()));
				}
				if(map.isEmpty()) return mapError;
				else return map;
			}
			
		
			
		/**
		 * Metodo che estrae i valori di un determinato campo, passato tramite fieldName
			
		 * @param fieldName nome del campo del file CSV
		 * @param list lista che si ottiene dopo aver effettuato il parsing, vettore di oggetti "Vegetablesproducts"
		 * @return la lista che contiene i valori di un determinato campo
		 */
			public List fieldValues(String fieldName, List list) {
				List<Object> values = new ArrayList<>();
				try {
					Field[] fields = Vegetablesproducts.class.getDeclaredFields();
					for(Object e : list) {
						// scorre il vettore di campi e controlla se il nome del campo corrispondente è uguale a quello passatogli come parametro 
						for(int i=0; i < fields.length; i++) {
							if(fieldName.equals(fields[i].getName())) {
								Method m = e.getClass().getMethod("get"+fields[i].getName());
								Object val = m.invoke(e);
								values.add(val); // se il controllo restituisce vero, aggiunge alla lista il valore dell'ogetto della lista passatagli come parametro ottenuto con il metodo getMethod
							}
						}
					}
				} catch(NoSuchMethodException ex) {
					ex.printStackTrace();
				} catch(SecurityException ex) {
					ex.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
				return values;
			}
			
			
	}



