package com.collegeregistration.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registerstudent
 */
@WebServlet("/Registerstudent")
public class Registerstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerstudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    ProcessStudent pro;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 pro = new ProcessStudent();
		Student generatedid = new Student();
		
	
		String fname = request.getParameter("firstname");
		String mname = request.getParameter("middlename");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String dob = request.getParameter("birthday");
		String enrollyear = request.getParameter("enrolleddate");
		String gender = request.getParameter("Gender");
		String status = request.getParameter("Status");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try {
			generatedid = pro.registerstudent(fname, mname, lname, email, password , dob, enrollyear, gender, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		out.println(" Your Student Id number is = " + generatedid.getStudId());
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
