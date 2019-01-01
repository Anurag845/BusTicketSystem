import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7541216398235741159L;
	
	private JPanel contentPane;
	private JLabel lblWelcomeUser;
	private JButton btnSeeBuses;
	private JButton btnBookTicket;
	private JButton btnCancelTicket;
	private JButton btnBack;
	private JSplitPane splitPane;
	private JPanel bookticket;
	private JPanel cancelticket;
	private JTextField pass1name;
	private JTextField pass1aadhar;
	private JTextField pass1age;
	private JTextField pass2name;
	private JTextField pass2aadhar;
	private JTextField pass2age;
	private JTextField pass3name;
	private JTextField pass3aadhar;
	private JTextField pass3age;
	private JTextField pass4name;
	private JTextField pass4aadhar;
	private JTextField pass4age;
	private JComboBox comboBox;
	private GridBagLayout gridBagLayout;
	private JLabel noofpass;
	private JTextField Busno; 
	private JButton submit;
	
	private GridBagLayout gridBagLayout1;
	private JTextField pass1book1;
	private JTextField pass1aadhar1;
	
	private JTextField pass2book1;
	private JTextField pass2aadhar1;
	
	private JTextField pass3book1;
	private JTextField pass3aadhar1;
	
	private JTextField pass4book1;
	private JTextField pass4aadhar1;

	private JComboBox comboBox1;
	private JLabel noofpass1;
	private JButton submit1;
	private JTextField Busno1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public UserFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(200, 200, 450, 450);
		setSize(800,600);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setSize(300,600);
		bookticket = new JPanel();
		cancelticket= new JPanel();
		bookticket.setSize(500,600);
		cancelticket.setSize(500,600);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		bookticket.setBorder(new EmptyBorder(5,5,5,5));
		cancelticket.setBorder(new EmptyBorder(5,5,5,5));

		bookticket.setLayout(null);
		contentPane.setVisible(true);
		//admin.setVisible(true);
		
		splitPane = new JSplitPane();
        splitPane.setSize(800,600);
        splitPane.setDividerSize(1);
        splitPane.setDividerLocation(300);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(contentPane);
        splitPane.setRightComponent(null);

        getContentPane().add(splitPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(200, 200, 450, 450);
		setSize(800,600);
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);*/
		
		lblWelcomeUser = new JLabel("Welcome User");
		lblWelcomeUser.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeUser.setBounds(100, 100, 159, 33);
		contentPane.add(lblWelcomeUser);
		
		btnSeeBuses = new JButton("See buses");
		btnSeeBuses.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSeeBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TicketBooking.oos.writeObject(3);
					String businfo = "Busno" + "\t" + "Availability" + "\t" + "Source" + "\t" + "Destination" + "\t" + "Date" + "\t" + "Fare" + "\n";
					int n = (int) TicketBooking.ois.readObject();
					System.out.println(n);
					for(int i = 0 ; i < n; i++) {
						Bus b = (Bus)TicketBooking.ois.readObject();
						businfo += b.busno + "\t" + b.availcount + "\t" + b.source + "\t" + b.destination + "\t" + b.date + "\t" + b.fare + "\n";
					}
					JOptionPane.showMessageDialog(null,new JTextArea(businfo));
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSeeBuses.setBounds(100,200, 140,30);
		contentPane.add(btnSeeBuses);
		
		btnBookTicket = new JButton("Book Ticket");
		btnBookTicket.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setDividerLocation(300);
				splitPane.setRightComponent(bookticket);
			}
		});
		btnBookTicket.setBounds(100, 300, 140,30);
		contentPane.add(btnBookTicket);
		
		btnCancelTicket = new JButton("Cancel Ticket");
		btnCancelTicket.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setDividerLocation(300);
				splitPane.setRightComponent(cancelticket);
			}
		});
		btnCancelTicket.setBounds(100, 400, 140,30);
		contentPane.add(btnCancelTicket);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFrame.this.setVisible(false);
			}
		});
		btnBack.setBounds(100, 500, 140,30);
		contentPane.add(btnBack);
		
		
		
		
		gridBagLayout = new GridBagLayout();
		
		bookticket.setLayout(gridBagLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		pass1name = new JTextField("Passenger 1 name");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		bookticket.add(pass1name,gbc);
		
		
		pass1aadhar = new JTextField("Passenger 1 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 1;
		bookticket.add(pass1aadhar,gbc);
		
		pass1age = new JTextField("Passenger 1 age");
		gbc.gridx = 3;
		gbc.gridy = 1;
		bookticket.add(pass1age,gbc);
		
		pass2name = new JTextField("Passenger 2 name");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1;
		bookticket.add(pass2name,gbc);
		
		
		pass2aadhar = new JTextField("Passenger 2 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 2;
		bookticket.add(pass2aadhar,gbc);
		
		pass2age = new JTextField("Passenger 2 age");
		gbc.gridx = 3;
		gbc.gridy = 2;
		bookticket.add(pass2age,gbc);
		
		pass3name = new JTextField("Passenger 3 name");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weighty = 1;
		bookticket.add(pass3name,gbc);
		
		
		pass3aadhar = new JTextField("Passenger 3 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 3;
		bookticket.add(pass3aadhar,gbc);
		
		pass3age = new JTextField("Passenger 3 age");
		gbc.gridx = 3;
		gbc.gridy = 3;
		bookticket.add(pass3age,gbc);

		pass4name = new JTextField("Passenger 4 name");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weighty = 1;
		bookticket.add(pass4name,gbc);
		
		
		pass4aadhar = new JTextField("Passenger 4 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 4;
		bookticket.add(pass4aadhar,gbc);
		
		pass4age = new JTextField("Passenger 4 age");
		gbc.gridx = 3;
		gbc.gridy = 4;
		bookticket.add(pass4age,gbc);

		
		Integer[] tno = new Integer[] {1,2,3,4};
		comboBox = new JComboBox<Object>(tno);
		
		pass1name.setEnabled(false);
		pass1aadhar.setEnabled(false);
		pass1age.setEnabled(false);
		pass2name.setEnabled(false);
		pass2aadhar.setEnabled(false);
		pass2age.setEnabled(false);
		pass3name.setEnabled(false);
		pass3aadhar.setEnabled(false);
		pass3age.setEnabled(false);
		pass4name.setEnabled(false);
		pass4aadhar.setEnabled(false);
		pass4age.setEnabled(false);

		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					pass1name.setEnabled(true);
					pass1aadhar.setEnabled(true);
					pass1age.setEnabled(true);
					pass2name.setEnabled(false);
					pass2aadhar.setEnabled(false);
					pass2age.setEnabled(false);
				}
				else if(comboBox.getSelectedIndex() == 1) {
					pass1name.setEnabled(true);
					pass1aadhar.setEnabled(true);
					pass1age.setEnabled(true);
					pass2name.setEnabled(true);
					pass2aadhar.setEnabled(true);
					pass2age.setEnabled(true);
				}
				else if(comboBox.getSelectedIndex() == 2) {
					pass1name.setEnabled(true);
					pass1aadhar.setEnabled(true);
					pass1age.setEnabled(true);
					pass2name.setEnabled(true);
					pass2aadhar.setEnabled(true);
					pass2age.setEnabled(true);
					pass3name.setEnabled(true);
					pass3aadhar.setEnabled(true);
					pass3age.setEnabled(true);
				}
				else if(comboBox.getSelectedIndex() == 3) {
					pass1name.setEnabled(true);
					pass1aadhar.setEnabled(true);
					pass1age.setEnabled(true);
					pass2name.setEnabled(true);
					pass2aadhar.setEnabled(true);
					pass2age.setEnabled(true);
					pass3name.setEnabled(true);
					pass3aadhar.setEnabled(true);
					pass3age.setEnabled(true);
					pass4name.setEnabled(true);
					pass4aadhar.setEnabled(true);
					pass4age.setEnabled(true);
				}
			}
		});
		
		noofpass = new JLabel("Number of passengers");
		Busno = new JTextField("Bus number");
		submit = new JButton("Submit");		
		String[] buslist = {};
		int i = 0;
		for(Bus b : Global.buses) {
			buslist[i] = b.busno + " " + b.source + " to " + b.destination;
			i++;
			System.out.println(i);
		}
		
		JComboBox combo = new JComboBox(buslist);
		
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for(int i = 0;i < buslist.length; i++) {
				if(combo.getSelectedItem().equals(buslist[i])) {
					String[] busdata = buslist[i].split("\\s+");
					int bno = Integer.parseInt(busdata[0]);
				}
			}
			}
		});
		
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		bookticket.add(Busno,gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		bookticket.add(noofpass,gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 2;
		gbc.weighty = 1;
		bookticket.add(comboBox,gbc);
		
		//gbc.anchor = GridBagConstraints.SOUTH;
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.weightx = 2;
		gbc.weighty = 1;
		bookticket.add(submit,gbc);
		
		/*gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 2;
		gbc.weighty = 1;
		contentPane.add(back,gbc);*/
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Busno.getText().equals("Bus number")) {
					JOptionPane.showMessageDialog(null,"Please enter bus number");
				}
				else {
					try {
						TicketBooking.oos.writeObject(5);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					int bno = Integer.parseInt(Busno.getText());
					System.out.println(bno);
					try {
						TicketBooking.oos.writeObject(bno);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String name,Aadhar,Age;
					int aadhar,age;
					Customer c1 = null,c2 = null,c3 = null,c4 = null;
					int c1book,c2book,c3book,c4book;
					boolean flag = false;
					String passinfo = "Bookno\t" + "Name\t" + "Aadhar\n";
					if(pass1name.isEnabled() && !pass2name.isEnabled()) {
						name = pass1name.getText();
						Aadhar = pass1aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass1age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
						}
						else {
							c1 = new Customer(bno,name,aadhar,age);
							try {
								TicketBooking.oos.writeObject(1);
								TicketBooking.oos.writeObject(c1);
								c1book = (int)TicketBooking.ois.readObject();
								passinfo += c1book + "\t" + c1.name +"\t" + c1.Aadhar + "\n";
							} catch (IOException | ClassNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					else if(pass2name.isEnabled() && !pass3name.isEnabled()) {
						name = pass1name.getText();
						Aadhar = pass1aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass1age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c1 = new Customer(bno,name,aadhar,age);
							flag = true;
						}
						name = pass2name.getText();
						Aadhar = pass2aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass2age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c2 = new Customer(bno,name,aadhar,age);
							flag = true;
						}
						if(flag) {
							try {
								TicketBooking.oos.writeObject(2);
								TicketBooking.oos.writeObject(c1);
								c1book = (int)TicketBooking.ois.readObject();
								passinfo += c1book + "\t" + c1.name +"\t" + c1.Aadhar + "\n";
								TicketBooking.oos.writeObject(c2);
								c2book = (int)TicketBooking.ois.readObject();
								passinfo += c2book + "\t" + c2.name +"\t" + c2.Aadhar + "\n";
							} catch (IOException | ClassNotFoundException e1) {
								e1.printStackTrace();
							}
						}
						
					}
					else if(pass3name.isEnabled() && !pass4name.isEnabled()) {
						name = pass1name.getText();
						Aadhar = pass1aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass1age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c1 = new Customer(bno,name,aadhar,age);
							flag = true;
						}
						name = pass2name.getText();
						Aadhar = pass2aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass2age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c2 = new Customer(bno,name,aadhar,age);
							flag = true;
						}
						
						name = pass3name.getText();
						Aadhar = pass3aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass3age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c3 = new Customer(bno,name,aadhar,age);
							flag = true;
						}
						
						if(flag) {
							try {
								TicketBooking.oos.writeObject(3);
								TicketBooking.oos.writeObject(c1);
								c1book = (int)TicketBooking.ois.readObject();
								passinfo += c1book + "\t" + c1.name +"\t" + c1.Aadhar + "\n";
								TicketBooking.oos.writeObject(c2);
								c2book = (int)TicketBooking.ois.readObject();
								passinfo += c2book + "\t" + c2.name +"\t" + c2.Aadhar + "\n";
								TicketBooking.oos.writeObject(c3);
								c3book = (int)TicketBooking.ois.readObject();
								passinfo += c3book + "\t" + c3.name +"\t" + c3.Aadhar + "\n";
							} catch (IOException | ClassNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
					else {
						
						name = pass1name.getText();
						Aadhar = pass1aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass1age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c1 = new Customer(bno,name,aadhar,age);
							flag = true;
						}
						name = pass2name.getText();
						Aadhar = pass2aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass2age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c2 = new Customer(bno,name,aadhar,age);
							flag = true;
						}
						
						name = pass3name.getText();
						Aadhar = pass3aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass3age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c3 = new Customer(bno,name,aadhar,age);
							flag = true;
						}

						name = pass4name.getText();
						Aadhar = pass4aadhar.getText();				
						aadhar = Integer.parseInt(Aadhar);
						Age = pass4age.getText();
						age = Integer.parseInt(Age);
						if(name.equals("") || Aadhar.equals("") || Age.equals("")) {
							JOptionPane.showMessageDialog(null,"Fields are empty");
							flag = false;
						}
						else if(name.matches(".*\\d+.*")) {
							JOptionPane.showMessageDialog(null,"Name contains number. Enter valid name");
							flag = false;
						}
						else if (!Aadhar.matches("[0-9]+") || !(Aadhar.length() == 8)) {
							JOptionPane.showMessageDialog(null,"Invalid Aadhar");
							flag = false;
						}
						else {
							c4 = new Customer(bno,name,aadhar,age);
							flag = true;
						}
						
						if(flag) {
							try {
								TicketBooking.oos.writeObject(4);
								TicketBooking.oos.writeObject(c1);
								c1book = (int)TicketBooking.ois.readObject();
								passinfo += c1book + "\t" + c1.name +"\t" + c1.Aadhar + "\n";
								TicketBooking.oos.writeObject(c2);
								c2book = (int)TicketBooking.ois.readObject();
								passinfo += c2book + "\t" + c2.name +"\t" + c2.Aadhar + "\n";
								TicketBooking.oos.writeObject(c3);
								c3book = (int)TicketBooking.ois.readObject();
								passinfo += c3book + "\t" + c3.name +"\t" + c3.Aadhar + "\n";
								TicketBooking.oos.writeObject(c4);
								c4book = (int)TicketBooking.ois.readObject();
								passinfo += c4book + "\t" + c4.name +"\t" + c4.Aadhar + "\n";
							} catch (IOException | ClassNotFoundException e1) {
								e1.printStackTrace();
							}
						}
						
					}
					try {
						JOptionPane.showMessageDialog(null,TicketBooking.ois.readObject());
						JOptionPane.showMessageDialog(null,new JTextArea(passinfo));
					} catch (HeadlessException | ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		
		
		
		cancelticket.setLayout(gridBagLayout);
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		pass1book1 = new JTextField("Passenger 1 booking number");
		gbc1.gridx = 1;
		gbc1.gridy = 1;
		gbc1.weighty = 1;
		gbc1.weightx = 1;
		cancelticket.add(pass1book1,gbc1);
		
		
		pass1aadhar1 = new JTextField("Passenger 1 Aadhar");
		gbc1.gridx = 2;
		gbc1.gridy = 1;
		cancelticket.add(pass1aadhar1,gbc1);
		
		/*pass1age = new JTextField("Passenger 1 name");
		gbc.gridx = 3;
		gbc.gridy = 1;
		contentPane.add(pass1age,gbc);*/
		
		pass2book1 = new JTextField("Passenger 2 booking number");
		gbc1.gridx = 1;
		gbc1.gridy = 2;
		gbc1.weighty = 1;
		cancelticket.add(pass2book1,gbc1);
		
		
		pass2aadhar1 = new JTextField("Passenger 2 Aadhar");
		gbc1.gridx = 2;
		gbc1.gridy = 2;
		cancelticket.add(pass2aadhar1,gbc1);
		
		/*pass2age = new JTextField("Passenger 2 name");
		gbc.gridx = 3;
		gbc.gridy = 2;
		contentPane.add(pass2age,gbc);*/
		
		pass3book1 = new JTextField("Passenger 3 booking number");
		gbc1.gridx = 1;
		gbc1.gridy = 3;
		gbc1.weighty = 1;
		cancelticket.add(pass3book1,gbc1);
		
		
		pass3aadhar1 = new JTextField("Passenger 3 Aadhar");
		gbc1.gridx = 2;
		gbc1.gridy = 3;
		cancelticket.add(pass3aadhar1,gbc1);
		
		/*pass3age = new JTextField("Passenger 3 name");
		gbc.gridx = 3;
		gbc.gridy = 3;
		contentPane.add(pass3age,gbc);*/

		pass4book1 = new JTextField("Passenger 4 booking number");
		gbc1.gridx = 1;
		gbc1.gridy = 4;
		gbc1.weighty = 1;
		cancelticket.add(pass4book1,gbc1);
		
		
		pass4aadhar1 = new JTextField("Passenger 4 Aadhar");
		gbc1.gridx = 2;
		gbc1.gridy = 4;
		cancelticket.add(pass4aadhar1,gbc1);
		
		/*pass4age = new JTextField("Passenger 4 name");
		gbc.gridx = 3;
		gbc.gridy = 4;
		contentPane.add(pass4age,gbc);*/

		
		Integer[] tno1 = new Integer[] {1,2,3,4};
		comboBox1 = new JComboBox<Object>(tno1);
		
		pass1book1.setEnabled(false);
		pass1aadhar1.setEnabled(false);
		//pass1age.setEnabled(false);
		pass2book1.setEnabled(false);
		pass2aadhar1.setEnabled(false);
		//pass2age.setEnabled(false);
		pass3book1.setEnabled(false);
		pass3aadhar1.setEnabled(false);
		//pass3age.setEnabled(false);
		pass4book1.setEnabled(false);
		pass4aadhar1.setEnabled(false);
		//pass4age.setEnabled(false);

		
		comboBox1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(comboBox1.getSelectedIndex() == 0) {
					pass1book1.setEnabled(true);
					pass1aadhar1.setEnabled(true);
					//pass1age.setEnabled(true);
					pass2book1.setEnabled(false);
					pass2aadhar1.setEnabled(false);
					//pass2age.setEnabled(false);
				}
				else if(comboBox1.getSelectedIndex() == 1) {
					pass1book1.setEnabled(true);
					pass1aadhar1.setEnabled(true);
					//pass1age.setEnabled(true);
					pass2book1.setEnabled(true);
					pass2aadhar1.setEnabled(true);
					//pass2age.setEnabled(true);
				}
				else if(comboBox1.getSelectedIndex() == 2) {
					pass1book1.setEnabled(true);
					pass1aadhar1.setEnabled(true);
					//pass1age.setEnabled(true);
					pass2book1.setEnabled(true);
					pass2aadhar1.setEnabled(true);
					//pass2age.setEnabled(true);
					pass3book1.setEnabled(true);
					pass3aadhar1.setEnabled(true);
					//pass3age.setEnabled(true);
				}
				else if(comboBox1.getSelectedIndex() == 3) {
					pass1book1.setEnabled(true);
					pass1aadhar1.setEnabled(true);
					//pass1age.setEnabled(true);
					pass2book1.setEnabled(true);
					pass2aadhar1.setEnabled(true);
					//pass2age.setEnabled(true);
					pass3book1.setEnabled(true);
					pass3aadhar1.setEnabled(true);
					//pass3age.setEnabled(true);
					pass4book1.setEnabled(true);
					pass4aadhar1.setEnabled(true);
					//pass4age.setEnabled(true);
				}
			}
		});
		
		noofpass1 = new JLabel("Number of passengers");
		Busno1 = new JTextField("Bus number");
		submit1 = new JButton("Submit");
		
		gbc1.anchor = GridBagConstraints.NORTH;
		gbc1.gridx = 1;
		gbc1.gridy = 1;
		gbc1.weightx = 1;
		gbc1.weighty = 1;
		cancelticket.add(Busno1,gbc1);

		gbc1.gridx = 2;
		gbc1.gridy = 1;
		gbc1.weightx = 1;
		gbc1.weighty = 1;
		cancelticket.add(noofpass1,gbc1);
		
		gbc1.gridx = 3;
		gbc1.gridy = 1;
		gbc1.weightx = 2;
		gbc1.weighty = 1;
		cancelticket.add(comboBox1,gbc1);
		
		//gbc.anchor = GridBagConstraints.SOUTH;
		gbc1.gridx = 3;
		gbc1.gridy = 5;
		gbc1.weightx = 2;
		gbc1.weighty = 1;
		cancelticket.add(submit1,gbc1);
		
		/*gbc1.gridx = 1;
		gbc1.gridy = 5;
		gbc1.weightx = 2;
		gbc1.weighty = 1;
		contentPane.add(back,gbc);*/
		
		
		submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Busno1.getText().equals("Bus number")) {
					JOptionPane.showMessageDialog(null,"Please enter bus number");
				}
				else {
					try {
						TicketBooking.oos.writeObject(6);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
					int bno = Integer.parseInt(Busno1.getText());
					//System.out.println(bno);
					try {
						TicketBooking.oos.writeObject(bno);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					int aadhar,bookno;
					String msg;
					//int c1book,c2book,c3book,c4book;
					//String passinfo = "Bookno\t" + "Aadhar\n";
					if(pass1book1.isEnabled() && !pass2book1.isEnabled()) {
						try {	
							bookno = Integer.parseInt(pass1book1.getText());
							aadhar = Integer.parseInt(pass1aadhar1.getText());						
						
							TicketBooking.oos.writeObject(1);
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							System.out.println(msg);
							
							//passinfo += c1book + "\t" + c1.Aadhar + "\n";
						} catch (IOException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}
					}
					else if(pass2book1.isEnabled() && !pass3book1.isEnabled()) {
						try {
							TicketBooking.oos.writeObject(2);
							bookno = Integer.parseInt(pass1book1.getText());
							aadhar = Integer.parseInt(pass1aadhar1.getText());						
						
							
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
						
							bookno = Integer.parseInt(pass2book1.getText());
							aadhar = Integer.parseInt(pass2aadhar1.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							/*c1book = (int)TicketBooking.ois.readObject();
							passinfo += c1book + "\t" + c1.name +"\t" + c1.Aadhar + "\n";
							TicketBooking.oos.writeObject(c2);
							c2book = (int)TicketBooking.ois.readObject();
							passinfo += c2book + "\t" + c2.name +"\t" + c2.Aadhar + "\n";*/
						} catch (IOException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}
					}
					else if(pass3book1.isEnabled() && !pass4book1.isEnabled()) {
						try {
							TicketBooking.oos.writeObject(3);
							bookno = Integer.parseInt(pass1book1.getText());
							aadhar = Integer.parseInt(pass1aadhar1.getText());						
							
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
						
							bookno = Integer.parseInt(pass2book1.getText());
							aadhar = Integer.parseInt(pass2aadhar1.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							bookno = Integer.parseInt(pass3book1.getText());
							aadhar = Integer.parseInt(pass3aadhar1.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							/*c1book = (int)TicketBooking.ois.readObject();
							passinfo += c1book + "\t" + c1.name +"\t" + c1.Aadhar + "\n";
							TicketBooking.oos.writeObject(c2);
							c2book = (int)TicketBooking.ois.readObject();
							passinfo += c2book + "\t" + c2.name +"\t" + c2.Aadhar + "\n";*/
						} catch (IOException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}	
					}
					else {
						try {
							TicketBooking.oos.writeObject(3);
							bookno = Integer.parseInt(pass1book1.getText());
							aadhar = Integer.parseInt(pass1aadhar1.getText());						
							
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
						
							bookno = Integer.parseInt(pass2book1.getText());
							aadhar = Integer.parseInt(pass2aadhar1.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							bookno = Integer.parseInt(pass3book1.getText());
							aadhar = Integer.parseInt(pass3aadhar1.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							bookno = Integer.parseInt(pass4book1.getText());
							aadhar = Integer.parseInt(pass4aadhar1.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							/*c1book = (int)TicketBooking.ois.readObject();
							passinfo += c1book + "\t" + c1.name +"\t" + c1.Aadhar + "\n";
							TicketBooking.oos.writeObject(c2);
							c2book = (int)TicketBooking.ois.readObject();
							passinfo += c2book + "\t" + c2.name +"\t" + c2.Aadhar + "\n";*/
						} catch (IOException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}
					}
					/*try {
						JOptionPane.showMessageDialog(null,TicketBooking.ois.readObject());
						JOptionPane.showMessageDialog(null,new JTextArea(passinfo));
					} catch (HeadlessException | ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
				}
			}		
		});

	}
}
