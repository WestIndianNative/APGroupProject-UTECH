package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class LoginPage {
	
	
	private JFrame crmLoginPage;
	private JTextField userIdCredentials;
	private JPasswordField userPassword;
	private JLabel idLable;
	private JLabel passwordLable;
	private JButton loginButton;
	private ImageIcon logoBand;
	JLabel result;
	
	private JLabel logoContainer;
	
	
	public LoginPage() {
		
		initializeComponents();
	}
	
	public JFrame getCrmLoginPage() {
		return crmLoginPage;
	}
	public void setCrmLoginPage(JFrame crmLoginPage) {
		this.crmLoginPage = crmLoginPage;
	}
	public JTextField getUserIdCredentials() {
		return userIdCredentials;
	}
	public void setUserIdCredentials(JTextField userIdCredentials) {
		this.userIdCredentials = userIdCredentials;
	}
	public JPasswordField getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(JPasswordField userPassword) {
		this.userPassword = userPassword;
	}
	
	public void initializeComponents(){
		
		
		/* Initializing frame components */
		
		
		crmLoginPage = new JFrame();
		crmLoginPage.getContentPane().setLayout(null);
		crmLoginPage.setResizable(false);
		crmLoginPage.setTitle("FLOW Customer Relationship Management System");
		
		
		//	Customized Colors
		Color customColor = new Color(255,184,28);
		Color custom_Color = new Color(0,132,202);
		crmLoginPage.getContentPane().setBackground(Color.white);
		crmLoginPage.setBounds(100,100, 592,534);
		
		crmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		idLable = new JLabel("ID Number");
		idLable.setBounds(160, 179, 100, 22);
		idLable.setForeground(customColor);
		idLable.setFont(new Font("", Font.PLAIN |Font.BOLD, 16));
		crmLoginPage.getContentPane().add(idLable);
		
		userIdCredentials  = new JTextField();
		userIdCredentials.setBounds(250,179,150,30);
		userIdCredentials.setForeground(custom_Color);
		userIdCredentials.setFont(new Font("", Font.PLAIN |Font.BOLD, 16));
		userIdCredentials.setBorder(new LineBorder(custom_Color,2));
		//setBounds(int x-coordinate, int y-coordinate, int width, int height
		crmLoginPage.getContentPane().add(userIdCredentials);
		
		passwordLable = new JLabel("Password");
		passwordLable.setForeground(customColor);
		passwordLable.setBounds(160, 250, 150,30);
		passwordLable.setFont(new Font("", Font.PLAIN |Font.BOLD, 16));
		crmLoginPage.getContentPane().add(passwordLable);
		
		userPassword  = new JPasswordField();
		userPassword.setBounds(250,250,150,30);
		userPassword.setForeground(custom_Color);
		userPassword.setBorder(new LineBorder(custom_Color,2));
		userPassword.setFont(new Font("", Font.PLAIN |Font.BOLD, 16));
		userPassword.setToolTipText("Enter the passwrods associated the ID #");
		crmLoginPage.getContentPane().add(userPassword);
		
		loginButton = new JButton("Login");
		
		loginButton.setForeground(custom_Color);
		loginButton.setBackground(customColor);
		loginButton.setBounds(275, 300, 80, 25);
		loginButton.setBorder(new LineBorder(custom_Color,1));
		crmLoginPage.getContentPane().add(loginButton);
		
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
		  
		  
		  
		JLabel welcome_greeting = new JLabel( Salutation +" | Welcome "
				, JLabel.CENTER );
		welcome_greeting.setBounds(200, 28, 580, 70);
		welcome_greeting.setFont(new Font("", Font.PLAIN |Font.BOLD |Font.ITALIC, 12));
		welcome_greeting.setForeground(Color.white);
		crmLoginPage.getContentPane().add(welcome_greeting);
		crmLoginPage.setVisible(true);
		
		java.time.LocalDate.now();
		
		logoBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/LogoBand.png", "Logo");
		
		logoContainer = new JLabel("",logoBand, JLabel.CENTER );
		logoContainer.setBounds(40, 150, 500, 300);
		
		crmLoginPage.getContentPane().add(logoContainer);
		
		 
		ImageIcon Band = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/Band.png", "Logo");
		JLabel bandContainer = new JLabel("",Band, JLabel.CENTER );
		bandContainer.setBounds(0, 0, 580, 70);
		crmLoginPage.getContentPane().add(bandContainer);
		
		//ImageIcon legal = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
				JLabel legalNotice = new JLabel("© 2022 Flow. C&W Communications Plc. All rights reserved. Registered in England and Wales\r\n"
						, JLabel.CENTER );
				legalNotice.setBounds(10, 430, 580, 70);
				legalNotice.setFont(new Font("", Font.PLAIN |Font.BOLD, 8));
				legalNotice.setForeground(Color.white);
				crmLoginPage.getContentPane().add(legalNotice);
		
		ImageIcon baseBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
		JLabel baseBandContainer = new JLabel("",baseBand, JLabel.CENTER );
		baseBandContainer.setBounds(0, 430, 580, 70);
		
		crmLoginPage.getContentPane().add(baseBandContainer);
		
		
		loginButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean flag = false;
				
				System.out.println("Now in action listner");
				String feedback = "";
				System.out.println(userIdCredentials.getText());
				System.out.println(userPassword.getText());
				
				String CustomerPassword = "Cust123";
				String CustomerID = "100";
				String RepPassword = "Rep123";
				String RepID = "120";
				String TechPassword = "Tech123";
				String TechID = "130";
				
				// && userPassword.getText(). ==CustomerPassword
				
				if(userIdCredentials.getText().equalsIgnoreCase(CustomerID)  && userPassword.getText().equalsIgnoreCase(CustomerPassword) ) {
					
					/*
					 * feedback = "Log in successful"; flag = true; updateResult(feedback);
					 */
					
					CustomerPage B = new CustomerPage();
					crmLoginPage.setVisible(false);
					crmLoginPage.dispose();
					
				}
				else if(userIdCredentials.getText().equalsIgnoreCase(RepID)  && userPassword.getText().equalsIgnoreCase(RepPassword) ) {
					
					/*
					 * feedback = "Log in successful"; flag = true; updateResult(feedback);
					 */
					
					RepresentativePage R = new RepresentativePage();
					crmLoginPage.setVisible(false);
					crmLoginPage.dispose();
					
				}
				else if(userIdCredentials.getText().equalsIgnoreCase(TechID)  && userPassword.getText().equalsIgnoreCase(TechPassword) ) {
					
					/*
					 * feedback = "Log in successful"; flag = true; updateResult(feedback);
					 */
					
					TechnicianPage T = new TechnicianPage();
					crmLoginPage.setVisible(false);
					crmLoginPage.dispose();
					
				}
				else if(userIdCredentials.getText().isBlank()  && userPassword.getText().isBlank()  ) {
					
					feedback = "Username and password required";
					updateResult(feedback);
					
				}
				
				else {
					
					feedback = "Incorrect username or password";
					updateResult(feedback);
				}
					
					
					
				}
			
			
		
				
			
			
		});
		
		
		
	}
	

	public void updateResult(String value) {
		
		int i=0;
	try {
		
		for(i=0; i<2; i++) {
		
		System.out.println("Now in updateResult");
		System.out.println(value);
			result = new JLabel();
			crmLoginPage.getContentPane().add(result);
			result.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			result.setForeground(Color.RED);
			result.setBounds(160, 329, 580, 70);
			result.setText("Error code: " + value);
			
			System.out.println(i);
			
			if(i==1)
				clearFields();
		
		}
			
		}catch(Exception e) {
			System.err.println(e);
		}
	
}
	
	

	public void clearFields()
	{
		//jbg.clearSelection();
		//userIdCredentials.setText("");
		result = new JLabel();
		result.setText("");
		
	}
	
	
	public static void main(String[] args) {
		
		
	
		//new LoginPage();
		
	//CustomerPage B = new CustomerPage();
		//new CustomerPage();
		
		//TechnicianPage C = new TechnicianPage();
		
		//Services S = new Services();
		
		 new	ReportIssue();
		//new ExistingIssues();
		
		//new RepresentativePage();
		
		//new LiveChat();
		
	}
	
	
}
