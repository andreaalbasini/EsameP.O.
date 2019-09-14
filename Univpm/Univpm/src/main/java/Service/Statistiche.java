package Service;

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
	
	
}


