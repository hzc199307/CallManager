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
 * 号码归属地 工具类
 * 
 * @author Zhichao
 * 
 */
public class AttributionUtil {

	/**
	 * 得到号码的归属地 TODO
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
	 * 得到号码的运营商 TODO
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
	 * 从http://webservice.webxml.com.cn获取手机号码归属地
	 * 
	 * @param phoneNumber
	 *            最少7位的手机号码
	 * @return 类似 “<string xmlns="http://WebXml.com.cn/">1362222：广东 广州
	 *         广东移动神州行卡</string>”
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
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
