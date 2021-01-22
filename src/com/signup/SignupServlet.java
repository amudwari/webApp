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


@WebServlet("/sign")
public class SignupServlet extends HttpServlet {
	
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
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql="insert into profile (username,password,name,email,mobile,gender,doe)" + "values(?,?,?,?,?,?,?)";

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/signup_db","root","root");
			// pstmt -contains compiled query
						PreparedStatement pstmt=con.prepareStatement(sql);
						
						//setting values inside the place holders
						pstmt.setString(1, username);
						pstmt.setString(2, password);
						pstmt.setString(3, name);
						pstmt.setString(4, email);
						pstmt.setString(5, mobile);
						pstmt.setString(6, gender);
					
						//Creating instance of Timestamp
						long millis = new Date().getTime();
						Timestamp timestamp=new Timestamp(millis);
						
						pstmt.setTimestamp(7, timestamp);
						
						
						//fire the query!!!
						pstmt.executeUpdate();
						
					}catch (Exception e) {
						e.printStackTrace();

		}

		Signup signup = new Signup(username, password, email, name, mobile, gender);
	
		req.setAttribute("data", signup);
		req.getRequestDispatcher("review.jsp").forward(req, resp);
	
	}

	
}
