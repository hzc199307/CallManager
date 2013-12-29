package com.xp.callmanager.Activity;

import java.util.Calendar;


import com.xp.callmanager.R;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class CallManagerActivity extends Activity implements OnClickListener {
	private int year;
	private int monthOfYear;
	private int dayOfMonth;
	private int hour;
	private int minute;
	private Button submit;
	private Button tongji;
	private TextView dateText;
	private TextView timeText;
	private Button dateButton;
	private Button timeButton;

	final static int DATE_DIALOG_ID = 1;
	final static int TIME_DIALOG_ID = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call_manager);
		
		dateText = (TextView) findViewById(R.id.call_managertextview02);
		timeText = (TextView) findViewById(R.id.call_managertextview03);
		
		dateButton = (Button) findViewById(R.id.call_manager_datebutton01);
		dateButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);
			}
		});

		timeButton = (Button) findViewById(R.id.call_manager_timebutton01);
		timeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(TIME_DIALOG_ID);
			}
		});
		
		// 设置为系统当前时间
				Calendar calendar = Calendar.getInstance();
				year = calendar.get(Calendar.YEAR);
				monthOfYear = calendar.get(Calendar.MONTH);
				dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
				hour = calendar.get(Calendar.HOUR_OF_DAY);
				minute = calendar.get(Calendar.MINUTE);

		submit = (Button) findViewById(R.id.call_manager_button01);
		submit.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CallManagerActivity.this,
						AddPlan.class); // 跳转到主页面
				startActivity(intent);


			}
		});
		
		tongji = (Button) findViewById(R.id.call_manager_button02);
		tongji.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CallManagerActivity.this,
						ShowPlan.class); // 跳转到主页面
				startActivity(intent);


			}
		});
	}
	
	// 当Activity调用showDialog()显示对话框时会调用此方法
			@Override
			protected Dialog onCreateDialog(int id) {
				// TODO Auto-generated method stub
				switch (id) {
				case DATE_DIALOG_ID:
					return new DatePickerDialog(this, new OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							// TODO Auto-generated method stub
							dateText.setText(year + "/" + (monthOfYear + 1) + "/"	+ dayOfMonth );
						}
					}, year, monthOfYear, dayOfMonth);

				case TIME_DIALOG_ID:
					return new TimePickerDialog(this, new OnTimeSetListener() {
						@Override
						public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
							// TODO Auto-generated method stub
							timeText.setText(hourOfDay + ":" + minute );
						}
					}, hour, minute, true);
				}
				return null;
			}
				
	/**
	 * 页面问题的处理
	 */
	private void onLayout() {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.call_manager, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
