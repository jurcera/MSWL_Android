package com.urcera.ejercicio3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LayoutActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.element);
		
		Intent i = this.getIntent();
		
		String title = i.getStringExtra("TITLE");
		String description = i.getStringExtra("DESCRIPTION");
		Integer image = i.getIntExtra("IMAGE", -1);
		
		TextView t = (TextView) this.findViewById(R.id.title);
		t.setText(title);
		
		TextView t2 = (TextView) this.findViewById(R.id.description);
		t2.setText(description);
		
		ImageView img = (ImageView) this.findViewById(R.id.image);
		img.setImageDrawable(this.getResources().getDrawable(image));
	}

}
