package com.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/signups")
public class SignupsServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//fetch all the data from database
		List<Signup> signups = new ArrayList <Signup>();
	
		//code for JDBC programming
	
		try{
			//Loading the driver
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/signup_db","root","root");
		
			String sql="select username,password,email,name,mobile,gender, pid, doe from profile";

			// pstmt -contains compiled query
				Statement stmt=con.createStatement();
						
						//fire the query
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
			               String username=rs.getString(1);
			               String password=rs.getString(2);
			               String email=rs.getString(3);
			               String name=rs.getString(4);
			               String mobile=rs.getString(5);
			               String gender=rs.getString(6);
							int pid=rs.getInt(7);
			                Timestamp doe=rs.getTimestamp(8);

	        		Signup signup = new Signup(username, password,email, name, mobile, gender);

	                signup.setPid(pid);
	                signup.setDoe(doe);

	                signups.add(signup);
		
	        
				}
					}catch (Exception e) {
						e.printStackTrace();
					}
			//setting data into request scope with key = psignups
			//so that we can access it on jsp
		
		req.setAttribute("psignups", signups);
		req.getRequestDispatcher("signups.jsp").forward(req, resp);
	
	}
}
