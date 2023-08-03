package dentist_gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class adden extends JFrame {

	private JPanel contentPane;
	private JTextField nam;
	private JTextField d_id;
	private JTextField qu;
	private JTextField con_no;
	private JTextField addr;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adden frame = new adden();
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
	public adden() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.CENTER);
		contentPane_1.setLayout(null);
		
		JLabel lblAddDentistDetails = new JLabel("ADD Dentist Details");
		lblAddDentistDetails.setBounds(175, 10, 383, 44);
		lblAddDentistDetails.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		contentPane_1.add(lblAddDentistDetails);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(26, 75, 73, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane_1.add(lblNewLabel_1);
		
		nam = new JTextField();
		nam.setBounds(123, 80, 96, 19);
		nam.setColumns(10);
		contentPane_1.add(nam);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dentist ID");
		lblNewLabel_1_1.setBounds(26, 110, 73, 25);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane_1.add(lblNewLabel_1_1);
		
		d_id = new JTextField();
		d_id.setBounds(123, 115, 96, 19);
		d_id.setColumns(10);
		contentPane_1.add(d_id);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact NO");
		lblNewLabel_1_1_1.setBounds(26, 180, 96, 25);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane_1.add(lblNewLabel_1_1_1);
		
		qu = new JTextField();
		qu.setBounds(123, 150, 96, 19);
		qu.setColumns(10);
		contentPane_1.add(qu);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Qulification");
		lblNewLabel_1_1_1_1.setBounds(26, 145, 96, 25);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane_1.add(lblNewLabel_1_1_1_1);
		
		con_no = new JTextField();
		con_no.setBounds(123, 185, 96, 19);
		con_no.setColumns(10);
		contentPane_1.add(con_no);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Address");
		lblNewLabel_1_1_1_2.setBounds(26, 215, 96, 25);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane_1.add(lblNewLabel_1_1_1_2);
		
		JTextArea print = new JTextArea();
		print.setBounds(457, 51, 497, 287);
		contentPane_1.add(print);
		
		addr = new JTextField();
		addr.setBounds(123, 220, 96, 19);
		addr.setColumns(10);
		contentPane_1.add(addr);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                  try
                  {
				   DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				      //Getting the connection
				      String oracleUrl = "jdbc:oracle:thin:@localhost:1521/xe";
				      Connection con = DriverManager.getConnection(oracleUrl, "nirmal", "nirmal");
				      System.out.println("Connection established......");
				      //Creating the Statement
				      Statement stmt = con.createStatement();
				      //Query to create a table
				      
				   String n=nam.getText();
				   String    q=qu.getText();
				   String ad=addr.getText();
				   String D_id=d_id.getText();
				   int de_id=Integer.parseInt(D_id);
				   String C_no=con_no.getText();
				   int co_no=Integer.parseInt(C_no);
				   
                  String query1 = "insert into Dentist values ("+de_id+",'"+n+"',"+co_no+",'"+q+"','"+ad+"')";
				   
				   int rs1 = stmt.executeUpdate(query1);	
				   JOptionPane.showMessageDialog(null,"Data Added");
                  }
                  catch(Exception e2) {
					   System.out.println(e2.toString()); 
				   }
			}
		});
		btnNewButton.setBounds(301, 109, 115, 30);
		contentPane_1.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					setVisible(false);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(301, 179, 115, 30);
		contentPane_1.add(btnBack);
		
		JButton btnNewButton_1 = new JButton("PRINT TABLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				 
			      //Getting the connection
			      String oracleUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			      Connection con = DriverManager.getConnection(oracleUrl, "nirmal", "nirmal");
			     
			      Statement stmt = con.createStatement();
			      //Query to create a table
			      String query = " SELECT * FROM  Dentist order by dentist_id";
			      String a,b="";
			      
			      
			      ResultSet rs = stmt.executeQuery(query);	
			      System.out.println("Table contents are displayed......");
			      a="Dentist_id\tName\tPhone_no\tQualification\tAddress\n";
			      b=b+a;
			      while(rs.next()) 
			      {
			  		a=(rs.getInt(1) + "\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\n");
			  		b=b+a;
			  		}
			      try
			      {
			    	  
			    	  
			      print.setText(b);
			      }
			      catch(Exception e4)
			      {
			    	  e4.printStackTrace();
			      }
			      con.close();
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(301, 259, 115, 38);
		contentPane_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("TABLE PRINT");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(646, 22, 231, 19);
		contentPane_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(109, 329, 96, 19);
		contentPane_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dentist_id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 332, 73, 13);
		contentPane_1.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				      //Getting the connection
				      String oracleUrl = "jdbc:oracle:thin:@localhost:1521/xe";
				      Connection con = DriverManager.getConnection(oracleUrl, "nirmal", "nirmal");
				     
				      Statement stmt = con.createStatement();
				      //Query to create a table
				      String temp=textField.getText();
				      int te=Integer.parseInt(temp);
				      String query = " SELECT * FROM  Dentist Where Dentist_id="+te+"";
				      String a,b="";
				      
				      
				      ResultSet rs = stmt.executeQuery(query);	
				      System.out.println("Table contents are displayed......");
				      a="Dentist_id\tName\tPhone_no\tQualification\tAddress\n";
				      b=b+a;
				      while(rs.next()) 
				      {
				  		a=(rs.getInt(1) + "\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\n");
				  		b=b+a;
				  		}
				      try
				      {
				    	  
				    	  
				      print.setText(b);
				      }
				      catch(Exception e4)
				      {
				    	  e4.printStackTrace();
				      }
				      con.close();
					}
					catch(Exception e3)
					{
						e3.printStackTrace();
					}
			}
		});
		btnNewButton_2.setBounds(37, 358, 85, 21);
		contentPane_1.add(btnNewButton_2);
		
		
	}
}
