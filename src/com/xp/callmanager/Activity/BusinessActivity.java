package com.xp.callmanager.Activity;

import java.util.ArrayList;

import com.xp.callmanager.R;
import com.xp.callmanager.more.Activity.AttributionActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Ӫҵ��
 * 
 * @author wangpei
 * 
 */
public class BusinessActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business);
		RelativeLayout attributionButton = (RelativeLayout)findViewById(R.id.attributionButton);
		attributionButton.setOnClickListener(new RelativeLayout.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Intent intent = new Intent(BusinessActivity.this,
						SenterActivity.class); // ��ת����������ز�ѯҳ��
				startActivity(intent);
				BusinessActivity.this.finish();
			}
		});
		;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.more, menu);
		return true;
	}


}
