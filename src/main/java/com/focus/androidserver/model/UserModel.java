package com.focus.androidserver.model;

import java.util.Date;

public class UserModel {
	private int id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String userType;
	private Date createDate;
	private String loginId;
	private String password;
	private String sex;
	private int status;
	private int passwordReset;
	private int ownerId;
	private int testStatus;
	
	public UserModel() {
	}
	
	public UserModel(int id, String firstName, String lastName,
			Date birthdate, String userType, Date createDate, String loginId,
			String password, String sex, int status, int passwordReset,
			int ownerId, int testStatus) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.userType = userType;
		this.createDate = createDate;
		this.loginId = loginId;
		this.password = password;
		this.sex = sex;
		this.status = status;
		this.passwordReset = passwordReset;
		this.ownerId = ownerId;
		this.testStatus = testStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPasswordReset() {
		return passwordReset;
	}
	public void setPasswordReset(int passwordReset) {
		this.passwordReset = passwordReset;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(int testStatus) {
		this.testStatus = testStatus;
	}
	
}
