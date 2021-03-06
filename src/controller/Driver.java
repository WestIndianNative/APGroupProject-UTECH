package controller;


 import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.customerService;
import view.ReportIssue;



public class Driver {
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	
	public static void main(String[] args) {
	
		/*logger.info("Customer Request  Success");
		customerService cust = new customerService(17,"Carrie","Lynch","Carrieann@gmail.com","8768361472","Damage","6/8/2022 "," "," "," "," ");
		System.out.println(cust.toString());
		 cust.create();
		System.out.print("Data successfully saved");
		logger.info("Customer Request  Success");*/
		
		//new ReportIssue();
		
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
		  settings.put("hibernate.connection.url",
		    "jdbc:mysql://localhost/customerservicedb");
		  settings.put("hibernate.connection.username", "root");
		  settings.put("hibernate.connection.password", "");
		  settings.put("hibernate.current_session_context_class", "thread");
		  settings.put("hibernate.show_sql", "true");
		  settings.put("hibernate.format_sql", "true");

		  ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		                                    .applySettings(settings).build();

		  MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		  // metadataSources.addAnnotatedClass(Player.class);
		  Metadata metadata = metadataSources.buildMetadata();

		  // here we build the SessionFactory (Hibernate 5.4)
		  SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		  Session session = sessionFactory.getCurrentSession();
		  return session;
		}

}
