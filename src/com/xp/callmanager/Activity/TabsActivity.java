package com.xp.callmanager.Activity;

import com.xp.callmanager.R;
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

		TabHost mTabHost = getTabHost();
		mTabHost.setup();

		mTabHost.addTab(mTabHost
				.newTabSpec("sfb")
				.setIndicator("ʡ�ѱ�",
						getResources().getDrawable(R.drawable.sfb_01))
				.setContent(new Intent(this, CallManagerActivity.class)));

		mTabHost.addTab(mTabHost
				.newTabSpec("tx")
				.setIndicator("ͨѶ",
						getResources().getDrawable(R.drawable.tx_01))
				.setContent(new Intent(this, TongxunActivity.class)));
		mTabHost.addTab(mTabHost
				.newTabSpec("yyt")
				.setIndicator("Ӫҵ��", getResources().getDrawable(R.drawable.yyt_01))
				.setContent(new Intent(this, BusinessActivity.class)));
		mTabHost.addTab(mTabHost
				.newTabSpec("gd")
				.setIndicator("����",
						getResources().getDrawable(R.drawable.gd_01))
				.setContent(new Intent(this, MoreActivity.class)));

		mTabHost.setCurrentTabByTag("sfb");
	}

}
