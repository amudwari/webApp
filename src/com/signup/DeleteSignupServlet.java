package com.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteSignup")
public class DeleteSignupServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email=req.getParameter("ddata");
				
		try{
			//Loading the driver

			Class.forName("com.mysql.jdbc.Driver");
			
			String sql=" delete from profile where email = ?";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/signup_db","root","root");
			// pstmt -contains compiled query
						PreparedStatement pstmt=con.prepareStatement(sql);
						
						//setting values inside the place holders
						pstmt.setString(1, email);

						//fire the query
						pstmt.executeUpdate();
			
					}catch (Exception e) {
						e.printStackTrace();
					}
		
		//Here first time this servlet is calling another servlet - SignupsServlet
		//which url pattern is = /signups
		//signups -> this servlet will show all the data from the database
		req.getRequestDispatcher("signups").forward(req, resp);
           	
	}


}
