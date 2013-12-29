package com.xp.callmanager.Activity;

import com.xp.callmanager.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CallManagerActivity extends Activity implements OnClickListener {
	private Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call_manager);

		submit = (Button) findViewById(R.id.call_manager_button01);
		submit.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CallManagerActivity.this,
						AddPlan.class); // 跳转到主页面
				startActivity(intent);


			}
		});
	}
	/**
	 * 页面问题的处理
	 */
	private void onLayout() {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.call_manager, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
