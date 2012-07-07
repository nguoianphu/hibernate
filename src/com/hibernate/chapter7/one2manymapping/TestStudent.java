package com.hibernate.chapter7.one2manymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestStudent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(College.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		{
			College collegeCanTho = new College();
			collegeCanTho.setCollegeName("Can Tho university");
			
			Student tuan = new Student();
			tuan.setStudentName("Vo Hung Tuan");
			tuan.setCollege(collegeCanTho);
			
			Student hung = new Student();
			hung.setStudentName("Nguyen Van Hung");
			hung.setCollege(collegeCanTho);
			
			session.save(collegeCanTho);
			session.save(tuan);
			session.save(hung);
		}
		
		session.getTransaction().commit();

	

	}

}
