package com.collegeregistration.student;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class Getstudentinfo
 */
@WebServlet("/Getstudentinfo")
public class Getstudentinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getstudentinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    Model data = (Model) context.getBean("helloWorld");
		
		PrintWriter out = response.getWriter();
    ProcessStudent pro = new ProcessStudent();
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	 data = pro.getstudentinfo(email, password);
	 out.println("<html><body>");
	 out.println("<table border=1 width=70% height=50%>");
     out.println("<tr><th>Student Id</th><th>Student First Name</th><th>Student Middle Name</th><th>Student Last Name</th><th>Email Address</th><th>Date Of Birth</th><th>Enrolled Year</th><th>Gender</th><th>Status</th><tr>");
     out.println("<tr><td>" + data.getStudId() + "</td><td>" + data.getFirstName() + "</td><td>" + data.getMiddleName() + "</td><td>" + data.getLastName() + "</td><td>" + data.getEmailaddress() + "</td><td>" + data.getDateofBirth() + "</td><td>" + data.getEnrolledyear() + "</td><td>" + data.getGender() + "</td><td>" + data.getStatus() + "</td></tr>"); 
     out.println("</table>");
     out.println("</html></body>");
     /*	if(login==true){
		
		response.sendRedirect("studentdata.html");
	}else { 
		response.sendRedirect("studentlogin.html");
	}
	*/

	out.println("You are successfully logged in.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
