package controller;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class SessionFactoryBuilder {

	 private static SessionFactory sessionFactory = null;

		
	 public  static SessionFactory getSessionFactory () {
		
		 if(sessionFactory==null) {
			 try {
				 Configuration cfg = new Configuration();
			        cfg.configure("hibernate.cfg.xml");
			        sessionFactory = cfg.buildSessionFactory();
			        //session = sessionFactory.openSession();
					/*
					 * sessionFactory =new
					 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass
					 * (Student.class).buildSessionFactory();
					 */
					 
			 }catch(RuntimeException e) 
			 {System.out.println(e.toString());}
		 }
		 return sessionFactory;
	 }
	 
	 
	public static void closeSessionFactory () {
		 if(sessionFactory!=null) {
			 sessionFactory.close();
		 }
	}


}
