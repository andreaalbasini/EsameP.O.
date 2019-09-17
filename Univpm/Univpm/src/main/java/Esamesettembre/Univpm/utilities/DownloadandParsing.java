package Esamesettembre.Univpm.utilities;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import Esamesettembre.Univpm.model.Vegetablesproducts;

/**
 * 
 * Classe che racchiude i metodi per il download del dataset e il parsing del file csv contenuto nell'url del dataset
 * 
 */

public class DownloadandParsing {

		
		private List<Vegetablesproducts> vegetablesList;
		private int limit;
		private String link = "";
		
		/**
		 * Due tipi di costruttori permettono la lettura controllata del dataset. Nel primo caso si inizializza la variabile limit a 1000,
		 * nel secondo si passa al costruttore il parametro contenente il valore del limite desiderato.
		 * @return 
		 * 
		 */
		
		public DownloadandParsing () {
			this.vegetablesList = new ArrayList<Vegetablesproducts>();
			this.limit = 1000;
		}
		
		/*public DownloadandParsing(int limit) {
			this.vegetablesList = new Vector<Vegetablesproducts>();
			this.limit = limit;
		}
		*/
		public String download(String url) {
			try {
				URLConnection openConnection = new URL(url).openConnection();  //crea una connesione tra applicazioe e url
				openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
				InputStream input = openConnection.getInputStream();  //crea il flusso di input
				
				 String data = "";
				 String line = "";
				 try {
				   InputStreamReader inputReader = new InputStreamReader(input);  //legge i byte e li decodifica in caratteri
				   BufferedReader br = new BufferedReader(inputReader);  //legge un file di testo
				   
				   while ((line = br.readLine())!=null) {  // legge finchè il file è vuoto
					   data += line;
					   
				   }
				 } finally {
				   input.close();
				 }
				 
				 JSONObject object = (JSONObject) JSONValue.parseWithException(data); 
				 JSONObject objectI = (JSONObject) (object.get("result"));  // assegna alla variabile objectI il json del dataset denominato result
				 JSONArray objectArray = (JSONArray) (objectI.get("resources"));  // assegna al vettore json objectArray il valore di resources che contiene l'url del csv da estrarre
						 
				 for(Object obj : objectArray) {
					 if (obj instanceof JSONObject) {
						 JSONObject obj1 = (JSONObject)obj;
						if(((String)obj1.get("format")).toLowerCase().contains("csv") && ((String)obj1.get("url")).contains("market-prices-vegetable-products_en"))  // estrae il csv desiderato verificando la presenza della stringa 
							//   "market-prices-vegetable-products_en" nell'url che si vuole estrarre
							 link = (String)obj1.get("url");
					 }
				 }			
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println( "\nDownload completato." );
			return link;
		}
		
		/**
		 * Metodo che effettua il parsing del file csv estratto precedentemente col metodo download
		 * 
		 * @param link contiene l'url del csv
		 * @return lista di oggetti Vegetablesproducts con i relativi attributi contenenti i valori del dataset
		 */
		
		
		
		public List<Vegetablesproducts> parsing(String link) {
			
			String line = "";
		    String csvSplitBy = "\"";  // carattere che divide i valori del csv,in questo caso le virgolette
		    BufferedReader br= null;
		    boolean flag1= false, flag2= false;
		    int count = 1;
		    
		    try {
		    	URL urlCSV = new URL(link);
		    	br = new BufferedReader(new InputStreamReader(urlCSV.openStream()));
		    	
		    	while (((line = br.readLine()) != null) && !flag2) {
		    		if (count==this.limit) flag2= true;  // esce dal ciclo quando la variabile count è uguale a limit
		    		if (!flag1) {flag1=true; continue;}  // permette di saltare la prima riga del csv
		    		String[] valore = line.split(csvSplitBy); // dopo aver letto una riga del csv la divide ogni volta che trova le virgolette
		    		String[] valore2 = new String[9];   
		    		for(int i=0, k=0; i<valore.length;i++ ) {      
		    			if(i % 2 != 0) {       //condizione che permette di "filtrare" e di prendere solo i valori desiderati
		    				valore2[k] = valore[i];
		    				k++;
		    			}
		    		}
		    		
		    		
		    		vegetablesList.add(new Vegetablesproducts (valore2[0],valore2[1],valore2[2],valore2[3],valore2[4],valore2[5],valore2[6],Integer.parseInt(valore2[7]),Double.parseDouble(valore2[8]) ));
	    			
		    		count++;
		    	}
		    } catch (FileNotFoundException e) {
		   		e.printStackTrace();
		   	} catch (IOException e) {
		   		e.printStackTrace();
		   	} finally {
		    	if (br != null) {
		    		try {
		    			br.close();
		    		} catch (IOException e) {
		    			e.printStackTrace();
		   			}
		   		}
		   	}
		    System.out.println("Parsing completato.\n");
		    
	
		    return vegetablesList;
		}
		
		// Metodo che restituisce la lista Vegetablesproducts in alternativa al metodo parsing
		
		public List<Vegetablesproducts> getData(){
			return vegetablesList;
		}
}

	

