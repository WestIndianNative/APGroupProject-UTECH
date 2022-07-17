package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.Customer;
import model.ServiceIssue;
import model.ServiceRequest;

public class TechnicianPage extends JPanel {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem logout;
	private JFrame Page;
	private JButton viewComplaints;
	private JButton liveChat;
	private ImageIcon logoBand;
	private JLabel logoContainer;
	private JScrollPane jsp;
	private JTable table;
	private JPanel TableContainer;
	
	
	

	public TechnicianPage() {
		
		initializeComponents();
	}
	
	
	public void initializeComponents(){
		

		
			/* Frame Attributes */
		 Page = new JFrame();
		 Page.getContentPane().setLayout(null);
		 Page.setResizable(false);
		 Page.setTitle("FLOW Technician Page");
			 Page.setVisible(true);
		
			//	Customized Colors
			Color customColor = new Color(255,184,28);
			Color custom_Color = new Color(0,132,202);
			 Page.getContentPane().setBackground(Color.white);
			 Page.setBounds(100,100, 580,534);
			 Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		  	Page.setJMenuBar(menuBar);
		  
			
			viewComplaints = new JButton("View Issues");
			viewComplaints.setBounds(100, 150, 160, 100);
			viewComplaints.setFont(new Font("", Font.PLAIN |Font.BOLD, 12));
			Page.getContentPane().add(viewComplaints);
			
			liveChat = new JButton("Live Chat");
			liveChat.setBounds(300, 150, 160, 100);
			liveChat.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			Page.getContentPane().add(liveChat);
		  
		  
		  
		  
			JLabel welcome_greeting = new JLabel( Salutation +" | Welcome "
				, JLabel.CENTER );
			welcome_greeting.setBounds(200, 28, 580, 70);
			welcome_greeting.setFont(new Font("", Font.PLAIN |Font.BOLD |Font.ITALIC, 12));
			welcome_greeting.setForeground(Color.white);
			Page.getContentPane().add(welcome_greeting);
		
			java.time.LocalDate.now();
		
			logoBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/LogoBand.png", "Logo");
			logoContainer = new JLabel("",logoBand, JLabel.CENTER );
			logoContainer.setBounds(40, 150, 500, 300);
			Page.getContentPane().add(logoContainer);
		
		 
			ImageIcon Band = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/Band.png", "Logo");
			JLabel bandContainer = new JLabel("",Band, JLabel.CENTER );
			bandContainer.setBounds(0, 0, 580, 70);
			Page.getContentPane().add(bandContainer);
		
			//ImageIcon legal = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
			JLabel legalNotice = new JLabel("© 2022 Flow. C&W Communications Plc. All rights reserved. Registered in England and Wales\r\n"
			, JLabel.CENTER );
			legalNotice.setBounds(10, 430, 580, 70);
			legalNotice.setFont(new Font("", Font.PLAIN |Font.BOLD, 8));
			legalNotice.setForeground(Color.white);
			Page.getContentPane().add(legalNotice);
		
			ImageIcon baseBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
			JLabel baseBandContainer = new JLabel("",baseBand, JLabel.CENTER );
			baseBandContainer.setBounds(0, 430, 580, 70);
			Page.getContentPane().add(baseBandContainer);
			

	
	
		  
				logout.addActionListener(new ActionListener() {
			
					@Override
					public void actionPerformed(ActionEvent event) {
						//	logger.info("clear button selected");
	
						Page.setVisible(false);
						Page.dispose();
				
						new LoginPage();
				
			}
				
		});
			
				viewComplaints.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						
						Page.setVisible(false);
						Page.dispose();
						new TechViewIssue();
					
				}

				});

				
				
				
				
	}		
	


	
				
}
