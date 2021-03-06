package com.collegeregistration.student;

/**
 * Student Model
 *  
 * @author Priya
 *
 */
public class Model {
	int studId;
	String firstName;
	String MiddleName;
	String lastName;
	String emailaddress;
	String dateofBirth;
	int phoneNo;
	String enrolledyear;
	String gender;
	String status;
	String job_title;
	String internship_type;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public String getEnrolledyear() {
		return enrolledyear;
	}
	public void setEnrolledyear(String enrolledyear) {
		this.enrolledyear = enrolledyear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getInternship_type() {
		return internship_type;
	}
	public void setInternship_type(String internship_type) {
		this.internship_type = internship_type;
	}
	
	
}
