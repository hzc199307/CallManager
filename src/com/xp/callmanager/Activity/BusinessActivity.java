package com.xp.callmanager.Activity;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import com.xp.callmanager.R;

import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * 营业厅
 * @author wangpei
 *
 */
public class BusinessActivity extends Activity {
	 private EditText numberPhone;
	 private EditText content;
	 private Button but_send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business);
		numberPhone=(EditText) findViewById(R.id.numberPhone);
        content=(EditText) findViewById(R.id.content);
        but_send=(Button) findViewById(R.id.send);
        but_send.setOnClickListener(new sendOnclickListener());
	}

	 private final class sendOnclickListener implements OnClickListener{
		  public void onClick(View v) {
		   String numberPhone2=numberPhone.getText().toString();
		      String content2=content.getText().toString();
		      SmsManager sms=SmsManager.getDefault();
		      ArrayList<String>texts=sms.divideMessage(content2);//拆分短信
		      for (String text : texts) {
		       sms.sendTextMessage(numberPhone2, null, text, null, null);
		   }
		Toast.makeText(getApplicationContext(), "发送成功", Toast.LENGTH_SHORT).show();
		  }
		 
		    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.business, menu);
		return true;
	}

}
