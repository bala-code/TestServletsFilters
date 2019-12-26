package com.bala.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationFilters implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String sid_error = "",sname_error ="",sage_error ="", semail_error = "" ,smobile_error = "";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String semail = request.getParameter("semail");
		String smobile = request.getParameter("smobile");
		
		boolean flag = true;
		
		if (sid == null || sid.equals("") )
		{
				sid_error =" Id must be Required";
				flag = false;
		}else {
			
			if(!sid.startsWith("D")) {
				sid_error="ID is Invalid, Please start ID number with D";
				flag=false;
			}
		}
		
		if (sname == null || sname.equals(""))
		{
			sname_error = "Name is reuired";
			flag = false;
		}
		
		if (sage == null || sage.equals(""))
		{
			
			sage_error = "age is reuired";
			flag = false;
		}else {
			int age = Integer.parseInt(sage);
			if(age<18) {
				sage_error = "As per the Law age should be 18";
				flag = false;
			}
			if(age>40) {
				sage_error = "sorry , age should be below 40";
				flag = false;
			}
			
		}
		
		
		if (semail == null || semail.equals(""))
		{
			semail_error = "Email is reuired";
			flag = false;
		}else {
			if(!semail.endsWith("@gmail.com"))
			
					sage_error = "Please register with gmail account";
					flag = false;
				
		}
		
		
		if (smobile == null || smobile.equals(""))
		{
			smobile_error = "Mobile is required";
			flag = false;
		}else {
			if(!smobile.startsWith("91")) {
				smobile_error = "Mobile number should start with 91";
				flag = false;
			}
		}
		
		
		
		if (flag == true) {
			chain.doFilter(request, response);
		}else {
			 
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>Software Engineer job portal</h2>");
			out.println("<h3>Student registration for Jobs</h3>");
			out.println("<form method='POST' action='/reg'> ");
			
			out.println("<table>");
			
			out.println("<tr>");
			out.println("<td>Id</td>");
			out.println("<td><input type='text' name='sid' value='"+sid+"'/></td>");
			out.println("<td><font color='red' size='5'><b>" + sid_error + "</b></font></td>");
			out.println("</tr>");
		
			out.println("<tr>");
			out.println("<td>Name</td>");
			out.println("<td><input type='text' name='sname' value='"+sname+"'/></td>");
			out.println("<td><font color='red' size='5'><b>" + sname_error + "</b></font></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Age</td>");
			out.println("<td><input type='text' name='sage' value='"+sage+"'/></td>");
			out.println("<td><font color='red' size='5'><b>" + sage_error + "</b></font></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Email</td>");
			out.println("<td><input type='text' name='semail' value='"+semail+"'/></td>");
			out.println("<td><font color='red' size='5'><b>" + semail_error + "</b></font></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Mobile</td>");
			out.println("<td><input type='text' name='smobile' value='"+smobile+"'/></td>");
			out.println("<td><font color='red' size='5'><b>" + smobile_error + "</b></font></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><input type='submit' value='Registration'/></td>");
			out.println("</tr>");
			
			out.println("</table></form></body></html>");
	
		}
			
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	

}
