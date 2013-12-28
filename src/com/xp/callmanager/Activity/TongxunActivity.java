package com.xp.callmanager.Activity;

import com.xp.callmanager.R;
import com.xp.callmanager.util.PhoneInfoUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class TongxunActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tongxun);
		TextView tx01 = (TextView) findViewById(R.id.tx01);
		tx01.setText(PhoneInfoUtil.getMyPhoneNumber(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tongxun, menu);
		return true;
	}

}
