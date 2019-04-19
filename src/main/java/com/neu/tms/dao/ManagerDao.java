package com.neu.tms.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.neu.tms.exception.ManagerException;
import com.neu.tms.model.Manager;
import com.neu.tms.model.Task;



public class ManagerDao extends DAO{

	public List<Manager> getAllManager()
            throws ManagerException {
        try {
            begin();            
            Query query = getSession().getNamedQuery("Manager.getAllManager");
            List<Manager> managers = query.list();
            close();
            return managers;
        } catch (HibernateException e) {
            rollback();
            throw new ManagerException("Exception while getting all managers data: " + e.getMessage());
        }
    }
	
	public List<String> getAllManagerEmailAddress()
            throws ManagerException {
        try {
            begin();            
            Query query = getSession().getNamedQuery("Manager.getAllManagerEmailAddress");
            List<String> managers = query.list();
            close();
            return managers;
        } catch (HibernateException e) {
            rollback();
            throw new ManagerException("Exception while getting all managers email Address: " + e.getMessage());
        }
    }
	
	public Manager getManagerByEmailAddress(String emailAddress)       
			throws ManagerException {
        try {
            begin();   
            Criteria criteria = getSession().createCriteria(Manager.class);
            criteria.add(Restrictions.eq("emailId", emailAddress));
            List<Manager> manager = criteria.list();
            close();
            return manager.get(0);		
	}
        catch (HibernateException e) {
            rollback();
            throw new ManagerException("Exception while getting managers with given email Address: " + e.getMessage());
        }
}
	public void update(Manager manager) throws ManagerException {
		try {
			begin();
			getSession().update(manager);
//			System.out.println(manager);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new ManagerException("Could not save the manager", e);
		}
	}
	
	public Set<Task> getAllTasksOfManager(String emailId)
            throws ManagerException {
        try {
        	begin();   
            Criteria criteria = getSession().createCriteria(Manager.class);
            criteria.add(Restrictions.eq("emailId", emailId));
            List<Manager> manager = criteria.list();
            Set<Task> tasks = manager.get(0).getTasks();
            close();
            return tasks;
        } catch (HibernateException e) {
            rollback();
            throw new ManagerException("Exception while getting tasks of manager: " + e.getMessage());
        }
    }
	
}
