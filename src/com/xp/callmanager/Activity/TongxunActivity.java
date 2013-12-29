package com.xp.callmanager.Activity;

import com.xp.callmanager.Adapter.CallCursorAdapter;
import com.xp.callmanager.R;
import com.xp.callmanager.util.ContentUriUtil;
import com.xp.callmanager.util.PhoneInfoUtil;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.Menu;
import android.widget.TextView;

public class TongxunActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tongxun);
		TextView tx01 = (TextView) findViewById(R.id.activity_tongxun_textview01);
		tx01.setText(PhoneInfoUtil.getMyPhoneNumber(this));
		ContentUriUtil mContentUriUtil = new ContentUriUtil(getContentResolver());
		setListAdapter(mContentUriUtil.getOut0WithoutNameCursor());
	}

	/**
	 * 根据查询条件或排序方式，进行数据查询并将查询到的结果填充到list的行
	 * @param mCursor
	 */
	protected void setListAdapter(Cursor mCursor){
		
		//将cursor生命周期交由activity来管理Activity.startManagingCursor(cursor)
		startManagingCursor(mCursor);
		CallCursorAdapter adapter = new CallCursorAdapter(this,
				R.layout.call_info, mCursor,
				new String[] { "number", "date"},
				new int[] { R.id.TextNumber,R.id.TextDate});
		setListAdapter(adapter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tongxun, menu);
		return true;
	}

}
