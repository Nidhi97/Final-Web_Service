package com.PluralSight.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String id;
	private String UserName;
	private String Password;
	private String RetypePassword;
	private String PhoneNumber;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getPassword() {
		return Password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getRetypePassword() {
		return RetypePassword;
	}
	public void setRetypePassword(String RetypePassword) {
		this.RetypePassword = RetypePassword;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	
	
}
