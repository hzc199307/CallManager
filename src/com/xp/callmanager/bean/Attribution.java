package com.xp.callmanager.bean;

import com.xp.callmanager.DBHelper.TableColumns.AttributionColumns;

import android.database.Cursor;

/**
 * 号码归属地 实体类
 * 
 * @author Zhichao
 * 
 */
public class Attribution {

	private String number; // 号码（7位）
	private String province;// 省份
	private String city; // 地级市 地区
	private String areaCode; // 座机区号
	private String postcode;// 邮编
	private String business;// 运营商（中国联通GSM ）attribution
	
	public Attribution() {
		// TODO 自动生成的构造函数存根
	}
	public Attribution(Cursor mCursor) {
		 this.setNumber(mCursor.getString(mCursor.getColumnIndex(AttributionColumns.number)));
		 this.setProvince(mCursor.getString(mCursor.getColumnIndex(AttributionColumns.province)));
		 this.setCity(mCursor.getString(mCursor.getColumnIndex(AttributionColumns.city)));
		 this.setAreaCode(mCursor.getString(mCursor.getColumnIndex(AttributionColumns.areaCode)));
		 this.setPostcode(mCursor.getString(mCursor.getColumnIndex(AttributionColumns.postcode)));
		 this.setBusiness(mCursor.getString(mCursor.getColumnIndex(AttributionColumns.attribution)));
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	
	
}
