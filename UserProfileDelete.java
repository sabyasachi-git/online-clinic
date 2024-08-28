package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.UserDao;
import com.db.DBConnect;

@SuppressWarnings("serial")
@WebServlet("/userProfileDelete")
public class UserProfileDelete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int uid = Integer.parseInt(req.getParameter("uid"));
		UserDao dao = new UserDao(DBConnect.getConn());
		boolean f = dao.deleteUser(uid);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "User Deleted");
			resp.sendRedirect("user_login.jsp");
		} else {
			session.setAttribute("errorMsg", "Something Wrong on Server");
			resp.sendRedirect("user_login.jsp");
		}
	}
	
}
