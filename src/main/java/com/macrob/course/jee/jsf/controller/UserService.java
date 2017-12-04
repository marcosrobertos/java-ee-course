/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.macrob.course.jee.jsf.controller;

import com.macrob.course.jee.jsf.model.UserBean;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


public class UserService implements Serializable {
	@PersistenceContext
	private EntityManager em;
	@Resource
    private UserTransaction userTransaction;
	
	public UserService(){
	}

	public void addUser(UserBean user) {
		try {
			userTransaction.begin();
			em.persist(user);
			userTransaction.commit();
		} catch (NotSupportedException exception) {
			
		} catch (SystemException exception) {
		} catch (RollbackException exception) {
		} catch (HeuristicMixedException exception) {
		} catch (HeuristicRollbackException exception) {
		} catch (SecurityException exception) {
		} catch (IllegalStateException exception) {
		}
	}

}
