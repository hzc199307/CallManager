package com.xp.callmanager.Activity;

import com.xp.callmanager.R;
import com.xp.callmanager.R.layout;
import com.xp.callmanager.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * ÓªÒµÌü
 * @author wangpei
 *
 */
public class BusinessActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.business, menu);
		return true;
	}

}
