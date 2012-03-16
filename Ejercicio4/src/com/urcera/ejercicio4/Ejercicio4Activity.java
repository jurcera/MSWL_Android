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
import android.util.Log;
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
	private ILocationService ils = null;
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               
        mContext = this;
        final GeoRssParser mRssParser = new GeoRssParser();
              
        //Log.d("Ej3", "Antes Cargar Array");
        
         
        ils = new ILocationService()
        {

			@Override
			public void updateCurentLocation(Location loc) {
				// TODO Auto-generated method stub
				
				// No voy a hacer nada con la localización por ahora.
				//mLoc = loc;
				
				if (pd != null) 
				{
					pd.dismiss();
					pd = null;
				}
				
		        try {
					mArray = mRssParser.parseGeoRssURL("http://earthquake.usgs.gov/earthquakes/catalogs/eqs7day-M5.xml");
													
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
        
        
        //Aqui habría que recoger el indice del array donde se ha metido el listener para poder desregistrarlo al salir de la activity   
		//No hace falta recogerlo le paso el ils en onStop y ya lo desregistra.
        LocService.regListener(ils); 
		
		
        
		pd = ProgressDialog.show(mContext, "Please wait ...", "Waiting for location ...", true);
				
		startService(new Intent(mContext,LocService.class));
        
        
    }
    
    /* En esta versión de Android he visto que pulsando el botón de atrás va al onStop y 
     * pulsando el botón de home va primero al onPause y después al onStop con lo que el
     * desrregistro lo hago sólo en el onStop
     * 
      
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity", "OnPause");
        LocService.unregListener(ils);
    }
    */
    
    @Override 
    protected void onResume() {
	   super.onResume();
	   mAdapter = null;
	   //ils = null;
	   //pd = null;
    }
    
    @Override 
    protected void onRestart() {
	   super.onRestart(); 
	   mArray.clear();
	}
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity", "OnStop");
        LocService.unregListener(ils);
   
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
					
			//Obtención del título	
			TextView tv1 = (TextView) view.findViewById(R.id.title);			
			tv1.setText(mArray.get(position).getTitle());
			//Obtención de la descripción
			TextView tv2 = (TextView) view.findViewById(R.id.description);
			tv2.setText(mArray.get(position).getDescription());
			//Obtención del link
			TextView tv3 = (TextView) view.findViewById(R.id.link);
			tv3.setText(mArray.get(position).getLink());
			//Obtención de la latitud
			TextView tv4 = (TextView) view.findViewById(R.id.latitude);
			tv4.setText(mArray.get(position).getLatitude().toString());
			//Obtención del la longitud
			TextView tv5 = (TextView) view.findViewById(R.id.longitude);
			tv5.setText(mArray.get(position).getLongitude().toString());
			
			return view;
		}
    }
}