package com.urcera.ejercicio3;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Ejercicio2Activity extends ListActivity {
    /* Called when the activity is first created. */
	
	private MyAdapter mAdapter = null;
	Ejercicio2Activity mContext = null;
    private static Integer RES_LAYOUTACTIVITY = 1;
	
	// Definición de la estructura de datos
	public class Node {
		public String mTitle;
		public String mDescription;
		public Integer mImageResource;
	}
	
	// ArrayList
	private static ArrayList<Node> mArray = new ArrayList<Node>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setArray();
        mAdapter = new MyAdapter(mContext);
		setListAdapter(mAdapter);
	}
    
    public void setArray() {
    
    	Node n = new Node();
		n.mTitle="Alemania";
		n.mDescription="Alemania (en alemán Deutschland), oficialmente República Federal de Alemania (en alemán: Bundesrepublik Deutschland), es un país de la Europa Central que forma parte de la Unión Europea (UE). Limita al norte con el mar del Norte, Dinamarca y el mar Báltico; al este con Polonia y la República Checa; al sur con Austria y Suiza, y al oeste con Francia, Luxemburgo, Bélgica y los Países Bajos. El territorio de Alemania abarca 357.021 km ² y posee un clima templado. Con más de 82 millones de habitantes, representa la mayor población entre los Estados miembros de la Unión Europea y es el hogar del tercer mayor grupo de emigrantes internacionales.";
		n.mImageResource=R.drawable.alemania;
		mArray.add(n);
		n= new Node();
		n.mTitle="Australia";
		n.mDescription="Australia (oficialmente, en inglés, Commonwealth of Australia: Confederación de Australia) es un país de Oceanía. Ocupa la principal masa continental de la plataforma llamada Sahul, además de algunas islas en los océanos Pacífico, Índico y Antártico. Los países más cercanos a Australia son Indonesia, Timor Oriental y Papúa Nueva Guinea al norte, las Islas Salomón, Vanuatu y la dependencia francesa de Nueva Caledonia al noreste, y Nueva Zelanda al sureste. Australia es el sexto país más grande del mundo con una superficie de 7.686.850 km².";
		n.mImageResource=R.drawable.australia;
		mArray.add(n);
		n= new Node();		
		n.mTitle="Belice";
		n.mDescription="Belice (en inglés: Belize) es un país de América ubicado en el extremo noreste de América Central. Limita al norte con México y al oeste con Guatemala y al sur. El golfo de Honduras lo separa del país homónimo, motivo por el cual fue conocido anteriormente como Honduras Británica hasta adquirir su actual denominación en razón de la ciudad de Belice (la maya Holzuz) y el río en cuya desembocadura está edificada. Su capital es Belmopán y la ciudad de Belice, antigua capital del país, es la principal aglomeración urbana y además el principal puerto.";
		n.mImageResource=R.drawable.belice;
		mArray.add(n);
		n= new Node();
		n.mTitle="Canadá";
		n.mDescription="Canadá (pronunciado en inglés Canada y en francés Canada) es una monarquía parlamentaria federal de América, ubicada en el extremo norte de América del Norte. Se extiende desde el océano Atlántico al este, el océano Pacífico al oeste, y hacia el norte hasta el océano Ártico, compartiendo frontera con los Estados Unidos de América al sur y al noroeste con su estado Alaska. Es el segundo país más extenso del mundo después de Rusia, y también el más septentrional. Ocupa cerca de la mitad del territorio de Norteamérica.";
		n.mImageResource=R.drawable.canada;
		mArray.add(n);
		n= new Node();
		n.mTitle="Chile";
		n.mDescription="Chile es un país de América, ubicado en el extremo sudoeste de América del Sur. Su nombre oficial es República de Chile y su capital es la ciudad de Santiago. Chile se describe normalmente constituido por tres zonas. La primera de ellas, conocida como Chile continental, comprende una larga y estrecha franja de tierra en la costa occidental del Cono Sur que se extiende mayormente desde la ribera sudoriental del océano Pacífico hasta la cordillera de los Andes, entre los paralelos 17°29' S y 56°32' S, a lo largo de 4270 km. Alcanza un ancho máximo de 445 km en los 52°21' S, a la altura del estrecho de Magallanes, y un ancho mínimo de 90 km en los 31°37' S, entre Punta Amolanas y Paso de la Casa de Piedra. Limita al norte con Perú, al este con Bolivia y Argentina, totalizando 6339 km de fronteras terrestres, y al sur con el paso Drake. La segunda, denominada Chile insular, corresponde a un conjunto de islas de origen volcánico en el océano Pacífico Sur: el archipiélago de Juan Fernández y las islas Desventuradas, pertenecientes a Sudamérica, la isla Salas y Gómez y la isla de Pascua, geográficamente ubicadas en la Polinesia. La tercera, llamada Territorio Chileno Antártico, es una zona de la Antártida de 1 250 257,6 km² entre los meridianos 53° W y 90° W sobre la cual Chile reclama soberanía, prolongando su límite meridional hasta el Polo Sur.";
		n.mImageResource=R.drawable.chile;
		mArray.add(n);
		n= new Node();
		n.mTitle="Ecuador";
		n.mDescription="Ecuador (oficialmente República del Ecuador) es un país situado en la parte noroeste de América del Sur. Ecuador limita al norte con Colombia, al sur y al este con Perú y al oeste con el océano Pacífico. El país tiene una extensión de 256 370 km² y una población de casi 15 millones de personas. Ecuador es surcado de norte a sur por una sección volcánica de la cordillera de los Andes, con 70 volcanes, siendo el más alto el Chimborazo, con 6310 msnm. Al oeste de los Andes se presentan el Golfo de Guayaquil y una llanura boscosa; y al este, la Amazonia. Es el país con la más alta concentración de ríos por kilómetro cuadrado en el mundo. En el territorio ecuatoriano, que incluye las islas Galápagos 1000 km al oeste de la costa, se encuentra la biodiversidad más densa del planeta";
		n.mImageResource=R.drawable.ecuador;
		mArray.add(n);
		n= new Node(); 
		n.mTitle="Estados Unidos de América";
		n.mDescription="Estados Unidos de América (en inglés: United States of America o USA); de manera abreviada, Estados Unidos, EUA o EE. UU.; es una república federal constitucional compuesta por 50 estados y un distrito federal. La mayor parte del país se ubica en el centro de América del Norte —donde se encuentran sus 48 estados contiguos y Washington D. C., el distrito de la capital—, entre los océanos Pacífico y el Atlántico, limita con Canadá al norte y con México al sur. El estado de Alaska está en el noroeste del continente, limitando con Canadá al este y separado de Rusia al oeste por el estrecho de Bering. El estado de Hawái es un archipiélago polinesio en medio del océano Pacífico, y es el único estado estadounidense que no se encuentra en América. El país también posee varios territorios en el mar Caribe y en el Pacífico. Con 9,83 millones de km² y con más de 308 millones de habitantes, es el tercer o cuarto país más grande por área total y el tercero más grande tanto por la superficie terrestre como por población. Es una de las naciones del mundo étnicamente más diversas y multiculturales, producto de la inmigración a gran escala.";
		n.mImageResource=R.drawable.eeuu;
		mArray.add(n);
		n= new Node();
		n.mTitle="España";
		n.mDescription="España, también denominado Reino de España, es un país soberano, miembro de la Unión Europea, constituido en Estado social y democrático de Derecho y cuya forma de gobierno es la monarquía parlamentaria. Su territorio, con capital en Madrid, ocupa la mayor parte de la península Ibérica, al que se añaden los archipiélagos de las islas Baleares (en el mar Mediterráneo occidental) y de las islas Canarias (en el océano Atlántico nororiental), así como en el norte del continente africano las ciudades autónomas de Ceuta y Melilla, además de los distritos y posesiones menores de las islas Chafarinas, el peñón de Vélez de la Gomera y el peñón de Alhucemas. El municipio de Llivia, rodeado totalmente por territorio francés, en los Pirineos, completa el conjunto de territorios junto con la isla de Alborán, las islas Columbretes y una serie de islas e islotes frente a sus propias costas. Tiene una extensión de 504.645 km², siendo el cuarto país más extenso del continente, tras Rusia, Ucrania y Francia. Con una altitud media de 650 metros es uno de los países más montañosos de Europa. Su población es de 47.190.493 habitantes, según datos del padrón municipal de 2011.";
		n.mImageResource=R.drawable.espana;
		mArray.add(n); 
		n= new Node();
		n.mTitle="Grecia";
		n.mDescription="Grecia (en griego moderno: Elláda; en griego antiguo: Hellás), oficialmente República Helénica (Ellinikí Dimokratía), es un país soberano miembro de la Unión Europea situado en el sureste de Europa. Está constituido en República parlamentaria. Su territorio, con capital en Atenas, ocupa la región más meridional de la Península Balcánica, al que se añaden las casi 6000 islas griegas que se extienden por el Mar Mediterráneo, entre las que estarían las islas Jónicas, las Sarónicas, las Cícladas, las Espóradas, la isla de Creta y el archipiélago del Dodecaneso.";
		n.mImageResource=R.drawable.grecia;
		mArray.add(n);
		n= new Node();
		n.mTitle="Japón";
		n.mDescription="Japón (Nihon o Nippon, oficialmente Nippon-koku, 'Estado de Japón'; significado literal: 'el país del origen del sol') , es un país insular del este de Asia. Está ubicado entre el océano Pacífico y el mar del Japón, al este de China, Rusia y la península de Corea. Japón está formado por cuatro islas principales: Honshu, Hokkaido, Kyushu y Shikoku, que forman el 97% de la superficie total del país, y por otras 6.848 islas menores adyacentes. Tiene una población de 127 millones de personas, la décima más numerosa del mundo. El área metropolitana de Tokio, que incluye a la ciudad capital de Tokio y las prefecturas de sus alrededores, es el área urbana más grande del mundo en términos de población, albergando a más de 30 millones de habitantes. Es el segundo país más poblado de Asia Oriental, después de China.";
		n.mImageResource=R.drawable.japon;
		mArray.add(n);
			
	}
         
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{

		Intent i = new Intent(mContext, LayoutActivity.class);
    	i.putExtra("TITLE", mArray.get(position).mTitle);
    	i.putExtra("DESCRIPTION", mArray.get(position).mDescription);
    	i.putExtra("IMAGE", mArray.get(position).mImageResource);    	
    	startActivityForResult(i, RES_LAYOUTACTIVITY); 
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
				
			//Obtención de la imagen
			ImageView img = (ImageView) view.findViewById(R.id.image);
			img.setImageDrawable(myContext.getResources().getDrawable(mArray.get(position).mImageResource));					
			//Obtención del título	
			TextView t = (TextView) view.findViewById(R.id.title);			
			t.setText(mArray.get(position).mTitle);
			//Obtención de la descripción
			TextView t2 = (TextView) view.findViewById(R.id.description);
			t2.setText(mArray.get(position).mDescription);
			
			return view;
		}
    }
}


