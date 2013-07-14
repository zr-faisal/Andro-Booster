package com.audacity.booster.fragments;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.audacity.booster.R;

public class MemoryBooster extends Fragment {
	
	SeekBar sbStat;
	TextView tvInfo;
	
	int totalMemory, freeMemory, parcentage;
	private static final long MEMORY_UNIT = 1048576L;
	private static final int MEMORY_MAX = 100;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.fragment_memory_booster, container, false);
		
		initIDs(view);
		initActions();
		
		return view;
	}
	

	private void initIDs(View v) {
		// TODO Auto-generated method stub
		sbStat = (SeekBar) v.findViewById(R.id.seekBar_ramBooster_stat);
		tvInfo = (TextView) v.findViewById(R.id.textView_ramBooster_info);
	}

	private void initActions() {
		// TODO Auto-generated method stub
		getmemoryStatus();
		
		sbStat.setProgress(MEMORY_MAX - parcentage);
		sbStat.setEnabled(false);
		
		tvInfo.setText("Free Memory " + freeMemory + " / " + totalMemory + " Total Memory (Megabytes)");
	}
	
	private void getmemoryStatus() {
		
		MemoryInfo memoryInfo = new MemoryInfo();
		ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(Activity.ACTIVITY_SERVICE);
		activityManager.getMemoryInfo(memoryInfo);
	
		totalMemory = (int) (memoryInfo.totalMem / MEMORY_UNIT);
		freeMemory = (int) (memoryInfo.availMem / MEMORY_UNIT);
		parcentage = (int) ((memoryInfo.availMem / MEMORY_UNIT * 100) / (memoryInfo.totalMem / MEMORY_UNIT));
	}
}
