package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;

public class TechnicianPage implements ActionListener {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem logout;
	private JFrame TechPage;
	private JButton viewComplaints;
	private JButton liveChat;
	private ImageIcon logoBand;
	private JLabel logoContainer;
	private JToggleButton Availabiltybutton; 
	
	
	

	public TechnicianPage() {
		
		initializeComponents();
	}
	
	
	public void initializeComponents(){
		

		
			/* Frame Attributes */
			TechPage = new JFrame();
			TechPage.getContentPane().setLayout(null);
			TechPage.setResizable(false);
			TechPage.setTitle("FLOW Technician Page");
			TechPage.setVisible(true);
		
			//	Customized Colors
			Color customColor = new Color(255,184,28);
			Color custom_Color = new Color(0,132,202);
			TechPage.getContentPane().setBackground(Color.white);
			TechPage.setBounds(100,100, 580,534);
			TechPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		  	menuBar.setFont(new Font("", Font.PLAIN |Font.BOLD, 9));
		  	TechPage.setJMenuBar(menuBar);
		  
		  	Availabiltybutton = new JToggleButton("OFF");
		  	Availabiltybutton.setBounds(100, 120, 160, 100);
		  	Color UnavailableRed = new Color(255,33,33);
		  	Availabiltybutton.setBackground(UnavailableRed);
			Availabiltybutton.setForeground(Color.white);
		  	Availabiltybutton.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  	//TechPage.getContentPane().add(Availabiltybutton);
		  	Availabiltybutton.addActionListener(this);
			
			viewComplaints = new JButton("View Issues");
			viewComplaints.setBounds(100, 150, 160, 100);
			viewComplaints.setFont(new Font("", Font.PLAIN |Font.BOLD, 12));
			TechPage.getContentPane().add(viewComplaints);
			
			liveChat = new JButton("Live Chat");
			liveChat.setBounds(300, 150, 160, 100);
			liveChat.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			TechPage.getContentPane().add(liveChat);
		  
		  
		  
		  
			JLabel welcome_greeting = new JLabel( Salutation +" | Welcome "
				, JLabel.CENTER );
			welcome_greeting.setBounds(200, 28, 580, 70);
			welcome_greeting.setFont(new Font("", Font.PLAIN |Font.BOLD |Font.ITALIC, 12));
			welcome_greeting.setForeground(Color.white);
			TechPage.getContentPane().add(welcome_greeting);
		
			java.time.LocalDate.now();
		
			logoBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/LogoBand.png", "Logo");
			logoContainer = new JLabel("",logoBand, JLabel.CENTER );
			logoContainer.setBounds(40, 150, 500, 300);
			TechPage.getContentPane().add(logoContainer);
		
		 
			ImageIcon Band = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/Band.png", "Logo");
			JLabel bandContainer = new JLabel("",Band, JLabel.CENTER );
			bandContainer.setBounds(0, 0, 580, 70);
			TechPage.getContentPane().add(bandContainer);
		
			//ImageIcon legal = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
			JLabel legalNotice = new JLabel("© 2022 Flow. C&W Communications Plc. All rights reserved. Registered in England and Wales\r\n"
			, JLabel.CENTER );
			legalNotice.setBounds(10, 430, 580, 70);
			legalNotice.setFont(new Font("", Font.PLAIN |Font.BOLD, 8));
			legalNotice.setForeground(Color.white);
			TechPage.getContentPane().add(legalNotice);
		
			ImageIcon baseBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
			JLabel baseBandContainer = new JLabel("",baseBand, JLabel.CENTER );
			baseBandContainer.setBounds(0, 430, 580, 70);
			TechPage.getContentPane().add(baseBandContainer);
			
	}
	
			public void actionPerformed(ActionEvent e) {
		
		
				if (Availabiltybutton.isSelected()) {
					Availabiltybutton.setText("ON");
					Color AvailabiltyGreen = new Color(122,196,92);
					Availabiltybutton.setBackground(Color.GREEN);
			
				}
				else {

					Availabiltybutton.setText("OFF");
					Color UnavailableRed = new Color(255,33,33);
					Availabiltybutton.setBackground(UnavailableRed);
					Availabiltybutton.setForeground(Color.white);
					Availabiltybutton.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
				}
		  
				logout.addActionListener(new ActionListener() {
			
					@Override
					public void actionPerformed(ActionEvent event) {
						//	logger.info("clear button selected");
	
						TechPage.setVisible(false);
						TechPage.dispose();
				
						new LoginPage();
				
			}
				
		});

	}

}
