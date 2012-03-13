package com.urcera.ejercicio4;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Ejercicio4Activity extends ListActivity {
	
	// Definicion de variables
	private ProgressDialog pd = null;
	Ejercicio4Activity mContext = null;
	private MyAdapter mAdapter = null;
	private static ArrayList<GeoRSSNode> mArray = new ArrayList<GeoRSSNode>();
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               
        mContext = this;
        final GeoRssParser mRssParser = new GeoRssParser();
              
        //Log.d("Ej3", "Antes Cargar Array");
        
        
        ILocationService ils = new ILocationService()
        {

			@Override
			public void updateCurentLocation(Location loc) {
				// TODO Auto-generated method stub
				
				// No voy a hacer nada con la localizaci�n por ahora.
				//mLoc = loc;
				
				if (pd != null) 
				{
					pd.dismiss();
					pd = null;
				}
				
		        try {
					mArray = mRssParser.parseGeoRssURL("http://earthquake.usgs.gov/earthquakes/catalogs/eqs7day-M5.xml");
					// mArray = mRssParser.parseGeoRssURL("http://www.suso.com/eqs7day-M5.xml");
								
				} catch (ParserConfigurationException e) {			
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

		              
		        //Log.d("Ej3", "Despues Cargar Array");
		        
		        mAdapter = new MyAdapter(mContext);
		        
		     
				setListAdapter(mAdapter);
			
				
			}
        
        };        
        
        
        //Aqui habr�a que recoger el indice del array donde se ha metido el listener para poder desregistrarlo al salir de la activity   
		
        LocService.regListener(ils); 
		
		
        
		pd = ProgressDialog.show(mContext, "Please wait ...", "Waiting for location ...", true);
		
		startService(new Intent(mContext,LocService.class));
        
        
    }
    
    
    public static class MyAdapter extends BaseAdapter {

		private Context myContext;
		
		public MyAdapter(Context c) {
			myContext = c;
		}
    	
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mArray.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view;

			// This IF ELSE build a new view if it's necessary o re-use a view			
			if (convertView == null) {
				// Make up a new view
				LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.main, null);
			} else {
				// Use convertView if it is available
				view = convertView;
			}
					
			//Obtenci�n del t�tulo	
			TextView tv1 = (TextView) view.findViewById(R.id.title);			
			tv1.setText(mArray.get(position).getTitle());
			//Obtenci�n de la descripci�n
			TextView tv2 = (TextView) view.findViewById(R.id.description);
			tv2.setText(mArray.get(position).getDescription());
			//Obtenci�n del link
			TextView tv3 = (TextView) view.findViewById(R.id.link);
			tv3.setText(mArray.get(position).getLink());
			//Obtenci�n de la latitud
			TextView tv4 = (TextView) view.findViewById(R.id.latitude);
			tv4.setText(mArray.get(position).getLatitude().toString());
			//Obtenci�n del la longitud
			TextView tv5 = (TextView) view.findViewById(R.id.longitude);
			tv5.setText(mArray.get(position).getLongitude().toString());
			
			return view;
		}
    }
}