package com.hibernate.chapter4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Account.class);
		config.configure("Hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session sesion = factory.getCurrentSession();
		sesion.beginTransaction();
		
		{
			CompoundKey key1 = new CompoundKey(01, 2002);
			Account tuan = new Account();
			tuan.setAccountBlance(10000);
			tuan.setCompoundKey(key1);
			
			CompoundKey key2 = new CompoundKey(02, 2001);
			Account hung = new Account();
			hung.setAccountBlance(99999999);
			hung.setCompoundKey(key2);
			
			sesion.save(tuan);
			sesion.save(hung);
			
		}
		sesion.getTransaction().commit();

	}

}
