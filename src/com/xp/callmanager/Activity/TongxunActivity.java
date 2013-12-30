package com.xp.callmanager.Activity;

import com.xp.callmanager.Adapter.CallCursorAdapter;
import com.xp.callmanager.R;
import com.xp.callmanager.util.ContentUriUtil;
import com.xp.callmanager.util.PhoneInfoUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class TongxunActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tongxun);
		TextView tx01 = (TextView) findViewById(R.id.activity_tongxun_textview01);
		tx01.setText("【可能忘记保存的号码】");//tx01.setText(PhoneInfoUtil.getMyPhoneNumber(this));
		ContentUriUtil mContentUriUtil = new ContentUriUtil(getContentResolver());
		setListAdapter(mContentUriUtil.getOut0WithoutNameCursor());
	}

	/**
	 * 根据游标，进行数据查询并将查询到的结果填充到list的行
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

	/**
	 * 主要响应listview的每一个Item的点击操作，弹出一个“是否加入通讯录”的对话框
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		LinearLayout layout = (LinearLayout)v;
		TextView numberText = (TextView)layout.findViewById(R.id.TextNumber);

		EditText mEditText = new EditText(this);
		mEditText.setHint("请输入联系人姓名...");
		new AlertDialog.Builder(this).setTitle("是否加入通讯录?").setIcon(android.R.drawable.ic_dialog_info).setView(mEditText).setPositiveButton("确定", null).setNegativeButton("取消", null).show();

		//		Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel://"+numberText.getText()));
		//		startActivity(callIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tongxun, menu);
		return true;
	}

}
