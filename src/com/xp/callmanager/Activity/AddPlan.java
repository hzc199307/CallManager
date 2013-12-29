package com.xp.callmanager.Activity;

import java.io.IOException;

import com.xp.callmanager.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class AddPlan extends Activity {
	private Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call_manager_addplan);
		
		submit = (Button) findViewById(R.id.call_manager_addplan_Button10);
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent checkIntent = new Intent(AddPlan.this,
						CallManagerActivity.class);
				// checkIntent.putExtra("filePath", SDPATH + "/test.txt");
				Log.i("Lvliang", "check intent start");
				AddPlan.this.finish();
				startActivity(checkIntent);
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
