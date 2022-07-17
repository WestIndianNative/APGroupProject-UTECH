package controller;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import view.*;

public class Driver {

	public static void main(String[] args) {
		
		
	//new ReportIssue();
	//new CustomerPage();
		//new TechViewIssue();	
		//new RepresentativePage();
	//	new AssignTech();
		
		new TechnicianPage();
		
	}
	
	
	
	public static Session getCurrentSessionFromConfig() {
		  // SessionFactory in Hibernate 5 example
		  Configuration config = new Configuration();
		  config.configure();
		  // local SessionFactory bean created
		  SessionFactory sessionFactory = config.buildSessionFactory();
		  Session session = sessionFactory.getCurrentSession();
		  return session;
		}


		public static Session getCurrentSessionX() {
		  // Hibernate 5.4 SessionFactory example without XML
		  Map<String, String> settings = new HashMap<>();
		  settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
		  settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
		  settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/FLOWdb");
		  settings.put("hibernate.connection.username", "root");
		  settings.put("hibernate.connection.password", "");
		  settings.put("hibernate.current_session_context_class", "thread");
		  settings.put("hibernate.show_sql", "true");
		  settings.put("hibernate.format_sql", "true");

		  ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		                                    .applySettings(settings).build();

		  MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		  Metadata metadata = metadataSources.buildMetadata();
		  SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		  Session session = sessionFactory.getCurrentSession();
		  return session;
		}

}
