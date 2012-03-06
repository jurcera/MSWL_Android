package es.org.capta.wishnucrtl;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void myClickHandler(View target) {

    	EditText editText = (EditText)findViewById(R.id.editText1);

    	switch (target.getId()) {
		case R.id.btnConnect:
			Log.d("DEBUG", "Conectado a: " + editText.getText());
			
			break;
		case R.id.btnDisconnect:
			Log.d("DEBUG", "Desconectado");
			break;
		
		}
    }

}