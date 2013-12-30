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
		tx01.setText("���������Ǳ���ĺ��롿");//tx01.setText(PhoneInfoUtil.getMyPhoneNumber(this));
		ContentUriUtil mContentUriUtil = new ContentUriUtil(getContentResolver());
		setListAdapter(mContentUriUtil.getOut0WithoutNameCursor());
	}

	/**
	 * �����α꣬�������ݲ�ѯ������ѯ���Ľ����䵽list����
	 * @param mCursor
	 */
	protected void setListAdapter(Cursor mCursor){

		//��cursor�������ڽ���activity������Activity.startManagingCursor(cursor)
		startManagingCursor(mCursor);
		CallCursorAdapter adapter = new CallCursorAdapter(this,
				R.layout.call_info, mCursor,
				new String[] { "number", "date"},
				new int[] { R.id.TextNumber,R.id.TextDate});
		setListAdapter(adapter);
	}

	/**
	 * ��Ҫ��Ӧlistview��ÿһ��Item�ĵ������������һ�����Ƿ����ͨѶ¼���ĶԻ���
	 */
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		LinearLayout layout = (LinearLayout)v;
		TextView numberText = (TextView)layout.findViewById(R.id.TextNumber);

		EditText mEditText = new EditText(this);
		mEditText.setHint("��������ϵ������...");
		new AlertDialog.Builder(this).setTitle("�Ƿ����ͨѶ¼?").setIcon(android.R.drawable.ic_dialog_info).setView(mEditText).setPositiveButton("ȷ��", null).setNegativeButton("ȡ��", null).show();

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
