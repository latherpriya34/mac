package com.collegeregistration.student;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class ProcessStudent {
	
	DatabaseConnection con;
	Model stud;
	
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

	
}
