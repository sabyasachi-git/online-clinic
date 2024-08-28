package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MedicineDao;
import com.db.DBConnect;

@SuppressWarnings("serial")
@WebServlet("/deleteMedicine")
public class DeleteMedicine extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		MedicineDao dao = new MedicineDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.deleteMedicine(id)) {
			session.setAttribute("succMsg", "Medicine Deleted Successfully..");
			resp.sendRedirect("admin/view_medicine.jsp");
		} else {
			session.setAttribute("errorMsg", "Something Wrong on Server");
			resp.sendRedirect("admin/view_medicine.jsp");
		}
		
	}	
}