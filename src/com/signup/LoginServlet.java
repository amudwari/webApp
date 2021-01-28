package com.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/signin")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		//code for JDBC programming
	
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql="select username,password,email,name,mobile,gender,doe from profile where username=? and password= ?";

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/signup_db","root","root");
			// pstmt -contains compiled query
						PreparedStatement pstmt=con.prepareStatement(sql);
						
						//setting values inside the place holders
						pstmt.setString(1, username);
						pstmt.setString(2, password);

						ResultSet rs=pstmt.executeQuery();
						if(rs.next()){
							//create session for logged in user
							HttpSession session=req.getSession();
							Signup signup=new Signup(username,password,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
							//adding user details into the session
							session.setAttribute("data", signup);
							req.getRequestDispatcher("review.jsp").forward(req, resp);
						}else{
							req.setAttribute("message", "Sorry! username and password are not correct!");
							req.getRequestDispatcher("login.jsp").forward(req, resp);
						}		
					}catch (Exception e) {
						e.printStackTrace();

		}

	}
	
}
