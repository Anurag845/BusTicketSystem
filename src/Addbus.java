import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;


public class Addbus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblEnterSource;
	private JLabel lblEnterDestination;
	private JButton btnNewButton;
	private JButton btnBack;
	private JTextField textFieldfr;
	private JLabel lblEnterDate;
	private JLabel lblEnterFare;
	private JComboBox combo1;
	private JComboBox combo2;
	private String source;
	private String destination;
	private String date;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbus frame = new Addbus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Addbus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEnterSource = new JLabel("Enter source");
		lblEnterSource.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterSource.setBounds(120,100, 172, 15);
		contentPane.add(lblEnterSource);
		
		String[] scities = {"Pune","Mumbai","Bangalore","Kolhapur"};
		String[] dcities = {"Pune","Mumbai","Bangalore"};
		combo1 = new JComboBox(scities);
		
		combo2 = new JComboBox(dcities);
		
		combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combo1.getSelectedIndex() == 0) {
					source = "Pune";
				}
				else if(combo1.getSelectedIndex() == 1) {
					source = "Mumbai";
				}
				else if(combo1.getSelectedIndex() == 2) {
					source = "Bangalore";
				}
				else if(combo1.getSelectedIndex() == 3) {
					source = "Kolhapur";
				}
				if(source == "Pune") {
					dcities[0] = "Mumbai";
					dcities[1] = "Bangalore";
					dcities[2] = "Kolhapur";
				}
				else if(source == "Mumbai") {
					dcities[0] = "Pune";
					dcities[1] = "Bangalore";
					dcities[2] = "Kolhapur";
				}
				else if(source == "Bangalore") {
					dcities[0] = "Mumbai";
					dcities[1] = "Pune";
					dcities[2] = "Kolhapur"; 
				}
				else if(source == "Kolhapur") {
					dcities[0] = "Mumbai";
					dcities[1] = "Pune";
					dcities[2] = "Bangalore"; 
				}
				DefaultComboBoxModel model = new DefaultComboBoxModel(dcities);
				combo2.setModel( model );
			}
		});
		
		combo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combo2.getSelectedIndex() == 0) {
					destination = dcities[0];
				}
				else if(combo2.getSelectedIndex() == 1) {
					destination = dcities[1];
				}
				else if(combo2.getSelectedIndex() == 2) {
					destination = dcities[2];
				}
			}
		});
		
		combo1.setBounds(300,100,150,25);
		contentPane.add(combo1);
		
		combo2.setBounds(300,170,150,25);
		contentPane.add(combo2);
		
		lblEnterDestination = new JLabel("Enter destination");
		lblEnterDestination.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterDestination.setBounds(120, 170, 161, 27);
		contentPane.add(lblEnterDestination);
		
		
		//Booking bk = new Booking();
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TicketBooking.oos.writeObject(1);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int bno = 0;
				int fare = Integer.parseInt(textFieldfr.getText());
				Bus b = new Bus(bno,source,destination,date,fare);
				try {
					TicketBooking.oos.writeObject(b);
					JOptionPane.showMessageDialog(null,new JTextArea((String) TicketBooking.ois.readObject()));
				} catch (IOException | HeadlessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//bk.addbus(bno,src,dest);
				//create new object of bus and add to HashSet buses
			}
		});
		btnNewButton.setBounds(300, 470, 117, 25);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addbus.this.setVisible(false);
			}
		});
		btnBack.setBounds(120, 470, 117, 25);
		contentPane.add(btnBack);
		
		lblEnterDate = new JLabel("Enter date");
		lblEnterDate.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterDate.setBounds(120, 240, 172, 15);
		contentPane.add(lblEnterDate);
		
		lblEnterFare = new JLabel("Enter fare");
		lblEnterFare.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterFare.setBounds(120, 310, 161, 15);
		contentPane.add(lblEnterFare);
		
		textFieldfr = new JTextField();
		textFieldfr.setBounds(300, 310, 150, 25);
		contentPane.add(textFieldfr);
		textFieldfr.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		
		dateChooser.setBounds(300, 234, 150, 25);
		contentPane.add(dateChooser);
		
		//java.util.Date date = dateChooser.getDateEditor().getDate();
		
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if("date".equals(evt.getPropertyName())) {
					//java.util.Date date = dateChooser.getDateEditor().getDate();
					DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
					date = fmt.format(dateChooser.getDate());
				}
			}
		});
	}
	
}
