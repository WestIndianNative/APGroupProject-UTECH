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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Customer;
import model.User;
//import model.User;
import model.customerService;

public class ReportIssue {

	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem logout;
	private JMenuItem previous;

	private JFrame Page;
	private ImageIcon logoBand;
	private JLabel logoContainer;

	
	private JButton reset;
	private JButton submit;
	

	private JLabel IDLabel;
	private JLabel Fname;
	private JLabel Lname;
	private JLabel emailAddress;
	private JLabel contactNumber;
	private JLabel DetailsOfIssue;
	
	private JTextField IDinput;
	private JTextField Fnameinput;
	private JTextField Lnameinput;
	private JTextField emailAddressinput;
	private JTextField contactNumberinput;
	private JTextField Addressinput;
	//private Customer newCustomer;
	
	private JLabel serviceLabel;
	private JComboBox sericeList;
	private String SL[]
	        = { "", "No Internet Connection","Intermittent Internet Service","No Cable","Missing Channels", "No Dial Tone","No Mobile Signal" };
	


	public ReportIssue() {
		
		
		initializeComponents();
	
	}
		
	
	
	
	@SuppressWarnings("unchecked")
	public void initializeComponents(){
		

		
		/* Frame Attributes */
		Page = new JFrame();
		Page.getContentPane().setLayout(null);
		Page.setResizable(false);
		Page.setTitle("Service Request Page");
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
		  	previous = new JMenuItem("Previous Page");
		  	menu.add(logout);
		  	menu.add(previous);
		  	menuBar.add(menu);
		  			 
		  	
		  //	menuBar.setBounds(400, 60, 50, 30);
		  	menuBar.setFont(new Font("", Font.PLAIN |Font.BOLD, 9));
			//CustomerPage.getContentPane().add(menuBar);
		  	Page.setJMenuBar(menuBar);
		  
		  
		  sericeList = new JComboBox(SL);
		  sericeList.setBounds(200, 100, 250, 20);
		  sericeList.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  sericeList.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(sericeList);
	
		  serviceLabel = new JLabel("Type of Issue");
		  serviceLabel.setBounds(100, 100, 100, 20);
		  serviceLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(serviceLabel);
		  
		  
		  IDLabel = new JLabel("ID Number");
		  IDLabel.setBounds(100, 150, 100, 20);
		  IDLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(IDLabel);
		  

		  IDinput = new JTextField();
		  IDinput.setBounds(180, 150, 100, 20);
		  IDinput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  IDinput.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(IDinput);
		  
		  
		  Fname = new JLabel("First Name");
		  Fname.setBounds(100, 200, 100, 20);
		  Fname.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(Fname);
		  
		  Fnameinput = new JTextField();
		  Fnameinput.setBounds(180, 200, 100, 20);
		  Fnameinput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Fnameinput.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(Fnameinput);
		  
		  
		  Lname = new JLabel("Last Name");
		  Lname.setBounds(300, 200, 100, 20);
		  Lname.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(Lname);
		  
		  Lnameinput = new JTextField();
		  Lnameinput.setBounds(380, 200, 100, 20);
		  Lnameinput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Lnameinput.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(Lnameinput);
		  
		  contactNumber = new JLabel("Contact No");
		  contactNumber.setBounds(100, 250, 100, 20);
		  contactNumber.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(contactNumber);
		  
		  contactNumberinput = new JTextField();
		  contactNumberinput.setBounds(180, 250, 100, 20);
		  contactNumberinput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  contactNumberinput.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(contactNumberinput);
		  
		  emailAddress = new JLabel("Email");
		  emailAddress.setBounds(300, 250, 100, 20);
		  emailAddress.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(emailAddress);
		  
		  emailAddressinput = new JTextField();
		  emailAddressinput.setBounds(380, 250, 100, 20);
		  emailAddressinput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  emailAddressinput.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(emailAddressinput);
		  
		  
		  
		  DetailsOfIssue = new JLabel("Details");
		  DetailsOfIssue.setBounds(100, 300, 100, 20);
		  DetailsOfIssue.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(DetailsOfIssue);
		  
		  Addressinput = new JTextField();
		  Addressinput.setBounds(180,300, 200, 40);
		  Addressinput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Addressinput.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(Addressinput);
		  
		  
		  submit = new JButton("Submit");
		  submit.setBounds(150, 400, 100, 20);
		  submit.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(submit);
		  
		  
		  
		  reset = new JButton("Reset");
		  reset.setBounds(300, 400, 100, 20);
		  reset.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(reset);
		  
	
		  
		  
		  
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
		
		
		
	reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
				System.out.println("clear button clicked");
				clearFields();
					
				
				
			}
				
		});
	
	logout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {
		//	logger.info("clear button selected");

	
	
				
		
			Page.setVisible(false);
			Page.dispose();
			new CustomerPage();
			
		}
			
	});

	submit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {
		//	logger.info("clear button selected");
			
			/*int cusServiceID,String firstName,String lastName,String Email, String Contact,String Issue_Type,
			String Date_of_Issue,String Status,String ResponseT,String lastResponse,String Who_Responed*/
	
			int ID = Integer.parseInt(IDinput.getText());
			String Issue_Type = (String) sericeList.getSelectedItem();
			String FirstName = Fnameinput.getText(); 
			String LastName = Lnameinput.getText(); 
			String Email =  emailAddressinput.getText();
			String Contact = contactNumberinput.getText();
			String DetailIssue = Addressinput.getText();
			String Date_of_Issue="";
			String Status="";
			String ResponseT="";
			String lastResponse="";
			String Who_Responded="";
			String Address="";
			String TechnicianA = "";
			
			//ID FirstName Last Name, String email, String phoneNumber, String Address, String TypeIssue, String DetailIssue
			customerService cust = new customerService(new Customer(new User(ID, FirstName,LastName),Email, Address, Contact,Issue_Type,DetailIssue),Date_of_Issue,Status,ResponseT, TechnicianA, lastResponse,Who_Responded);
			
			//User customer, String email, String phoneNumber, String Address, String TypeIssue, String DetailIssue --  String Date_of_Issue, String Status, String ResponseT, String TechnicianA, String lastResponse, String Who_Responed
			
	}
			
	});
		

	previous.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {
		//	logger.info("clear button selected");

	
	
				
		
			Page.setVisible(false);
			Page.dispose();
			new CustomerPage();
			
		}
			
	});

		
	}
	
	public void clearFields()
	{
		
		
		Addressinput.setText("");
		emailAddressinput.setText("");
		Fnameinput.setText("");
		Lnameinput.setText("");
		IDinput.setText("");
		contactNumberinput.setText("");
		sericeList.setSelectedIndex(0);
		
		JOptionPane.showMessageDialog(Page, "Form succesfully cleared", "Reset", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
