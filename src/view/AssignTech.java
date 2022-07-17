package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.persistence.Column;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.*;

public class AssignTech extends JPanel {

	 private static final Logger logger = LogManager.getLogger(AssignTech.class);


	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem logout;
	private JMenuItem previous;
	private JMenuItem referesh;

	private JFrame Page;
	private ImageIcon logoBand;
	private JLabel logoContainer;

	
	private JButton reset;
	private JButton submit;
	

	private JLabel IDLabel;
	private JLabel customerIDLabel;
	private JLabel responseLabel;
	
	
	private JTextField IDinput;
	private JTextField customerIDinput;

	private JTextField ResponseInput;
	private JTextField Statusinput;
	private JLabel TechlistLable;
	
	private JLabel RepListLabel;
	private JComboBox TechList;
	private JComboBox RepList;
	
	private JTable table;
	private JScrollPane jsp;
	private JPanel TableContainer;
	
	private String TL[]
	        = { "", "Kevin Johnson","Dane Hyatt","Trever Ried","Wayne Walker", "Tim Duncan","Altea Brown" };
	
	private String Who_Responded;
	private String Last_Response_Date;
	
	
	/**
	 * @param who_Responded
	 * @param last_Response_Date
	 */
	public AssignTech(String who_Responded, String last_Response_Date) {
		super();
		Who_Responded = who_Responded;
		Last_Response_Date = last_Response_Date;
	}

	public String getWho_Responded() {
		return Who_Responded;
	}


	public void setWho_Responded(String who_Responded) {
		Who_Responded = who_Responded;
	}





	public String getLast_Response_Date() {
		return Last_Response_Date;
	}





	public void setLast_Response_Date(String last_Response_Date) {
		Last_Response_Date = last_Response_Date;
	}





	public AssignTech() {
		
		
		initializeComponents();
	
	}
		
		
	
	
	
