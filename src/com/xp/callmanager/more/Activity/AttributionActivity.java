package com.xp.callmanager.more.Activity;

import com.xp.callmanager.R;
import com.xp.callmanager.R.layout;
import com.xp.callmanager.R.menu;
import com.xp.callmanager.bean.Attribution;
import com.xp.callmanager.util.AttributionUtil;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AttributionActivity extends Activity {

	private Button searchButton;
	private TextView tvNumber,tvAreaCode ,tvBusiness,tvCity,tvPostcode,tvProvince;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attribution);
		
		searchButton = (Button)findViewById(R.id.searchButton);
		
		tvNumber = (TextView)findViewById(R.id.tvNumber);
		tvAreaCode = (TextView)findViewById(R.id.tvAreaCode);
		tvBusiness = (TextView)findViewById(R.id.tvBusiness);
		tvCity = (TextView)findViewById(R.id.tvCity);
		tvPostcode = (TextView)findViewById(R.id.tvPostcode);
		tvProvince = (TextView)findViewById(R.id.tvProvince);
		
		final EditText searchAddrEdit = (EditText)findViewById(R.id.searchAddrEdit);
		searchButton.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				searchAddr(searchAddrEdit.getText().toString());
			}
		});
		
		
		
	}
	
	/**
	 * 
	 */
	public void searchAddr(String number)
	{
		AttributionUtil mAttributionUtil = new AttributionUtil(this);
		long along = Long.parseLong(number);
		Attribution mAttribution = mAttributionUtil.getAddrFromDB(along);
		if(mAttribution!=null)
		{
			tvAreaCode.setText(mAttribution.getAreaCode());
			tvBusiness.setText(mAttribution.getBusiness());
			tvCity.setText(mAttribution.getCity());
			tvPostcode.setText(mAttribution.getPostcode());
			tvProvince.setText(mAttribution.getProvince());
			tvNumber.setText(mAttribution.getNumber());
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.attribution, menu);
		return true;
	}

}
