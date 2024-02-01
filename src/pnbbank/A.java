package pnbbank;

import java.awt.Color;





import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
//import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
//import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import javax.swing.JLabel;
import pnbbank.withdraw;


public class A {

	private JFrame frame;
	 private JDesktopPane desktopPane;
	 private JTextField JDrs13;
	 private Deposit depositWindow;
	 private JInternalFrame withdrawWindow;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A window = new A();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	Connection con;
//	PreparedStatement insert;
//	public void autoID() {
//
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//				con=DriverManager.getConnection("jdbc:mysql://localhost/pnbbank","root","");
//				Statement s=con.createStatement();
//				ResultSet rs=s.executeQuery("select*Max(cust_id)from customer");
//				rs.next();
//				rs.getString("Max(cust_id)");
//				
//				if(rs.getString("Max(cust_id)")==null) 
//				{
//					// Assuming JDrs13 is a JTextField or a similar component
//					
//
//					JDrs13.setText("CU00001");
//				}
//				
//				else {
//				
//					long id=Long.parseLong(rs.getString("Max(cust_id").substring(2,rs.getString("Max(cust_id)").length()));
//                    id++;
//                    JDrs13.setText("CU"+String.format("%03d", id));
//				
//				}
//				
//				
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//
//	}
//	
	


	/**
	 * Create the application.
	 */
	public A() {
		initialize();
//		autoID();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920, 1080);
		
		desktopPane = new JDesktopPane(); // Initialize JDesktopPane
        frame.setContentPane(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Calibri", Font.BOLD, 20));
		menuBar.add(mnNewMenu);
//		
		JMenuItem mntmNewMenuItem = new JMenuItem("Customer");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                B nw=new B();
	                nw.NewScreen();
	                

			}
		});
		

//		
		
		
//		

//		JMenuItem mntmNewMenuItem1 = new JMenuItem("Account");
//		mntmNewMenuItem1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////	                D nw1=new D();
////	                nw1.NewScreen1();
//				D accountDetailsWindow = new D();
//                accountDetailsWindow.NewScreen1();
//
//			}
//		});
//		JMenuItem mntmNewMenuItem3 = new JMenuItem("Deposit");
//		mntmNewMenuItem3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////	                D nw1=new D();
////	                nw1.NewScreen1();
//				Deposit ds=new Deposit();
//				ds.NewScreen2();
//			}
//		});


		// Existing code...
		
		 
	
	
	
	  
		mntmNewMenuItem.setFont(new Font("Calibri", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem);
		
		
		// Existing code...

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Account");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Account ac = new Account();
		        desktopPane.add(ac);
		        ac.setVisible(true);
		    }
		});
		mntmNewMenuItem_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem_1);

		// Existing code...

		
		
		
		
		JMenu mnNewMenu_1 = new JMenu("Transaction");
		mnNewMenu_1.setFont(new Font("Calibri", Font.BOLD, 20));
		menuBar.add(mnNewMenu_1);

		
		
		
//		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Deposit");
//		mntmNewMenuItem_3.setFont(new Font("Calibri", Font.PLAIN, 20));
//		mnNewMenu_1.add(mntmNewMenuItem_3);
//		
		 JMenuItem mntmNewMenuItem_3 = new JMenuItem("Deposit");
		 mntmNewMenuItem_3.setFont(new Font("Calibri", Font.PLAIN, 20));
	        mntmNewMenuItem_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Check if the depositWindow is null or not
	                if (depositWindow == null || depositWindow.isClosed()) {
	                    depositWindow = new Deposit();
	                    desktopPane.add(depositWindow);
	                    depositWindow.setVisible(true);
	                } else {
	                    depositWindow.setVisible(true);
	                    depositWindow.toFront();
	                }
	            }
	        });
	        mnNewMenu_1.add(mntmNewMenuItem_3);
		
		
		

		
		
		
		
		JMenu mnNewMenu_2 = new JMenu("Transfer");
		mnNewMenu_2.setFont(new Font("Calibri", Font.BOLD, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Transfer to Transfer");
		mntmNewMenuItem_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Report");
		mnNewMenu_3.setFont(new Font("Calibri", Font.BOLD, 20));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Customer report");
		mntmNewMenuItem_5.setFont(new Font("Calibri", Font.PLAIN, 20));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_4 = new JMenu("Balance");
		mnNewMenu_4.setFont(new Font("Calibri", Font.BOLD, 20));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Balance amount");
		mntmNewMenuItem_6.setFont(new Font("Calibri", Font.PLAIN, 20));
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_5 = new JMenu("Login");
		mnNewMenu_5.setFont(new Font("Calibri", Font.BOLD, 20));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("User Account");
		mntmNewMenuItem_7.setFont(new Font("Calibri", Font.PLAIN, 20));
		mnNewMenu_5.add(mntmNewMenuItem_7);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar.add(menuBar_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setFont(new Font("Calibri", Font.BOLD, 20));
		menuBar.add(menuBar_1);
	}}
	
	
	
	
//	PreparedStatement insert;
//	public void autoID() {
//
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//				con=DriverManager.getConnection("jdbc:mysql://localhost/pnbbank","root","");
//				Statement s=con.createStatement();
//				ResultSet rs=s.executeQuery("select*Max(cust_id)from customer");
//				rs.next();
//				rs.getString("Max(cust_id)");
//				
//				if(rs.getString("Max(cust_id)")==null) 
//				{
//					// Assuming JDrs13 is a JTextField or a similar component
//					
//
//					JDrs13.setText("CU00001");
//				}
//				
//				else {
//				
//					long id=Long.parseLong(rs.getString("Max(cust_id").substring(2,rs.getString("Max(cust_id)").length()));
//                    id++;
//                    JDrs13.setText("CU"+String.format("%03d", id));
//				
//				}
//			 } catch (Exception e) {
//			        e.printStackTrace();
//			    }
//			}
//	
//	
//	public void Branch() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost/pnbbank","root","");
//			insert = con.prepareStatement("select*from Branch");
//			ResultSet rs=insert.executeQuery();
//			comboBox.removeAllItems();
//			 while (rs.next()) {
////		            String branchName = rs.getString("branch_name");
////		            comboBox.addItem(branchName);
//				    comboBox.addItem(rs.getString(2));
//		        }
//
//		        // Close the ResultSet and PreparedStatement
//		       
//		    } catch (ClassNotFoundException ex) {
//		    	ex.printStackTrace();
//		    }catch (SQLException ex) {
//		    	ex.printStackTrace();
//		}
//	}}
