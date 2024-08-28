package com.user.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.User;
import com.dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try {
			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			User u = new User(fullName, email, password);
			UserDao dao = new UserDao(DBConnect.getConn());			
			HttpSession session=req.getSession();
			
			if(isValidEmail(email) && isValidName(fullName) && fullName.length()>1)
			{	
				if (dao.register(u)) {
					session.setAttribute("succMsg", "Register Successful");
					resp.sendRedirect("user_login.jsp");
				} 
				else {	
					session.setAttribute("errorMsg", "Something Went Wrong on Server");
					resp.sendRedirect("user_login.jsp");
				}
			}
			else {
				session.setAttribute("errorMsg", "Invalid ID or Password");
				resp.sendRedirect("user_login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}