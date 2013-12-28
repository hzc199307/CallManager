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
				// TODO �Զ����ɵķ������
				Intent intent = new Intent(MoreActivity.this,
						AttributionActivity.class); // ��ת����������ز�ѯҳ��
				startActivity(intent);
				//MoreActivity.this.finish(); ��ᵼ��MoreActivity��delete �������޷����ص���
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
