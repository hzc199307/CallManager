package com.xp.callmanager.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.xp.callmanager.bean.Attribution;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * ��������� ������
 * 
 * @author Zhichao
 * 
 */
public class AttributionUtil {

	/**
	 * �õ�����Ĺ����� TODO
	 * 
	 * @param phoneNumber
	 * @return
	 */
	private SQLiteDatabase db;
	
	public AttributionUtil(Context mContext) {
		db = mContext.openOrCreateDatabase("attribution.db", Context.MODE_PRIVATE, null);  
        db.execSQL("DROP TABLE IF EXISTS person"); 
	}
	public static String getAttr(long phoneNumber) {
		long phoneNumber7 = getPrev7of(phoneNumber);
		return null;
	}

	/**
	 * �õ��������Ӫ�� TODO
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static String getOperator(long phoneNumber) {
		long phoneNumber3 = getPrev3of(phoneNumber);
		return null;
	}
	
	public Attribution getAddrFromDB(long phoneNumber)
	{
		Cursor c = db.query("t_numberattribution", null, "number = "+getPrev7of(phoneNumber), null, null, null, null);
		if(c.moveToFirst())
		{
			return new Attribution(c);
		}
		else
			return null;
	}

	/**
	 * ��http://webservice.webxml.com.cn��ȡ�ֻ����������
	 * 
	 * @param phoneNumber
	 *            ����7λ���ֻ�����
	 * @return ���� ��<string xmlns="http://WebXml.com.cn/">1362222���㶫 ����
	 *         �㶫�ƶ������п�</string>��
	 */
	public static String getAddrFromWeb(long phoneNumber) {
		String url = "http://webservice.webxml.com.cn//WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
		url += "?mobileCode=" + phoneNumber + "&userID=";
		HttpGet httpGet = new HttpGet(url);
		HttpResponse mHttpResponse;
		try {
			mHttpResponse = new DefaultHttpClient().execute(httpGet);
			if (mHttpResponse.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(mHttpResponse.getEntity());
				return result;
			}
		} catch (ClientProtocolException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}

	private static long getPrev3of(long phoneNumber) {
		return phoneNumber / 100000000;
	}

	private static long getPrev7of(long phoneNumber) {
		long temp = phoneNumber;
		int weishu = 0;
		while(temp>0)
		{
			temp/=10;
			weishu++;
		}
		if(weishu>=7)
		{
			weishu-=7;
			while(weishu>0){
				weishu--;
				phoneNumber/=10;
			};
			return phoneNumber;
		}
		else
		{
			return 0;
		}
		
	}

}
