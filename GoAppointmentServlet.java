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
@WebServlet("/bookAppointment")
public class GoAppointmentServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		int uPincode = Integer.parseInt(req.getParameter("upc"));
		int did = Integer.parseInt(req.getParameter("did"));
		String docName = req.getParameter("docName");
		String docSpec = req.getParameter("spec");
		String dvisit = req.getParameter("vd");
		String apn_date = req.getParameter("appoint_date");
		String timeSlots = req.getParameter("ts");
		//int ats_id = Integer.parseInt(req.getParameter("ats_id"));
		int cons_fee = Integer.parseInt(req.getParameter("cfee"));
				
		Appointment ap = new Appointment(userId, fullname, email, phno, gender, age, uPincode, did, docName, docSpec, dvisit, apn_date, timeSlots, cons_fee);

		AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		if (dao.addAppointment(ap)) {		
			
			session.setAttribute("succMsg", "Appointment Successful");
			resp.sendRedirect("appointment_userDetails.jsp");
			//RequestDispatcher rd = req.getRequestDispatcher("appointment.jsp");
			//rd.forward(req, resp);
			
		}else {
			session.setAttribute("errorMsg", "Something Wrong on Server");
			resp.sendRedirect("appointment_userDetails.jsp");
		}
	}
}
