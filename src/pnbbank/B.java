//package pnbbank;
//
//import java.awt.EventQueue;
//
//
//import javax.swing.*;
//
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.Font;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.awt.event.ActionEvent;
//import javax.swing.JComboBox;
//import java.awt.Label;
//import java.awt.TextField;
//import java.sql.Statement;
//
//
//public class B {
//
//	private JFrame frame;
//	private JTextField txtfname;
//	private JTextField txtlname;
//	private JTextField txtcity;
//	private JTextField txtphone;
//	private JTextField txtstate;
//	 
//	
//	private JLabel JDrs13; 
//	 private JComboBox<String> comboBox;
//	
//
//	
//
//	/**
//	 * Launch the application.
////	 */
////	public static void main(String args[]) {
////		EventQueue.invokeLater(new Runnable() {
////			public void run() {
////				try {
////					B window = new B();
////					window.NewScreen();
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////			}
////		});
////	}
////
//	 public static void main(String[] args) {
//	        NewScreen();
//	    }
//
//	    public static void NewScreen() {
//	        EventQueue.invokeLater(new Runnable() {
//	            public void run() {
//	                try {
//	                    B window = new B();
//	                    window.frame.setVisible(true);
//	                } catch (Exception e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	        });
//	    }
// 
//	
//
//	 
//	 
//	/**
//	 * Create the application.
//	 */
//	public B() {
//		initialize();
//		autoID();
//		Branch();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("FirstName");
//		lblNewLabel.setBounds(39, 35, 67, 13);
//		frame.getContentPane().add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("LastName");
//		lblNewLabel_1.setBounds(39, 77, 67, 13);
//		frame.getContentPane().add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("City");
//		lblNewLabel_2.setBounds(49, 100, 45, 13);
//		frame.getContentPane().add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_3 = new JLabel("Branch");
//		lblNewLabel_3.setBounds(39, 173, 45, 13);
//		frame.getContentPane().add(lblNewLabel_3);
//		
//		JLabel lblNewLabel_4 = new JLabel("Phone");
//		lblNewLabel_4.setBounds(39, 196, 45, 13);
//		frame.getContentPane().add(lblNewLabel_4);
//		
//		txtfname = new JTextField();
//		txtfname.setBounds(160, 38, 96, 19);
//		frame.getContentPane().add(txtfname);
//		txtfname.setColumns(10);
//		
//		txtlname = new JTextField();
//		txtlname.setBounds(170, 74, 96, 19);
//		frame.getContentPane().add(txtlname);
//		txtlname.setColumns(10);
//		
//		txtcity = new JTextField();
//		txtcity.setBounds(160, 97, 96, 19);
//		frame.getContentPane().add(txtcity);
//		txtcity.setColumns(10);
//		
//		txtphone = new JTextField();
//		txtphone.setBounds(160, 193, 96, 19);
//		frame.getContentPane().add(txtphone);
//		txtphone.setColumns(10);
//		
//		JLabel lblNewLabel_5 = new JLabel("CustNo");
//		lblNewLabel_5.setBounds(39, 10, 45, 13);
//		frame.getContentPane().add(lblNewLabel_5);
//		
//		
//		JDrs13 = new JLabel("JDrs13");
//		JDrs13.setForeground(new Color(255, 0, 0));
//		JDrs13.setFont(new Font("Tahoma", Font.BOLD, 15));
//		JDrs13.setBounds(160, 10, 85, 13);
//		frame.getContentPane().add(JDrs13);
//
//		JButton btnNewButton = new JButton("Add");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				String cust_id=JDrs13.getText();
//				String FirstName=txtfname.getText();
//				String LastName=txtlname.getText();
//				String city=txtcity.getText();
//				String state=txtstate.getText();
//				String branch=comboBox.getSelectedItem().toString();
//				String phone=txtphone.getText();
//				
//				
////				  try {
////			            int phoneNumber = Integer.parseInt(phone);
////			            // Now, phoneNumber is a valid integer, proceed with the insertion
////			            insert.setString(7, String.valueOf(phoneNumber));
////			        } catch (NumberFormatException ex) {
////			            // Handle the case where the input is not a valid integer
////			            JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.");
////			            // You may choose to return from the method or take appropriate action
////			            return;
////			        } catch (SQLException ex) {
////			            ex.printStackTrace();
////			            // Handle the SQLException here if needed
////			            return;
////			        }
//				
////				
////				  try {
////			            int phoneNumber = Integer.parseInt(phone);
////			            // Now, phoneNumber is a valid integer, proceed with the insertion
////			            insert.setString(7, String.valueOf(phoneNumber));
////			        
////			        } catch (SQLException ex) {
////			            ex.printStackTrace();
////			            // Handle the SQLException here if needed
////			            return;
////			        }
//
//				if (!phone.isEmpty()) {
//				    try {
//				        int phoneNumber = Integer.parseInt(phone);
//				        // Now, phoneNumber is a valid integer, proceed with the insertion
//				        insert.setString(10, String.valueOf(phoneNumber));
//				    } catch (NumberFormatException ex) {
//				        // Handle the case where the input is not a valid integer
//				        JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.");
//				        // You may choose to return from the method or take appropriate action
//				        return;
//				    } catch (SQLException ex) {
//				        ex.printStackTrace();
//				        // Handle the SQLException here if needed
//				        return;}
//				    }else {
//				        // Handle the case where the input is empty
//				        JOptionPane.showMessageDialog(frame, "Please enter a phone number.");
//				        // You may choose to return from the method or take appropriate action
//				        return;
//				    }
//
//				
//				
//				
//
////				  btnNewButton.addActionListener(new ActionListener() {
////					    public void actionPerformed(ActionEvent e) {
////
////					        String cust_id = JDrs13.getText();
////					        String FirstName = txtfname.getText();
////					        String LastName = txtlname.getText();
////					        String city = txtcity.getText();
////					        String state = txtstate.getText();
////					        String branch = comboBox.getSelectedItem().toString();
////					        String phone = txtphone.getText();
////
////					        // Validate if the phone is a valid integer
////					        
////					        try {
////					            int phoneNumber = Integer.parseInt(phone);
////					            // Now, phoneNumber is a valid integer, proceed with the insertion
////					            insert.setString(7, String.valueOf(phoneNumber));
////					        } catch (NumberFormatException ex) {
////					            // Handle the case where the input is not a valid integer
////					            JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.");
////					            // You may choose to return from the method or take appropriate action
////					            return;
////					        }
//				  
//				  
//				  
//
//					        try {
//					            con = DriverManager.getConnection("jdbc:mysql://localhost/pnbbank", "root", "");
//
//					            // Fix the SQL query
//					            String sql = "INSERT INTO customer (cust_id, FirstName, LastName, City, State, BranchName, PhoneNo) VALUES (?, ?, ?, ?, ?, ?, ?)";
//					            insert = con.prepareStatement(sql);
//
//					            insert.setString(1, cust_id);
//					            insert.setString(2, FirstName);
//					            insert.setString(3, LastName);
//					            insert.setString(4, city);
//					            insert.setString(5, state);
//					            insert.setString(6, branch);
//
//					            insert.executeUpdate();
//					            JOptionPane.showMessageDialog(frame, "Record added");
//					        } catch (SQLException e1) {
//					            e1.printStackTrace();
//					        } finally {
//					            // Close resources in a finally block to ensure they are always closed
//					            try {
//					                if (insert != null) {
//					                    insert.close();
//					                }
//					                if (con != null) {
//					                    con.close();
//					                }
//					            } catch (SQLException ex) {
//					                ex.printStackTrace();
//					            }
//					        }
//					    }
//					});
//				
//			
//		
//		btnNewButton.setBounds(39, 219, 85, 21);
//		frame.getContentPane().add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Cancel");
//		btnNewButton_1.setBounds(193, 219, 85, 21);
//		frame.getContentPane().add(btnNewButton_1);
//		
//		JLabel JDrs13 = new JLabel("JDrs13");
//		JDrs13.setForeground(new Color(255, 0, 0));
//		JDrs13.setFont(new Font("Tahoma", Font.BOLD, 15));
//		JDrs13.setBounds(160, 10, 85, 13);
//		frame.getContentPane().add(JDrs13);
//		
//		 comboBox = new JComboBox();
//		comboBox.setBounds(160, 165, 96, 21);
//		frame.getContentPane().add(comboBox);
//		
//		Label label = new Label("New label");
//		label.setBounds(35, 119, 59, 21);
//		frame.getContentPane().add(label);
//		
//		
//		txtstate = new JTextField();
//		txtstate.setBounds(170, 122, 96, 21);
//		frame.getContentPane().add(txtstate);
//
//
//	}
//	
//	
//	
//	private Connection con;
//	private PreparedStatement insert;
//	private Statement s;  
//
//	
//
//	public void autoID() {
//	    ResultSet rs = null;  // Declare ResultSet here
//
//	    try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
//	        s = con.createStatement();
//	        rs = s.executeQuery("SELECT MAX(cust_id) FROM customer");
//
//	        if (rs.next()) {
//	            String maxCustId = rs.getString(1);
//
//	            if (maxCustId == null) {
//	                JDrs13.setText("CS001");
//	            } else {
//	                long id = Long.parseLong(maxCustId.substring(2));
//	                id++;
//	                JDrs13.setText("CS" + String.format("%03d", id));
//	            }
//	        }
//	    } catch (ClassNotFoundException | SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        // Close resources in a finally block to ensure they are always closed
//	        try {
//	            if (rs != null) {
//	                rs.close();
//	            }
//	            if (s != null) {
//	                s.close();
//	            }
//	            if (con != null) {
//	                con.close();
//	            }
//	        } catch (SQLException ex) {
//	            ex.printStackTrace();
//	        }
//	    }
//	}
//
//
//	
//	
////	public void Branch() {
////		try {
////			Class.forName("com.mysql.cj.jdbc.Driver");
////			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank","root","");
////			insert = con.prepareStatement("SELECT*from branch");
////			ResultSet rs=insert.executeQuery();
////			comboBox.removeAllItems();
////			 while (rs.next()) {
////		            String branch = rs.getString("branch");
////		            comboBox.addItem(branch);
////				 comboBox.addItem(rs.getString(2));
////		        }
////
////		        // Close the ResultSet and PreparedStatement
////		       
////		    } catch (ClassNotFoundException ex) {
////		    	ex.printStackTrace();
////		    }catch (SQLException ex) {
////		    	ex.printStackTrace();
////		}
////	}	
////}
//
//		
//	public void Branch() {
//	    try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
//	        insert = con.prepareStatement("SELECT * FROM branch");
//	        ResultSet rs = insert.executeQuery();
//	        comboBox.removeAllItems();
//	        while (rs.next()) {
//	            String branch = rs.getString("branch");
//	            comboBox.addItem(branch);
//	            comboBox.addItem(rs.getString(2));
//	        }
//
//	        // Close the ResultSet and PreparedStatement
//	        rs.close();
//	        insert.close();
//	        con.close();
//	    } catch (ClassNotFoundException | SQLException ex) {
//	        ex.printStackTrace();
//	    }
//	}
//
//	
//	public void yourMethod() {
//	    PreparedStatement insert = null;
//
//	    try {
//	        // Create a PreparedStatement for your INSERT operation
//	        insert = con.prepareStatement("INSERT INTO customer (cust_id, FirstName, LastName, City, State, BranchName, PhoneNo) VALUES (?, ?, ?, ?, ?, ?, ?)");
//	        
//	        // Your existing code
//	        // ...
//
//	        // Add the new code for handling the phone number input
//	        String phone = txtphone.getText();
//	        if (!phone.isEmpty()) {
//	            try {
//	                int phoneNumber = Integer.parseInt(phone);
//	                // Now, phoneNumber is a valid integer, proceed with the insertion
//	                insert.setString(7, String.valueOf(phoneNumber));
//	            } catch (NumberFormatException ex) {
//	                // Handle the case where the input is not a valid integer
//	                JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.");
//	                // You may choose to return from the method or take appropriate action
//	                return;
//	            }
//	        } else {
//	            // Handle the case where the input is empty
//	            JOptionPane.showMessageDialog(frame, "Please enter a phone number.");
//	            // You may choose to return from the method or take appropriate action
//	            return;
//	        }
//
//	        // Your existing code continues...
//	        // Execute the insert statement
//	        insert.executeUpdate();
//	        JOptionPane.showMessageDialog(frame, "Record added");
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	        // Handle the SQLException here if needed
//	    } finally {
//	        try {
//	            // Close the insert PreparedStatement in the finally block
//	            if (insert != null) {
//	                insert.close();
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}}
//




