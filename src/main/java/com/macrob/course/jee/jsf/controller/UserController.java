package com.macrob.course.jee.jsf.controller;

import com.macrob.course.jee.jsf.model.UserInfo;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.log4j.Logger;

/**
 * @author Siva
 *
 */
@Named
@SessionScoped
public class UserController implements Serializable {
    
    @Inject
    private UserService userService;
    
    private static final Logger LOGGER = Logger.getLogger(UserController.class);
    
    private UserInfo loginUser = new UserInfo();
    private UserInfo registrationUser = new UserInfo();
    private String loginStatus;
    
    public UserController() {
		 LOGGER.debug("creating an instance of UserController");
//		 userService = new UserService();
    }
    
    public UserInfo getLoginUser() {
        return loginUser;
    }
    
    public void setLoginUser(UserInfo loginUser) {
        this.loginUser = loginUser;
    }
    
    public UserInfo getRegistrationUser() {
        return registrationUser;
    }
    
    public void setRegistrationUser(UserInfo registrationUser) {
        this.registrationUser = registrationUser;
    }

    public String getLoginStatus() {
        return loginStatus;
    }
    
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
    
    public String login() {
        boolean validCredentials = "admin".equals(loginUser.getUserName()) && "admin".equals(loginUser.getPassword());
        this.loginStatus = validCredentials ? "Login Successful" : "Login failed";
        return null;
    }
    
    public String register() {
        LOGGER.info("Registering User :" + this.registrationUser);
        String msg = "User Registered Successfully";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
        return null;        
    }
    
    public String doRegister() {
        LOGGER.info("Registering User :" + this.registrationUser);
        String msg = "User Registered Successfully";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        return "registrationWithVal.jsf?faces-redirect=true";        
    }
    
    public void checkUserNamesExists() {
        String userName = this.registrationUser.getUserName();
        if ("admin".equals(userName) || "test".equals(userName)) {
            String msg = "UserName [" + userName + "] already in use.";
            FacesContext.getCurrentInstance().addMessage("registrationForm:userName",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
    }
    
    public String updateUser() {
        LOGGER.info("Updating User Id: " + this.loginUser.getId());
        String msg = "User updated Successfully";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
        return "userDetails.jsf";
    }
    
    public String deleteUser() {
        LOGGER.info("deleting User Id: " + this.loginUser.getId());
        String msg = "User deleted Successfully";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
        return "userDetails.jsf";
    }
    
    public void checkEmailExists() {
        String email = this.registrationUser.getEmail();
        if ("admin@gmail.com".equals(email) || "test@gmail.com".equals(email)) {
            String msg = "Email [" + email + "] already in use.";
            FacesContext.getCurrentInstance().addMessage("registrationForm:email",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        } else {
            String msg = "Email [" + email + "] is available.";
            FacesContext.getCurrentInstance().addMessage("registrationForm:email",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
        }
    }
    
    public void saveUser() {
//        userService.addUser(registrationUser);
    }
	 
	public String addConfirmedUser() {
		boolean added = true; // actual application may fail to add user
		userService.addUser(loginUser);
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
}
