package com.xp.callmanager.Activity;

import com.xp.callmanager.R;
import com.xp.callmanager.R.layout;
import com.xp.callmanager.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TongxunActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tongxun);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tongxun, menu);
		return true;
	}

}
