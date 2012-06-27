package com.hibernate.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestSchool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(School.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		{
			SchoolDetail tuanDetail = new SchoolDetail();
			tuanDetail.setPublicSchool(true);
			tuanDetail.setSchoolAddress("125/5 Dang Van Ngu");
			tuanDetail.setStudentCount(999);
			
			School tuan = new School();
			tuan.setSchoolName("DH Vo Hung Tuan");
			tuan.setSchoolDetail(tuanDetail);
			
			session.save(tuan);
		}
		session.getTransaction().commit();


	}

}
