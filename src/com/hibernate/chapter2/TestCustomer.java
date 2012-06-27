package com.hibernate.chapter2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCustomer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Customer.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		{
			Customer tuan = new Customer();
//			tuan.setCustomerId(1);
			tuan.setCustomerName("Vo Hung Tuan");
			tuan.setCustomerAddress("125/5 Tran Binh Trong");
			tuan.setCreditScore(16);
			tuan.setRewardPoints(4);
			
			session.save(tuan);
		}
		session.getTransaction().commit();

	}

}
