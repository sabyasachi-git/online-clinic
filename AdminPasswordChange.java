package com.admin.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.db.DBConnect;

@SuppressWarnings("serial")
@WebServlet("/adminPassword")
public class AdminPasswordChange extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int aid = Integer.parseInt(req.getParameter("aid"));
		String oldPassword = req.getParameter("old_pass");
		String newPassword = req.getParameter("new_pass");

		AdminDao dao = new AdminDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.checkOldPassword(aid, oldPassword)) {

			if (dao.changePassword(aid, newPassword)) {
				session.setAttribute("succMsg", "Password Change Successfully");
				resp.sendRedirect("admin/index.jsp");

			} else {
				session.setAttribute("errorMsg", "Something Wrong on Server");
				resp.sendRedirect("admin/index.jsp");
			}

		} else {
			session.setAttribute("errorMsg", "Old Password Incorrect");
			resp.sendRedirect("admin/index.jsp");
		}

	}
}