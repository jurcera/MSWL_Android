package com.urcera.ejercicio4;

import java.util.ArrayList;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class LocService extends Service {
	

	private static Location mLoc = null;
	
	private static ArrayList<ILocationService> mArrayList = new ArrayList<ILocationService>(); 
	
	@Override
	public IBinder onBind(Intent arg0) {
		
		return null;
	}

	@Override
	public void onCreate() {
		
		Log.d("LocService: ", "Iniciando servicio");
		
		getLocation();
	}
	
	// ********************************************************************************
	// Para registrar un listener de la activity que se conecte al servicio
	// ********************************************************************************
	
	public static void regListener (ILocationService iLocService)
	{ 
		mArrayList.add(iLocService);
		// Habría que controlar que no se añade un listener dos veces
		
		//¿Hay que devolver el indice del array donde se ha añadido el listener?
	}
	
	// ********************************************************************************
	// Para desregistrar un listener de la activity que se conecte al servicio
	// ********************************************************************************
	
	public static void unregListener (ILocationService iLocService)
	{ 
		mArrayList.remove(iLocService);
				
		//Hay que devolver el indice del array donde se ha añadido el listener.
	}
	
	
	private static Location getLoc()
	{ 
		return mLoc;
	}
	
    // *************************************************************************************
    // Obtiene la posición del SERVICIO DE LOCALIZACION
    // *************************************************************************************	
	
	
    private void getLocation ()
    {    
    	LocationManager mLocationManager;
    	LocationListener mLocationListener;
    	
    	mLocationManager = (LocationManager)
    	         getSystemService(Context.LOCATION_SERVICE);
    	
    	mLocationListener = new MyLocationListener();
    	
    	mLocationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER,
    											 5000, 15, mLocationListener); 
    	  	
    }
    
    
    // *************************************************************************************
    // Listener que escucha el LocationManager y cuando se produce un cambio en la posición
    // recorre el array de Activities registradas y ejecuta lo que hay en ellas.
    // *************************************************************************************
    
    private class MyLocationListener implements LocationListener
    {

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			
			mLoc = location;
			Log.d("LocService:", String.valueOf(mLoc.getLatitude()) + 
					           " " + 
					           String.valueOf(mLoc.getLongitude()));
			
			// SUSO
			// Recorrer el array de listener para ejecutar el código en cada activity
			
			for (int i=0; i<mArrayList.size(); i++)
			{
				//Ejecutar con AsyncTask para evitar problemas de que algún listener se cuelgue y deje parado a todo lo demás y además se lancen en paralelo
				mArrayList.get(i).updateCurentLocation(mLoc);
			}
				
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}

		
    	
    }
}
