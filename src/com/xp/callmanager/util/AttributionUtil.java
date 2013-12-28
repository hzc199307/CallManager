package com.xp.callmanager.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

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
	public static String getAttr(int phoneNumber) {
		int phoneNumber7 = getPrev7of(phoneNumber);
		return null;
	}

	/**
	 * �õ��������Ӫ�� TODO
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static String getOperator(int phoneNumber) {
		int phoneNumber3 = getPrev3of(phoneNumber);
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
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
