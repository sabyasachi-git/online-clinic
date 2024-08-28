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
@WebServlet("/generateLink")
public class AppointmentLink extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String apn_link = req.getParameter("apn_link");
		int uid = Integer.parseInt(req.getParameter("uid"));
		Appointment ap = new Appointment(apn_link, uid);
		AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		if (dao.generateUserAppointmentLink(ap)) {		
			
			session.setAttribute("succMsg", "Link Generate Successfully");
			resp.sendRedirect("doctor/patient.jsp");
			//RequestDispatcher rd = req.getRequestDispatcher("appointment.jsp");
			//rd.forward(req, resp);
			
		}else {
			session.setAttribute("errorMsg", "Something Wrong on Server");
			resp.sendRedirect("doctor/patient.jsp");
		}
	}
}
