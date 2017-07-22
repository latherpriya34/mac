package com.collegeregistration.student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
	
	Connection conn;
	
	public Statement getConnection(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Collegedatabase?characterEncoding=UTF-8&useSSL=false", "root", "root");
					return  conn.createStatement();
			}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	

	
	public void closeConnection() throws SQLException{
		 conn.close();
	}

}
