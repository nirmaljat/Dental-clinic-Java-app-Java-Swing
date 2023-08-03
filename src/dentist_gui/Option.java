package dentist_gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Option extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Option frame = new Option();
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
	public Option() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OPTION PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(256, 25, 175, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADD NEW Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					addpat a=new addpat();
					a.setVisible(true);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(72, 92, 198, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADD new Dentist");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					adden ad=new adden();
					ad.setVisible(true);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(365, 92, 198, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("NEW Appoinment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					addap ad=new addap();
					ad.setVisible(true);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(72, 205, 198, 49);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("ADD PATIENT Medicine DETAILS");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					addmed ad=new addmed();
					ad.setVisible(true);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setBounds(365, 205, 198, 49);
		contentPane.add(btnNewButton_2_1);
	}
}
