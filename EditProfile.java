package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

@SuppressWarnings("serial")
@WebServlet("/doctorUpdateProfile")
public class EditProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int did = Integer.parseInt(req.getParameter("did"));
			String dregID = req.getParameter("drn");
			String fullName = req.getParameter("fname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String dvisit = req.getParameter("visitDay");
			String cfee = req.getParameter("cfee");
			String mobno = req.getParameter("mobno");
			String email = req.getParameter("email");			

			Doctor d = new Doctor(did, dregID, fullName, dob, qualification, spec, dvisit, cfee, mobno, email);

			DoctorDao dao = new DoctorDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.updateDoctor(d)) {
				Doctor updateDoctor = dao.getDoctorById(did);
				session.setAttribute("succMsgd", "Doctor Updated Successfully..");
				session.setAttribute("doctObj", updateDoctor);
				resp.sendRedirect("doctor/edit_profile.jsp");
			} else {
				session.setAttribute("errorMsgd", "Something Wrong on Server");
				resp.sendRedirect("doctor/edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}