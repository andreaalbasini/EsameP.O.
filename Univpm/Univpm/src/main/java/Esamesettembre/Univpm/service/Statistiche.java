package Esamesettembre.Univpm.service;
import java.util.*;
public class Statistiche {
	
	
		
		/**
		 * Metodo che effettua un conteggio sul numero di elementi di una lista
		 * 
		 * @param lista contiene i valori da contare
		 * @return dimensione della lista
		 */
		public static int count(List lista) {
			return lista.size();
		}
		
		/**
		 * Metodo che restituisce la somma dei valori di una lista numerica
		 * 
		 * @param lista contiene i valori che andranno sommati
		 * @return somma dei valori
		 */
		public static double sum(List<Number> lista) {
			double somma=0;
			for(Number numero : lista)
				somma += numero.doubleValue();   //scorre la lista e somma tutti i valori
			return somma;
		}
		
		
		/**
		 * Metodo che restituisce la media dei valori di una lista numerica
		 * 
		 * @param lista contiene i valori utilizzati per calcolare la media
		 * @return media dei valori
		 */
		
		public static double avg(List<Number> lista) {
			return sum(lista)/count(lista);  //restituisce la media
		}
		
		/**
		 * Metodo che restituisce il massimo tra il valori di una lista numerica
		 * 
		 * @param lista contiene i valori dai quali si estrae il massimo
		 * @return massimo dei valori
		 */
		public static double max(List<Number> lista) {
			double max = lista.get(0).doubleValue();  //assegna il primo valore della lista a max
			for(Number numero : lista) {
				if(numero.doubleValue() > max) max = numero.doubleValue();  //scorre la lista e verifica se il valore dell'indice corrispondente � maggiore di max
			}
			return max;
		}
		
		/**
		 * Metodo che restituisce il minimo tra il valori di una lista numerica
		 * 
		 * @param lista contiene i valori dai quali si estrae il minimo
		 * @return minimo dei valori
		 */
		public static double min(List<Number> lista) {
			double min = lista.get(0).doubleValue();  //assegna il primo valore della lista a min
			for(Number numero : lista) {
				if(numero.doubleValue() < min) min = numero.doubleValue();  //scorre la lista e verifica se il valore dell'indice corrispondente � minore di min
			}
			return min;
		}
		
		/**
		 * Metodo che restituisce la deviazione standard dei valori di una lista numerica
		 * 
		 * @param lista contiene i valori con i quali si calcola la deviazione standard
		 * @return deviazione standard
		 */
		public static double DevStd(List<Number> lista) {  //formula della deviazione standard: DevStd = radice della sommatoria degli (xi-xmedio)^2
			double somma=0;
			for(Number numero : lista) {
				somma += Math.pow(numero.doubleValue() - avg(lista), 2);
			}
			return Math.sqrt(somma);
		}
		
		/**
		 * Metodo che conta le occorrenze di un elemento all'interno di una lista
		 * 
		 * @param lista contiene i valori per i quali si vogliono calcolare le occorrenze
		 * @return restituisce una map chiave-valore dove le chiavi sono gli elementi della lista e i valori le corrispondenti occorrenze
		 */
		public static Map<Object, Integer> ElementiUnici(List lista) {
			Map<Object,Integer> mappa = new HashMap<>();  //creazione della mappa
			for(Object obj : lista) {  //scorre la lista
				if(mappa.containsKey(obj))  //controlla se la chiave esiste già
					mappa.replace(obj, mappa.get(obj) + 1);  //se esiste aumenta il suo valore di 1
				else
					mappa.put(obj, 1);  //se non esiste la crea e le assegna il valore 1
			}
			return mappa;
		}
		
		/**
		 * Metodo che restituisce una mappa nella quale vengono visualizzate tutte le statistiche numeriche di una lista 
		 * 
		 * @param lista fornisce i valori con i quali si possono calcolare tutte le statistiche
		 * @return map che contiene come chiavi il nome della statistica e come valore quello calcolato tramite i metodi della classe
		 */
		public static List<String> NumStats(String campo, List<Number> lista){
			List<String> list = new ArrayList<>();  //crea una mappa che contiene le chiavi e i valori delle statistiche numeriche
			list.add("field:"+ campo);
			list.add("count:"+ count(lista));
			list.add("sum:"+sum(lista));
			list.add("avg:"+ avg(lista));
	        list.add("max:"+ max(lista));
	        list.add("min:"+ min(lista));
	        list.add("DevStd:"+ DevStd(lista));
	        return list;
		}
	
		
		 
		/**
		 * Metodo che restituisce una lista nella quale vengono visualizzate tutte le statistiche della lista contenente gli attributi non numerici
		 * 
		 * @param lista fornisce i valori con i quali si possono calcolare tutte le statistiche non numeriche
		 * @return map che contiene come chiavi il nome della statistica e come valore quello calcolato tramite i metodi della classe
		 */
	
		
		public static List<String> StrStats(String campo, List lista) {
			List<String> lst = new ArrayList<>();  //crea una lista che contiene le statistiche non numeriche
			lst.add("field:"+ campo);
			lst.add("count:"+count(lista));
			lst.add("elementi unici:"+ ElementiUnici(lista));
	        return lst;
		}
		
		
		
		/**
		 * Metodo che serve a visualizzare il tipo di statistiche in base al campo specificato
		 * 
		 * @param campo contiene il nome dell'attributo del quale si vogliono si vogliono calcolare le statistiche 
		 * @param list contiene la lista dei valori utili per il calcolo delle statistiche
		 * @return
		 */
		
	
		
		public List<String> getStats(String campo, List<Object> list) {
			List<String> lst1 = new ArrayList();
			if(!list.isEmpty()) {
				 // se il primo valore è un numero crea una lista di numeri e gli passa i valori della lista castati a Number
				if (list.get(0) instanceof Number) { 
					List<Number> numList = new ArrayList<>();
					for (Object elem : list) {
						numList.add(((Number) elem));
					}
					lst1 = NumStats(campo, numList); // calcola le statistiche numeriche
				}
				// se il primo valore non è un numero calcola le statistiche per le stringhe
				else {
					lst1 = StrStats(campo, list);
				}
			}
			return lst1;
		
		}
	}



	


