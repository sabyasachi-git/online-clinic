package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entity.Doctor;
public class DoctorDao {
	private Connection conn;
	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean registerDoctor(Doctor d) {
		boolean f = false;
		try {
			String sql = "insert into doctor_details(DOC_REGISTRATION_ID, DOC_FULL_NAME, DOC_DOB, DOC_QUALIFICATION, SPECIALIST_CATEGORY, DOC_VISITING_DAY, DOC_VISITING_TIME, DOC_PATIENT_VISIT_LIMIT, DOC_CONSULTATION_FEE, DOC_MOBILE_NO, DOC_EMAIL_ID, DOC_LOGIN_PASSWORD) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDreg_id());
			ps.setString(2, d.getFull_name());
			ps.setString(3, d.getDob());
			ps.setString(4, d.getQualification());
			ps.setString(5, d.getSpecialist());
			ps.setString(6, d.getVisiting_day());
			ps.setString(7, d.getVisiting_time());
			ps.setString(8, d.getPatient_visit_limit());
			ps.setString(9, d.getCons_fee());
			ps.setString(10, d.getMobno());
			ps.setString(11, d.getEmail());
			ps.setString(12, d.getPassword());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {
			String sql = "select * from doctor_details order by DOC_ID desc";
			PreparedStatement ps = conn.prepareStatement(sql);

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
	
	public boolean updateDoctor(Doctor d) {
		boolean f = false;

		try {
			String sql = "update doctor_details set DOC_REGISTRATION_ID=?,DOC_FULL_NAME=?,DOC_DOB=?,DOC_QUALIFICATION=?,SPECIALIST_CATEGORY=?,DOC_VISITING_DAY=?,DOC_CONSULTATION_FEE=?,DOC_MOBILE_NO=?,DOC_EMAIL_ID=? where DOC_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDreg_id());
			ps.setString(2, d.getFull_name());
			ps.setString(3, d.getDob());
			ps.setString(4, d.getQualification());
			ps.setString(5, d.getSpecialist());
			ps.setString(6, d.getVisiting_day());
			//ps.setString(7, d.getVisiting_time());
			//ps.setString(8, d.getPatient_visit_limit());
			ps.setString(7, d.getCons_fee());
			ps.setString(8, d.getMobno());
			ps.setString(9, d.getEmail());
			//ps.setString(12, d.getPassword());
			ps.setInt(10, d.getDid());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteDoctor(int id) {
		boolean f = false;
		try {
			String sql = "delete from doctor_details where DOC_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Doctor login(String email, String psw) {
		Doctor d = null;
		try {

			String sql = "select * from doctor_details where DOC_EMAIL_ID=? and DOC_LOGIN_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	public int countDoctor() {
		int i = 0;
		try {
			String sql = "select * from doctor_details";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int countUSer() {
		int i = 0;
		try {
			String sql = "select * from user_login_info";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int countSpecialist() {
		int i = 0;
		try {
			String sql = "select * from specialist_doctor_list";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean checkOldPassword(int did, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from doctor_details where DOC_ID=? and DOC_LOGIN_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean changePassword(String newPassword, int did) {
		boolean f = false;

		try {
			String sql = "update doctor_details set DOC_LOGIN_PASSWORD=? where DOC_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, did);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public Doctor getDoctorById(int did) {

		Doctor d = null;
		try {
			String sql = "select * from doctor_details where DOC_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
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
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	
	public Doctor getDoctorByName(String fullName) {

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
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
//##	
	public int countAppointment() {
		int i = 0;
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = conn.prepareStatement(sql);
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
	
}