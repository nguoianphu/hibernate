package com.hibernate.chapter6.one2onemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		{
			PersonDetail tuanDetail = new  PersonDetail();
			tuanDetail.setZipCode("1234");
			tuanDetail.setJob("Engineer");
			tuanDetail.setIncome(7000000);
			
			Person tuan = new Person();
			tuan.setPersonName("Tuan Vo");
			
			tuan.setPersonDetail(tuanDetail);
			
			session.save(tuan);
			// no need save(tuanDetail) if we set cascadeType
			
		}
		
		session.getTransaction().commit();

	}

}
