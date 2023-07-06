package registration_page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class registration_page {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration_page window = new registration_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(226, 221, 249));
		frame.setBounds(100, 100, 672, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(181, 25, 298, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(89, 110, 167, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Roll Number");
		lblNewLabel_1_1.setFont(new Font("Rockwell", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(89, 165, 167, 38);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Rockwell", Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(89, 221, 167, 38);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setFont(new Font("Rockwell", Font.ITALIC, 20));
		lblNewLabel_1_3.setBounds(89, 269, 167, 38);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		t1 = new JTextField();
		t1.setBounds(280, 110, 203, 38);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(280, 165, 203, 38);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(280, 221, 203, 38);
		frame.getContentPane().add(t3);
		
		JRadioButton r1 = new JRadioButton("Male");
		r1.setFont(new Font("Rockwell", Font.PLAIN, 18));
		r1.setBounds(280, 279, 74, 21);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
		r2.setFont(new Font("Rockwell", Font.PLAIN, 18));
		r2.setBounds(371, 279, 108, 21);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Password");
		lblNewLabel_1_3_1.setFont(new Font("Rockwell", Font.ITALIC, 20));
		lblNewLabel_1_3_1.setBounds(89, 320, 167, 38);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		p1 = new JPasswordField();
		p1.setBounds(280, 320, 199, 41);
		frame.getContentPane().add(p1);
		
		JButton btn = new JButton("SUBMIT");
		btn.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				String nm=t1.getText();
				String num1=t2.getText();
				int rn=Integer.parseInt(num1);
				String num2=t3.getText();
				int age=Integer.parseInt(num2);
				String pswd=p1.getText();
				String gender;
				if(r1.isSelected()){
					gender="Male";
				}
				else if(r2.isSelected()){
					gender="Male";
				}
				else {
					gender="Invalid";
				}
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","123456");
					String q="Insert into reg values('"+nm+"','"+rn+"','"+age+"','"+gender+"','"+pswd+"')";
					java.sql.Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btn,"Registration Done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn.setFont(new Font("Rockwell", Font.PLAIN, 15));
		btn.setBounds(181, 401, 136, 31);
		frame.getContentPane().add(btn);
	}
}
