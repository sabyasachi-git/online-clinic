package com.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;

@SuppressWarnings("serial")
@WebServlet("/appAppointment")
public class AppointmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws 
	ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		int uPincode = Integer.parseInt(req.getParameter("upc"));
		String docName = req.getParameter("docName");
		
		Appointment ap = new Appointment(userId, fullname, email, phno, gender, age, uPincode, docName);

		AppointmentDao dao = new AppointmentDao(DBConnect.getConn());		
		boolean flag=true;
		if (flag) {
			HttpSession session = req.getSession();
			session.setAttribute("apn", ap);
			RequestDispatcher rd = req.getRequestDispatcher("appointment.jsp");
			rd.forward(req, resp);			
		} 
	}
}