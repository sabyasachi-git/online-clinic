package com.admin.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpecialistDao;
import com.db.DBConnect;

@SuppressWarnings("serial")
@WebServlet("/deleteSpecialist")
public class DeleteSpecialist extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String specName = req.getParameter("dspec");

		SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
		boolean f = dao.deleteSpecialist(specName);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "Specialist Deleted");
			resp.sendRedirect("admin/index.jsp");
		} else {
			session.setAttribute("errorMsg", "Something Wrong on Server");
			resp.sendRedirect("admin/index.jsp");
		}
	}
}