package com.entity;

public class Qualification {
	
	private int q_id;
	private String quali_name;
	
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qualification(int q_id, String quali_name) {
		super();
		this.q_id = q_id;
		this.quali_name = quali_name;
	}
	
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public String getQuali_name() {
		return quali_name;
	}
	public void setQuali_name(String quali_name) {
		this.quali_name = quali_name;
	}
}