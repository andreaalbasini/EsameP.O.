package utilities;


	
	
	
	
	


	import java.io.BufferedReader;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.net.URL;
	import java.net.URLConnection;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.*;

	//import org.json.simple.JSONArray;
	//import org.json.simple.JSONObject;
	//import org.json.simple.JSONValue;
	//import org.json.simple.parser.ParseException;

	import model.Vegetablesproducts;

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
		
		public DownloadAndParsing () {
			this.vegetablesList = new ArrayList<Vegetablesproducts>();
			this.limit = 1000;
		}
		
		public DownloadAndParsing(int limit) {
			this.vegetablesList = new Vector<Vegetablesproducts>();
			this.limit = limit;
		}
		
}
