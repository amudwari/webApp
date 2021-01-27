package com.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editSignup")
public class EditSignupServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//This is email id in jsp which record you want to delete
		String pemail=req.getParameter("ddata");
		
		//fetch all the data from database
		Signup signup=new Signup();

		try{
			//Loading the driver

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/signup_db","root","root");
	
			String sql="select username,password,email,name,mobile,gender, pid, doe from profile where email=?";

			// pstmt -contains compiled query
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1, pemail);
						
						//fire the query
			ResultSet rs=stmt.executeQuery();
			
			
			
			
			
			
			if(rs.next()) {
			               String username=rs.getString(1);
			               String password=rs.getString(2);
			               String email=rs.getString(3);
			               String name=rs.getString(4);
			               String mobile=rs.getString(5);
			               String gender=rs.getString(6);
						   int pid=rs.getInt(7);
			               Timestamp doe=rs.getTimestamp(8);

	        	   signup = new Signup(username, password, email, name, mobile, gender);

	                signup.setPid(pid);
	                signup.setDoe(doe);
						}

					}catch (Exception e) {
						e.printStackTrace();
					}
			//setting data into request scope with key = psignups
			//so that we can access it on jsp
		
		req.setAttribute("signup", signup);
		req.getRequestDispatcher("esignup.jsp").forward(req, resp);
	
	}
}
