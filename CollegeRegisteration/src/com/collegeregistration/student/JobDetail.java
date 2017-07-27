package com.collegeregistration.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jobdetail
 */
@WebServlet("/JobDetail")
public class JobDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessStudent p = new ProcessStudent();
		Model r = new Model();
		String student_id= request.getParameter("studentid");
		String job_title = request.getParameter("jobtitle");
		String internship_type = request.getParameter("internshiptype");
		String job_group = request.getParameter("jobgroup");
		String job_description = request.getParameter("description");
		r= p.insertjobdetail(student_id, job_title, internship_type, job_group, job_description);
		PrintWriter out = response.getWriter();
		out.println(r.getJob_title());
		out.println(r.getInternship_type());
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
