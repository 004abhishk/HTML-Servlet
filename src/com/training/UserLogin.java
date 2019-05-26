package com.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("do init method.");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do POST method.");
		try {
			String userName = "";
			String userPassword = "";
			String uname = request.getParameter("username");
			String upassword = request.getParameter("password");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineExamination", "root", "root");
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from userlogin");
			while (rs != null && rs.next()) {
				userName = rs.getString("username");
				if(userName.equalsIgnoreCase(uname)) {
					userPassword = rs.getString("userpassword");
					break;
				}	
			}
			if(uname.equalsIgnoreCase(userName) && upassword.equalsIgnoreCase(userPassword)) {
				response.sendRedirect("UserInfo?UserName="+userName);
			}else {
				response.sendRedirect("UserLogin.html");
				System.out.println("User Login failed.");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR in class : " + getServletName() + ":" + e.getMessage() );
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR in class : " + getServletName() + ":" + e.getMessage() );
			e.printStackTrace();
		}
	}

}
