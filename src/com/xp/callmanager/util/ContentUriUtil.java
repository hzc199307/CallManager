package com.xp.callmanager.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CallLog;

/**
 * ͨ����¼ ������
 * 
 * @author Zhichao
 * 
 */
public class ContentUriUtil {

	private GregorianCalendar calendar = new GregorianCalendar();
	private Date now = new Date();
	private ContentResolver mContentResolver;
	private String dayOfWeek;

	public ContentUriUtil(ContentResolver mContentResolver) {
		this.mContentResolver = mContentResolver;
		calendar.setTime(now);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);// ����һ�����ڵĵ�һ��Ϊ����1��Ĭ����������
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		SimpleDateFormat dateutil = new SimpleDateFormat("yyyy-MM-dd");
		dayOfWeek = dateutil.format(calendar.getTime()) + " 00:00:00";// ��ȡ����һ��ʱ��
	}

	/**
	 * ��ȡĳһ��Ĳ������ TODO
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public int getOutTimeofDay(int year, int month, int day) {
		return 0;
	}

	/**
	 * ��ȡĳһ�µĲ������ TODO
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public int getOutTimeofMonth(int year, int month) {
		return 0;
	}

	/**
	 * ��ȡĳһ��Ĳ������ TODO
	 * 
	 * @param year
	 * @return
	 */
	public int getOutTimeofYear(int year) {
		return 0;
	}

	/**
	 * һ��ʱ��Ĳ������ TODO
	 * 
	 * @param year1
	 * @param month1
	 * @param day1
	 * @param year2
	 * @param month2
	 * @param day2
	 * @return
	 */
	public int getOutTimeofD_D(int year1, int month1, int day1, int year2,
			int month2, int day2) {
		return 0;
	}

	public int getOutTimeofM_M(int year1, int month1, int year2, int month2) {
		return 0;
	}

	public int getOutTimeofY_Y(int year1, int year2) {
		return 0;
	}

	/**
	 * ��ȡ ���� �Ѳ� �绰��ʱ��
	 * 
	 * @return
	 */
	public int getOutTimeofThisDay() {
		return getCallTimeByWhere("type=2 and datetime(substr(date,1,10),'unixepoch','localtime')>date('now','localtime')||' 00:00:00'");
	}

	/**
	 * ��ȡ ���� �ѽ� �绰��ʱ��
	 * 
	 * @return
	 */
	public int geInTimeofThisDay() {
		return getCallTimeByWhere("type=1 and datetime(substr(date,1,10),'unixepoch','localtime')>date('now','localtime')||' 00:00:00'");
	}

	/**
	 * ��ȡ ���� �Ѳ� �绰��ʱ��
	 * 
	 * @return
	 */
	public int getOutTimeofThisWeek() {
		return getCallTimeByWhere("type=2 and datetime(substr(date,1,10),'unixepoch','localtime')>datetime('"
				+ dayOfWeek + "')");
	}

	/**
	 * ��ȡ ���� �ѽ� �绰��ʱ��
	 * 
	 * @return
	 */
	public int geInTimeofThisWeek() {
		return getCallTimeByWhere("type=1 and datetime(substr(date,1,10),'unixepoch','localtime')>datetime('"
				+ dayOfWeek + "')");
	}

	/**
	 * ��ȡ ���� �Ѳ� �绰��ʱ��
	 * 
	 * @return
	 */
	public int getOutTimeofThisMonth() {
		return getCallTimeByWhere("type=2 and datetime(substr(date,1,10),'unixepoch','localtime')>datetime('now','start of month')");
	}

	/**
	 * ��ȡ ���� �ѽ� �绰��ʱ��
	 * 
	 * @return
	 */
	public int getInTimeofThisMonth() {
		return getCallTimeByWhere("type=1 and datetime(substr(date,1,10),'unixepoch','localtime')>datetime('now','start of month')");
	}

	/**
	 * ����������ȡͨ��ʱ��(����)
	 * 
	 * @param where
	 *            ����
	 * @param mContentResolver
	 * @return
	 */
	private int getCallTimeByWhere(String where) {
		int total = 0;
		final Cursor cursor = mContentResolver.query(CallLog.Calls.CONTENT_URI,
				new String[] { CallLog.Calls.NUMBER, CallLog.Calls.DURATION },
				where, null, CallLog.Calls.DEFAULT_SORT_ORDER);
		// startManagingCursor(cursor)

		int count = cursor.getCount();
		for (int i = 0; i < count; i++) {
			cursor.moveToPosition(i);
			int duration = 0;
			try {
				duration = Integer.parseInt(cursor.getString(cursor
						.getColumnIndex(CallLog.Calls.DURATION)));
				if (duration % 60 > 0)
					duration = duration / 60 + 1;
				else
					duration = duration / 60;
			} catch (Exception e) {
				duration = 1;
			}
			total += duration;
		}
		return total;
	}

	/**
	 * ��ȡͨѶʱ��Ϊ0��û���������Ѳ��绰 �α�
	 * @return
	 */
	public Cursor getOut0WithoutNameCursor()
	{
		return mContentResolver.query(CallLog.Calls.CONTENT_URI,
				null,
				"type=2 and DURATION=0 and name is null ", null, CallLog.Calls.DEFAULT_SORT_ORDER);
	}
}
