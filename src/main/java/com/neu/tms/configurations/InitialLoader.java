package com.neu.tms.configurations;

import com.neu.tms.dao.ManagerDao;
import com.neu.tms.dao.ProjectDao;
import com.neu.tms.dao.TaskDao;
import com.neu.tms.dao.UserDao;
import com.neu.tms.exception.ProjectException;
import com.neu.tms.exception.UserException;
import com.neu.tms.model.Admin;
import com.neu.tms.model.Manager;
import com.neu.tms.model.Project;
import com.neu.tms.model.Student;
import com.neu.tms.model.Task;
import com.neu.tms.model.User;

public class InitialLoader {
	
	public static void main(String[] args) {
		try {
//			createUsers();
//			dummyData();
//			ManagerDao managerDao = new ManagerDao();
//			
//			System.out.println(managerDao.getAllManagerEmailAddress());
//			Manager manager = managerDao.getManagerByEmailAddress("manager1@husky.neu.edu");
//			Project project = new Project("project"+5,"project"+5 +" is the application development project", null, null, null);
//			manager.setProject(project);
//			managerDao.update(manager);
//			System.out.println(managerDao.getManagerByEmailAddress("manager1@husky.neu.edu"));
			ManagerDao managerDao = new ManagerDao();
//			Manager manager=managerDao.getManagerByEmailAddress("manager1@husky.neu.edu");
			
//			Task task1 = new Task("Task2", "SQL setup", null, TaskSeverity.HIGH, TaskStatus.NOTSTARTED,null,null,manager);
//			TaskDao taskDao = new TaskDao();
//			taskDao.create(task1);
//			UserDao userDao = new UserDao();
			//ManagerDao managerDao = new ManagerDao();
//			User u = userDao.getUser("manager1@husky.neu.edu");
//			if(u instanceof Manager) {
//				
//			}
			managerDao.getManagerByEmailAddress("manager1@husky.neu.edu");
//			managerDao.getAllTasksOfManager("manager1@husky.neu.edu");
			
			System.out.println(managerDao.getAllTasksOfManager("manager1@husky.neu.edu").size()+"nnn");
//			System.out.println(u);
//			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void createUsers() throws UserException {
		UserDao userDao = new UserDao();
		Admin admin = new Admin("admin@husky.neu.edu","admin");
			userDao.create(admin);
			for(int i=1;i<5;i++) {
				Manager manager = new Manager("manager"+i+"@husky.neu.edu","manager"+i, null, null, null);
				userDao.create(manager);
			}
			for(int i=1;i<5;i++) {
				Student student = new Student("student"+i+"@husky.neu.edu","student"+i, null, null, null);
				userDao.create(student);
			}
	}
	
	public static void dummyData() throws Exception {
		ProjectDao projectDao = new ProjectDao();
		for(int i=1;i<5;i++) {
			Project project = new Project("project"+i,"project"+i +" is the application development project", null, null, null);
			projectDao.create(project);
		}
	}

}