	@SuppressWarnings("unchecked")
	public void initializeComponents(){
		

		
		/* Frame Attributes */
		Page = new JFrame();
		Page.getContentPane().setLayout(null);
		Page.setResizable(false);
		Page.setTitle("Technician Assignment Page");
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
		  
////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////// TABLE POPULATION /////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

			TableContainer = new JPanel();
			TableContainer.setLayout(new BorderLayout());
			TableContainer.setBounds(5, 80, 565, 220);
			TableContainer.setOpaque(true);
			table = new JTable();
			jsp = new JScrollPane(table);

			DefaultTableModel model = new DefaultTableModel();
			table.setModel(model);
			Object[] columnHeading = new Object[10];
			
			logger.info("A table to created");
			columnHeading[0] = "RecordID";
			columnHeading[1] = "Contact";
			columnHeading[2] = "ReportDetails";
			columnHeading[3] = "Email";
			columnHeading[4] = "Fname";
			columnHeading[5] = "Id";
			columnHeading[6] = "ReportIssue";
			columnHeading[7] = "Lname";
			columnHeading[8] = "LostResponseDate";
			columnHeading[9] = "WhoResponded";

			model.setColumnIdentifiers(columnHeading);

			Object[] rowData = new Object[10];

			try {

				System.out.println("Entering Loop");
				ArrayList<ServiceIssue> SList = getServiceIssueList();
				ArrayList<Customer> RList = getCustomerList();
				ArrayList<AssignTech> AList = getTechList();
				for (int i = 0; i < SList.size(); i++) {

					System.out.println("Inside Loop");
					rowData[0] = i + 1;
					rowData[1] = RList.get(i).getContactNo();
					rowData[2] = SList.get(i).getDetailOfIssue();
					rowData[3] = RList.get(i).getEmailAddress();
					rowData[4] = RList.get(i).getFirstName();
					rowData[5] = RList.get(i).getId();
					rowData[6] = SList.get(i).getIssueType();
					rowData[7] = RList.get(i).getLastName();
					rowData[8] = AList.get(i).getLast_Response_Date();
					rowData[9] = AList.get(i).getWho_Responded();

					model.addRow(rowData);
				}

			} catch (Exception e) {

				e.printStackTrace();
				logger.warn("A table to created");
				logger.trace(e);
				logger.error("A exception occurred in ");

			if (this.table != null) {

				table.setFillsViewportHeight(true);
				table.setShowGrid(true);
				table.getTableHeader().setBackground(Color.lightGray);
				table.setFillsViewportHeight(true);
				table.setEnabled(false);
				table.setPreferredScrollableViewportSize(new Dimension(10, 100));
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setOpaque(false);
				table.getTableHeader().setOpaque(false);
				table.getTableHeader().setReorderingAllowed(false);
				table.getTableHeader().setFont(new Font("", Font.PLAIN | Font.BOLD, 12));
				table.setFont(new Font("", Font.PLAIN, 8));
				table.getColumnModel().getColumn(0).setPreferredWidth(50);
				table.getColumnModel().getColumn(1).setPreferredWidth(50);
				table.getColumnModel().getColumn(2).setPreferredWidth(70);
				table.getColumnModel().getColumn(5).setPreferredWidth(50);
				table.getColumnModel().getColumn(4).setPreferredWidth(50);

				table.getTableHeader().setPreferredSize(new Dimension(10, 20));
				table.getTableHeader().setBackground(custom_Color);
				table.getTableHeader().setForeground(Color.WHITE);

				table.setRowHeight(0, 50);
				table.setRowHeight(1, 50);
				table.setRowHeight(2, 50);
				table.setRowHeight(3, 50);
				table.setRowHeight(4, 50);
				table.setRowHeight(5, 50);
				table.setRowHeight(6, 50);
				table.setRowHeight(7, 50);
				table.setRowHeight(8, 50);
				table.setRowHeight(9, 50);
				jsp.setVisible(true);
				TableContainer.add(jsp, BorderLayout.CENTER);
				Page.getContentPane().add(TableContainer, BorderLayout.CENTER);

				table.setSize(500, 500);
}  
		  
			/* Frame Buttons */
		  

		  
		  menuBar = new JMenuBar();
		  	menu = new JMenu("File");
		  	logout = new JMenuItem("Log Out");
		  	previous = new JMenuItem("Previous Page");
		  	referesh = new JMenuItem("Refresh Page");
		  	menu.add(logout);
		  	menu.add(previous);
		  	menu.add(referesh);
		  	menuBar.add(menu);
		  			 
		  	
		  //	menuBar.setBounds(400, 60, 50, 30);
		  	menuBar.setFont(new Font("", Font.PLAIN |Font.BOLD, 9));
			//CustomerPage.getContentPane().add(menuBar);
		  	Page.setJMenuBar(menuBar);
		  
		  
		  TechList = new JComboBox(TL);
		  TechList.setBounds(20, 375, 180, 20);
		  TechList.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  TechList.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(TechList);
		  
		  
		  
		  TechlistLable = new JLabel("Technicians");
		  TechlistLable.setBounds(20, 353, 250, 20);
		  TechlistLable.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		 // TechlistLable.setBorder(new LineBorder(custom_Color,1));
		 Page.getContentPane().add(TechlistLable);
		  
		  
		  
		 RepList = new JComboBox(TL);
		 RepList.setBounds(20, 410, 180, 20);
		 RepList.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		 RepList.setBorder(new LineBorder(custom_Color,1));
		 Page.getContentPane().add(RepList);
		  
		  
		  
		  RepListLabel = new JLabel("Representatives");
		  RepListLabel.setBounds(20, 390, 250, 20);
		  RepListLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		 // RepListLabel.setBorder(new LineBorder(custom_Color,1));
		 Page.getContentPane().add(RepListLabel);
		  
		  //TechlistLable
			/*
			 * employLabel = new JLabel("employLabel"); employLabel.setBounds(100, 100, 100,
			 * 20); employLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
			 * Page.getContentPane().add( employeeList);
			 */
		  
		  IDLabel = new JLabel("Emp No.");
		  IDLabel.setBounds(100, 335, 100, 20);
		  IDLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		//  Page.getContentPane().add(IDLabel);
		  

		  IDinput = new JTextField();
		  IDinput.setBounds(180, 150, 100, 20);
		  IDinput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  IDinput.setBorder(new LineBorder(custom_Color,1));
		  //Page.getContentPane().add(IDinput);
		  
		  
		  customerIDLabel = new JLabel("Customer ID");
		  customerIDLabel.setBounds(100, 335, 100, 20);
		  customerIDLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		//  Page.getContentPane().add(customerIDLabel);
		  
		  customerIDinput = new JTextField();
		  customerIDinput.setBounds(250, 200, 100, 20);
		  customerIDinput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  customerIDinput.setBorder(new LineBorder(custom_Color,1));
		 // Page.getContentPane().add(customerIDinput);
		 
		  
		  
		  
		  responseLabel = new JLabel("Response");
		  responseLabel.setBounds(270, 343, 100, 50);
		  responseLabel.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(responseLabel);
		  
		  ResponseInput = new JTextField();
		  ResponseInput.setBounds(240, 380, 150, 50);
		  ResponseInput.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  ResponseInput.setBorder(new LineBorder(custom_Color,1));
		  Page.getContentPane().add(ResponseInput);
		  
		  
	
		  
		  submit = new JButton("Submit");
		  submit.setBounds(420, 370, 100, 20);
		  submit.setFont(new Font("", Font.PLAIN |Font.BOLD, 14));
		  Page.getContentPane().add(submit);
		  
		  
		  
		  reset = new JButton("Reset");
		  reset.setBounds(420, 410, 100, 20);
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
		
		
		referesh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
				Page.setVisible(false);
				Page.dispose();
				new AssignTech();
					
				
				
			}
				
		});
		
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
		logger.info("logoutbutton selected");

	
	
				
		
			Page.setVisible(false);
			Page.dispose();
			new LoginPage();
			
		}
			
	});

		

	previous.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			logger.info("previous page button selected");

	
	
				
		
			Page.setVisible(false);
			Page.dispose();
			new RepresentativePage();
			
		}
			
	});
	
	
	submit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
		//	logger.info("clear button selected");

			
		
		//	int ID = Integer.parseInt(IDinput.getText());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   
			String techList = (String) TechList.getSelectedItem();
			String repList = (String) RepList.getSelectedItem();
		//	String custID = customerIDinput.getText();			
			String response = ResponseInput.getText();
			String lastresponseTime = dtf.format(now);
	
			
			
			if (TechList.getSelectedIndex() ==0|| response.isBlank() || RepList.getSelectedIndex() ==0) {
				JOptionPane.showMessageDialog(Page, "All fields are required before submitting a response", "Error",
						JOptionPane.INFORMATION_MESSAGE);

			} else {



			JOptionPane.showMessageDialog(Page, "Your response has been accepted ", "Hello"+ RepList.getSelectedItem(), JOptionPane.INFORMATION_MESSAGE);
		
			int result = JOptionPane.showConfirmDialog(Page, "Are the required columns already in the database?.");
			
			if(result == 1) {
				
				
			
			
			try {
					AddColumns("TechAssignment");
				}catch (SQLException e1) {
				
					e1.printStackTrace();
				}
			
			}else if(result ==0) {
				
				String popUpInput = JOptionPane.showInputDialog(Page, "Enter the record Id of the row that you would like to update");
			
					JOptionPane.showMessageDialog(Page, "Performing your request... ");
					
					
				try {
					
					
					TechAssignment(techList, popUpInput);
					LastResponseTime(lastresponseTime, popUpInput);
					responseStatement(response, popUpInput);
					RepAssignment(repList, popUpInput);

					JOptionPane.showMessageDialog(Page,"Record updated successfully");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			else {
				
				JOptionPane.showMessageDialog(Page,"Request cancelled");
			}
			
			}
			
			
	}

	});

			}
		
	}
	




	public void AddColumns(String columnName) throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		RowSetFactory factory = RowSetProvider.newFactory();
	    CachedRowSet rowSet = factory.createCachedRowSet();
	    String Url = "jdbc:mysql://localhost:3306/FLOWdb";
	    rowSet.setUrl(Url);
	    rowSet.setUsername("root");
	    rowSet.setPassword("");
	    rowSet.setCommand("SELECT * FROM customerissue");
	    rowSet.execute();
	    ResultSetMetaData meta = rowSet.getMetaData();
	    int columnCount = meta.getColumnCount();
	    
	    boolean exist = false;
	    
	    for(int i=1;i<=columnCount; i++) {
	    	if(meta.getColumnName(i).equals(columnName));
	    		exist = true;
	    	
	    }
	
	    if(exist) {
	    	System.out.println("Column exist");
	    	JOptionPane.showMessageDialog(Page, "Column already exist ", "Column Record Check", JOptionPane.INFORMATION_MESSAGE);
	    }
	    else {
	    	
	    	System.out.println("Column does not exist");
	    	JOptionPane.showMessageDialog(Page, "Column does not exist creating... ", "Column Record Check", JOptionPane.INFORMATION_MESSAGE);
		
		
		 Connection con = DriverManager.getConnection(Url, "root", "");
		 Statement stmt = con.createStatement();
		 String query1 = "ALTER TABLE customerissue ADD Last_ResponseDate varchar(255)";
		 String query2 = "ALTER TABLE customerissue ADD TechAssignment varchar(255)";
		 String query3 = "ALTER TABLE customerissue ADD Who_Response varchar(255)";
		 String query4 = "ALTER TABLE customerissue ADD Response varchar(255)";
		 
		 stmt.executeUpdate(query1);
		 stmt.executeUpdate(query2);
		 stmt.executeUpdate(query3);
		 stmt.executeUpdate(query4);
		 
		 System.out.println("Columns added");
		 
	    }
		 
	}
	

	
	public void LastResponseTime(String parameter, String RecordNo) throws SQLException {
		
		System.out.println(parameter);
		
		System.out.println(RecordNo);
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 String Url = "jdbc:mysql://localhost:3306/FLOWdb";
		 Connection con = DriverManager.getConnection(Url, "root", "");		
		PreparedStatement pstmt = con.prepareStatement("UPDATE customerissue SET Last_ResponseDate = ? WHERE Record_No = ?");
		logger.trace("An update was sent to the customerisssue table from assignTech");
	
		pstmt.setString(1, parameter);//First Parameter is update statement ?
		pstmt.setString(2,RecordNo);//Second Parameter is update statement ?
		pstmt.executeUpdate();

	}
	
	
	public void responseStatement(String parameter, String RecordNo) throws SQLException {
		
		System.out.println(parameter);
		
		System.out.println(RecordNo);
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 String Url = "jdbc:mysql://localhost:3306/FLOWdb";
		 Connection con = DriverManager.getConnection(Url, "root", "");		
		PreparedStatement pstmt = con.prepareStatement("UPDATE customerissue SET Response = ? WHERE Record_No = ?");

	
		pstmt.setString(1, parameter);//First Parameter is update statement ?
		pstmt.setString(2,RecordNo);//Second Parameter is update statement ?
		pstmt.executeUpdate();
	
	}
	
	public void TechAssignment(String parameter, String RecordNo) throws SQLException {
		
		System.out.println(parameter);
		
		System.out.println(RecordNo);
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 String Url = "jdbc:mysql://localhost:3306/FLOWdb";
		 Connection con = DriverManager.getConnection(Url, "root", "");		
		PreparedStatement pstmt = con.prepareStatement("UPDATE customerissue SET TechAssignment = ? WHERE Record_No = ?");
	//	String techList = (String) TechList.getSelectedItem();

	
		pstmt.setString(1, parameter);//First Parameter is update statement ?
		pstmt.setString(2,RecordNo);//Second Parameter is update statement ?
		pstmt.executeUpdate();

	
	}
	
	public void RepAssignment(String parameter, String RecordNo) throws SQLException {
		
		System.out.println(parameter);
		
		System.out.println(RecordNo);
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 String Url = "jdbc:mysql://localhost:3306/FLOWdb";
		 Connection con = DriverManager.getConnection(Url, "root", "");		
		PreparedStatement pstmt = con.prepareStatement("UPDATE customerissue SET Who_Response = ? WHERE Record_No = ?");
		//String techList = (String) TechList.getSelectedItem();

	
		pstmt.setString(1, parameter);//First Parameter is update statement ?
		pstmt.setString(2,RecordNo);//Second Parameter is update statement ?
		pstmt.executeUpdate();
		

	}
	
	public void clearFields()
	{
		
	//	ResponseInput.setText("");
		//customerIDinput.setText("");
		TechList.setSelectedIndex(0);
		RepList.setSelectedIndex(0);
		
		JOptionPane.showMessageDialog(Page, "Form succesfully cleared", "Reset", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static Connection getConnection() {

		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FLOWdb", "root", "");
		} catch (SQLException sql) {

			sql.printStackTrace();
		}
			
		logger.trace("A connection was succefully initialized ");
		return con;
	}

	public ArrayList<ServiceIssue> getServiceIssueList() {

		ArrayList<ServiceIssue> dataSet = new ArrayList<ServiceIssue>();
		String query = "SELECT * FROM customerIssue";
		Connection con = getConnection();
		Statement selectStatement;
		ResultSet rs;

		try {

			selectStatement = con.createStatement();
			rs = selectStatement.executeQuery(query);
			ServiceIssue report;
			while (rs.next()) {

				report = new ServiceIssue(rs.getInt("Id"), rs.getString("Fname"), rs.getString("Lname"),
						rs.getString("Email"), rs.getString("Contact"), rs.getString("IssueType"),
						rs.getString("ReportDetails")

				);
				dataSet.add(report);
			}
		} catch (SQLException sql) {

			sql.printStackTrace();
		}

		return dataSet;
	}
	
	
	public ArrayList<AssignTech> getTechList() {

		ArrayList<AssignTech> dataSet = new ArrayList<AssignTech>();
		String query = "SELECT * FROM customerIssue";
		Connection con = getConnection();
		Statement selectStatement;
		ResultSet rs;

		try {

			selectStatement = con.createStatement();
			rs = selectStatement.executeQuery(query);
			AssignTech report;
			while (rs.next()) {

				report = new AssignTech(rs.getString("Last_ResponseDate"), rs.getString("Who_Response"));
				
				dataSet.add(report);
			}
		} catch (SQLException sql) {

			sql.printStackTrace();
		}

		return dataSet;
	}
	
	

	public ArrayList<Customer> getCustomerList() {

		ArrayList<Customer> dataSet = new ArrayList<Customer>();
		String query = "SELECT * FROM customerIssue";
		Connection con = getConnection();
		Statement selectStatement;
		ResultSet rs;

		try {

			selectStatement = con.createStatement();
			rs = selectStatement.executeQuery(query);
			Customer report;
			while (rs.next()) {

				report = new Customer(rs.getInt("Id"), rs.getString("Fname"), rs.getString("Lname"),
						rs.getString("Email"), rs.getString("Contact"));
				dataSet.add(report);
			}
		} catch (SQLException sql) {

			sql.printStackTrace();
		}

		return dataSet;
	}
	
	
	
	
}

