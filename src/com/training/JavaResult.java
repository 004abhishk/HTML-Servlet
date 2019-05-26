package com.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Result")
public class JavaResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String q1 = request.getParameter("Q1");
		String q2 = request.getParameter("Q2");
		String q3 = request.getParameter("Q3");
		String q4 = request.getParameter("Q4");
		int totalQuestion = 4;
		int rightQuestion = 0;
		int marks = 0;
		if(q1.equalsIgnoreCase("all")) {
			rightQuestion = rightQuestion+1;
			marks = marks+5;
		}
		if(q2.equalsIgnoreCase("0.0f")) {
			rightQuestion = rightQuestion+1;
			marks = marks+5;
		}
		if(q3.equalsIgnoreCase("initialize")) {
			rightQuestion = rightQuestion+1;
			marks = marks+5;
		}
		if(q4.equalsIgnoreCase("serializable")) {
			rightQuestion = rightQuestion+1;
			marks = marks+5;
		}
		PrintWriter print = response.getWriter();
		String display = "<html><center><div><h3>Your Score below : </h3><label>Total Questions : </label>"+ totalQuestion +"<br/><label>Right Questions : </label>"
		+ rightQuestion + "<br/><label>Total Marks : </label>" + marks +"</div></center></html>";
		print.println(display);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
