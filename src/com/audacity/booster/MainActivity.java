package com.audacity.booster;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView tvMemoryBooster, tvSignalBooster, tvGpsBooster;
	TextView tvAntiVirus, tvWifiExtender, tvBatterySaver;
	Button btnContact, btnAboutUs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initIDs();
		initActions();
	}

	private void initIDs() {
		// TODO Auto-generated method stub
		tvMemoryBooster = (TextView) findViewById(R.id.textView_main_memoryBooster);
		tvSignalBooster = (TextView) findViewById(R.id.textView_main_signalBooster);
		tvGpsBooster = (TextView) findViewById(R.id.textView_main_gpsBooster);
		
		tvAntiVirus = (TextView) findViewById(R.id.textView_main_antiVirus);
		tvWifiExtender = (TextView) findViewById(R.id.textView_main_wifiExtender);
		tvBatterySaver = (TextView) findViewById(R.id.textView_main_batterySaver);
		
		btnContact = (Button) findViewById(R.id.button_main_contact);
		btnAboutUs = (Button) findViewById(R.id.button_main_aboutUs);
	}

	private void initActions() {
		// TODO Auto-generated method stub
		tvMemoryBooster.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), tvMemoryBooster.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		tvSignalBooster.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), tvSignalBooster.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});

		tvGpsBooster.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), tvGpsBooster.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		tvAntiVirus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), tvAntiVirus.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		tvWifiExtender.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), tvWifiExtender.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		tvBatterySaver.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), tvBatterySaver.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		btnContact.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), btnContact.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
		
		btnAboutUs.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), btnAboutUs.getText().toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
