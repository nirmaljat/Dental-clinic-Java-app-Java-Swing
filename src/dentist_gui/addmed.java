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

public class addmed extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField qua;
	private JTextField ap_id;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addmed frame = new addmed();
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
	public addmed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1054, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD MEDICINE DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(126, 21, 198, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Medicine Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(23, 86, 120, 31);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(190, 93, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		qua = new JTextField();
		qua.setColumns(10);
		qua.setBounds(190, 141, 96, 19);
		contentPane.add(qua);
		
		ap_id = new JTextField();
		ap_id.setColumns(10);
		ap_id.setBounds(190, 184, 96, 19);
		contentPane.add(ap_id);
		
		JLabel lblNewLabel_1_1 = new JLabel("Medicine Quantity");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(23, 127, 120, 31);
		contentPane.add(lblNewLabel_1_1);

		JTextArea print = new JTextArea();
		print.setBounds(482, 57, 479, 279);
		contentPane.add(print);
		
		JLabel lblNewLabel_1_2 = new JLabel("Appoinmnet ID");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(23, 168, 120, 31);
		contentPane.add(lblNewLabel_1_2);
		
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
			      
			      String n=name.getText();
				   String    quan=qua.getText();
				   int q=Integer.parseInt(quan);
				   String ap=ap_id.getText();
				  
				   int a=Integer.parseInt(ap);
				  
				   
				   String query1 = "insert into medicine values ("+a+","+q+",'"+n+"')";
				   
				   int rs1 = stmt.executeUpdate(query1);	
				   JOptionPane.showMessageDialog(null,"Data Added");
			}
				catch(Exception e2) 
				{
					System.out.println(e2.toString());
				}
			
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(40, 222, 103, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
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
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(190, 222, 103, 31);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("PRINT TABLE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(651, 21, 120, 26);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("print Table");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				      //Getting the connection
				      String oracleUrl = "jdbc:oracle:thin:@localhost:1521/xe";
				      Connection con = DriverManager.getConnection(oracleUrl, "nirmal", "nirmal");
				     
				      Statement stmt = con.createStatement();
				      //Query to create a table
				      String query = " SELECT * FROM  Medicine order by appoinment_id";
				      String a,b ="";
				      
				      ResultSet rs = stmt.executeQuery(query);	
				      System.out.println("Table contents are displayed......");
				      a="Appoinment_id\tQuantity\tName\n";
				      b=b+a;
				      while(rs.next()) 
				      {
				  		a=(rs.getInt(1) + "\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\n");
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(86, 288, 155, 26);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ap_id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(315, 96, 96, 19);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(376, 98, 96, 19);
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
				      String query = " SELECT * FROM  Medicine where appoinment_id="+te+"";
				      String a,b ="";
				      
				      ResultSet rs = stmt.executeQuery(query);	
				      System.out.println("Table contents are displayed......");
				      a="Appoinment_id\tQuantity\tName\n";
				      b=b+a;
				      while(rs.next()) 
				      {
				  		a=(rs.getInt(1) + "\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\n");
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
		btnNewButton_2.setBounds(343, 140, 85, 21);
		contentPane.add(btnNewButton_2);
		
	}
}
