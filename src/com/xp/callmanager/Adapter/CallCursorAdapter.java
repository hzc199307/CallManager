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
 * ��ȡ���ݺ󣬽����ݿ���䵽ָ���õ�����
 * 
 * @author Snake
 * 
 */
public class CallCursorAdapter extends ResourceCursorAdapter {
	final int DAY = 1440; // һ��ķ���ֵ
	private int[] mTo;
	private String[] mOriginalFrom;

	public CallCursorAdapter(Context context, int layout, Cursor c,
			String[] from, int[] to) {
		super(context, layout, c);
		mOriginalFrom = from;
		mTo = to;
	}

	/**
	 * �����ݵ���ͼ��
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
							"yyyy��M��dd�� HH:mm");
					value = sdf.format(new Date(callTime));

				} 
				// view.setBackgroundResource(R.color.incoming); // ��������ɫ
				setText((TextView) views[i], value);
			}

		}

		final Context mContext = context;
		//TODO final TextView mNumber = (TextView) view.findViewById(R.id.TextNumber);
		// ImageView mailButton = (ImageView)
		// view.findViewById(R.id.MailButton);
		// if (mailButton != null) {
		// // Ϊ�������ͼ����Ӵ����¼���ʹ����뷢�Ͷ��Ž���
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
