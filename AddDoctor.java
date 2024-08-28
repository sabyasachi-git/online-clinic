package com.admin.servlet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

	public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9]+([._%-]*[A-Za-z0-9]+)*@[A-Za-z0-9]+\\.[A-Za-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
	public static boolean isValidName(String name) {
        // Regular expression for a valid name (alphabets and spaces only)
        String regex = "^[A-Za-z\\s]+$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }
	public static boolean isvalidDOB(String dob) {
	      
		  int cd = 1998;
		  String [] a = dob.split("-",2);
	      int db;
	      db = Integer.parseInt(a[0]);
	     
	      if (db<cd) {	          
	          return true; 
	      } else {	         
	          return false; 
	      }	    
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		try {			
			String dregID = req.getParameter("drn");
			String fullName = req.getParameter("fname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String dvisit = req.getParameter("visitDay");
			String tvisit = req.getParameter("visitTime");
			String pvl = req.getParameter("pvl");
			String cfee = req.getParameter("cfee");
			String mobno = req.getParameter("mobno");
			String email = req.getParameter("email");			
			String password = req.getParameter("password");

			String regex = "\\d{10}";
			Doctor d = new Doctor(dregID, fullName, dob, qualification, spec, dvisit,
					tvisit, pvl, cfee, mobno, email, password);

			DoctorDao dao = new DoctorDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if(isValidEmail(email) && mobno.matches(regex) && isvalidDOB(dob) && 
					isValidName(fullName) && fullName.length()>1)
			{	
				if (dao.registerDoctor(d))
				{	
					session.setAttribute("succMsg", "Doctor Added Successfully..");
					resp.sendRedirect("admin/index.jsp");
				}
				else {
					session.setAttribute("errorMsg","Something Wrong on Server");
					resp.sendRedirect("admin/index.jsp");
				}
			} 
			else 
			{
				session.setAttribute("errorMsg", "Invalid Mobile_No or Email-ID");
				resp.sendRedirect("admin/index.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}