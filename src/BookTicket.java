import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.GridBagConstraints;

public class BookTicket extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8723956111018556016L;
	private JPanel contentPane;
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
	private JButton back;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTicket frame = new BookTicket();
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
	public BookTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 450);
		contentPane = new JPanel();
		gridBagLayout = new GridBagLayout();
		
		contentPane.setLayout(gridBagLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		pass1name = new JTextField("Passenger 1 name");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		contentPane.add(pass1name,gbc);
		
		
		pass1aadhar = new JTextField("Passenger 1 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 1;
		contentPane.add(pass1aadhar,gbc);
		
		pass1age = new JTextField("Passenger 1 age");
		gbc.gridx = 3;
		gbc.gridy = 1;
		contentPane.add(pass1age,gbc);
		
		pass2name = new JTextField("Passenger 2 name");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1;
		contentPane.add(pass2name,gbc);
		
		
		pass2aadhar = new JTextField("Passenger 2 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 2;
		contentPane.add(pass2aadhar,gbc);
		
		pass2age = new JTextField("Passenger 2 age");
		gbc.gridx = 3;
		gbc.gridy = 2;
		contentPane.add(pass2age,gbc);
		
		pass3name = new JTextField("Passenger 3 name");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weighty = 1;
		contentPane.add(pass3name,gbc);
		
		
		pass3aadhar = new JTextField("Passenger 3 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 3;
		contentPane.add(pass3aadhar,gbc);
		
		pass3age = new JTextField("Passenger 3 age");
		gbc.gridx = 3;
		gbc.gridy = 3;
		contentPane.add(pass3age,gbc);

		pass4name = new JTextField("Passenger 4 name");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weighty = 1;
		contentPane.add(pass4name,gbc);
		
		
		pass4aadhar = new JTextField("Passenger 4 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 4;
		contentPane.add(pass4aadhar,gbc);
		
		pass4age = new JTextField("Passenger 4 age");
		gbc.gridx = 3;
		gbc.gridy = 4;
		contentPane.add(pass4age,gbc);

		
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
		back = new JButton("Back");
		
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
		contentPane.add(Busno,gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		contentPane.add(noofpass,gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 2;
		gbc.weighty = 1;
		contentPane.add(comboBox,gbc);
		
		//gbc.anchor = GridBagConstraints.SOUTH;
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.weightx = 2;
		gbc.weighty = 1;
		contentPane.add(submit,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 2;
		gbc.weighty = 1;
		contentPane.add(back,gbc);
		
		add(contentPane);
		
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
					String name;
					int aadhar,age;
					Customer c1,c2,c3,c4;
					int c1book,c2book,c3book,c4book;
					String passinfo = "Bookno\t" + "Name\t" + "Aadhar\n";
					if(pass1name.isEnabled() && !pass2name.isEnabled()) {
						name = pass1name.getText();
						aadhar = Integer.parseInt(pass1aadhar.getText());
						age = Integer.parseInt(pass1age.getText());
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
					else if(pass2name.isEnabled() && !pass3name.isEnabled()) {
						name = pass1name.getText();
						aadhar = Integer.parseInt(pass1aadhar.getText());
						age = Integer.parseInt(pass1age.getText());
						c1 = new Customer(bno,name,aadhar,age);
						name = pass2name.getText();
						aadhar = Integer.parseInt(pass2aadhar.getText());
						age = Integer.parseInt(pass2age.getText());
						c2 = new Customer(bno,name,aadhar,age);
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
					else if(pass3name.isEnabled() && !pass4name.isEnabled()) {
						name = pass1name.getText();
						aadhar = Integer.parseInt(pass1aadhar.getText());
						age = Integer.parseInt(pass1age.getText());
						c1 = new Customer(bno,name,aadhar,age);
						name = pass2name.getText();
						aadhar = Integer.parseInt(pass2aadhar.getText());
						age = Integer.parseInt(pass2age.getText());
						c2 = new Customer(bno,name,aadhar,age);
						name = pass3name.getText();
						aadhar = Integer.parseInt(pass3aadhar.getText());
						age = Integer.parseInt(pass3age.getText());
						c3 = new Customer(bno,name,aadhar,age);
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
					else {
						
						name = pass1name.getText();
						aadhar = Integer.parseInt(pass1aadhar.getText());
						age = Integer.parseInt(pass1age.getText());
						c1 = new Customer(bno,name,aadhar,age);
						name = pass2name.getText();
						aadhar = Integer.parseInt(pass2aadhar.getText());
						age = Integer.parseInt(pass2age.getText());
						c2 = new Customer(bno,name,aadhar,age);
						name = pass3name.getText();
						aadhar = Integer.parseInt(pass3aadhar.getText());
						age = Integer.parseInt(pass3age.getText());
						c3 = new Customer(bno,name,aadhar,age);
						name = pass4name.getText();
						aadhar = Integer.parseInt(pass4aadhar.getText());
						age = Integer.parseInt(pass4age.getText());
						c4 = new Customer(bno,name,aadhar,age);
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
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTicket.this.setVisible(false);
			}
		});
		
	}
}
