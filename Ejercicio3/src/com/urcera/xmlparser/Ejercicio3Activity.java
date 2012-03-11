package com.urcera.xmlparser;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Ejercicio3Activity extends ListActivity {
	
	// private final String TAG = "MainActivity";
	Ejercicio3Activity mContext = null;
	private MyAdapter mAdapter = null;
	private static ArrayList<GeoRSSNode> mArray = new ArrayList<GeoRSSNode>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
        
        mContext = this;
        GeoRssParser mRssParser = new GeoRssParser();
        
        //Log.d("Ej3", "Antes Cargar Array");
        
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