package com.xp.callmanager.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

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
	public static String getAttr(int phoneNumber) {
		int phoneNumber7 = getPrev7of(phoneNumber);
		return null;
	}

	/**
	 * 得到号码的运营商 TODO
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static String getOperator(int phoneNumber) {
		int phoneNumber3 = getPrev3of(phoneNumber);
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
	private static String getAddrFromWeb(int phoneNumber) {
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

	private static int getPrev3of(int phoneNumber) {
		return phoneNumber / 100000000;
	}

	private static int getPrev7of(int phoneNumber) {
		return phoneNumber / 10000;
	}

}
