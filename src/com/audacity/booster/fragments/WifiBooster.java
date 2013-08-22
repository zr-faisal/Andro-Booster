package com.audacity.booster.fragments;

import com.audacity.booster.R;
import com.audacity.booster.utils.HelperUtil;
import com.audacity.booster.views.HoloCircleSeekBar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class WifiBooster extends Fragment {

	HoloCircleSeekBar hcsMeter;
	Button btnBoostWifi;
	
	private int CURRENT_NET_STAT;
	private int MAX = 100;
	private int NET_BOOST = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.fragment_wifi_booster, container, false);
		
		initIDs(view);
		initActions();
		
		return view;
	}
	

	private void initIDs(View v) {
		// TODO Auto-generated method stub
		
		btnBoostWifi = (Button) v.findViewById(R.id.button_wifiBooster_boostWifi);
		
		hcsMeter = (HoloCircleSeekBar) v.findViewById(R.id.circleSeekBar_wifi_stat);
	}
	
	private void initActions() {
		// TODO Auto-generated method stub
		CURRENT_NET_STAT = HelperUtil.createRandomWithRenge(65, MAX);
		hcsMeter.setValue(CURRENT_NET_STAT, "%");
		
		btnBoostWifi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				NET_BOOST = HelperUtil.createRandomWithRenge(1, MAX-CURRENT_NET_STAT);
				int NEW_STAT = CURRENT_NET_STAT + NET_BOOST;
				
				if(NEW_STAT > CURRENT_NET_STAT && NEW_STAT < MAX) {
					
					hcsMeter.setValue(NEW_STAT, "%");
					Toast.makeText(getActivity(), "WIFI Signal Boost " + (float)(NET_BOOST*MAX/CURRENT_NET_STAT) + "%", Toast.LENGTH_SHORT).show();
					
					CURRENT_NET_STAT = NEW_STAT;
				}
				else {
					
					Toast.makeText(getActivity(), "Unable to boost more!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
