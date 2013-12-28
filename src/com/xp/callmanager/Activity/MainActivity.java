package com.xp.callmanager.Activity;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.xp.callmanager.R;
import com.xp.callmanager.DBHelper.DBHelper;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		onDB();

		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				Intent intent = new Intent (MainActivity.this,TabsActivity.class); //跳转到主页面	
				startActivity(intent);			
				MainActivity.this.finish();
			}
		}, 1000);//停留1秒
		//		TextView mTextView = (TextView)findViewById(R.id.hello);


	}

	/**
	 * 对数据库的操作
	 */
	public void onDB()
	{
		DBHelper mDBHelper = new DBHelper(this);
		try {
			mDBHelper.createDataBase();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Cursor mCursor = mDBHelper.query("select * from t_numberattribution where number=1378759 ", null);
		mCursor.moveToFirst();
		TextView mTextView = (TextView)findViewById(R.id.hello);
		mTextView.setText(mCursor.getString(1));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
