package com.macrob.course.jee.jsf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * @author Roberto
 *
 */
@ManagedBean
@SessionScoped
public class UserBean {

	protected String firstName;
	protected String lastName;
	protected Date dob;
	protected String sex;
	protected String email;
	protected String serviceLevel = "medium";
	private List<UserInfo> userInfoList;
	private UserInfo selectedUser;
	
	public UserBean(){
		System.out.println("creating a UserBean");
		userInfoList = new ArrayList<UserInfo>();
	}

	public String getFirstName() {
		System.out.println("getFirstName");
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("setFirstName");
		this.firstName = firstName;
	}

	public String getLastName() {
		System.out.println("getLastName");
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println("setLastName");
		this.lastName = lastName;
	}

	public Date getDob() {
		System.out.println("getDob");
		return dob;
	}

	public void setDob(Date dob) {
		System.out.println("setDob");
		this.dob = dob;
	}

	public String getSex() {
		System.out.println("getSex");
		return sex;
	}

	public void setSex(String sex) {
		System.out.println("setSex");
		this.sex = sex;
	}

	public String getEmail() {
		System.out.println("getEmail");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("setEmail");
		this.email = email;
	}

	public String getServiceLevel() {
		System.out.println("getServiceLevel");
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		System.out.println("setServiceLevel");
		this.serviceLevel = serviceLevel;
	}

	public void validateEmail(FacesContext context,
			  UIComponent toValidate,
			  Object value) throws ValidatorException {
		System.out.println("validateEmail");
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Invalid email address");
			throw new ValidatorException(message);
		}
	}
	
	public String addNewUser(){
		System.out.println("prepare controller for new User");
		cleanUserProperties();
		return "register";
	}

	private void cleanUserProperties() {
		firstName = "";
		lastName = "";
		dob = null;
		sex = "";
		email = "";
}
	public String addConfirmedUser() {
		System.out.println("addConfirmUser");
		boolean added = true; // actual application may fail to add user
		FacesMessage doneMessage = null;
		String outcome = null;
		if (added) {
			userInfoList.add(
					  new UserInfo(
								 userInfoList.size() + 1,
								 lastName,
								 lastName,
								 firstName,
								 lastName,
								 email,
								 "",
								 dob));
			doneMessage = new FacesMessage("Successfully added new Customer");
			outcome = "done";
		} else {
			doneMessage = new FacesMessage("Failed to add new Customer");
			outcome = "register";
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
	}
	
	public List<UserInfo> getUserInfoList(){
		return userInfoList;
	}
	
	public void metodo1(){
		System.out.println("metodo1");
	}
	
	public void metodo2(){
		System.out.println("metodo2");
	}

	/**
	 * @return the selectedUser
	 */
	public UserInfo getSelectedUser() {
		return selectedUser;
	}

	/**
	 * @param selectedUser the selectedUser to set
	 */
	public void setSelectedUser(UserInfo selectedUser) {
		this.selectedUser = selectedUser;
	}
}
