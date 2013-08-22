package com.audacity.booster.fragments;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.audacity.booster.MainActivity;
import com.audacity.booster.R;

public class BatteryBooster extends Fragment {
	
	CheckBox cbManual, cbDim, cbWIFI, cbBluetooth, cbVibration;
	Button btnBoostBattery;
	
	boolean backlightDIM, backlightDIMBLAC, turnOffWIFI, turnOffBluetooth,
	turnOffGPS, turnOffViberation, useOnly2G, dataConnectionOff, airplaneMode;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.fragment_battery_booster, container, false);
		
		initIDs(view);
		initActions();
		
		return view;
	}
	

	private void initIDs(View v) {
		// TODO Auto-generated method stub
		cbManual = (CheckBox) v.findViewById(R.id.checkBox_battery_manual);
		cbManual.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				changeAllState(isChecked);
			}
		});
		
		cbDim = (CheckBox) v.findViewById(R.id.checkBox_battery_dim);
		cbWIFI = (CheckBox) v.findViewById(R.id.checkBox_battery_wifi);
		cbBluetooth = (CheckBox) v.findViewById(R.id.checkBox_battery_bluetooth);
		cbVibration = (CheckBox) v.findViewById(R.id.checkBox_battery_vibration);
		
		btnBoostBattery = (Button) v.findViewById(R.id.button_wifiBooster_boostBattery);
	}
	
	private void initActions() {
		// TODO Auto-generated method stub
		btnBoostBattery.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				backlightDIM();
//				 backlightDIMBLAC();
//				 killRunningAPP();
				 turnOffWIFI();
				 turnOffBluetooth();
//				 turnOffGPS();
				 turnOffViberation();
//				 airplaneMode();
				 Toast.makeText(getActivity(), "WIFI turned off." +
				 							"\nBleutooth turned off." +
				 							"\nVibration turned off.",
				 							Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void changeAllState(boolean state) {
		
		cbDim.setEnabled(state);
		cbDim.setClickable(state);
		
		cbWIFI.setEnabled(state);
		cbWIFI.setClickable(state);
		
		cbBluetooth.setEnabled(state);
		cbBluetooth.setClickable(state);
		
		cbVibration.setEnabled(state);
		cbVibration.setClickable(state);
	}
	
	private void backlightDIM() {

		android.provider.Settings.System.putInt(getActivity().getContentResolver(),
				android.provider.Settings.System.SCREEN_BRIGHTNESS, 10);

		WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
		lp.screenBrightness = 0.2f;// 100 / 100.0f;
		getActivity().getWindow().setAttributes(lp);

//		startActivity(new Intent(this, MainActivity.class));
//		finish();
		backlightDIM = true;
	}

	private void backlightDIMBLAC() {

		WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
		lp.screenBrightness = 0.01f;
		getActivity().getWindow().setAttributes(lp);
		backlightDIMBLAC = true;

	}

	private void killRunningAPP() {

		final ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(Activity.ACTIVITY_SERVICE);
		final List<RunningTaskInfo> recentTasks = activityManager
				.getRunningTasks(Integer.MAX_VALUE);

		ActivityManager manager = (ActivityManager) getActivity()
				.getSystemService(Activity.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> activityes = ((ActivityManager) manager)
				.getRunningAppProcesses();

		for (int i = 0; i < activityes.size(); i++) {

			Log.e("APP: " + i, activityes.get(i).processName);
			String packageName = activityes.get(i).processName;
			activityManager.killBackgroundProcesses(packageName);

		}

	}

	private void turnOffWIFI() {

		WifiManager wifiManager = (WifiManager) getActivity()
				.getSystemService(Context.WIFI_SERVICE);
		wifiManager.setWifiEnabled(false);
		turnOffWIFI = true;
	}

	private void turnOffBluetooth() {

		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter
				.getDefaultAdapter();
		if (mBluetoothAdapter.isEnabled()) {
			mBluetoothAdapter.disable();
		}

		turnOffBluetooth = true;
	}

//	private void turnOffGPS() {
//	
//	}

	private void turnOffViberation() {

		AudioManager audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		turnOffViberation = true;
	}

//	private void useOnly2G() {
//
//	}

//	private void dataConnectionOff() {
//
//	}

	// This will be on manual batter saver
	private void airplaneMode() {

		boolean isEnabled = android.provider.Settings.System.getInt(
				getActivity().getContentResolver(),
				android.provider.Settings.System.AIRPLANE_MODE_ON, 0) == 1;

		android.provider.Settings.System.putInt(getActivity().getContentResolver(),
				android.provider.Settings.System.AIRPLANE_MODE_ON,
				isEnabled ? 0 : 1);

		Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
		intent.putExtra("state", !isEnabled);
		getActivity().sendBroadcast(intent);

		airplaneMode = true;
	}

//	@Override
//	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//		// TODO Auto-generated method stub
//		int id = buttonView.getId();
//		if(id == R.id.checkBox_battery_dim) {
//			
//			changeAllState(isChecked);
//		}
//		else {
//			if(isChecked) {
//				
//				switch (id) {
//				
//				case R.id.checkBox_battery_dim:
//					Log.d("onCheckedChanged:", "Dim");
//					break;
//					
//				case R.id.checkBox_battery_wifi:
//					Log.d("onCheckedChanged:", "Wifi");
//					break;
//					
//				case R.id.checkBox_battery_bluetooth:
//					Log.d("onCheckedChanged:", "Bluetooth");
//					break;
//					
//				case R.id.checkBox_battery_vibration:
//					Log.d("onCheckedChanged:", "Vibration");
//					break;
//
//				default:
//					break;
//				}
//			}	
//		}
//	}
}
