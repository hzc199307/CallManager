package com.xp.callmanager.Activity;

import java.io.IOException;

import com.xp.callmanager.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.TextView;

import com.xp.callmanager.DBHelper.DBHelper;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		onDB();

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(MainActivity.this,
						TabsActivity.class); // ��ת����ҳ��
				startActivity(intent);
				MainActivity.this.finish();
			}
		}, 1000);// ͣ��1��
		// TextView mTextView = (TextView)findViewById(R.id.hello);

	}

	/**
	 * �����ݿ�Ĳ���
	 */
	public void onDB() {
		DBHelper mDBHelper = new DBHelper(this);
		try {
			mDBHelper.createDataBase();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		Cursor mCursor = mDBHelper
				.query("select * from t_numberattribution where number=1378759 ",
						null);
		mCursor.moveToFirst();
		TextView mTextView = (TextView) findViewById(R.id.hello);
		mTextView.setText(mCursor.getString(1));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
