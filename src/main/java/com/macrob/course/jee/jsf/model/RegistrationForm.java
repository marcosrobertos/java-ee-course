/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macrob.course.jee.jsf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistrationForm {

    private Integer userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date dob;
    private String gender;
    private List<String> interests = new ArrayList<String>();
    private boolean subscribeToNewsLetter;

    //setters/getters
    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the interests
     */
    public List<String> getInterests() {
        return interests;
    }

    /**
     * @param interests the interests to set
     */
    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    /**
     * @return the subscribeToNewsLetter
     */
    public boolean isSubscribeToNewsLetter() {
        return subscribeToNewsLetter;
    }

    /**
     * @param subscribeToNewsLetter the subscribeToNewsLetter to set
     */
    public void setSubscribeToNewsLetter(boolean subscribeToNewsLetter) {
        this.subscribeToNewsLetter = subscribeToNewsLetter;
    }

}
