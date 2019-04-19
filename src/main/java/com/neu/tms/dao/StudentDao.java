package com.neu.tms.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.neu.tms.exception.StudentException;
import com.neu.tms.model.Student;
import com.neu.tms.model.Task;

public class StudentDao extends DAO{
	
	public Student getStudenrByEmailAddress(String emailAddress)       
			throws StudentException {
        try {
            begin();   
            Criteria criteria = getSession().createCriteria(Student.class);
            criteria.add(Restrictions.eq("emailId", emailAddress));
            List<Student> students = criteria.list();
            close();
            return students.get(0);		
	}
        catch (HibernateException e) {
            rollback();
            throw new StudentException("Exception while getting students with given email Address: " + e.getMessage());
        }
}
	public void update(Student student) throws StudentException {
		try {
			begin();
			getSession().update(student);
//			System.out.println(manager);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new StudentException("Could not save the student", e);
		}
	}
	
	public Set<Task> getAllTasksOfStudent(String emailId)
            throws StudentException {
        try {
        	begin();   
            Criteria criteria = getSession().createCriteria(Student.class);
            criteria.add(Restrictions.eq("emailId", emailId));
            List<Student> student = criteria.list();
            Set<Task> tasks = student.get(0).getTasksAssigned();
            close();
            return tasks;
        } catch (HibernateException e) {
            rollback();
            throw new StudentException("Exception while getting tasks of students: " + e.getMessage());
        }
    }
}
