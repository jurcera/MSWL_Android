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
	
	// Definici�n de la estructura de datos
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
		n.mDescription="Alemania (en alem�n Deutschland), oficialmente Rep�blica Federal de Alemania (en alem�n: Bundesrepublik Deutschland), es un pa�s de la Europa Central que forma parte de la Uni�n Europea (UE). Limita al norte con el mar del Norte, Dinamarca y el mar B�ltico; al este con Polonia y la Rep�blica Checa; al sur con Austria y Suiza, y al oeste con Francia, Luxemburgo, B�lgica y los Pa�ses Bajos. El territorio de Alemania abarca 357.021 km � y posee un clima templado. Con m�s de 82 millones de habitantes, representa la mayor poblaci�n entre los Estados miembros de la Uni�n Europea y es el hogar del tercer mayor grupo de emigrantes internacionales.";
		n.mImageResource=R.drawable.alemania;
		mArray.add(n);
		n= new Node();
		n.mTitle="Australia";
		n.mDescription="Australia (oficialmente, en ingl�s, Commonwealth of Australia: Confederaci�n de Australia) es un pa�s de Ocean�a. Ocupa la principal masa continental de la plataforma llamada Sahul, adem�s de algunas islas en los oc�anos Pac�fico, �ndico y Ant�rtico. Los pa�ses m�s cercanos a Australia son Indonesia, Timor Oriental y Pap�a Nueva Guinea al norte, las Islas Salom�n, Vanuatu y la dependencia francesa de Nueva Caledonia al noreste, y Nueva Zelanda al sureste. Australia es el sexto pa�s m�s grande del mundo con una superficie de 7.686.850 km�.";
		n.mImageResource=R.drawable.australia;
		mArray.add(n);
		n= new Node();		
		n.mTitle="Belice";
		n.mDescription="Belice (en ingl�s: Belize) es un pa�s de Am�rica ubicado en el extremo noreste de Am�rica Central. Limita al norte con M�xico y al oeste con Guatemala y al sur. El golfo de Honduras lo separa del pa�s hom�nimo, motivo por el cual fue conocido anteriormente como Honduras Brit�nica hasta adquirir su actual denominaci�n en raz�n de la ciudad de Belice (la maya Holzuz) y el r�o en cuya desembocadura est� edificada. Su capital es Belmop�n y la ciudad de Belice, antigua capital del pa�s, es la principal aglomeraci�n urbana y adem�s el principal puerto.";
		n.mImageResource=R.drawable.belice;
		mArray.add(n);
		n= new Node();
		n.mTitle="Canad�";
		n.mDescription="Canad� (pronunciado en ingl�s Canada y en franc�s Canada) es una monarqu�a parlamentaria federal de Am�rica, ubicada en el extremo norte de Am�rica del Norte. Se extiende desde el oc�ano Atl�ntico al este, el oc�ano Pac�fico al oeste, y hacia el norte hasta el oc�ano �rtico, compartiendo frontera con los Estados Unidos de Am�rica al sur y al noroeste con su estado Alaska. Es el segundo pa�s m�s extenso del mundo despu�s de Rusia, y tambi�n el m�s septentrional. Ocupa cerca de la mitad del territorio de Norteam�rica.";
		n.mImageResource=R.drawable.canada;
		mArray.add(n);
		n= new Node();
		n.mTitle="Chile";
		n.mDescription="Chile es un pa�s de Am�rica, ubicado en el extremo sudoeste de Am�rica del Sur. Su nombre oficial es Rep�blica de Chile y su capital es la ciudad de Santiago. Chile se describe normalmente constituido por tres zonas. La primera de ellas, conocida como Chile continental, comprende una larga y estrecha franja de tierra en la costa occidental del Cono Sur que se extiende mayormente desde la ribera sudoriental del oc�ano Pac�fico hasta la cordillera de los Andes, entre los paralelos 17�29' S y 56�32' S, a lo largo de 4270 km. Alcanza un ancho m�ximo de 445 km en los 52�21' S, a la altura del estrecho de Magallanes, y un ancho m�nimo de 90 km en los 31�37' S, entre Punta Amolanas y Paso de la Casa de Piedra. Limita al norte con Per�, al este con Bolivia y Argentina, totalizando 6339 km de fronteras terrestres, y al sur con el paso Drake. La segunda, denominada Chile insular, corresponde a un conjunto de islas de origen volc�nico en el oc�ano Pac�fico Sur: el archipi�lago de Juan Fern�ndez y las islas Desventuradas, pertenecientes a Sudam�rica, la isla Salas y G�mez y la isla de Pascua, geogr�ficamente ubicadas en la Polinesia. La tercera, llamada Territorio Chileno Ant�rtico, es una zona de la Ant�rtida de 1 250 257,6 km� entre los meridianos 53� W y 90� W sobre la cual Chile reclama soberan�a, prolongando su l�mite meridional hasta el Polo Sur.";
		n.mImageResource=R.drawable.chile;
		mArray.add(n);
		n= new Node();
		n.mTitle="Ecuador";
		n.mDescription="Ecuador (oficialmente Rep�blica del Ecuador) es un pa�s situado en la parte noroeste de Am�rica del Sur. Ecuador limita al norte con Colombia, al sur y al este con Per� y al oeste con el oc�ano Pac�fico. El pa�s tiene una extensi�n de 256 370 km� y una poblaci�n de casi 15 millones de personas. Ecuador es surcado de norte a sur por una secci�n volc�nica de la cordillera de los Andes, con 70 volcanes, siendo el m�s alto el Chimborazo, con 6310 msnm. Al oeste de los Andes se presentan el Golfo de Guayaquil y una llanura boscosa; y al este, la Amazonia. Es el pa�s con la m�s alta concentraci�n de r�os por kil�metro cuadrado en el mundo. En el territorio ecuatoriano, que incluye las islas Gal�pagos 1000 km al oeste de la costa, se encuentra la biodiversidad m�s densa del planeta";
		n.mImageResource=R.drawable.ecuador;
		mArray.add(n);
		n= new Node(); 
		n.mTitle="Estados Unidos de Am�rica";
		n.mDescription="Estados Unidos de Am�rica (en ingl�s: United States of America o USA); de manera abreviada, Estados Unidos, EUA o EE. UU.; es una rep�blica federal constitucional compuesta por 50 estados y un distrito federal. La mayor parte del pa�s se ubica en el centro de Am�rica del Norte �donde se encuentran sus 48 estados contiguos y Washington D. C., el distrito de la capital�, entre los oc�anos Pac�fico y el Atl�ntico, limita con Canad� al norte y con M�xico al sur. El estado de Alaska est� en el noroeste del continente, limitando con Canad� al este y separado de Rusia al oeste por el estrecho de Bering. El estado de Haw�i es un archipi�lago polinesio en medio del oc�ano Pac�fico, y es el �nico estado estadounidense que no se encuentra en Am�rica. El pa�s tambi�n posee varios territorios en el mar Caribe y en el Pac�fico. Con 9,83 millones de km� y con m�s de 308 millones de habitantes, es el tercer o cuarto pa�s m�s grande por �rea total y el tercero m�s grande tanto por la superficie terrestre como por poblaci�n. Es una de las naciones del mundo �tnicamente m�s diversas y multiculturales, producto de la inmigraci�n a gran escala.";
		n.mImageResource=R.drawable.eeuu;
		mArray.add(n);
		n= new Node();
		n.mTitle="Espa�a";
		n.mDescription="Espa�a, tambi�n denominado Reino de Espa�a, es un pa�s soberano, miembro de la Uni�n Europea, constituido en Estado social y democr�tico de Derecho y cuya forma de gobierno es la monarqu�a parlamentaria. Su territorio, con capital en Madrid, ocupa la mayor parte de la pen�nsula Ib�rica, al que se a�aden los archipi�lagos de las islas Baleares (en el mar Mediterr�neo occidental) y de las islas Canarias (en el oc�ano Atl�ntico nororiental), as� como en el norte del continente africano las ciudades aut�nomas de Ceuta y Melilla, adem�s de los distritos y posesiones menores de las islas Chafarinas, el pe��n de V�lez de la Gomera y el pe��n de Alhucemas. El municipio de Llivia, rodeado totalmente por territorio franc�s, en los Pirineos, completa el conjunto de territorios junto con la isla de Albor�n, las islas Columbretes y una serie de islas e islotes frente a sus propias costas. Tiene una extensi�n de 504.645 km�, siendo el cuarto pa�s m�s extenso del continente, tras Rusia, Ucrania y Francia. Con una altitud media de 650 metros es uno de los pa�ses m�s monta�osos de Europa. Su poblaci�n es de 47.190.493 habitantes, seg�n datos del padr�n municipal de 2011.";
		n.mImageResource=R.drawable.espana;
		mArray.add(n); 
		n= new Node();
		n.mTitle="Grecia";
		n.mDescription="Grecia (en griego moderno: Ell�da; en griego antiguo: Hell�s), oficialmente Rep�blica Hel�nica (Ellinik� Dimokrat�a), es un pa�s soberano miembro de la Uni�n Europea situado en el sureste de Europa. Est� constituido en Rep�blica parlamentaria. Su territorio, con capital en Atenas, ocupa la regi�n m�s meridional de la Pen�nsula Balc�nica, al que se a�aden las casi 6000 islas griegas que se extienden por el Mar Mediterr�neo, entre las que estar�an las islas J�nicas, las Sar�nicas, las C�cladas, las Esp�radas, la isla de Creta y el archipi�lago del Dodecaneso.";
		n.mImageResource=R.drawable.grecia;
		mArray.add(n);
		n= new Node();
		n.mTitle="Jap�n";
		n.mDescription="Jap�n (Nihon o Nippon, oficialmente Nippon-koku, 'Estado de Jap�n'; significado literal: 'el pa�s del origen del sol') , es un pa�s insular del este de Asia. Est� ubicado entre el oc�ano Pac�fico y el mar del Jap�n, al este de China, Rusia y la pen�nsula de Corea. Jap�n est� formado por cuatro islas principales: Honshu, Hokkaido, Kyushu y Shikoku, que forman el 97% de la superficie total del pa�s, y por otras 6.848 islas menores adyacentes. Tiene una poblaci�n de 127 millones de personas, la d�cima m�s numerosa del mundo. El �rea metropolitana de Tokio, que incluye a la ciudad capital de Tokio y las prefecturas de sus alrededores, es el �rea urbana m�s grande del mundo en t�rminos de poblaci�n, albergando a m�s de 30 millones de habitantes. Es el segundo pa�s m�s poblado de Asia Oriental, despu�s de China.";
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
				
			//Obtenci�n de la imagen
			ImageView img = (ImageView) view.findViewById(R.id.image);
			img.setImageDrawable(myContext.getResources().getDrawable(mArray.get(position).mImageResource));					
			//Obtenci�n del t�tulo	
			TextView t = (TextView) view.findViewById(R.id.title);			
			t.setText(mArray.get(position).mTitle);
			//Obtenci�n de la descripci�n
			TextView t2 = (TextView) view.findViewById(R.id.description);
			t2.setText(mArray.get(position).mDescription);
			
			return view;
		}
    }
}


