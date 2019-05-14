package com.neu.tms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.tms.exception.ProjectException;
import com.neu.tms.model.Project;
import com.neu.tms.model.UserRequest;



public class RequestDao extends DAO{

	public boolean create(UserRequest requestForProjectAssignment)
            throws Exception {
        try {
            begin();            
            getSession().save(requestForProjectAssignment);     
            commit();
            close();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating RequestForProjectAssignment: " + e.getMessage());
        }
    }
	
	public List<UserRequest> getRequests() throws Exception{
		try {
            begin();            
            Query query = getSession().createQuery("from UserRequest");  
            List<UserRequest> result = query.list();
            close();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating requests: " + e.getMessage());
        }
	}
	
	public boolean deleteRequest(UserRequest userRequest) throws Exception{
		try {
            begin();            
            getSession().delete(userRequest); 
            commit();
            close();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating requests: " + e.getMessage());
        }
	}
	
	public UserRequest getUserRequestById(long id) throws Exception{
		try {
            begin();            
            UserRequest userRequest = getSession().get(UserRequest.class, id); 
            close();
            return userRequest;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating requests: " + e.getMessage());
        }
	}
}
