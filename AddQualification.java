package com.admin.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.QualificationDao;
import com.db.DBConnect;

@SuppressWarnings("serial")
@WebServlet("/addQualification")
public class AddQualification extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String QName = req.getParameter("QName");

		QualificationDao dao = new QualificationDao(DBConnect.getConn());
		boolean f = dao.addQualification(QName);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "Qualification Added");
			resp.sendRedirect("admin/index.jsp");
		} else {
			session.setAttribute("errorMsg", "Something Wrong on server");
			resp.sendRedirect("admin/index.jsp");
		}
	}	
}