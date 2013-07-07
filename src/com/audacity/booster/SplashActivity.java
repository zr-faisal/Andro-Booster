package com.audacity.booster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends Activity {

	private int splashTime = 3000;
	private Thread splashThread;
	SplashActivity splashActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		splashActivity = this;

		splashThread = new Thread() {

			@Override
			public void run() {

				try {

					synchronized (this) {

						wait(splashTime);
					}
				}
				catch(Exception ex) {

					Log.e(splashActivity.getLocalClassName(), ex.getMessage());
				}
				finally {

					Intent i = new Intent(SplashActivity.this, MainActivity.class);
					startActivity(i);
					overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

					finish();
				}
			}
		};

		splashThread.start();
	}

}
