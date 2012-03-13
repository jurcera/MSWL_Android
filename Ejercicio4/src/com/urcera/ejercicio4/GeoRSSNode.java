
package com.urcera.ejercicio4;

public class GeoRSSNode {

	String mTitle = null;
	String mDescription = null;
	String mLink = null;
	
	// It's possible use Location structure to save 
	// geolocation data
	Double mLatitude = 0.0;
	Double mLongitude = 0.0;
	
	
	public GeoRSSNode (String title, String description, String link, Double latitude, Double longitude)
	{
		mTitle = title;
		mDescription = description;
		mLink = link;
		mLatitude = latitude;
		mLongitude = longitude;

	}
	
	//SUSO: generar métodos para cada una de las variables para que nos devuelva la información
	// Get para obtener el valor
	// Set para modificar el valor
	
	// GET
	
	public String getTitle () 
	{
		return mTitle;
	}
	
	public String getDescription () 
	{
		return mDescription;
	}
	
	public String getLink () 
	{
		return mLink;
	}
	
	public Double getLatitude () 
	{
		return mLatitude;
	}
	
	public Double getLongitude () 
	{
		return mLongitude;
	}
	

	// SET
	
	public void  setTitle (String title)
	{
		mTitle = title;
	}
	
	public void setDescription (String description) 
	{
		mDescription = description;
	}
	
	public void setLink (String link) 
	{
		mLink = link;
	}
	
	public void setLatitude (Double latitude) 
	{
		mLatitude = latitude;
	}
	
	public void getLongitude (Double longitude) 
	{
		mLongitude = longitude;
	}
	
}