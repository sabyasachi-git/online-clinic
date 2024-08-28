package com.entity;

public class TimeSlots {
	
	private int ats_id;
	private String ats_info;
	
	public TimeSlots() {
		super();
	}

	public TimeSlots(int ats_id, String ats_info) {
		super();
		this.ats_id = ats_id;
		this.ats_info = ats_info;
	}
	
	public TimeSlots(String ats_info) {
		super();
		this.ats_info = ats_info;
	}

	public int getAts_id() {
		return ats_id;
	}

	public void setAts_id(int ats_id) {
		this.ats_id = ats_id;
	}

	public String getAts_info() {
		return ats_info;
	}

	public void setAts_info(String ats_info) {
		this.ats_info = ats_info;
	}

}
