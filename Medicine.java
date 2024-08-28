package com.entity;

public class Medicine {
	private int med_id;	
	private String mf_name;
	private String med_name;
	private String batch_no;
	private String mf_date;
	private String exp_date;
	private String med_mrp;
	
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Medicine(int med_id, String mf_name, String med_name, String batch_no, String mf_date, String exp_date,
			String med_mrp) {
		super();
		this.med_id = med_id;
		this.mf_name = mf_name;
		this.med_name = med_name;
		this.batch_no = batch_no;
		this.mf_date = mf_date;
		this.exp_date = exp_date;
		this.med_mrp = med_mrp;
	}

	public int getMed_id() {
		return med_id;
	}

	public void setMed_id(int med_id) {
		this.med_id = med_id;
	}

	public String getMf_name() {
		return mf_name;
	}

	public void setMf_name(String mf_name) {
		this.mf_name = mf_name;
	}

	public String getMed_name() {
		return med_name;
	}

	public void setMed_name(String med_name) {
		this.med_name = med_name;
	}

	public String getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	public String getMf_date() {
		return mf_date;
	}

	public void setMf_date(String mf_date) {
		this.mf_date = mf_date;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	public String getMed_mrp() {
		return med_mrp;
	}

	public void setMed_mrp(String med_mrp) {
		this.med_mrp = med_mrp;
	}
}