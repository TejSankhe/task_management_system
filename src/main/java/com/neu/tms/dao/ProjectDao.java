package com.neu.tms.dao;

import org.hibernate.HibernateException;

import com.neu.tms.exception.ProjectException;
import com.neu.tms.model.Project;



public class ProjectDao extends DAO{

	public boolean create(Project project)
            throws ProjectException {
        try {
            begin();            
            getSession().save(project);     
            commit();
            close();
            return true;
        } catch (HibernateException e) {
            rollback();
            throw new ProjectException("Exception while creating Project: " + e.getMessage());
        }
    }
}
