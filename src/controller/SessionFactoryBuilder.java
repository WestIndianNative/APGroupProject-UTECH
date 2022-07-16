package controller;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SessionFactoryBuilder {

	 private static SessionFactory sessionFactory = null;
	//private static Session session;


	 public  static SessionFactory getSessionFactory () {
		 if(sessionFactory==null) {
			 try {
				 Configuration cfg = new Configuration();
			        cfg.configure("hibernate.cfg.xml");
			        sessionFactory = cfg.buildSessionFactory();
			   //     session =sessionFactory.openSession();

		/*	 sessionFactory =new
					 Configuration().configure("hibernate.cfg.xml").addAnnotatedClass
					 (Customer.class).buildSessionFactory();
			 
				*/	 
			 }catch(RuntimeException e) {System.out.println(e.toString());}
		 }
		 return sessionFactory;
	 }
	public static void closeSessionFactory () {
		 if(sessionFactory!=null) {
			 sessionFactory.close();
		 }
	}

}