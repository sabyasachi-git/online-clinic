package com.entity;
public class Doctor {
	private int did;
	private String dreg_id;
	private String full_name;
	private String dob;
	private String qualification;
	private String specialist;
	private String visiting_day;
	private String visiting_time;
	private String patient_visit_limit;
	private String cons_fee;
	private String mobno;
	private String email;	
	private String password;
	
	public Doctor() {
		super();
	}

	public Doctor(String dreg_id, String full_name, String dob, String qualification, String specialist,
			String visiting_day, String visiting_time, String patient_visit_limit, String cons_fee, String mobno,
			String email, String password) {
		super();
		this.dreg_id = dreg_id;
		this.full_name = full_name;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.visiting_day = visiting_day;
		this.visiting_time = visiting_time;
		this.patient_visit_limit = patient_visit_limit;
		this.cons_fee = cons_fee;
		this.mobno = mobno;
		this.email = email;
		this.password = password;
	}
	
	public Doctor(int did, String dreg_id, String full_name, String dob, String qualification, String specialist,
			String visiting_day, String visiting_time, String patient_visit_limit, String cons_fee, String mobno,
			String email, String password) {
		super();
		this.did = did;
		this.dreg_id = dreg_id;
		this.full_name = full_name;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.visiting_day = visiting_day;
		this.visiting_time = visiting_time;
		this.patient_visit_limit = patient_visit_limit;
		this.cons_fee = cons_fee;
		this.mobno = mobno;
		this.email = email;
		this.password = password;
	}
	
	public Doctor(int did, String dreg_id, String full_name, String dob, String qualification, String specialist,
			String visiting_day, String cons_fee, String mobno, String email) {
		super();
		this.did = did;
		this.dreg_id = dreg_id;
		this.full_name = full_name;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.visiting_day = visiting_day;
		this.cons_fee = cons_fee;
		this.mobno = mobno;
		this.email = email;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDreg_id() {
		return dreg_id;
	}

	public void setDreg_id(String dreg_id) {
		this.dreg_id = dreg_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getVisiting_day() {
		return visiting_day;
	}

	public void setVisiting_day(String visiting_day) {
		this.visiting_day = visiting_day;
	}

	public String getVisiting_time() {
		return visiting_time;
	}

	public void setVisiting_time(String visiting_time) {
		this.visiting_time = visiting_time;
	}

	public String getPatient_visit_limit() {
		return patient_visit_limit;
	}

	public void setPatient_visit_limit(String patient_visit_limit) {
		this.patient_visit_limit = patient_visit_limit;
	}

	public String getCons_fee() {
		return cons_fee;
	}

	public void setCons_fee(String cons_fee) {
		this.cons_fee = cons_fee;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}