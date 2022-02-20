package com.ashokit.usermgmt.model;
  
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.Table;
  
@Entity
@Table(name="USER_TBL") 
public class UserModel {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="USER_ID") 
  private Integer userId;
  
  @Column(name="FIRST_NAME") 
  private String firstName;
  
  @Column(name="LAST_NAME") 
  private String lastName;
  
  @Column(name="EMAIL") 
  private String email;
  
  @Column(name="PHONE_NUMBER") 
  private String phoneNumber;
  
  @Column(name="DOB") 
  private String dob;
  
  @Column(name="GENDER") 
  private String gender;
  
  @Column(name="PASSWORD") 
  private String password;
  
  @Column(name="COUNTRY") 
  private String country;
  
  @Column(name="STATE") 
  private String state;
  
  @Column(name="CITY") 
  private String city;
  
  @Column(name="STATUS") 
  private String status;
  
  @Column(name="CREATED_DATE") 
  private String dateCreated;
  
  @Column(name="UPDATED_DATE") 
  private String dateUpdated;

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getDateCreated() {
	return dateCreated;
}

public void setDateCreated(String dateCreated) {
	this.dateCreated = dateCreated;
}

public String getDateUpdated() {
	return dateUpdated;
}

public void setDateUpdated(String dateUpdated) {
	this.dateUpdated = dateUpdated;
}
  
  
  }
 