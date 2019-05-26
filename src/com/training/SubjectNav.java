package com.training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubjectNav")
public class SubjectNav extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Subject Nav called.");
		String subject = request.getParameter("subject").toUpperCase();
		switch(subject) {
			case "JAVA" : 
				System.out.println("JAVA");
				response.sendRedirect("JAVA.html");
				break;
			case ".NET" :
				System.out.println("DOTNET");
				response.sendRedirect("DOTNET.html");
				break;
			case "PYTHON" :
				System.out.println("PYTHON");
				response.sendRedirect("PYTHON.html");
				break;
			default :
				System.out.println("DEFAULT");
				response.sendRedirect("JAVA.html");
				break;
		}
	}

}
