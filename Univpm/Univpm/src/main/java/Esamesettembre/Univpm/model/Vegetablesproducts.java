package Esamesettembre.Univpm.model;

import java.io.Serializable;


/**
 * 
 *	Classe che modella i campi del file CSV
 *
 */
public class Vegetablesproducts implements Serializable { 
	
	
	
		private String Category, SectorCode, ProductCode, ProductDesc, ProductBriefDescription, Unit, Country;
		private int Period;
		private double  MPMarketPrice; 
	
		/**
		 * Costruttore
		 * @param Category 
		 * @param SectorCode
		 * @param ProductCode
		 * @param ProductDesc
		 * @param ProductBriefDescription
		 * @param Unit
		 * @param Country
		 * @param Period
		 * @param MPMarketPrice
		 */
			public  Vegetablesproducts (String Category, String SectorCode, String ProductCode, String ProductDesc, String ProductBriefDescription,String  Unit, String  Country,  int Period, double  MPMarketPrice )
		{
			this.Category= Category;
			this.SectorCode= SectorCode;
			this.ProductCode= ProductCode;
			this.ProductDesc= ProductDesc;
			this.ProductBriefDescription= ProductBriefDescription;
			this.Unit=Unit;
			this.Country= Country;
			this.Period= Period;
			this.MPMarketPrice= MPMarketPrice;
		}
		
	
		public String getCategory() {
	        return Category;
	        
	    }public String getSectorCode() {
	        return SectorCode;
	        
	    }public String getProductCode() {
	        return ProductCode;
	        
	    }public String getProductDesc() {
	        return ProductDesc;
	        
	    }public String getProductBriefDescription() {
	        return ProductBriefDescription;
	        
	    }public String getUnit() {
	        return Unit;
	        
	    }public String getCountry() {
	        return Country;
	        
	    }public int getPeriod() {
	        return Period;
	        
	    }public double getMPMarketPrice() {
	        return MPMarketPrice;
	    }
	  
	    /**
	     * Stampa l'oggetto
	     */
	    
	    
	    @Override
	    public String toString() {
	        return "Products: {Category='" + Category  +
	                ", SectorCode='" + SectorCode + 
	                ", ProductCode='" + ProductCode + 
	                ", ProductDesc='" + ProductDesc + 
	                ", ProductBriefDescription='" + ProductBriefDescription + 
	                ", Unit=" + Unit +", Country=" + Country +", Period=" + Period +
	                ", MPMarketPrice=" + MPMarketPrice +  
	                '}';
	    }
	}



