package com.xp.callmanager.Activity;

import com.example.callmanager.R;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class TabsActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabs);
		
		TabHost mTabHost = (TabHost)findViewById(R.id.main_tabhost);
		mTabHost.setup();
		
//		mTabHost.addTab(mTabHost.newTabSpec("incoming").setIndicator("����",
//				getResources().getDrawable(R.drawable.incoming)).setContent(
//				new Intent(this, IncomingContactList.class)));
//
//		mTabHost.addTab(mTabHost.newTabSpec("goouting").setIndicator("����",
//				getResources().getDrawable(R.drawable.outgoing)).setContent(
//				new Intent(this, OutgoingContactList.class)));
//		mTabHost.addTab(mTabHost.newTabSpec("missed").setIndicator("δ��",
//				getResources().getDrawable(R.drawable.missed)).setContent(
//				new Intent(this, MissedContactList.class)));
//		mTabHost.addTab(mTabHost.newTabSpec("total").setIndicator("�ܼ�",
//				getResources().getDrawable(R.drawable.total)).setContent(
//				new Intent(this, TotalDisplay.class)));
		
//		mTabHost.setCurrentTabByTag(tag);
	}

}