package pnbbank;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B {

    private JFrame frame;
    private JTextField txtfname;
    private JTextField txtlname;
    private JTextField txtcity;
    private JTextField txtphone;
    private JTextField txtstate;

    private JLabel JDrs13;
    private JComboBox<String> comboBox;

    private Connection con;
    private PreparedStatement insert;
    private Statement s;

    /**
     * Create the application.
     */
    public B() {
        initialize();
        autoID();
        Branch();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("FirstName");
        lblNewLabel.setBounds(39, 35, 67, 13);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("LastName");
        lblNewLabel_1.setBounds(39, 58, 67, 13);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("City");
        lblNewLabel_2.setBounds(39, 81, 45, 13);
        frame.getContentPane().add(lblNewLabel_2);
         
        JLabel lblNewLabel_4 = new JLabel("Branch");
        lblNewLabel_4.setBounds(39, 141, 45, 13);
        frame.getContentPane().add(lblNewLabel_4);

        txtfname = new JTextField();
        txtfname.setBounds(170, 32, 96, 19);
        frame.getContentPane().add(txtfname);
        txtfname.setColumns(10);

        txtlname = new JTextField();
        txtlname.setBounds(170, 55, 96, 19);
        frame.getContentPane().add(txtlname);
        txtlname.setColumns(10);

        txtcity = new JTextField();
        txtcity.setBounds(170, 78, 96, 19);
        frame.getContentPane().add(txtcity);
        txtcity.setColumns(10);
        
        txtstate= new JTextField("CustNo");
        frame.getContentPane().add(txtstate);
        txtstate.setColumns(10);


        txtphone = new JTextField();
        txtphone.setBounds(160, 193, 96, 19);
        frame.getContentPane().add(txtphone);
        txtphone.setColumns(10);

        
        JDrs13 = new JLabel("JDrs13");
        JDrs13.setForeground(new Color(255, 0, 0));
        JDrs13.setFont(new Font("Tahoma", Font.BOLD, 15));
        JDrs13.setBounds(160, 10, 85, 13);
        frame.getContentPane().add(JDrs13);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });
        btnNewButton.setBounds(39, 219, 85, 21);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 frame.dispose();
        		
        		
        	}
        });
        btnNewButton_1.setBounds(193, 219, 85, 21);
        frame.getContentPane().add(btnNewButton_1);

        comboBox = new JComboBox();
        comboBox.setBounds(170, 141, 96, 21);
        frame.getContentPane().add(comboBox);

        Label label = new Label("State");
        label.setFont(new Font("Cambria", Font.BOLD, 10));
        label.setBounds(39, 100, 59, 21);
        frame.getContentPane().add(label);

        txtstate = new JTextField();
        txtstate.setBounds(170, 107, 96, 21);
        frame.getContentPane().add(txtstate);
        
        JLabel lblNewLabel_5 = new JLabel("Phone");
        lblNewLabel_5.setBounds(39, 196, 45, 13);
        frame.getContentPane().add(lblNewLabel_5);
    }

   
 // Add a method to initialize the insert PreparedStatement
    private void initializeInsertStatement() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/pnbbank", "root", "");
            String sql = "INSERT INTO customer (cust_id, FirstName, LastName, City, State, BranchName, PhoneNo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            insert = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Modify the addRecord method to call the initializeInsertStatement method
    private void addRecord() {
        initializeInsertStatement(); // Call the method to initialize the insert statement

        String cust_id = JDrs13.getText();
        String FirstName = txtfname.getText();
        String LastName = txtlname.getText();
        String city = txtcity.getText();
        String state = txtstate.getText();
        String branch = comboBox.getSelectedItem().toString();
        String phone = txtphone.getText();

        if (!phone.isEmpty()) {
            try {
                int phoneNumber = Integer.parseInt(phone);
                insert.setString(7, String.valueOf(phoneNumber));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid phone number.");
                return;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return;
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter a phone number.");
            return;
        }

        try {
            insert.setString(1, cust_id);
            insert.setString(2, FirstName);
            insert.setString(3, LastName);
            insert.setString(4, city);
            insert.setString(5, state);
            insert.setString(6, branch);

            insert.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Record added");
            
            txtfname.setText("");
            txtlname.setText("");
            txtcity.setText("");
            txtstate.setText("");
            comboBox.setSelectedIndex(-1);
            txtphone.setText("");
            autoID();
            txtfname.requestFocus();
            
            
            
            
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (insert != null) {
                    insert.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    
    
    private void autoID() {
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
            s = con.createStatement();
            rs = s.executeQuery("SELECT MAX(cust_id) FROM customer");

            if (rs.next()) {
                String maxCustId = rs.getString(1);

                if (maxCustId == null) {
                    JDrs13.setText("CS001");
                } else {
                    long id = Long.parseLong(maxCustId.substring(2));
                    id++;
                    JDrs13.setText("CS" + String.format("%03d", id));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (s != null) {
                    s.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void Branch() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
            insert = con.prepareStatement("SELECT * FROM branch");
            ResultSet rs = insert.executeQuery();
            comboBox.removeAllItems();
            while (rs.next()) {
                String branch = rs.getString("branch");
                comboBox.addItem(branch);
                comboBox.addItem(rs.getString(2));
            }

            rs.close();
            insert.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
    
    public static void main(String[] args) {
        NewScreen();
    }

    public static void NewScreen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    B window = new B();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

