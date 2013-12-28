package com.xp.callmanager.more.Activity;

import com.xp.callmanager.R;
import com.xp.callmanager.R.layout;
import com.xp.callmanager.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AttributionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attribution);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.attribution, menu);
		return true;
	}

}
