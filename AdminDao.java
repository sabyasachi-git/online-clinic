package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Admin;

public class AdminDao {
	
	private Connection conn;
	public AdminDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public Admin login(String email, String psw) {
		Admin d = null;
		try {

			String sql = "select * from admin_login where ADMIN_EMAIL=? and ADMIN_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Admin();
				d.setAd_id(rs.getInt(1));
				d.setAd_email(rs.getString(2));
				d.setAd_password(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public boolean checkOldPassword(int ad_id, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from admin_login where ADMIN_ID=? and ADMIN_PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setInt(1, ad_id);
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

	public boolean changePassword(int ad_id, String newPassword) {
		boolean f = false;

		try {
			String sql = "update admin_login set ADMIN_PASSWORD=? where ADMIN_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, ad_id);

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