package com.audacity.booster.fragments;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Fragment;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.audacity.booster.R;
import com.audacity.booster.views.HoloCircleSeekBar;

public class MemoryBooster extends Fragment {
	
	TextView tvTotalMemory, tvCurrentUsage;
	HoloCircleSeekBar hcsMemoryMeter;
	Button btnBoostMemory;
	
	int totalMemory, freeMemory, parcentage;
	private static final long MEMORY_UNIT = 1048576L;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.fragment_memory_booster, container, false);
		
		initIDs(view);
		initActions();
		
		return view;
	}
	

	private void initIDs(View v) {
		// TODO Auto-generated method stub
		tvTotalMemory = (TextView) v.findViewById(R.id.textView_ramBooster_totalMemory);
		tvCurrentUsage = (TextView) v.findViewById(R.id.textView_ramBooster_usedMemory);
		
		btnBoostMemory = (Button) v.findViewById(R.id.button_ramBooster_boostMemory);
		
		hcsMemoryMeter = (HoloCircleSeekBar) v.findViewById(R.id.circleSeekBar_memory_stat);
	}

	private void initActions() {
		// TODO Auto-generated method stub
		getmemoryStatus();

		tvTotalMemory.setText("System Memory = " + totalMemory + " MB");
		tvCurrentUsage.setText("Currently Used = " + (totalMemory - freeMemory) + " MB");
		
		hcsMemoryMeter.setValue(parcentage);
		hcsMemoryMeter.setEnabled(false);
		hcsMemoryMeter.setClickable(false);
//		hcsMemoryMeter.setTouchDelegate(null);
		
		btnBoostMemory.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				freeMemory();
			}
		});
	}
	
	protected void freeMemory() {
		// TODO Auto-generated method stub
		ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(Activity.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> taskInfo = activityManager.getRunningTasks(100);
		for(int i=1; i<taskInfo.size(); i++) {
			
			ComponentName componentInfo = taskInfo.get(i).topActivity;
			activityManager.killBackgroundProcesses(componentInfo.getPackageName());
		}
//		List<ActivityManager.RecentTaskInfo> listRecentTasks = activityManager..getRecentTasks(100, ActivityManager.RECENT_WITH_EXCLUDED);
//		 
//		for(RecentTaskInfo recent : listRecentTasks) {
//			 
//			Log.i("freeMemory: ", "Recent=" + recent.description);
//			Log.i("freeMemory: ", "ID=" + recent.id + " , PID=" + recent.persistentId);
//			Log.i("freeMemory: ", "Pacage=" + recent.origActivity.getPackageName());
//		}
		
		System.runFinalization();
	    Runtime.getRuntime().gc();
	    System.gc();
	    
	    updateUI();
	}
	
	private void updateUI() {
		
		getmemoryStatus();

		tvTotalMemory.setText("System Memory = " + totalMemory + " MB");
		tvCurrentUsage.setText("Currently Used = " + (totalMemory - freeMemory) + " MB");
		
		hcsMemoryMeter.setValue(parcentage);
	}

	protected void getmemoryStatus() {
		
		MemoryInfo memoryInfo = new MemoryInfo();
		ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(Activity.ACTIVITY_SERVICE);
		activityManager.getMemoryInfo(memoryInfo);
	
		totalMemory = (int) (memoryInfo.totalMem / MEMORY_UNIT);
		freeMemory = (int) (memoryInfo.availMem / MEMORY_UNIT);
		parcentage = (int) ((memoryInfo.availMem / MEMORY_UNIT * 100) / (memoryInfo.totalMem / MEMORY_UNIT));
	}
	
}
