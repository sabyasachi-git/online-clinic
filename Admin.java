package com.entity;

public class Admin {
	
	private int ad_id;
	private String ad_email;
	private String ad_password;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int ad_id, String ad_email, String ad_password) {
		super();
		this.ad_id = ad_id;
		this.ad_email = ad_email;
		this.ad_password = ad_password;
	}

	public int getAd_id() {
		return ad_id;
	}

	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}

	public String getAd_email() {
		return ad_email;
	}

	public void setAd_email(String ad_email) {
		this.ad_email = ad_email;
	}

	public String getAd_password() {
		return ad_password;
	}

	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
}
