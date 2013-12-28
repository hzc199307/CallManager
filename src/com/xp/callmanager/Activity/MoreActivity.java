package com.xp.callmanager.Activity;

import com.xp.callmanager.R;
import com.xp.callmanager.more.Activity.AttributionActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

public class MoreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more);
		RelativeLayout attributionButton = (RelativeLayout)findViewById(R.id.attributionButton);
		attributionButton.setOnClickListener(new RelativeLayout.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(MoreActivity.this,
						AttributionActivity.class); // 跳转到号码归属地查询页面
				startActivity(intent);
				//MoreActivity.this.finish(); 这会导致MoreActivity被delete 以至于无法返回到它
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
