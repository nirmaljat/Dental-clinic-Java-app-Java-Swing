package dentist_gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;


public class addap extends JFrame {

	private JPanel contentPane;
	private JTextField p_id;
	private JTextField d_id;
	private JTextField date;
	private JTextField time;
	private JTextField ap_id;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addap frame = new addap();
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
	public addap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JTextArea print = new JTextArea();
		print.setBounds(541, 77, 504, 259);
		contentPane.add(print);
		
		JLabel lblNewLabel = new JLabel("ADD APIONMENT DETAILS");
		lblNewLabel.setBounds(145, 10, 378, 32);
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID");
		lblNewLabel_1.setBounds(37, 77, 73, 32);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dentist ID");
		lblNewLabel_1_1.setBounds(37, 119, 73, 32);
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Appoinment DATE");
		lblNewLabel_1_2.setBounds(37, 161, 115, 32);
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Appoinment Time");
		lblNewLabel_1_3.setBounds(37, 203, 113, 32);
		lblNewLabel_1_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_3);
		
		p_id = new JTextField();
		p_id.setBounds(181, 85, 96, 19);
		contentPane.add(p_id);
		p_id.setColumns(10);
		
		d_id = new JTextField();
		d_id.setBounds(181, 127, 96, 19);
		contentPane.add(d_id);
		d_id.setColumns(10);
		
		date = new JTextField();
		date.setBounds(181, 169, 96, 19);
		contentPane.add(date);
		date.setColumns(10);
		
		time = new JTextField();
		time.setBounds(181, 211, 96, 19);
		contentPane.add(time);
		time.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
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
				      
				      String D_id=d_id.getText();
					  int de_id=Integer.parseInt(D_id);
					  String P_id=p_id.getText();
					  int pa_id=Integer.parseInt(P_id);
					  String A_id=ap_id.getText();
					  int app_id=Integer.parseInt(A_id);
					  String tm=time.getText();	
					  
					  String da=date.getText();
					 

					  
					  
					  
					  String query1 = "insert into Appoinment values ("+app_id+","+pa_id+","+de_id+",'"+da+" ','"+tm+"')";
					  int rs1 = stmt.executeUpdate(query1);	
					   JOptionPane.showMessageDialog(null,"Data Added");
                 }
				 catch(Exception E)
				 {
					 System.out.println(E.toString()); 
				 }
			}
		});
		btnNewButton.setBounds(341, 168, 105, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_4 = new JLabel("Appoinment ID");
		lblNewLabel_1_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(37, 41, 98, 32);
		contentPane.add(lblNewLabel_1_4);
		
		ap_id = new JTextField();
		ap_id.setColumns(10);
		ap_id.setBounds(181, 49, 96, 19);
		contentPane.add(ap_id);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setBounds(341, 210, 105, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("PRINT TABLE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				      //Getting the connection
				      String oracleUrl = "jdbc:oracle:thin:@localhost:1521/xe";
				      Connection con = DriverManager.getConnection(oracleUrl, "nirmal", "nirmal");
				     
				      Statement stmt = con.createStatement();
				      //Query to create a table
				      String query = " SELECT * FROM  appoinment order by appoinment_id";
				      String a,b ="";
				      
				      ResultSet rs = stmt.executeQuery(query);	
				      System.out.println("Table contents are displayed......");
				      a="Appionment_id \tpatient_id\tDentist_id\tDate\tTime\n";
				      b=b+a;
				      while(rs.next()) 
				      {
				  		a=(rs.getInt(1) + "\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\n");
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
		btnNewButton_1_1.setBounds(341, 113, 155, 38);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("TABLE PRINT");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(599, 23, 231, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AP_id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(46, 350, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(147, 349, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
				      String query = " SELECT * FROM  appoinment Where appoinment_id="+te+"";
				      String a,b ="";
				      
				      ResultSet rs = stmt.executeQuery(query);	
				      System.out.println("Table contents are displayed......");
				      a="Appionment_id \tpatient_id\tDentist_id\tDate\tTime\n";
				      b=b+a;
				      while(rs.next()) 
				      {
				  		a=(rs.getInt(1) + "\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\n");
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
		btnNewButton_2.setBounds(60, 409, 85, 21);
		contentPane.add(btnNewButton_2);
		
	}
}
