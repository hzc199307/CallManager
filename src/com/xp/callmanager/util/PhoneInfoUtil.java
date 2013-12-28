package com.xp.callmanager.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * 
 * @author Zhichao
 *
 */
public class PhoneInfoUtil {

	/**
	 * ��ȡ��������
	 * @param context
	 * @return
	 */
	public static String getMyPhoneNumber(Context context)
	{
		TelephonyManager mTelephonyMgr;   
	    mTelephonyMgr = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);    
	    return mTelephonyMgr.getLine1Number();   
	}
}
