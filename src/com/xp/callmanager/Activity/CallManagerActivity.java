package com.xp.callmanager.Activity;

import com.xp.callmanager.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CallManagerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call_manager);
		
		
	}

	/**
	 * 页面问题的处理
	 */
	private void onLayout()
	{
		

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.call_manager, menu);
		return true;
	}

}
