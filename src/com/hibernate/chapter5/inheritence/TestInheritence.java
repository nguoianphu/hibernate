package com.hibernate.chapter5.inheritence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestInheritence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Module.class);
		config.addAnnotatedClass(Task.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		{
			Project project = new Project();
			project.setProjectName("Hibernate");
			
			Module module = new Module();
			module.setProjectName("Spring");
			module.setModuleName("AOP");
			
			Task task = new Task();
			task.setProjectName("Java");
			task.setModuleName("Learn");
			task.setTaskName("Try");
			
			session.save(project);
			session.save(module);
			session.save(task);
			
		}
		session.getTransaction().commit();

	}

}
