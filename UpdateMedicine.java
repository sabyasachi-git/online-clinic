package com.admin.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.dao.MedicineDao;
import com.entity.Medicine;

@SuppressWarnings("serial")
@WebServlet("/updateMedicine")
public class UpdateMedicine extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String mf_Name = req.getParameter("mfn");
			String med_Name = req.getParameter("medName");
			String batch_no = req.getParameter("bn");
			String mf_date = req.getParameter("mfd");
			String exp_date = req.getParameter("exp");
			String med_mrp = req.getParameter("mrp");

			int id = Integer.parseInt(req.getParameter("id"));

			Medicine m = new Medicine(id, mf_Name, med_Name, batch_no, mf_date, exp_date, med_mrp);

			MedicineDao dao = new MedicineDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.updateMedicine(m)) {
				session.setAttribute("succMsg", "Medicine Updated Successfully..");
				resp.sendRedirect("admin/view_medicine.jsp");
			} else {
				session.setAttribute("errorMsg", "Something Wrong on Server");
				resp.sendRedirect("admin/view_medicine.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
}