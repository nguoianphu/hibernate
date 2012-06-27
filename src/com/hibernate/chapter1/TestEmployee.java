package com.hibernate.chapter1;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Employee.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		{
			
			Employee tuan = new Employee();
//			tuan.setEmpId(001);
			tuan.setEmpName("Vo Hung Tuan");
			tuan.setEmpEmailAdress("vohungtuan@gmail.com");
			tuan.setEmpPassword("123456");
			tuan.setPernament(true);
			tuan.setEmpJoinDate(new GregorianCalendar(2011, 12, 25));
			tuan.setEmpLoginTime(Date.valueOf("2012-06-24"));
			
			session.save(tuan);
		
		}
		{
			
			Employee alex = new Employee();
//			alex.setEmpId(001);
			alex.setEmpName("Vo Hung alex");
			alex.setEmpEmailAdress("vohungalex@gmail.com");
			alex.setEmpPassword("123456");
			alex.setPernament(true);
			alex.setEmpJoinDate(new GregorianCalendar(2011, 12, 25));
			alex.setEmpLoginTime(Date.valueOf("2012-06-24"));
			
			session.save(alex);
		
		}
		session.getTransaction().commit();

	}

}
