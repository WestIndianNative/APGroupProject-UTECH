package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import model.Customer;
import model.ServiceIssue;

public class ExistingIssues extends JPanel {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem logout;
	private JMenuItem previous;

	private JFrame Page;
	private ImageIcon logoBand;
	private JLabel logoContainer;
	private JTable table;
	private JScrollPane jsp;
	private JPanel TableContainer;

	public ExistingIssues() {

		Initialize();

	}

	public void Initialize() {

		/* Frame Attributes */
		Page = new JFrame();
		Page.getContentPane().setLayout(null);
		Page.setResizable(false);
		Page.setTitle("Exisiting Issues");
		Page.setVisible(true);
		Page.pack();

		// Customized Colors
		@SuppressWarnings("unused")
		Color customColor = new Color(255, 184, 28);
		@SuppressWarnings("unused")
		Color custom_Color = new Color(0, 132, 202);
		Page.getContentPane().setBackground(Color.white);
		Page.setBounds(100, 100, 587, 540);

		Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		@SuppressWarnings("unused")
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY HH:mm");
		@SuppressWarnings("unused")
		LocalDateTime now = LocalDateTime.now();

		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		String Salutation = "";

		if (timeOfDay >= 0 && timeOfDay < 12) {
			Salutation = "Good Morning";
		} else if (timeOfDay >= 12 && timeOfDay < 16) {
			Salutation = "Good Afternoon";
		} else if (timeOfDay >= 16 && timeOfDay < 21) {
			Salutation = "Good Evening";
		} else if (timeOfDay >= 21 && timeOfDay < 24) {
			Salutation = "Good Night";
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////// TABLE POPULATION /////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////

		TableContainer = new JPanel();
		TableContainer.setLayout(new BorderLayout());
		TableContainer.setBounds(5, 120, 565, 220);
		TableContainer.setOpaque(true);
		table = new JTable();
		jsp = new JScrollPane(table);
	

		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		Object[] columnHeading = new Object[10];
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
		}

		if (this.table != null) {

			table.setFillsViewportHeight(true);
			table.setShowGrid(true);
			table.getTableHeader().setBackground(Color.lightGray);
			table.setFillsViewportHeight(true);
			table.setEnabled(false);
			table.setPreferredScrollableViewportSize(new Dimension (10,100));
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
		menu.add(logout);
		menu.add(previous);
		menuBar.add(menu);
		menuBar.setFont(new Font("", Font.PLAIN | Font.BOLD, 9));
		Page.setJMenuBar(menuBar);

		JLabel welcome_greeting = new JLabel(Salutation + " | Welcome ", JLabel.CENTER);
		welcome_greeting.setBounds(200, 28, 580, 70);
		welcome_greeting.setFont(new Font("", Font.PLAIN | Font.BOLD | Font.ITALIC, 12));
		welcome_greeting.setForeground(Color.white);
		Page.getContentPane().add(welcome_greeting);

		java.time.LocalDate.now();

		logoBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/LogoBand.png", "Logo");

		logoContainer = new JLabel("", logoBand, JLabel.CENTER);
		logoContainer.setBounds(40, 150, 500, 300);

		Page.getContentPane().add(logoContainer);

		ImageIcon Band = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/Band.png", "Logo");
		JLabel bandContainer = new JLabel("", Band, JLabel.CENTER);
		bandContainer.setBounds(0, 0, 580, 70);
		Page.getContentPane().add(bandContainer);

		@SuppressWarnings("unused")
		ImageIcon legal = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
		JLabel legalNotice = new JLabel(
				"© 2022 Flow. C&W Communications Plc. All rights reserved. Registered in England and Wales\r\n",
				JLabel.CENTER);
		legalNotice.setBounds(10, 430, 580, 70);
		legalNotice.setFont(new Font("", Font.PLAIN | Font.BOLD, 8));
		legalNotice.setForeground(Color.white);
		Page.getContentPane().add(legalNotice);

		ImageIcon baseBand = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
		JLabel baseBandContainer = new JLabel("", baseBand, JLabel.CENTER);
		baseBandContainer.setBounds(0, 430, 580, 70);

		Page.getContentPane().add(baseBandContainer);

		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// logger.info("clear button selected");

				Page.setVisible(false);
				Page.dispose();

				new LoginPage();

			}

		});

		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// logger.info("clear button selected");

				Page.setVisible(false);
				Page.dispose();

				new CustomerPage();

			}

		});

	}


	public static Connection getConnection() {

		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FLOWdb", "root", "");
		} catch (SQLException sql) {

			sql.printStackTrace();
		}

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
