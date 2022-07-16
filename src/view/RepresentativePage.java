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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;

public class RepresentativePage {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem logout;
	private JLabel containerLabel;

	private JFrame RepresentativePage;
	private JButton resolved;
	private JButton outstanding;
	private JComboBox sericeList;
	private String SL[]
	        = { "", "No Internet Connection","Intermittent Internet Service","No Cable","Missing Channels", "No Dial Tone","No Mobile Signal" };
	
	
	private JButton services;
	private JLabel viewComplaintLabel;
	private JButton viewComplaints;
	private JButton liveChat;
	private ImageIcon logoBand;
	private JLabel logoContainer;
	
	

	public RepresentativePage() {
		
		initializeComponents();
	}
	
	
	public void initializeComponents(){
		

		
		/* Frame Attributes */
		RepresentativePage = new JFrame();
		RepresentativePage.getContentPane().setLayout(null);
		RepresentativePage.setResizable(false);
		RepresentativePage.setTitle("FLOW Represetaive Page");
		RepresentativePage.setVisible(true);
		
		
		//	Customized Colors
		Color customColor = new Color(255,184,28);
		Color custom_Color = new Color(0,132,202);
		RepresentativePage.getContentPane().setBackground(Color.white);
		RepresentativePage.setBounds(100,100, 580,534);
		
		RepresentativePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
		  	RepresentativePage.setJMenuBar(menuBar);
			
			services = new JButton("View Services");
			services.setBounds(70, 115, 160, 100);
			services.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			RepresentativePage.getContentPane().add(services);
			
			viewComplaintLabel = new JLabel("View Complaints");
			viewComplaintLabel.setBounds(350, 76, 160, 100);
			viewComplaintLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			RepresentativePage.getContentPane().add(viewComplaintLabel);
			
			containerLabel = new JLabel("");
			containerLabel.setBounds(290, 115, 270, 100);
			containerLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			containerLabel.setBorder(new LineBorder(Color.lightGray,2));
			RepresentativePage.getContentPane().add(containerLabel);
			
			resolved = new JButton("Resolved");
			resolved.setBounds(300, 140, 120, 40);
			resolved.setBackground(Color.GREEN);
			resolved.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			RepresentativePage.getContentPane().add(resolved);
			
			
			outstanding = new JButton("Oustanding ");
			outstanding.setBounds(430, 140, 120, 40);
			outstanding.setBackground(Color.RED);
			outstanding.setForeground(Color.ORANGE);
			//setBounds(int x-coordinate, int y-coordinate, int width, int height
			outstanding.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			RepresentativePage.getContentPane().add(outstanding);
			
			  sericeList = new JComboBox(SL);
			  sericeList.setBounds(370, 190, 100, 20);
			  sericeList.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			  sericeList.setBorder(new LineBorder(custom_Color,1));
			  RepresentativePage.getContentPane().add(sericeList);
		  
			
			viewComplaints = new JButton("Assign Tech");
			viewComplaints.setBounds(70, 240, 160, 100);
			viewComplaints.setFont(new Font("", Font.PLAIN |Font.BOLD, 12));
			RepresentativePage.getContentPane().add(viewComplaints);
			
			liveChat = new JButton("Live Chat");
			liveChat.setBounds(350, 240, 160, 100);
			liveChat.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			RepresentativePage.getContentPane().add(liveChat);
		  
		  
		  
		  
		JLabel welcome_greeting = new JLabel( Salutation +" | Welcome "
				, JLabel.CENTER );
		welcome_greeting.setBounds(200, 28, 580, 70);
		welcome_greeting.setFont(new Font("", Font.PLAIN |Font.BOLD |Font.ITALIC, 12));
		welcome_greeting.setForeground(Color.white);
		RepresentativePage.getContentPane().add(welcome_greeting);
		
		java.time.LocalDate.now();
		
		logoBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/LogoBand.png", "Logo");
		
		logoContainer = new JLabel("",logoBand, JLabel.CENTER );
		logoContainer.setBounds(40, 150, 500, 300);
		
		RepresentativePage.getContentPane().add(logoContainer);
		
		 
		ImageIcon Band = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/Band.png", "Logo");
		JLabel bandContainer = new JLabel("",Band, JLabel.CENTER );
		bandContainer.setBounds(0, 0, 580, 70);
		RepresentativePage.getContentPane().add(bandContainer);
		
		//ImageIcon legal = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
				JLabel legalNotice = new JLabel("© 2022 Flow. C&W Communications Plc. All rights reserved. Registered in England and Wales\r\n"
						, JLabel.CENTER );
				legalNotice.setBounds(10, 430, 580, 70);
				legalNotice.setFont(new Font("", Font.PLAIN |Font.BOLD, 8));
				legalNotice.setForeground(Color.white);
				RepresentativePage.getContentPane().add(legalNotice);
		
		ImageIcon baseBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
		JLabel baseBandContainer = new JLabel("",baseBand, JLabel.CENTER );
		baseBandContainer.setBounds(0, 430, 580, 70);
		
		RepresentativePage.getContentPane().add(baseBandContainer);
		
		services.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
				//System.out.println("clear button clicked");
				
				RepresentativePage.setVisible(false);
				RepresentativePage.dispose();
					
				new ViewServiceRequest();
				
			}
				
		});
		
		

		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
				//System.out.println("clear button clicked");
				
				RepresentativePage.setVisible(false);
				RepresentativePage.dispose();
					
				new LoginPage();
				
			}
				
		});
		
		liveChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
				//System.out.println("clear button clicked");
				
				RepresentativePage.setVisible(false);
				RepresentativePage.dispose();
					
				new LiveChat();
				
			}
				
		});
		
		
		
	}
	
	
}
