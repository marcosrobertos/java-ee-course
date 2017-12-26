package com.macrob.course.jee.jsf.controller;

import com.macrob.course.jee.jsf.model.UserInfo;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 * @author Roberto
 *
 */
@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable {
    private static final Logger logger = Logger.getLogger(UserManagedBean.class);
	 
	 @Inject
	 private UserService userService;
	 //attributes for acces from jsf need mandatory getter and setter 
    private Integer id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String sex;
    private Date dob;
	 private UserInfo loginUser = new UserInfo();

    public UserManagedBean() {
        logger.debug("creating a userbean object");
    }

    public UserManagedBean(Integer id, String userName, String password, String firstName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
    }

    public UserManagedBean(Integer id, String userName, String password, String firstName,
            String lastName, String email, String phone, Date dob) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password="
                + password + ", firstName=" + firstName + ", lastName="
                + lastName + ", email=" + email + ", phone=" + phone + ", dob="
                + dob + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    protected String serviceLevel = "medium";

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public void validateEmail(FacesContext context,
            UIComponent toValidate,
            Object value) throws ValidatorException {
        String emailStr = (String) value;
        if (-1 == emailStr.indexOf("@")) {
            FacesMessage message = new FacesMessage("Invalid email address");
            throw new ValidatorException(message);
        }
    }

    public String addConfirmedUser() {
        boolean added = true; // actual application may fail to add user
		  userService.addUser(getLoginUser());
		  
        FacesMessage doneMessage = null;
        String outcome = null;
        if (added) {
            doneMessage = new FacesMessage("Successfully added new user");
            outcome = "done";
        } else {
            doneMessage = new FacesMessage("Failed to add new user");
            outcome = "register";
        }
        FacesContext.getCurrentInstance().addMessage(null, doneMessage);
        return outcome;
    }

	/**
	 * @return the loginUser
	 */
	public UserInfo getLoginUser() {
		return loginUser;
	}

	/**
	 * @param loginUser the loginUser to set
	 */
	public void setLoginUser(UserInfo loginUser) {
		this.loginUser = loginUser;
	}

}
