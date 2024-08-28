package com.entity;

public class Appointment {
	private int apnid;
	private int uid;
	private String ufullName;
	private String uemail;
	private String uphNo;
	private String ugender;
	private int uage;
	private int uadPincode;
	private int doctorId;
	private String docName;
	private String docSpec;
	private String docvDay;
	private String uappointmentDate;
	//private int atsId;
	private String apptimeslot;
	private int docCons_fee;
	private String apnLink;
	
	public Appointment() {
		super();
	}
	
	public Appointment(int uid, String ufullName, String uemail, String uphNo, String ugender, int uage,
			int uadPincode, String docName) {
		super();
		this.uid = uid;
		this.ufullName = ufullName;
		this.uemail = uemail;
		this.uphNo = uphNo;
		this.ugender = ugender;
		this.uage = uage;
		this.uadPincode = uadPincode;
		this.docName = docName;
	}
	
	public Appointment(int uid, String ufullName, String uemail, String uphNo, String ugender, int uage,
			int uadPincode, int doctorId, String docName, String docSpec, String docvDay, String uappointmentDate,
			String apptimeslot, int docCons_fee) {
		super();
		this.uid = uid;
		this.ufullName = ufullName;
		this.uemail = uemail;
		this.uphNo = uphNo;
		this.ugender = ugender;
		this.uage = uage;
		this.uadPincode = uadPincode;
		this.doctorId = doctorId;
		this.docName = docName;
		this.docSpec = docSpec;
		this.docvDay = docvDay;
		this.uappointmentDate = uappointmentDate;
		this.apptimeslot = apptimeslot;
		this.docCons_fee = docCons_fee;
	}
	
	public Appointment(String apnLink, int apnid) {
		super();
		this.apnLink = apnLink;
		this.apnid = apnid;
	}

	public Appointment(int apnid, int uid, String ufullName, String uemail, String uphNo, String ugender, int uage,
			int uadPincode, int doctorId, String docName, String docSpec, String docvDay, String uappointmentDate,
			String apptimeslot, int docCons_fee, String apnLink) {
		super();
		this.apnid = apnid;
		this.uid = uid;
		this.ufullName = ufullName;
		this.uemail = uemail;
		this.uphNo = uphNo;
		this.ugender = ugender;
		this.uage = uage;
		this.uadPincode = uadPincode;
		this.doctorId = doctorId;
		this.docName = docName;
		this.docSpec = docSpec;
		this.docvDay = docvDay;
		this.uappointmentDate = uappointmentDate;
		this.apptimeslot = apptimeslot;
		this.docCons_fee = docCons_fee;
		this.apnLink = apnLink;
	}

	public int getApnid() {
		return apnid;
	}

	public void setApnid(int apnid) {
		this.apnid = apnid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUfullName() {
		return ufullName;
	}

	public void setUfullName(String ufullName) {
		this.ufullName = ufullName;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUphNo() {
		return uphNo;
	}

	public void setUphNo(String uphNo) {
		this.uphNo = uphNo;
	}

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public int getUadPincode() {
		return uadPincode;
	}

	public void setUadPincode(int uadPincode) {
		this.uadPincode = uadPincode;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocSpec() {
		return docSpec;
	}

	public void setDocSpec(String docSpec) {
		this.docSpec = docSpec;
	}

	public String getDocvDay() {
		return docvDay;
	}

	public void setDocvDay(String docvDay) {
		this.docvDay = docvDay;
	}

	public String getUappointmentDate() {
		return uappointmentDate;
	}

	public void setUappointmentDate(String uappointmentDate) {
		this.uappointmentDate = uappointmentDate;
	}

	/*public int getAtsId() {
		return atsId;
	}

	public void setAtsId(int atsId) {
		this.atsId = atsId;
	}*/

	public String getApptimeslot() {
		return apptimeslot;
	}

	public void setApptimeslot(String apptimeslot) {
		this.apptimeslot = apptimeslot;
	}

	public int getDocCons_fee() {
		return docCons_fee;
	}

	public void setDocCons_fee(int docCons_fee) {
		this.docCons_fee = docCons_fee;
	}

	public String getApnLink() {
		return apnLink;
	}

	public void setApnLink(String apnLink) {
		this.apnLink = apnLink;
	}
}