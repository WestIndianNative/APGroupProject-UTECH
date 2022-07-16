package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import client.Client;
import customer.Complaints;
import customer.Customer;

public class ViewDetails implements ActionListener {
	private JFrame frame = new JFrame("Complaint and Account Details");
	public JMenuBar serviceBar;
	public JMenu serviceMenu, subMenu;
	public JMenuItem menuItem;
	private JTextArea resultTxt;

	public JTextField searchField;
    public JButton searchB = new JButton ("Search");
	public JPanel panel = new JPanel();
    private JLabel titleLbl;
    private JButton bckBtn;
    
    Complaints complaint = new Complaints();
	
	public ViewDetails()
	{
		frame.setResizable(false);
		frame.setBounds(700, 300, 980, 591);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); //center output on screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(160, 160, 160));
		
		titleLbl = new JLabel("Complaint Id: ");
		titleLbl.setBounds(20, 10, 290, 35); //x, y, width, length
	    titleLbl.setFont(new Font("Inter", Font.BOLD, 16));
	    frame.getContentPane().add(titleLbl);
	    
	    resultTxt = new JTextArea();
	    resultTxt.setBounds(50, 90, 830, 400);
	    resultTxt.setFont(new Font("Inter", Font.PLAIN, 17));
	    resultTxt.setBackground(new Color(192, 192, 192));
	    resultTxt.setVisible(false);
	    frame.getContentPane().add(resultTxt);
	    
		searchField = new JTextField();
		searchField.setFont(new Font("Inter", Font.PLAIN, 14));
		searchField.setBounds(117, 10, 130, 30);
		frame.getContentPane().add(searchField );
	
		searchB = new JButton("Search");
		searchB.setFont(new Font("Inter", Font.BOLD, 14));
		searchB.setForeground(Color.white);
		searchB.setBorderPainted(false);
		searchB.setBounds(265, 10, 80, 30);
		searchB.setBackground(new Color(96, 96, 96));
		frame.getContentPane().add(searchB);
		searchB.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(searchField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Complaint Id Missing!","View Status", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					Client client = new Client();
					
					complaint.setcNo(searchField.getText());
					client.sendAction("ViewDetails");
					client.sendComplaintId(complaint.getcNo());
					client.receiveResponse();
				}			
			}
	});
		bckBtn = new JButton("Back");
		bckBtn.setFont(new Font("Inter", Font.BOLD, 14));
		bckBtn.setForeground(Color.white);
		bckBtn.setBorderPainted(false);
		bckBtn.setBounds(365, 10, 80, 30);
		bckBtn.setBackground(new Color(96, 96, 96));
		bckBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//new CustomerDashboard();
				frame.dispose();
			}
		});
		frame.getContentPane().add(bckBtn);

		menu();
		frame.setVisible(true);
		}
		 public void menu() 
		 {
			//Create the Menu Bar
				serviceBar = new JMenuBar();
				serviceMenu = new JMenu("Services");
				serviceMenu.setFont(new Font("Inter", Font.BOLD, 14));
				serviceMenu.setMnemonic(KeyEvent.VK_A);
				serviceMenu.getAccessibleContext().setAccessibleDescription(null);
				serviceMenu.setBounds(250,70,50,15);
			    serviceMenu.setOpaque(true);
			    serviceBar.add(serviceMenu);
				
				//menu items
				menuItem = new JMenuItem("Lodge New Complaint", KeyEvent.VK_T);
				menuItem.setFont(new Font("Inter", Font.BOLD, 14));
				menuItem.setBackground(new Color(255, 255, 255));
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
				menuItem.getAccessibleContext().setAccessibleDescription("Complaint");
				menuItem.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						//new LodgeComplaint();
					}	
				});
				serviceMenu.add(menuItem);		
				
				menuItem = new JMenuItem("View a Complaint", KeyEvent.VK_T);
				menuItem.setFont(new Font("Inter", Font.BOLD, 14));
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
				menuItem.getAccessibleContext().setAccessibleDescription("Complaint");
				menuItem.setBackground(new Color(255, 255, 255));
				menuItem.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						frame.dispose();
						new ViewDetails();
					}			
				});
				serviceMenu.add(menuItem);
				
				menuItem = new JMenuItem("Query Account Status", KeyEvent.VK_T);
				menuItem.setFont(new Font("Inter", Font.BOLD, 14));
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
				menuItem.getAccessibleContext().setAccessibleDescription("Complaint");
				menuItem.setBackground(new Color(255, 255, 255));
				menuItem.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						//new QueryAccountStatus();
					}
				});
				serviceMenu.add(menuItem);
				
				menuItem = new JMenuItem("View Past Complaints", KeyEvent.VK_T);
				menuItem.setFont(new Font("Inter", Font.BOLD, 14));
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
				menuItem.getAccessibleContext().setAccessibleDescription("Complaint");
				menuItem.setBackground(new Color(255, 255, 255));
				menuItem.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						new ViewAllComplaints();
					}
				});
				serviceMenu.add(menuItem);
				
				menuItem = new JMenuItem("View Past Payments", KeyEvent.VK_T);
				menuItem.setFont(new Font("Inter", Font.BOLD, 14));
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
				menuItem.getAccessibleContext().setAccessibleDescription("Complaint");
				menuItem.setBackground(new Color(255, 255, 255));
				menuItem.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						new PaymentsView();
					}
				});
				serviceMenu.add(menuItem);
			
				serviceMenu = new JMenu("Back");
				serviceMenu.setFont(new Font("Inter", Font.BOLD, 14));
				serviceMenu.setMnemonic(KeyEvent.VK_A);
				serviceMenu.getAccessibleContext().setAccessibleDescription(null);
				serviceMenu.addMouseListener(new MouseListener()
				{
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.dispose();
						//new CustomerDashboard();
					}
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					});
				serviceBar.add(serviceMenu);
				
				serviceMenu = new JMenu("Log Out");
				serviceMenu.setFont(new Font("Inter", Font.BOLD, 14));
				serviceMenu.setMnemonic(KeyEvent.VK_A);
				serviceMenu.getAccessibleContext().setAccessibleDescription(null);
				serviceMenu.addMouseListener(new MouseListener()
				{
					@Override
					public void mouseClicked(MouseEvent e) {
						frame.dispose();
						//new CustomerLoginWindow();
					}
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					});
					serviceBar.add(serviceMenu);
			    
				class MenuListener
				{
				  MenuListener listener =  new MenuListener();
				}
				frame.add(serviceBar);
				frame.setJMenuBar(serviceBar); 
				frame.setVisible(true);
		 }
		 public void setText(Complaints co, Customer cust)
		 {
			 frame.setVisible(true);
			 searchField.setText(co.getcNo());
			 resultTxt.setVisible(true);
			 resultTxt.setText("Customer Id: " + cust.getId() + "\nName " + cust.getfName()+" "+cust.getlName() + "\nEmail: " + cust.getEmail() + "\nContact: " + cust.getContact() + "\nAddress: " + cust.getAddress() + "\nComplaint Category: " + co.getCategory() + "\nDetails: "+co.getDetails() + "\nStatus: " + co.getStatus() + "\nResponse Date: " + co.getRepResponseDate() + "\nRespondent: "+co.getRepRespondent() +"\nResponse: "+co.getRepResponse()
			 +"\nTech Response Date: " + co.getTechResponseDate()+"\nTech Respondent: "+co.getTechRespondent()+"\nResponse: "+co.getTechResponse());
			 resultTxt.setEditable(false);
		 }	
	public static void main(String[] args) {
		new ViewDetails();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
