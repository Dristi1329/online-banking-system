package pnbbank;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Account extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtcustid;
	private JTextField txtcustname;
	private JTextField txtbalance;
	 private JLabel txtaccno;
    private Statement s;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account frame = new Account();
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
	
	Connection con;
	PreparedStatement insert;
	ResultSet rs;
	
	
	public Account() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account No");
		lblNewLabel.setBounds(21, 30, 58, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Id");
		lblNewLabel_1.setBounds(21, 75, 79, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setBounds(10, 126, 90, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Account type");
		lblNewLabel_3.setBounds(10, 173, 90, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Balance");
		lblNewLabel_4.setBounds(21, 210, 58, 13);
		getContentPane().add(lblNewLabel_4);
		
//		JLabel txtaccno = new JLabel("JDrs13");
//		txtaccno.setFont(new Font("Tahoma", Font.BOLD, 15));
//		txtaccno.setBounds(143, 30, 82, 13);
//		getContentPane().add(txtaccno);
//		
		txtcustid = new JTextField();
		txtcustid.setBounds(129, 72, 96, 19);
		getContentPane().add(txtcustid);
		txtcustid.setColumns(10);
		
		txtcustname = new JTextField();
		txtcustname.setBounds(129, 123, 96, 19);
		getContentPane().add(txtcustname);
		txtcustname.setColumns(10);
		
		txtbalance = new JTextField();
		txtbalance.setBounds(143, 210, 96, 19);
		getContentPane().add(txtbalance);
		txtbalance.setColumns(10);
		
		
		txtaccno = new JLabel("A0001");  // Initialize JDrs13 label
		txtaccno.setForeground(new Color(0, 0, 255));
		txtaccno.setBackground(new Color(0, 0, 255));
	    txtaccno.setFont(new Font("Tahoma", Font.BOLD, 15));
	    txtaccno.setBounds(143, 30, 82, 13);
	    getContentPane().add(txtaccno);
		
		
		JComboBox txtacctype = new JComboBox();
		txtacctype.setModel(new DefaultComboBoxModel(new String[] {"Saving", "Fix", "Current"}));
		txtacctype.setBounds(143, 169, 107, 21);
		getContentPane().add(txtacctype);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String account_no=txtaccno.getText();
					String customerid=txtcustid.getText();
					String cusomername=txtcustname.getText();
					String acctype = txtacctype.getSelectedItem().toString();
					String balance=txtbalance.getText();					
					
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost/pnbbank","root","");
					insert=con.prepareStatement("INSERT INTO accout_details(acc_id,cust_id,acc_type,Balance)VALUES(?,?,?,?)");
					insert.setString(1, account_no);
					insert.setString(2, customerid);
					insert.setString(3, acctype);
					insert.setString(4, balance);
					insert.executeUpdate();
					JOptionPane.showMessageDialog(Account.this, "Account Created");
					
					
					txtcustid.setText("");
					txtcustname.setText("");
					txtbalance.setText("");
					txtacctype.setSelectedIndex(-1);
					
					autoID();
					txtcustid.requestFocus();
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				
				
				
			}
		});
		btnNewButton.setBounds(311, 71, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(311, 147, 85, 21);
		getContentPane().add(btnNewButton_1);
		


		
		
		JButton btnNewButton_2 = new JButton("Find");
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String cust_id = txtcustid.getText();
		        try {
		            // Initialize the connection before preparing the statement
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");

		            // Prepare the statement and execute the query
		            insert = con.prepareStatement("SELECT * FROM customer WHERE cust_id=?");
		            insert.setString(1, cust_id);
		            rs = insert.executeQuery();

		            // Process the result
		            if (rs.next() == false) {
		                JOptionPane.showMessageDialog(Account.this, "Customer is not found");
		            } else {
		                String firstName = rs.getString("FirstName");
		                txtcustname.setText(firstName.trim());
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        } finally {
		            // Close resources in a finally block
		            try {
		                if (rs != null) {
		                    rs.close();
		                }
		                if (insert != null) {
		                    insert.close();
		                }
		                if (con != null) {
		                    con.close();
		                }
		            } catch (SQLException e2) {
		                e2.printStackTrace();
		            }
		        }
		    }
		});
		btnNewButton_2.setBounds(311, 26, 85, 21);
		getContentPane().add(btnNewButton_2);
}



	 private void autoID() {
	        ResultSet rs = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pnbbank", "root", "");
	            s = con.createStatement();
	            rs = s.executeQuery("SELECT MAX(acc_id) FROM accout_details");

	            if (rs.next()) {
	                String maxaccid= rs.getString(1);

	                if (maxaccid == null) {
	                    txtaccno.setText("A0001");
	                } else {
	                	String numericPart = maxaccid.substring(1);
	                    long id = Long.parseLong(maxaccid.substring(2));
	                    id++;
	                    txtaccno.setText("A" + String.format("%04d", id));
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
	    }}