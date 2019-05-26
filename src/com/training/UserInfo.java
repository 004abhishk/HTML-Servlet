package com.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname ="";
		String lname ="";
		int contact = 0;
		String emailid = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineExamination", "root", "root");
			Statement stmt = con.createStatement();
			String username = request.getParameter("UserName");
			String query = "Select * from userinformation where username = '" + username +"'" ;
			ResultSet rs = stmt.executeQuery(query);
			while(rs != null && rs.next()) {
				if(rs.getString("username").equalsIgnoreCase(username)) {
					fname = rs.getString("firstname");
					lname = rs.getString("lastname");
					contact = rs.getInt("contact");
					emailid = rs.getString("emailid");
					break;
				}
			}
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		} 
		
		PrintWriter print = response.getWriter();
		String htmlResponse = "<html><body><h2>User Information</h2>"+ "<form action="+ "\"SubjectNav\" method="+ "\"post\">" +"<label>First Name : </label>" +fname +"</br>"+"<label>Last Name : </label>"
		+ lname + "</br><label> Contact: </label>"+ contact +"</br><label>Email Id: </label>"+ emailid +"</br>" + "<label> Select one Subject : </label>" +
				"<select name=" + "\"subject\">"+ "<option>JAVA</option>"+ "<option>.NET</option>"+ "<option>Python</option>" 
				+"</select></br>" + "<input type="+ "\"submit\""+ "value = " +"\"Proceed\"" +">" +"</form><body></html>";
		print.println(htmlResponse);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
