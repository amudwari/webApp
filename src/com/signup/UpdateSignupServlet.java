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


@WebServlet("/updateSignup")
public class UpdateSignupServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		String mobile=req.getParameter("mobile");
		String gender=req.getParameter("gender");
				
				
		
		//code for JDBC programming
	
		try{
			//Loading the driver
			//below is present inside jar file
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql="update profile set username=?,password=?,name=?,mobile=?,gender=? where email=?";

			//making connection to the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/signup_db","root","root");
			// pstmt -contains compiled query
						PreparedStatement pstmt=con.prepareStatement(sql);
						
						//setting values inside the place holders
						pstmt.setString(1, username);
						pstmt.setString(2, password);
						pstmt.setString(3, name);
						pstmt.setString(4, mobile);
						pstmt.setString(5, gender);
						pstmt.setString(6, email);

						//fire the query!!!
						pstmt.executeUpdate();
						
					}catch (Exception e) {
						e.printStackTrace();

		}
		req.getRequestDispatcher("signups").forward(req, resp);
	
	}

	
}
