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
//import com.entity.Medicine;

@SuppressWarnings("serial")
@WebServlet("/addMedicine")
public class AddMedicine extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mf_Name = req.getParameter("mfn");
		String med_Name = req.getParameter("medName");
		String batch_no = req.getParameter("bn");
		String mf_date = req.getParameter("mfd");
		String exp_date = req.getParameter("exp");
		String med_mrp = req.getParameter("mrp");

		//Medicine m = new Medicine(specName, medName);
		
		MedicineDao dao = new MedicineDao(DBConnect.getConn());
		boolean f = dao.addMedicine(mf_Name, med_Name, batch_no, mf_date, exp_date, med_mrp);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "Medicine Added");
			resp.sendRedirect("admin/index.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("admin/index.jsp");
		}
	}
}