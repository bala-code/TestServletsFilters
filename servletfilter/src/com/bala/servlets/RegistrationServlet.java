package com.bala.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	try {
		
	
	String sid = request.getParameter("sid");
	String sname = request.getParameter("sname");
	int sage = Integer.parseInt(request.getParameter("sage"));
	String semail = request.getParameter("semail");
	String smobile = request.getParameter("smobile");
	
	out.println("<html>");
	out.println("<body>");
	out.println("<h2> Thanks for Registration</h2>");
	out.println("<table border ='1'>");
	out.println("<tr><td>Student Id </td><td>"+sid+"</td></tr>");
	out.println("<tr><td>Student Name</td><td>"+sname+"</td></tr>");
	out.println("<tr><td>Student Age </td><td>"+sage+"</td></tr>");
	out.println("<tr><td>Student Email</td><td>"+semail+"</td></tr>");
	out.println("<tr><td>Student Mobile </td><td>"+smobile+"</td></tr>");
	out.println("</table></body></html>");
	
	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	
	}

}
