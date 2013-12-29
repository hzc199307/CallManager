package com.xp.callmanager.Adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xp.callmanager.R;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;


/**
 * 读取数据后，将数据库填充到指定好的行中
 * 
 * @author Snake
 * 
 */
public class CallCursorAdapter extends ResourceCursorAdapter {
	final int DAY = 1440; // 一天的分钟值
	private int[] mTo;
	private String[] mOriginalFrom;

	public CallCursorAdapter(Context context, int layout, Cursor c,
			String[] from, int[] to) {
		super(context, layout, c);
		mOriginalFrom = from;
		mTo = to;
	}

	/**
	 * 绑定数据到视图中
	 */
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO Auto-generated method stub
		View[] views = new View[mTo.length];
		int total = 0;
		for (int i = 0; i < views.length; i++) {
			views[i] = view.findViewById(mTo[i]);
			String value = cursor.getString(cursor
					.getColumnIndex(mOriginalFrom[i]));

			if (views[i] instanceof TextView) {
				if ("date".equals(mOriginalFrom[i])) {
					long callTime = Long.parseLong(value);

					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy年M月dd日 HH:mm");
					value = sdf.format(new Date(callTime));

				} 
				// view.setBackgroundResource(R.color.incoming); // 更改行颜色
				setText((TextView) views[i], value);
			}

		}

		final Context mContext = context;
		//TODO final TextView mNumber = (TextView) view.findViewById(R.id.TextNumber);
		// ImageView mailButton = (ImageView)
		// view.findViewById(R.id.MailButton);
		// if (mailButton != null) {
		// // 为点击短信图标添加触发事件，使其进入发送短信界面
		// mailButton.setOnClickListener(new OnClickListener() {
		// public void onClick(View v) {
		// Uri smsToUri = Uri.parse("smsto://" + mNumber.getText());
		// Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
		// smsToUri);
		// mContext.startActivity(smsIntent);
		// }
		// });
		// }
	}

	public void setText(TextView v, String text) {
		v.setText(text);
	}
}
