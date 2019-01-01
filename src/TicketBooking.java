import java.net.*;
import java.awt.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TicketBooking extends JFrame{

	private static final long serialVersionUID = 1L;
	//private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldusr;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblWelcomeToBus;
	private JButton btnNewButton;
	private JButton btnSignUp;
	
	public static ObjectOutputStream oos = null;
	
	public static ObjectInputStream ois = null;
	public Socket s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TicketBooking frame = new TicketBooking();
					frame.setVisible(true);
					
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicketBooking() {
		super("Bus Ticket Booking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//setUndecorated(true);
		setSize(800,600);
		contentPane = new JPanel();
		//contentPane.setForeground(Color.BLACK);
		//contentPane.setBackground(Color.DARK_GRAY);
		//frame.setBounds(200, 200, 450, 450);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWelcomeToBus = new JLabel("Welcome to Bus Ticket Booking System");
		lblWelcomeToBus.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWelcomeToBus.setForeground(Color.BLACK);
		lblWelcomeToBus.setBounds(200, 37, 463, 39);
		contentPane.add(lblWelcomeToBus);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(250, 157, 105, 30);
		contentPane.add(lblUsername);
		
		textFieldusr = new JTextField();
		textFieldusr.setBounds(460, 158, 131, 30);
		contentPane.add(textFieldusr);
		textFieldusr.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(250, 232, 105, 30);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(460, 233, 131, 30);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TicketBooking.oos.writeObject(8);
					String username = textFieldusr.getText();
					String password = new String(passwordField.getPassword());
					TicketBooking.oos.writeObject(username);
					TicketBooking.oos.writeObject(password);
					int decision = (int)TicketBooking.ois.readObject();
					JOptionPane.showMessageDialog(null,(String)TicketBooking.ois.readObject());
					if(decision == 1) {
						Adminframe obj = new Adminframe();
						obj.setVisible(true);
					}
					else if(decision == 2) {
						UserFrame obj = new UserFrame();
						obj.setVisible(true);
					}
					
				} catch (IOException | HeadlessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(350, 350, 117, 25);
		contentPane.add(btnNewButton);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp obj = new SignUp();
				obj.setVisible(true);
			}
		});
		btnSignUp.setBounds(350, 450, 117, 25);
		contentPane.add(btnSignUp);
		
		try {
			s = new Socket("localhost",3000);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			TicketBooking.oos = new ObjectOutputStream(s.getOutputStream());
			TicketBooking.ois = new ObjectInputStream(s.getInputStream());
			setVisible(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
