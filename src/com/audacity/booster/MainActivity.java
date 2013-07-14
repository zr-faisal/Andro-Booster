package com.audacity.booster;

import com.audacity.booster.fragments.MemoryBooster;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ListView lvNavDrawer;
	TextView tvMemoryBooster, tvSignalBooster, tvGpsBooster;
	TextView tvAntiVirus, tvWifiExtender, tvBatterySaver;
	Button btnContact, btnAboutUs;
	RelativeLayout rlFragment;
	LinearLayout rlFrame;
	
	// Fragment variables
	FragmentManager mFragmentManager;
	FragmentTransaction mFragmentTransaction;

	String[] navItems;
	
	// Drawer variables
	private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle = "Andro-Booster";
    private CharSequence mTitle = "Andro-Booster";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		
        mFragmentManager = getFragmentManager();
		navItems = getResources().getStringArray(R.array.nav_items);
		
		initIDs();
		initActions();
	}

	private void initIDs() {
		// TODO Auto-generated method stub
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		
		lvNavDrawer = (ListView) findViewById(R.id.left_drawer);
		
		rlFrame = (LinearLayout) findViewById(R.id.content_frame);
		rlFragment = (RelativeLayout) findViewById(R.id.content_fragment);
		
		tvMemoryBooster = (TextView) findViewById(R.id.textView_main_memoryBooster);
		tvSignalBooster = (TextView) findViewById(R.id.textView_main_signalBooster);
		tvGpsBooster = (TextView) findViewById(R.id.textView_main_gpsBooster);
		
		tvAntiVirus = (TextView) findViewById(R.id.textView_main_antiVirus);
		tvWifiExtender = (TextView) findViewById(R.id.textView_main_wifiExtender);
		tvBatterySaver = (TextView) findViewById(R.id.textView_main_batterySaver);
		
//		btnContact = (Button) findViewById(R.id.button_main_contact);
//		btnAboutUs = (Button) findViewById(R.id.button_main_aboutUs);
	}

	private void initActions() {
		// TODO Auto-generated method stub
		 mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
	
		lvNavDrawer.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
		lvNavDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				switch(arg2) {
				
				case 0:
					rlFrame.setVisibility(View.VISIBLE);
					rlFrame.setEnabled(true);
					rlFragment.setVisibility(View.GONE);
					break;
					
				case 1:
					rlFragment.setVisibility(View.VISIBLE);
					rlFrame.setVisibility(View.GONE);
					rlFrame.setEnabled(false);
					goToMemoryBooster();
					break;
					
				case 2:
					Toast.makeText(MainActivity.this, "Navigate to: " + navItems[arg2], Toast.LENGTH_SHORT).show();
					break;
					
				case 3:
					Toast.makeText(MainActivity.this, "Navigate to: " + navItems[arg2], Toast.LENGTH_SHORT).show();
					break;
					
				case 4:
					Toast.makeText(MainActivity.this, "Navigate to: " + navItems[arg2], Toast.LENGTH_SHORT).show();
					break;
					
				case 5:
					Toast.makeText(MainActivity.this, "Navigate to: " + navItems[arg2], Toast.LENGTH_SHORT).show();
					break;
					
				case 6:
					Toast.makeText(MainActivity.this, "Navigate to: " + navItems[arg2], Toast.LENGTH_SHORT).show();
					break;
				}
				
				// Close the drawer
			    mDrawerLayout.closeDrawer(lvNavDrawer);
			}
		});
		
		tvMemoryBooster.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				rlFragment.setVisibility(View.VISIBLE);
				rlFrame.setVisibility(View.GONE);
				rlFrame.setEnabled(false);
				
				goToMemoryBooster();
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
		
//		btnContact.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getBaseContext(), btnContact.getText().toString(), Toast.LENGTH_SHORT).show();
//			}
//		});
//		
//		btnAboutUs.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getBaseContext(), btnAboutUs.getText().toString(), Toast.LENGTH_SHORT).show();
//			}
//		});
	}
	
	// Highlight the selected item, update the title, and close the drawer
	private void setNavigatedTitle(int pos) {
		
		mTitle = navItems[pos];
	    lvNavDrawer.setItemChecked(pos, true);
	}
	
	// Fragment Navigations
	private void goToMemoryBooster() {
		
		mFragmentTransaction = mFragmentManager.beginTransaction();
		mFragmentTransaction.replace(R.id.content_fragment, new MemoryBooster());
		mFragmentTransaction.addToBackStack(null);
		mFragmentTransaction.commit();
		
		setNavigatedTitle(1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

	@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(lvNavDrawer);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        
        return super.onPrepareOptionsMenu(menu);
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
        	
          return true;
        }
        // Handle other action bar items here...

        return super.onOptionsItemSelected(item);
    }
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
