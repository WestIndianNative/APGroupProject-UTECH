package crmGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

public class ViewServiceRequest {

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
	
	
	public ViewServiceRequest() {
		
		Initialize();

	}


	public void Initialize() {
		


			  
			  	
		/* Frame Attributes */
		Page = new JFrame();
		Page.getContentPane().setLayout(null);
		Page.setResizable(true);
		Page.setTitle("Exisiting Issues");
		Page.setVisible(true);
		Page.pack();
		
		//	Customized Colors
		Color customColor = new Color(255,184,28);
		Color custom_Color = new Color(0,132,202);
		Page.getContentPane().setBackground(Color.white);
		Page.setBounds(100,100, 587,540);
		
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
		  
	
		//  TableContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
		  TableContainer = new JPanel();
		  TableContainer.setLayout(new BorderLayout());
			TableContainer.setBackground(Color.gray);
			//table.getTableHeader().setOpaque(false);
			//table.getTableHeader().setBackground(Color.lightGray);
			//table.setOpaque(false);
		//	table.getTableHeader().setReorderingAllowed(false);
			TableContainer.setBounds(0,100, 570,300);
			Page.getContentPane().add(TableContainer, BorderLayout.CENTER);


			String[] columnsHeadings = {"ID", "First Name", "Last Name", "Contact No", "Email Address", "Report Issue", "Report Details" };
			String [][]data_rows ={
				{"Chris", "45", "Male","4", "5","6","7"},
				{"Paula", "32", "Female","", "","",""},
				{"Michael", "17","Male","", "","",""},
				{"Beverly", "32", "Female","", "","",""}
				
		};
			
			table = new JTable(data_rows,columnsHeadings) {
				private static final long serialVersionUID = 1L;
				
				public boolean isCellEditable(int data_row, int columns) {
					
					return false;
				
				}
				public Component prepareRenderer(TableCellRenderer renderer, int dataRows, int columns) {
					
					Component row = super.prepareRenderer(renderer, dataRows, columns);
					
					if(dataRows % 2 ==0) {
						row.setBackground(Color.WHITE);
					}else {
						row.setBackground(Color.LIGHT_GRAY);
					}
					if(isCellSelected(dataRows, columns)) {
						row.setBackground(Color.GREEN);
					}
					return row;
				}
			};
			
				table.setPreferredScrollableViewportSize(new Dimension(500,250));
					table.setFillsViewportHeight(true);
					table.setShowGrid(true);
					table.setSize(1500, 900);			
					table.getColumnModel().getColumn(0).setPreferredWidth(80);
					table.setRowHeight(0, 50);
					
					table.getColumnModel().getColumn(1).setPreferredWidth(100);
					table.setRowHeight(1, 50);
					
					table.getColumnModel().getColumn(2).setPreferredWidth(100);
					table.setRowHeight(2, 50);
					table.getColumnModel().getColumn(3).setPreferredWidth(100);
					table.setRowHeight(3, 50);
					table.getColumnModel().getColumn(4).setPreferredWidth(100);
					table.setRowHeight(4, 50);
					table.getColumnModel().getColumn(5).setPreferredWidth(100);
					table.setRowHeight(5, 50);
					
					table.getColumnModel().getColumn(6).setPreferredWidth(200);
					table.setRowHeight(6, 50);
					
				
					
					
					table.getTableHeader().setReorderingAllowed(false);
					jsp = new JScrollPane(table);
					TableContainer.add(jsp);



					  /* Frame Buttons */
					  
					  
							menuBar = new JMenuBar();
						  	menu = new JMenu("File");
						  	logout = new JMenuItem("Log Out");
						  	previous = new JMenuItem("Previous Page");
						  	menu.add(logout);
						  	menu.add(previous);
						  	menuBar.add(menu);
						  	menuBar.setFont(new Font("", Font.PLAIN |Font.BOLD, 9));
						  	Page.setJMenuBar(menuBar);
	
		  
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
		
		ImageIcon legal = new ImageIcon("C:\\Users\\brown\\eclipse-workspace\\AP-Project 2022/BaseBand.png", "Logo");
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
	
	previous.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {
		//	logger.info("clear button selected");

	
	
				
		
			Page.setVisible(false);
			Page.dispose();
				
			new RepresentativePage();
			
		}
			
	});

		
		
	}

	
	
}

