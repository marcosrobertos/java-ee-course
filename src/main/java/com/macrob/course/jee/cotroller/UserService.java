/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mroberto.course.jee.cotroller;

import com.mroberto.course.jee.model.User;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Cliente
 */
@Stateless
public class UserService {
    @Inject
    private EntityManager em;
    
    public void addUser(User user){
        em.persist(user);
    }
}
