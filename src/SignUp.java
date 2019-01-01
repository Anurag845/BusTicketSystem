import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SignUp extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5258268418299922820L;

	private JPanel contentPane;
	
	private JLabel lblUsername;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JPasswordField passwordField_1;
	private JLabel lblEnterName;
	private JLabel lblEnterAadharNumber;
	private JLabel lblUserNAme;
	private JLabel lblEnterPassword;
	private JLabel lblReenterPassword;
	private JComboBox comboBox;
	private JLabel lblDesignation;
	private JButton btnSignUp;
	private JButton btnBack;
	private String designation;
	private JTextField textField_3;

	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(200, 200, 450, 450);
		setSize(800,600);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEnterName = new JLabel("Enter name");
		lblEnterName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnterName.setBounds(167, 60, 151, 15);
		contentPane.add(lblEnterName);
		
		textField = new JTextField();
		textField.setBounds(364, 60, 142, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblEnterAadharNumber = new JLabel("Enter Aadhar number");
		lblEnterAadharNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnterAadharNumber.setBounds(167, 110, 169, 15);
		contentPane.add(lblEnterAadharNumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(364, 110, 142, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblUserNAme = new JLabel("Enter Username");
		lblUserNAme.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUserNAme.setBounds(167, 160, 151, 15);
		contentPane.add(lblUserNAme);
		
		lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnterPassword.setBounds(167, 210, 142, 15);
		contentPane.add(lblEnterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(364, 210, 142, 19);
		contentPane.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(364, 160, 142, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblReenterPassword = new JLabel("Reenter password");
		lblReenterPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblReenterPassword.setBounds(167, 260, 151, 15);
		contentPane.add(lblReenterPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(364, 260, 142, 19);
		contentPane.add(passwordField_1);
		
		String[] desig = new String[] {"Admin","User"};
		
		comboBox = new JComboBox<Object>(desig);
		comboBox.setBounds(364, 360, 114, 24);
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					designation = "admin";
				}
				else {
					designation = "user";
				}
			}
		});
		
		lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDesignation.setBounds(167, 360, 151, 15);
		contentPane.add(lblDesignation);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = textField.getText();
				String Aadhar = textField_1.getText();
				
				String username = textField_2.getText();
				String password = new String(passwordField.getPassword());
				String password2 = new String(passwordField_1.getPassword());
				String emailid = textField_3.getText();
				
				if(name.equals("") || Aadhar.equals("") || username.equals("") || password.equals("") || password2.equals("") || emailid.equals("")) {
					JOptionPane.showMessageDialog(null,"Fields empty");
				}
				else if(name.matches(".*\\d+.*")) {
					JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
				}
				
				else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
					JOptionPane.showMessageDialog(null,"Invalid Aadhar");
				}
				
				else if(!emailid.contains("@") || !emailid.contains(".com")) {
					JOptionPane.showMessageDialog(null,"Invalid email id");
				}
				else if(!password.equals(password2)) {
					JOptionPane.showMessageDialog(null,"Reentered password does not match");
				}
				
				else {
					try {
						long aadhar = Integer.parseInt(Aadhar);
						TicketBooking.oos.writeObject(9);
						TicketBooking.oos.writeObject(name);
						TicketBooking.oos.writeObject(aadhar);
						TicketBooking.oos.writeObject(username);
						TicketBooking.oos.writeObject(password);
						TicketBooking.oos.writeObject(designation);
						TicketBooking.oos.writeObject(emailid);
						JOptionPane.showMessageDialog(null,(String)TicketBooking.ois.readObject());
					}
					catch(IOException | HeadlessException | ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnSignUp.setBounds(361, 430, 117, 25);
		contentPane.add(btnSignUp);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp.this.setVisible(false);
			}
		});
		btnBack.setBounds(196,430, 117, 25);
		contentPane.add(btnBack);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmailId.setBounds(167, 310, 70, 15);
		contentPane.add(lblEmailId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(364, 310, 142, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblUsername = new JLabel("Username");
	}
}


