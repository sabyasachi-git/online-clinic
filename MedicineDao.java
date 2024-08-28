package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Medicine;

public class MedicineDao {

	private Connection conn;

	public MedicineDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addMedicine(String mfn, String medName, String bn, String mfd, String exp, String mrp) {
		boolean f = false;
		try {
			String sql = "insert into medicine_details(MED_MF_NAME, MEDICINE_NAME, MED_BATCH_NO, MED_MF_DATE, MED_EXP_DATE, MED_MRP) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mfn);
			ps.setString(2, medName);
			ps.setString(3, bn);
			ps.setString(4, mfd);
			ps.setString(5, exp);
			ps.setString(6, mrp);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public int countMed() {
		int i = 0;
		try {
			String sql = "select * from medicine_details";
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
	
	public List<Medicine> getAllMedicine() {
		List<Medicine> list = new ArrayList<Medicine>();
		Medicine d = null;
		try {

			String sql = "select * from medicine_details order by MED_ID desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Medicine();
				d.setMed_id(rs.getInt(1));
				d.setMf_name(rs.getString(2));
				d.setMed_name(rs.getString(3));
				d.setBatch_no(rs.getString(4));
				d.setMf_date(rs.getString(5));
				d.setExp_date(rs.getString(6));
				d.setMed_mrp(rs.getString(7));
				list.add(d);				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Medicine getMedicineById(int id) {

		Medicine m = null;
		try {
			String sql = "select * from medicine_details where MED_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				m = new Medicine();
				m.setMed_id(rs.getInt(1));
				m.setMf_name(rs.getString(2));
				m.setMed_name(rs.getString(3));
				m.setBatch_no(rs.getString(4));
				m.setMf_date(rs.getString(5));
				m.setExp_date(rs.getString(6));
				m.setMed_mrp(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public boolean updateMedicine(Medicine m) {
		boolean f = false;

		try {
			String sql = "update medicine_details set MED_MF_NAME=?,MEDICINE_NAME=?,MED_BATCH_NO=?,MED_MF_DATE=?,MED_EXP_DATE=?,MED_MRP=? where MED_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getMf_name());
			ps.setString(2, m.getMed_name());
			ps.setString(3, m.getBatch_no());
			ps.setString(4, m.getMf_date());
			ps.setString(5, m.getExp_date());
			ps.setString(6, m.getMed_mrp());
			ps.setInt(7, m.getMed_id());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteMedicine(int id) {
		boolean f = false;
		try {
			String sql = "delete from medicine_details where MED_ID=?";
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
}