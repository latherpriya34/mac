package com.collegeregistration.student;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class ProcessStudent {
	
	DatabaseConnection con;
	Student stud;
	
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
	
	public Student registerstudent(String fname,String mname,String lname,String email,String password,String dob,String enrollyear,String gender,String status) throws SQLException{
		
		try{
			
			 stud = new Student();
			con = new DatabaseConnection();
			Statement stat = con.getConnection();
			ResultSet rs;
			int j =0 ;
			
			try {
				stat.executeUpdate("insert into registerdetail(firstname, middlename, lastname, emailaddress,password, dob,enrolledyear, gender, status) values ('"+fname+"','"+mname+"','"+lname+"','"+email+"','"+password+"','"+dob+"','"+enrollyear+"','"+gender+"','"+status+"')");
			    rs=stat.executeQuery("SELECT stud_id FROM collegedatabase.registerdetail where emailaddress = '"+email+"'");
			    	if(rs.next())
			    	{	
			    		stud.setStudId(rs.getInt("stud_id"));
			    	
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

	public Student getstudentinfo(String email, String password){
		
		 
		try{
		stud = new Student();
        String dbUsername, dbPassword;
       
        con = new DatabaseConnection();
		Statement stat = con.getConnection();
		ResultSet rs, rs1;
        
		try{
			
           rs =  stat.executeQuery("SELECT emailaddress, password FROM collegedatabase.registerdetail where emailaddress = '"+email+"'");
             

            while(rs.next()){
                dbUsername = rs.getString("emailaddress");
                dbPassword = rs.getString("password");

                if(dbUsername.equals(email) && dbPassword.equals(password)){
                	
                	rs1 = stat.executeQuery("select * from collegedatabase.registerdetail where emailaddress = '"+email+"'");
                	while(rs1.next()){
                	stud.setStudId(rs1.getInt("stud_id"));
		    		stud.setFirstName(rs1.getString("firstname"));
		    		stud.setMiddleName(rs1.getString("middlename"));
		    		stud.setLastName(rs1.getString("lastname"));
		    		stud.setEmailaddress(rs1.getString("emailaddress"));
		    		stud.setDateofBirth(rs1.getString("dob"));
		    		stud.setEnrolledyear(rs1.getString("enrolledyear"));
		    		stud.setGender(rs1.getString("gender"));
		    		stud.setStatus(rs1.getString("status"));
                	}
                    
                }}
		
		}catch (Exception e){
			e.printStackTrace();
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return stud;
	}
	
public Student registerstaff(String fname,String mname,String lname,String email,String password) throws SQLException{
		
		try{
			
			 stud = new Student();
			con = new DatabaseConnection();
			Statement stat = con.getConnection();
			ResultSet rs;
			int j =0 ;
			
			try {
				stat.executeUpdate("insert into staff(firstname, middlename, lastname, emailaddress,password) values ('"+fname+"','"+mname+"','"+lname+"','"+email+"','"+password+"')");
			    rs=stat.executeQuery("SELECT staff_id FROM collegedatabase.staff where emailaddress = '"+email+"'");
			    	if(rs.next())
			    	{	
			    		stud.setStaffId(rs.getInt("staff_id"));
			    	
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

public boolean staffloginpage(String email, String password){
	
	boolean outfromdatabase = false;
	 
	try{
	stud = new Student();
    String dbUsername, dbPassword ;
   
    con = new DatabaseConnection();
	Statement stat = con.getConnection();
	ResultSet rs;
    
	try{
		
       rs =  stat.executeQuery("SELECT emailaddress, password FROM collegedatabase.staff where emailaddress = '"+email+"'");
         

        while(rs.next()){
            dbUsername = rs.getString("emailaddress");
            dbPassword = rs.getString("password");

            if(dbUsername.equals(email) && dbPassword.equals(password)){
            	
            	outfromdatabase = true;                
            }}
	
	}catch (Exception e){
		e.printStackTrace();
	}
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return outfromdatabase;
}

public String deletestudent(int stud_Id){
	
	String result = "your row has been deleted.";
	try{
	stud = new Student();
   
    
   
    con = new DatabaseConnection();
	Statement stat = con.getConnection();
	
            	
            	stat.executeUpdate("delete from collegedatabase.registerdetail " + " where stud_id = "+stud_Id+" ");                
            
            
        
        
	
	
	
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return result;
}
}
