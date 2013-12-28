package com.xp.callmanager.DBHelper;

/**
 * 储存列名称
 * 
 * @author Zhichao
 */
public class TableColumns {

	public interface AttributionColumns {
		public static final String number = "number"; // 号码（7位）
		public static final String province = "province"; // 省份
		public static final String city = "city"; // 地级市 地区
		public static final String areaCode = "areaCode"; // 座机区号
		public static final String postcode = "postcode"; // 邮编
		public static final String attribution = "attribution"; // 运营商（中国联通GSM ）
	}
}
