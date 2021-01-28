package com.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//hey give me my session only
		HttpSession session=req.getSession(false);
		if(session!=null){
			//kill my session
			session.invalidate();
		}
		req.setAttribute("message", "You have been log out successfully from the application");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
           	
	}
	
}
