package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.*;

public class CustomerPage {
	
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem logout;
	
	private JFrame CustomerPage;
	private JButton serviceRequest;
	private JButton reportIssue;
	private JButton viewIssue;
	private JButton liveChat;
	private ImageIcon logoBand;
	private JLabel logoContainer;
	
	

	public CustomerPage() {
		
		initializeComponents();
	}
	
	
	public void initializeComponents(){
		

		
		/* Frame Attributes */
		CustomerPage = new JFrame();
		CustomerPage.getContentPane().setLayout(null);
		CustomerPage.setResizable(false);
		CustomerPage.setTitle("FLOW Customer Page");
		CustomerPage.setVisible(true);
		
		
		//	Customized Colors
		Color customColor = new Color(255,184,28);
		Color custom_Color = new Color(0,132,202);
		CustomerPage.getContentPane().setBackground(Color.white);
		CustomerPage.setBounds(100,100, 580,534);
		
		CustomerPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY HH:mm");  
		  LocalDateTime now = LocalDateTime.now(); 
		
		  Calendar c = Calendar.getInstance();
		  int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		  String Salutation = "";
		  
		  if(timeOfDay >= 0 && timeOfDay < 12){
		     Salutation = "Good Morning";  
		  }else if(timeOfDay >= 12 && timeOfDay < 16){
			  Salutation = "Good Afternoon";
		  }else if(timeOfDay >= 16 && timeOfDay < 21){
			  Salutation = "Good Evening";
		  }else if(timeOfDay >= 21 && timeOfDay < 24){
			  Salutation ="Good Night";
		  }
		  
		  
			/* Frame Buttons */
		  	menuBar = new JMenuBar();
		  	menu = new JMenu("File");
		  	logout = new JMenuItem("Log Out");
		  	menu.add(logout);
		  	menuBar.add(menu);
		  			 
		  	
		  //	menuBar.setBounds(400, 60, 50, 30);
		  	menuBar.setFont(new Font("", Font.PLAIN |Font.BOLD, 9));
			//CustomerPage.getContentPane().add(menuBar);
			CustomerPage.setJMenuBar(menuBar);
		  	
		  	
			serviceRequest = new JButton("Request A Service");
			serviceRequest.setBounds(100, 120, 160, 100);
			serviceRequest.setFont(new Font("", Font.PLAIN |Font.BOLD, 12));
			CustomerPage.getContentPane().add(serviceRequest);
			
			reportIssue = new JButton("Report A Issue");
			reportIssue.setBounds(300, 120, 160, 100);
			reportIssue.setFont(new Font("", Font.PLAIN |Font.BOLD, 12));
			CustomerPage.getContentPane().add(reportIssue);
		  
			
			viewIssue = new JButton("View Existing Issues");
			viewIssue.setBounds(100, 240, 160, 100);
			viewIssue.setFont(new Font("", Font.PLAIN |Font.BOLD, 12));
			CustomerPage.getContentPane().add(viewIssue);
			
			liveChat = new JButton("Live Chat");
			liveChat.setBounds(300, 240, 160, 100);
			liveChat.setFont(new Font("", Font.PLAIN |Font.BOLD, 12));
			CustomerPage.getContentPane().add(liveChat);
		  
		  
		  
		  
		JLabel welcome_greeting = new JLabel( Salutation +" | Welcome "
				, JLabel.CENTER );
		welcome_greeting.setBounds(200, 28, 580, 70);
		welcome_greeting.setFont(new Font("", Font.PLAIN |Font.BOLD |Font.ITALIC, 12));
		welcome_greeting.setForeground(Color.white);
		CustomerPage.getContentPane().add(welcome_greeting);
		
		java.time.LocalDate.now();
		
		logoBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/LogoBand.png", "Logo");
		
		logoContainer = new JLabel("",logoBand, JLabel.CENTER );
		logoContainer.setBounds(40, 150, 500, 300);
		
		CustomerPage.getContentPane().add(logoContainer);
		
		 
		ImageIcon Band = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/Band.png", "Logo");
		JLabel bandContainer = new JLabel("",Band, JLabel.CENTER );
		bandContainer.setBounds(0, 0, 580, 70);
		CustomerPage.getContentPane().add(bandContainer);
		
		//ImageIcon legal = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
				JLabel legalNotice = new JLabel("© 2022 Flow. C&W Communications Plc. All rights reserved. Registered in England and Wales\r\n"
						, JLabel.CENTER );
				legalNotice.setBounds(10, 430, 580, 70);
				legalNotice.setFont(new Font("", Font.PLAIN |Font.BOLD, 8));
				legalNotice.setForeground(Color.white);
				CustomerPage.getContentPane().add(legalNotice);
		
		ImageIcon baseBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
		JLabel baseBandContainer = new JLabel("",baseBand, JLabel.CENTER );
		baseBandContainer.setBounds(0, 430, 580, 70);
		
		CustomerPage.getContentPane().add(baseBandContainer);
		
		
		
		serviceRequest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
				//System.out.println("clear button clicked");
				new Services();
				CustomerPage.setVisible(false);
				CustomerPage.dispose();
					
				
				
			}
				
		});
		
		
		reportIssue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
				//System.out.println("clear button clicked");
				new ReportIssue();
				CustomerPage.setVisible(false);
				CustomerPage.dispose();
					
				
				
			}
				
		});
		
		viewIssue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
				System.out.println("clear button clicked");
				
				CustomerPage.setVisible(false);
				CustomerPage.dispose();
				new ExistingIssues();
				
				
			}
				
		});
		
		

		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
				//System.out.println("clear button clicked");
				
				CustomerPage.setVisible(false);
				CustomerPage.dispose();
					
				new LoginPage();
				
			}
				
		});
		

		liveChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
				//System.out.println("clear button clicked");
				
				CustomerPage.setVisible(false);
				CustomerPage.dispose();
					
				new LiveChat();
				
			}
				
		});
		
		
	}
	
	

}
