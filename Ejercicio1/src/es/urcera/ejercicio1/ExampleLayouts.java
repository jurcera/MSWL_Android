package es.urcera.ejercicio1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class ExampleLayouts extends Activity {
    /** Called when the activity is first created. */
    private TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) this.findViewById(R.id.marquee);  
        tv.setSelected(true);   // Set focus to the textview
    }
}