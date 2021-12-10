//POJO class for User
package com.service.serviceDentalDatabase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity                     //Database Objects
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	private String firstName;
	private String lastName;
	private int age;
	private String password;
	private int otpOfUser;

	public Registration() {
		super();
	}
	//Parameterized Constructor
	public Registration(int id, String emailId, String firstName, String lastName, String password,int otpOfUser,int age) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.otpOfUser=otpOfUser;
		this.age=age;

	}
	
	//Getter and Setter Method
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getOtpOfUser() {
		return otpOfUser;
	}
	public void setOtpOfUser(int otpOfUser) {
		this.otpOfUser = otpOfUser;
	}
	
}