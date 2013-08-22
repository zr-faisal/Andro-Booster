package com.audacity.booster.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.audacity.booster.R;
import com.audacity.booster.utils.HelperUtil;
import com.audacity.booster.views.HoloCircleSeekBar;

public class NetworkBooster extends Fragment {

	HoloCircleSeekBar hcsMeter;
	Button btnBoostNetwork;
	
	private int CURRENT_NET_STAT;
	private int MAX = 100;
	private int NET_BOOST = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.fragment_network_booster, container, false);
		
		initIDs(view);
		initActions();
		
		return view;
	}
	

	private void initIDs(View v) {
		// TODO Auto-generated method stub
		
		btnBoostNetwork = (Button) v.findViewById(R.id.button_netBooster_boostNetwork);
		
		hcsMeter = (HoloCircleSeekBar) v.findViewById(R.id.circleSeekBar_network_stat);
	}
	
	private void initActions() {
		// TODO Auto-generated method stub
		CURRENT_NET_STAT = HelperUtil.createRandomWithRenge(85, MAX);
		hcsMeter.setValue(CURRENT_NET_STAT, "%");
		
		btnBoostNetwork.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				NET_BOOST = HelperUtil.createRandomWithRenge(1, MAX-CURRENT_NET_STAT);
				int NEW_STAT = CURRENT_NET_STAT + NET_BOOST;
				
				if(NEW_STAT > CURRENT_NET_STAT && NEW_STAT < MAX) {
					
					hcsMeter.setValue(NEW_STAT, "%");
					Toast.makeText(getActivity(), "Network Frequency Boost " + (float)(NET_BOOST*MAX/CURRENT_NET_STAT) + "%", Toast.LENGTH_SHORT).show();
					
					CURRENT_NET_STAT = NEW_STAT;
				}
				else {
					
					Toast.makeText(getActivity(), "Unable to boost more!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
