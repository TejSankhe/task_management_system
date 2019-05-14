package com.neu.tms.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.neu.tms.exception.StudentException;
import com.neu.tms.exception.TaskException;
import com.neu.tms.model.Student;
import com.neu.tms.model.Task;

public class TaskDao extends DAO{

	public boolean create(Task task)
            throws TaskException {
        try {
            begin();            
            getSession().save(task);     
            commit();
            close();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new TaskException("Exception while creating Task: " + e.getMessage());
        }
    }
	
	public Task getTask(long id)
            throws TaskException {
        try {
            begin();            
            Task result = getSession().get(Task.class, id);
            close();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new TaskException("Exception while creating Task: " + e.getMessage());
        }
    }
	
	public void update(Task task) throws TaskException {
		try {
			begin();
			getSession().update(task);
//			System.out.println(manager);
			commit();
			 close();
		} catch (HibernateException e) {
			rollback();
			throw new TaskException("Could not save the task", e);
		}
	}
}
