package com.collegeregistration.student;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ProcessStudent {
	
	DatabaseConnection con;
	Model stud;
	
	public String insertjobdetail(String student_id, String job_title, String internship_type, String job_group, String job_description)
	{
		con = new DatabaseConnection();
		Statement stat = con.getConnection();
		
		try{
			System.out.print(student_id);
			stat.executeUpdate("insert into studentjob(student_id,job_title, internship_type, job_group, job_description) values ('"+student_id+"','"+job_title+"', '"+internship_type+"' , '"+job_group+"', '"+job_description+"') ");
		}
		catch(Exception e)
		{

			return "Data failed " + e;
		}
		return "Data has inserted";
	}
	
	public Model registerstudent(String fname,String mname,String lname,String email,String password,String dob,String enrollyear,String gender,String status) throws SQLException{
		
		try{
			
			 stud = new Model();
			con = new DatabaseConnection();
			Statement stat = con.getConnection();
			ResultSet rs;
			int j =0 ;
			
			try {
				stat.executeUpdate("insert into registerdetail(firstname, middlename, lastname, emailaddress,password, dob,enrolledyear, gender, status) values ('"+fname+"','"+mname+"','"+lname+"','"+email+"','"+password+"','"+dob+"','"+enrollyear+"','"+gender+"','"+status+"')");
			    rs=stat.executeQuery("SELECT stud_id FROM collegedatabase.registerdetail where emailaddress = '"+email+"'");
			    	if(rs.next())
			    	{	j=rs.getInt("stud_id");
			    		stud.setStudId(j);
			    	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	
		return stud;
	}

	public boolean getstudentinfo(String email, String password){
		
		 boolean login = false;
		try{
		
        String dbUsername, dbPassword;
       
        con = new DatabaseConnection();
		Statement stat = con.getConnection();
		ResultSet rs;
        
		try{
			
           rs =  stat.executeQuery("SELECT emailaddress, password FROM collegedatabase.registerdetail where emailaddress = '"+email+"'");
             

            while(rs.next()){
                dbUsername = rs.getString("emailaddress");
                dbPassword = rs.getString("password");

                if(dbUsername.equals(email) && dbPassword.equals(password)){
                    System.out.println("OK");
                    login = true;
                }}
		
		}catch (Exception e){
			e.printStackTrace();
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return login;
	}
	
}
