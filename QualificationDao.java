package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Qualification;
public class QualificationDao {

	private Connection conn;

	public QualificationDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addQualification(String QName) {
		boolean f = false;
		try {
			String sql = "insert into doctor_qualification_details(DQ_NAME) values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, QName);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public int countQualification() {
		int i = 0;
		try {
			String sql = "select * from doctor_qualification_details";
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
	
	public List<Qualification> getAllQualification() {
		List<Qualification> list = new ArrayList<Qualification>();
		Qualification s = null;

		try {
			String sql = "select * from doctor_qualification_details";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				s = new Qualification();
				s.setQ_id(rs.getInt(1));
				s.setQuali_name(rs.getString(2));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
}