package com.dao;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entity.Appointment;
import com.entity.Doctor;
import com.entity.TimeSlots;
public class AppointmentDao {
	
	private Connection conn;
	public AppointmentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Doctor> getDoctorByName(String fullName) {		
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {
			String sql = "select * from doctor_details where DOC_FULL_NAME=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fullName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				d = new Doctor();
				d.setDid(rs.getInt(1));
				d.setDreg_id(rs.getString(2));
				d.setFull_name(rs.getString(3));
				d.setDob(rs.getString(4));
				d.setQualification(rs.getString(5));
				d.setSpecialist(rs.getString(6));
				d.setVisiting_day(rs.getString(7));
				d.setVisiting_time(rs.getString(8));
				d.setPatient_visit_limit(rs.getString(9));
				d.setCons_fee(rs.getString(10));
				d.setMobno(rs.getString(11));
				d.setEmail(rs.getString(12));
				d.setPassword(rs.getString(13));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
	public List<TimeSlots> getAllTimeSlots() {
		List<TimeSlots> list = new ArrayList<TimeSlots>();
		TimeSlots ts = null;
		try {
			String sql = "select * from appointment_time_slots order by ATS_ID";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ts = new TimeSlots();
				ts.setAts_id(rs.getInt(1));
				ts.setAts_info(rs.getString(2));				
				list.add(ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int countAllAppointment() {
		int i = 0;
		try {
			String sql = "select * from user_appointment_info";
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countAppointmentByDoctorID(int did) {
		int i = 0;
		try {
			String sql = "select * from user_appointment_info where DOC_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	public boolean addAppointment(Appointment ap) {
		boolean f = false;

		try {
			String sql = "insert into user_appointment_info(USER_ID, USER_FULL_NAME, USER_EMAIL, USER_PHONE_NUMBER, USER_GENDER, USER_AGE, USER_ADDRESS_PINCODE, DOC_ID, DOC_FULL_NAME, DOC_SPECIALIST_CATEGORY, DOC_VISITING_DAY, USER_APPOINTMENT_DATE, ATS_INFO, DOC_CONSULTATION_FEE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ap.getUid());
			ps.setString(2, ap.getUfullName());
			ps.setString(3, ap.getUemail());
			ps.setString(4, ap.getUphNo());
			ps.setString(5, ap.getUgender());
			ps.setInt(6, ap.getUage());
			ps.setInt(7, ap.getUadPincode());
			ps.setInt(8, ap.getDoctorId());
			ps.setString(9, ap.getDocName());
			ps.setString(10, ap.getDocSpec());
			ps.setString(11, ap.getDocvDay());
			ps.setString(12, ap.getUappointmentDate());
			//ps.setInt(13, ap.getAtsId());
			ps.setString(13, ap.getApptimeslot());
			ps.setInt(14, ap.getDocCons_fee());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean generateUserAppointmentLink(Appointment ap) {
		boolean f = false;

		try {
			String sql = "update user_appointment_info set USER_APN_LINK=? where APN_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, ap.getApnLink());
			ps.setInt(2, ap.getApnid());
			
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Appointment> getAllAppointmentByLoginUser(int userId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {
			String sql = "select * from user_appointment_info where USER_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setApnid(rs.getInt(1));
				ap.setUid(rs.getInt(2));
				ap.setUfullName(rs.getString(3));
				ap.setUemail(rs.getString(4));
				ap.setUphNo(rs.getString(5));
				ap.setUgender(rs.getString(6));
				ap.setUage(rs.getInt(7));
				ap.setUadPincode(rs.getInt(8));
				ap.setDoctorId(rs.getInt(9));
				ap.setDocName(rs.getString(10));
				ap.setDocSpec(rs.getString(11));
				ap.setDocvDay(rs.getString(12));
				ap.setUappointmentDate(rs.getString(13));
				//ap.setAtsId(rs.getInt(14));
				ap.setApptimeslot(rs.getString(14));
				ap.setDocCons_fee(rs.getInt(15));
				ap.setApnLink(rs.getString(16));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Appointment> getAllAppointmentByDoctorLogin(int doctorId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from user_appointment_info where DOC_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctorId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setApnid(rs.getInt(1));
				ap.setUid(rs.getInt(2));
				ap.setUfullName(rs.getString(3));
				ap.setUemail(rs.getString(4));
				ap.setUphNo(rs.getString(5));
				ap.setUgender(rs.getString(6));
				ap.setUage(rs.getInt(7));
				ap.setUadPincode(rs.getInt(8));
				ap.setDoctorId(rs.getInt(9));
				ap.setDocName(rs.getString(10));
				ap.setDocSpec(rs.getString(11));
				ap.setDocvDay(rs.getString(12));
				ap.setUappointmentDate(rs.getString(13));
				//ap.setAtsId(rs.getInt(14));
				ap.setApptimeslot(rs.getString(14));
				ap.setDocCons_fee(rs.getInt(15));
				ap.setApnLink(rs.getString(16));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Appointment getAppointmentById(int id) {

		Appointment ap = null;
		try {

			String sql = "select * from user_appointment_info where APN_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setApnid(rs.getInt(1));
				ap.setUid(rs.getInt(2));
				ap.setUfullName(rs.getString(3));
				ap.setUemail(rs.getString(4));
				ap.setUphNo(rs.getString(5));
				ap.setUgender(rs.getString(6));
				ap.setUage(rs.getInt(7));
				ap.setUadPincode(rs.getInt(8));
				ap.setDoctorId(rs.getInt(9));
				ap.setDocName(rs.getString(10));
				ap.setDocSpec(rs.getString(11));
				ap.setDocvDay(rs.getString(12));
				ap.setUappointmentDate(rs.getString(13));
				//ap.setAtsId(rs.getInt(14));
				ap.setApptimeslot(rs.getString(14));
				ap.setDocCons_fee(rs.getInt(15));
				ap.setApnLink(rs.getString(16));				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ap;
	}
	
	public List<Appointment> getAllAppointment() {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		try {
			String sql = "select * from user_appointment_info order by APN_ID";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setApnid(rs.getInt(1));
				ap.setUid(rs.getInt(2));
				ap.setUfullName(rs.getString(3));
				ap.setUemail(rs.getString(4));
				ap.setUphNo(rs.getString(5));
				ap.setUgender(rs.getString(6));
				ap.setUage(rs.getInt(7));
				ap.setUadPincode(rs.getInt(8));
				ap.setDoctorId(rs.getInt(9));
				ap.setDocName(rs.getString(10));
				ap.setDocSpec(rs.getString(11));
				ap.setDocvDay(rs.getString(12));
				ap.setUappointmentDate(rs.getString(13));
				//ap.setAtsId(rs.getInt(14));
				ap.setApptimeslot(rs.getString(14));
				ap.setDocCons_fee(rs.getInt(15));
				ap.setApnLink(rs.getString(16));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*public boolean updateCommentStatus(int id, int doctId, String comm) {
		boolean f = false;
		try {		
			try {
			String file_name= "C:\\Users\\HP\\Downloads\\patient_status.pdf";//"D:\\NetBeans\\patient_status.pdf";
			Document doc=new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(file_name));
			doc.open();			
			Paragraph para=new Paragraph(comm);
			doc.add(para);			
			doc.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
			String sql = "update appointment set status=? where id=? and doctor_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doctId);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}*/

}