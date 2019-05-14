package com.neu.tms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Example;

import com.neu.tms.exception.UserException;
import com.neu.tms.model.User;

public class UserDao extends DAO{

	public boolean create(User user)
            throws UserException {
        try {
            begin();            
            getSession().save(user);     
            commit();
            close();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public User getUser(String emailId)
            throws UserException {
        try {
            begin();   
            User exampleUser = new User();
            exampleUser.setEmailId(emailId);
            Criteria criteria = getSession().createCriteria(User.class);
            criteria.add(Example.create(exampleUser));
            List<User> user = criteria.list();
            if(user.size()==0)
            	return null;
            User u = user.get(0);
            close();
            return u;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while getting user: " + e.getMessage());
        }
    }
	
	public User authenticateUser(String emailId, String password)
            throws UserException {
        try {
            begin();   
            User exampleUser = new User();
            exampleUser.setEmailId(emailId);
            exampleUser.setPassword(password);
            Criteria criteria = getSession().createCriteria(User.class);
            criteria.add(Example.create(exampleUser));
            List<User> user = criteria.list();
            if(user.size()==0)
            	return null;
            User u = user.get(0);
            close();
            return u;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while getting user: " + e.getMessage());
        }
    }
}
