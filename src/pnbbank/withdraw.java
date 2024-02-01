package pnbbank;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class withdraw extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw frame = new withdraw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	Connection conn;
	PreparedStatement insert;
	PreparedStatement update;
	ResultSet rs;
	
	public withdraw() {
		setBounds(100, 100, 450, 300);
		JLabel label = new JLabel("Enter the Account No");
		label.setFont(new Font("Cambria", Font.BOLD, 20));
		label.setBounds(10, 28, 256, 33);
		getContentPane().add(label);
		
		TextField accno = new TextField();
		accno.setBounds(10, 85, 243, 33);
		getContentPane().add(accno);
		
		JLabel label_1 = new JLabel("Customer No");
		label_1.setBounds(10, 124, 80, 21);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setBounds(10, 157, 80, 21);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setBounds(10, 184, 80, 21);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Date");
		label_4.setBounds(10, 221, 59, 21);
		getContentPane().add(label_4);
		
		JLabel cust_id = new JLabel("jLabel1");
		cust_id.setBounds(112, 124, 59, 21);
		getContentPane().add(cust_id);
		
		JLabel firstname = new JLabel("jLabel2");
		firstname.setBounds(112, 157, 59, 21);
		getContentPane().add(firstname);
		
		JLabel lastname = new JLabel("jLabel3");
		lastname.setBounds(112, 184, 59, 21);
		getContentPane().add(lastname);
		
		JLabel date = new JLabel("jLabel4");
		date.setBounds(112, 221, 59, 21);
		getContentPane().add(date);
		
		JLabel jLabel4 = new JLabel();
        jLabel4.setBounds(122, 222, 150, 25);
        getContentPane().add(jLabel4);
		
		
		
		
		JLabel balance = new JLabel("Balance");
		balance.setBounds(344, 10, 59, 21);
		getContentPane().add(balance);
		
		JLabel label_10 = new JLabel("jLabel5");
		label_10.setBounds(344, 54, 59, 21);
		getContentPane().add(label_10);
		
		JLabel lblWithdraw = new JLabel("withdraw");
		lblWithdraw.setFont(new Font("Dialog", Font.BOLD, 15));
		lblWithdraw.setBounds(317, 101, 86, 33);
		getContentPane().add(lblWithdraw);
		
		TextField amount = new TextField();
		amount.setBackground(new Color(255, 255, 0));
		amount.setBounds(286, 157, 130, 33);
		getContentPane().add(amount);
		amount.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	 String acc_no=accno.getText();
			    	String custid=cust_id.getText();
			    	String First_name=firstname.getText();
			    	String Last_name=lastname.getText();
			    	String Date=date.getText();
			    	String Balance=balance.getText();
			    	String ammount=amount.getText();
	    		 
		    	
		    	 try {
		    		 
		    		
		    		 
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	 try {
					conn=DriverManager.getConnection("jdbc:mysql://localhost/pnbbank","root","");
					insert=conn.prepareStatement("INSERT INTO deposit(acc_id,cust_id,date,Balance,deposit)VALUES(?,?,?,?,?)");
					insert.setString(1,acc_no);
					insert.setString(2,custid);
					insert.setString(3,Date);
					insert.setString(4,Balance);
					insert.setString(5,ammount);
					
					
					update=conn.prepareStatement("UPDATE accout_details set balance=balance ? WHERE acc_id=?");
					update.setString(1, ammount);
					update.setString(2, acc_no);


					insert.executeUpdate();
					
					JOptionPane.showMessageDialog(withdraw.this, "Deposit...");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	 
		    	
		    	
		    	 finally {
		    		    // Close resources and perform cleanup

		    		    // Close the connection
		    		    if (conn != null) {
		    		        try {
		    		            conn.close();
		    		        } catch (SQLException ex) {
		    		            ex.printStackTrace();
		    		        }
		    	
		        // Your action event handling code here
		    		    }}}
		});
		
		
		Button button = new Button("OK");
		button.addActionListener(new ActionListener() {
			
		
		
			
			
			public void actionPerformed(ActionEvent e) {
		        String acc_no = accno.getText();
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");

		            // Implement logic to fetch customer details and account balance based on the entered account number
		            String query = "SELECT c.*, a.balance FROM customer c JOIN accout_details a ON c.cust_id = a.cust_id WHERE a.acc_id = ?";
		            PreparedStatement stmt = conn.prepareStatement(query);
		            stmt.setString(1, acc_no);
		            ResultSet rs = stmt.executeQuery();

		            if (rs.next()) {
		                // Populate the labels with the retrieved customer details and account balance
		                cust_id.setText(rs.getString("cust_id"));
		                firstname.setText(rs.getString("FirstName"));
		                lastname.setText(rs.getString("LastName"));
		                // Add label for balance
		                label_10.setText(rs.getString("balance"));
		                // ... Add other labels accordingly

		                // Show deposit message
		                JOptionPane.showMessageDialog(withdraw.this, "Deposit...");
		            } else {
		                // Handle case when account number is not found
		                JOptionPane.showMessageDialog(null, "Account number not found", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		        } catch (ClassNotFoundException | SQLException ex) {
		            ex.printStackTrace();
		        } finally {
		            // Close the connection in an appropriate location
		            if (conn != null) {
		                try {
		                    conn.close();
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        }
		    }
			
			
			
		
		});
		
		
		
		
		
		button.setBounds(255, 221, 66, 21);
		getContentPane().add(button);
		
		Button button_1 = new Button("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				dispose();
			}
		});
		button_1.setBounds(362, 221, 66, 21);
		getContentPane().add(button_1);
		
		
		
		Connection con;
		PreparedStatement insert;
		ResultSet rs;
		
//		JButton btnNewButton = new JButton("Find");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				String accno=textField.getText();
//				 try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//		            try {
//						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				
//				
//				
//			}
//		});
		
		
		
		
		
//		JButton btnNewButton = new JButton("Find");
//
//        // Declare a final reference variable to hold the connection
//        final Connection[] connectionHolder = {null};
//
//        btnNewButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String accno = textField.getText();
//                try {
//                    Class.forName("com.mysql.cj.jdbc.Driver");
//                    connectionHolder[0] = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
//                    
////                    insert=con.prepareStatement("SELECT c.cust_id,c.FirstName,c.LastName,a.Balance from customer c,accout_details a WHERE c.cust_id=a.cust_id and a.cust_id=?");
////                    insert.setString(1, accno);
////                    rs=insert.executeQuery();
////                    
//                   
//                    
//                    
//                    
//                    
//                    // Implement logic to fetch customer details based on the entered account number
//                    String query = "SELECT * FROM customer WHERE acc_no = ?";
//                    PreparedStatement stmt = connectionHolder[0].prepareStatement(query);
//                    stmt.setString(1, accno);
//                    ResultSet rs = stmt.executeQuery();
//
//                    if (rs.next()) {
//                        // Populate the labels with the retrieved customer details
//                        label_5.setText(rs.getString("cust_no"));
//                        label_6.setText(rs.getString("FirstName"));
//                        label_7.setText(rs.getString("LastName"));
//                        // ... Add other labels accordingly
//                    } else {
//                        // Handle case when account number is not found
//                        JOptionPane.showMessageDialog(null, "Account number not found", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                } catch (ClassNotFoundException | SQLException ex) {
//                    ex.printStackTrace();
//                } finally {
//                    // Close the connection in an appropriate location
//                    if (connectionHolder[0] != null) {
//                        try {
//                            connectionHolder[0].close();
//                        } catch (SQLException ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                }
//            }
//        });
//        btnNewButton.setBounds(181, 124, 85, 21);
//        getContentPane().add(btnNewButton);
//    }
//
//	}
//

		
		
		
//		JButton btnNewButton = new JButton("Find");
//
//		// Declare a final reference variable to hold the connection
//		final Connection[] connectionHolder = {null};
//
//		btnNewButton.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        String accno = textField.getText();
//		        try {
//		            Class.forName("com.mysql.cj.jdbc.Driver");
//		            connectionHolder[0] = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
//		            
//		            // Implement logic to fetch customer details based on the entered account number
//		            String query = "SELECT * FROM customer WHERE acc_no = ?";
//		            PreparedStatement stmt = connectionHolder[0].prepareStatement(query);
//		            stmt.setString(1, accno);
//		            ResultSet rs = stmt.executeQuery();
//
//		            if (rs.next()) {
//		                // Populate the labels with the retrieved customer details
//		                label_5.setText(rs.getString("cust_no"));
//		                label_6.setText(rs.getString("FirstName"));
//		                label_7.setText(rs.getString("LastName"));
//		                // ... Add other labels accordingly
//		            } else {
//		                // Handle case when account number is not found
//		                JOptionPane.showMessageDialog(null, "Account number not found", "Error", JOptionPane.ERROR_MESSAGE);
//		            }
//
//		        } catch (ClassNotFoundException | SQLException ex) {
//		            ex.printStackTrace();
//		        } finally {
//		            // Close the connection in an appropriate location
//		            if (connectionHolder[0] != null) {
//		                try {
//		                    connectionHolder[0].close();
//		                } catch (SQLException ex) {
//		                    ex.printStackTrace();
//		                }
//		            }
//		        }
//		    }
//		});
//		btnNewButton.setBounds(181, 124, 85, 21);
//		getContentPane().add(btnNewButton);

		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Find");

		// Declare a final reference variable to hold the connection
		final Connection[] connectionHolder = {null};
//
		btnNewButton.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        String acc_no = textField.getText();
//		        try {
//		            Class.forName("com.mysql.cj.jdbc.Driver");
//		            connectionHolder[0] = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
//		            
//		            // Implement logic to fetch customer details based on the entered account number
//		            String query = "SELECT * FROM customer WHERE cust_id = ?";
//		            PreparedStatement stmt = connectionHolder[0].prepareStatement(query);
//		            stmt.setString(1, acc_no);
//		            ResultSet rs = stmt.executeQuery();
//
//		            if (rs.next()) {
//		                // Populate the labels with the retrieved customer details
//		                label_5.setText(rs.getString("cust_no"));
//		                label_6.setText(rs.getString("FirstName"));
//		                label_7.setText(rs.getString("LastName"));
//		                // ... Add other labels accordingly
//		            } else {
//		                // Handle case when account number is not found
//		                JOptionPane.showMessageDialog(null, "Account number not found", "Error", JOptionPane.ERROR_MESSAGE);
//		            }
//
//		        } catch (ClassNotFoundException | SQLException ex) {
//		            ex.printStackTrace();
//		        } finally {
//		            // Close the connection in an appropriate location
//		            if (connectionHolder[0] != null) {
//		                try {
//		                    connectionHolder[0].close();
//		                } catch (SQLException ex) {
//		                    ex.printStackTrace();
//		                }
//		            }
//		        }
//		    }
//		});
//		btnNewButton.setBounds(181, 124, 85, 21);
//		getContentPane().add(btnNewButton);
//}}
//		        
		
		  
			
			
			public void actionPerformed(ActionEvent e) {
			    String acc_no = accno.getText();
			    try {
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        connectionHolder[0] = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");

			        // Implement logic to fetch customer details and account balance based on the entered account number
			        String query = "SELECT c.*, a.balance FROM customer c JOIN accout_details a ON c.cust_id = a.cust_id WHERE a.acc_id = ?";
			        PreparedStatement stmt = connectionHolder[0].prepareStatement(query);
			        stmt.setString(1, acc_no);
			        ResultSet rs = stmt.executeQuery();

			        if (rs.next()) {
			            // Populate the labels with the retrieved customer details and account balance
			            cust_id.setText(rs.getString("cust_id"));
			            firstname.setText(rs.getString("FirstName"));
			            lastname.setText(rs.getString("LastName"));
			            // Add label for balance
			            label_10.setText(rs.getString("balance"));
			            // ... Add other labels accordingly
			        } else {
			            // Handle case when account number is not found
			            JOptionPane.showMessageDialog(null, "Account number not found", "Error", JOptionPane.ERROR_MESSAGE);
			        }

			    } catch (ClassNotFoundException | SQLException ex) {
			        ex.printStackTrace();
			    } finally {
			        // Close the connection in an appropriate location
			        if (connectionHolder[0] != null) {
			            try {
			                connectionHolder[0].close();
			            } catch (SQLException ex) {
			                ex.printStackTrace();
			            }
			        }
			    }
			}
		});
		btnNewButton.setBounds(181, 124, 85, 21);
		getContentPane().add(btnNewButton);
		
		
		date();
		
}
public void date() {
    DateTimeFormatter dtd = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    String date = dtd.format(now);
    jLabel4.setText(date);
}

	}


