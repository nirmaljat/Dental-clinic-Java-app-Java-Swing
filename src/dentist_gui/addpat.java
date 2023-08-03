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
import javax.swing.JTextArea;

public class addpat extends JFrame {

	private JPanel contentPane;
	private JTextField nam;
	private JTextField p_id;
	private JTextField ag;
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
					addpat frame = new addpat();
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
	public addpat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1113, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD Patient Details");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(175, 10, 383, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(26, 75, 73, 25);
		contentPane.add(lblNewLabel_1);
		
		nam = new JTextField();
		nam.setBounds(113, 80, 96, 19);
		contentPane.add(nam);
		nam.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Patient ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(26, 110, 73, 25);
		contentPane.add(lblNewLabel_1_1);
		
		p_id = new JTextField();
		p_id.setColumns(10);
		p_id.setBounds(113, 115, 96, 19);
		contentPane.add(p_id);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact NO");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(26, 180, 96, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		ag = new JTextField();
		ag.setBounds(113, 150, 96, 19);
		contentPane.add(ag);
		ag.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Age");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(26, 145, 73, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		con_no = new JTextField();
		con_no.setColumns(10);
		con_no.setBounds(113, 185, 96, 19);
		contentPane.add(con_no);
		JTextArea print = new JTextArea();
		print.setBounds(494, 83, 487, 273);
		contentPane.add(print);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Address");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(26, 215, 96, 25);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		addr = new JTextField();
		addr.setBounds(113, 220, 96, 19);
		contentPane.add(addr);
		addr.setColumns(10);
		
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
				   String    a=ag.getText();
				   int age=Integer.parseInt(a);
				   String ad=addr.getText();
				   String P_id=p_id.getText();
				   int pa_id=Integer.parseInt(P_id);
				   String C_no=con_no.getText();
				   int co_no=Integer.parseInt(C_no);
				   
				   String query1 = "insert into patient values ("+pa_id+",'"+n+"',"+co_no+","+age+",'"+ad+"')";
				   
				   int rs1 = stmt.executeUpdate(query1);	
				   JOptionPane.showMessageDialog(null,"Data Added");
				   }
				 catch(Exception e2) {
					   System.out.println(e2.toString()); 
				   }
			}
		});
		btnNewButton.setBounds(325, 124, 115, 30);
		contentPane.add(btnNewButton);
		
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
		btnBack.setBounds(325, 184, 115, 30);
		contentPane.add(btnBack);
		
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
				      String query = " SELECT * FROM  patient order by patient_id";
				      String a,b ="";
				      
				      ResultSet rs = stmt.executeQuery(query);	
				      System.out.println("Table contents are displayed......");
				      a="Patient_id_id\tName\tPhone_no\tAge\tAddress\n";
				      b=b+a;
				      while(rs.next()) 
				      {
				  		a=(rs.getInt(1) + "\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\n");
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
		btnNewButton_1_1.setBounds(325, 234, 132, 38);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("TABLE PRINT");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(658, 35, 231, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("patient_id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(54, 356, 81, 19);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(155, 358, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
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
				      String query = " SELECT * FROM  patient where patient_id="+te+"";
				      String a,b ="";
				      
				      ResultSet rs = stmt.executeQuery(query);	
				      System.out.println("Table contents are displayed......");
				      a="Patient_id_id\tName\tPhone_no\tAge\tAddress\n";
				      b=b+a;
				      while(rs.next()) 
				      {
				  		a=(rs.getInt(1) + "\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\n");
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
		btnNewButton_1.setBounds(83, 412, 85, 21);
		contentPane.add(btnNewButton_1);
		
		
	}
}
