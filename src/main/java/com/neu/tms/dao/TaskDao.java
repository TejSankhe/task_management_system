package com.neu.tms.dao;

import org.hibernate.HibernateException;

import com.neu.tms.exception.TaskException;
import com.neu.tms.model.Task;

public class TaskDao extends DAO{

	public boolean create(Task task)
            throws TaskException {
        try {
            begin();            
            getSession().save(task);     
            commit();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new TaskException("Exception while creating Task: " + e.getMessage());
        }
    }
}
