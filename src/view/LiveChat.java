package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class LiveChat {

	private JFrame liveChat;
	private JTextField Customer;
	private JTextField Employee;
	private JLabel EmployeeLabel;
	private JLabel CustomerLabel;
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem logout;
	private JMenuItem previous;
	
	
	
	public JFrame getFrame() {
		return liveChat;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LiveChat window = new LiveChat();
					window.liveChat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LiveChat() {
		initialize();
	}

	
	private void initialize() {
		liveChat = new JFrame();
		liveChat.setResizable(false);
		liveChat.setTitle("FLOW - Live Chat");
		liveChat.setVisible(true);
		liveChat.setBounds(100, 100, 578, 642);
		Color custom_Color = new Color(112,48,160);
		liveChat.getContentPane().setBackground(custom_Color);
		liveChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		liveChat.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("", Font.PLAIN, 16));
		btnNewButton.setBounds(422, 545, 132, 31);
		liveChat.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 544, 386);
		scrollPane.setBackground(Color.BLUE);
		liveChat.getContentPane().add(scrollPane);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 483, 403, 93);
		scrollPane.setBackground(Color.RED);
		liveChat.getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("Type message here");
		scrollPane_1.setViewportView(textArea);
		
		CustomerLabel = new JLabel("Customer:");
		CustomerLabel.setFont(new Font("", Font.PLAIN, 14));
		CustomerLabel.setBounds(10, 22, 67, 13);
		CustomerLabel.setForeground(Color.WHITE);
		liveChat.getContentPane().add(CustomerLabel);
		
		Customer = new JTextField();
		Customer.setEditable(false);
		Customer.setBounds(103, 21, 96, 19);
		liveChat.getContentPane().add(Customer);
		
		menuBar = new JMenuBar();
	  	menu = new JMenu("File");
	  	logout = new JMenuItem("Log Out");
	  	previous = new JMenuItem("Previous Page");
	  	menu.add(logout);
	  	menu.add(previous);
	  	menuBar.add(menu);
	  	menuBar.setFont(new Font("", Font.PLAIN |Font.BOLD, 9));
	  	liveChat.setJMenuBar(menuBar);
		
		
		Customer.setColumns(10);
		
		EmployeeLabel = new JLabel("Eomployee:");
		EmployeeLabel.setFont(new Font("", Font.PLAIN, 14));
		EmployeeLabel.setBounds(10, 47, 83, 18);
		EmployeeLabel.setForeground(Color.WHITE);
		liveChat.getContentPane().add(EmployeeLabel);
		
		Employee = new JTextField();
		Employee.setEditable(false);
		Employee.setColumns(10);
		Employee.setBounds(103, 46, 96, 19);
		liveChat.getContentPane().add(Employee);
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
			
				liveChat.setVisible(false);
				liveChat.dispose();
					
				new LoginPage();
				
			}
				
		});
		
		previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
			//	logger.info("clear button selected");

		
		
					
			
				liveChat.setVisible(false);
				liveChat.dispose();
				
				
				
				/* Add if statement to differentiate between Tech, Rep and cust class*/
				new RepresentativePage();
				
			}
				
		});
	}
}

