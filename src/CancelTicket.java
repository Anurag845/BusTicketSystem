import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CancelTicket extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private GridBagLayout gridBagLayout;
	private JTextField pass1book;
	private JTextField pass1aadhar;
	
	private JTextField pass2book;
	private JTextField pass2aadhar;
	
	private JTextField pass3book;
	private JTextField pass3aadhar;
	
	private JTextField pass4book;
	private JTextField pass4aadhar;

	private JComboBox comboBox;
	private JLabel noofpass;
	private JButton back;
	private JButton submit;
	private JTextField Busno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelTicket frame = new CancelTicket();
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
	public CancelTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 450);
		contentPane = new JPanel();
		gridBagLayout = new GridBagLayout();
		
		contentPane.setLayout(gridBagLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		pass1book = new JTextField("Passenger 1 booking number");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 1;
		gbc.weightx = 1;
		contentPane.add(pass1book,gbc);
		
		
		pass1aadhar = new JTextField("Passenger 1 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 1;
		contentPane.add(pass1aadhar,gbc);
		
		/*pass1age = new JTextField("Passenger 1 name");
		gbc.gridx = 3;
		gbc.gridy = 1;
		contentPane.add(pass1age,gbc);*/
		
		pass2book = new JTextField("Passenger 2 booking number");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1;
		contentPane.add(pass2book,gbc);
		
		
		pass2aadhar = new JTextField("Passenger 2 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 2;
		contentPane.add(pass2aadhar,gbc);
		
		/*pass2age = new JTextField("Passenger 2 name");
		gbc.gridx = 3;
		gbc.gridy = 2;
		contentPane.add(pass2age,gbc);*/
		
		pass3book = new JTextField("Passenger 3 booking number");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weighty = 1;
		contentPane.add(pass3book,gbc);
		
		
		pass3aadhar = new JTextField("Passenger 3 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 3;
		contentPane.add(pass3aadhar,gbc);
		
		/*pass3age = new JTextField("Passenger 3 name");
		gbc.gridx = 3;
		gbc.gridy = 3;
		contentPane.add(pass3age,gbc);*/

		pass4book = new JTextField("Passenger 4 booking number");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weighty = 1;
		contentPane.add(pass4book,gbc);
		
		
		pass4aadhar = new JTextField("Passenger 4 Aadhar");
		gbc.gridx = 2;
		gbc.gridy = 4;
		contentPane.add(pass4aadhar,gbc);
		
		/*pass4age = new JTextField("Passenger 4 name");
		gbc.gridx = 3;
		gbc.gridy = 4;
		contentPane.add(pass4age,gbc);*/

		
		Integer[] tno = new Integer[] {1,2,3,4};
		comboBox = new JComboBox<Object>(tno);
		
		pass1book.setEnabled(false);
		pass1aadhar.setEnabled(false);
		//pass1age.setEnabled(false);
		pass2book.setEnabled(false);
		pass2aadhar.setEnabled(false);
		//pass2age.setEnabled(false);
		pass3book.setEnabled(false);
		pass3aadhar.setEnabled(false);
		//pass3age.setEnabled(false);
		pass4book.setEnabled(false);
		pass4aadhar.setEnabled(false);
		//pass4age.setEnabled(false);

		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					pass1book.setEnabled(true);
					pass1aadhar.setEnabled(true);
					//pass1age.setEnabled(true);
					pass2book.setEnabled(false);
					pass2aadhar.setEnabled(false);
					//pass2age.setEnabled(false);
				}
				else if(comboBox.getSelectedIndex() == 1) {
					pass1book.setEnabled(true);
					pass1aadhar.setEnabled(true);
					//pass1age.setEnabled(true);
					pass2book.setEnabled(true);
					pass2aadhar.setEnabled(true);
					//pass2age.setEnabled(true);
				}
				else if(comboBox.getSelectedIndex() == 2) {
					pass1book.setEnabled(true);
					pass1aadhar.setEnabled(true);
					//pass1age.setEnabled(true);
					pass2book.setEnabled(true);
					pass2aadhar.setEnabled(true);
					//pass2age.setEnabled(true);
					pass3book.setEnabled(true);
					pass3aadhar.setEnabled(true);
					//pass3age.setEnabled(true);
				}
				else if(comboBox.getSelectedIndex() == 3) {
					pass1book.setEnabled(true);
					pass1aadhar.setEnabled(true);
					//pass1age.setEnabled(true);
					pass2book.setEnabled(true);
					pass2aadhar.setEnabled(true);
					//pass2age.setEnabled(true);
					pass3book.setEnabled(true);
					pass3aadhar.setEnabled(true);
					//pass3age.setEnabled(true);
					pass4book.setEnabled(true);
					pass4aadhar.setEnabled(true);
					//pass4age.setEnabled(true);
				}
			}
		});
		
		noofpass = new JLabel("Number of passengers");
		Busno = new JTextField("Bus number");
		submit = new JButton("Submit");
		back = new JButton("Back");
		
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
						TicketBooking.oos.writeObject(6);
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
					
					int aadhar,bookno;
					String msg;
					//int c1book,c2book,c3book,c4book;
					//String passinfo = "Bookno\t" + "Aadhar\n";
					if(pass1book.isEnabled() && !pass2book.isEnabled()) {
						try {	
							bookno = Integer.parseInt(pass1book.getText());
							aadhar = Integer.parseInt(pass1aadhar.getText());						
						
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
					else if(pass2book.isEnabled() && !pass3book.isEnabled()) {
						try {
							TicketBooking.oos.writeObject(2);
							bookno = Integer.parseInt(pass1book.getText());
							aadhar = Integer.parseInt(pass1aadhar.getText());						
						
							
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
						
							bookno = Integer.parseInt(pass2book.getText());
							aadhar = Integer.parseInt(pass2aadhar.getText());							
						
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
					else if(pass3book.isEnabled() && !pass4book.isEnabled()) {
						try {
							TicketBooking.oos.writeObject(3);
							bookno = Integer.parseInt(pass1book.getText());
							aadhar = Integer.parseInt(pass1aadhar.getText());						
							
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
						
							bookno = Integer.parseInt(pass2book.getText());
							aadhar = Integer.parseInt(pass2aadhar.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							bookno = Integer.parseInt(pass3book.getText());
							aadhar = Integer.parseInt(pass3aadhar.getText());							
						
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
							bookno = Integer.parseInt(pass1book.getText());
							aadhar = Integer.parseInt(pass1aadhar.getText());						
							
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
						
							bookno = Integer.parseInt(pass2book.getText());
							aadhar = Integer.parseInt(pass2aadhar.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							bookno = Integer.parseInt(pass3book.getText());
							aadhar = Integer.parseInt(pass3aadhar.getText());							
						
							TicketBooking.oos.writeObject(bookno);
							TicketBooking.oos.writeObject(aadhar);
							msg = (String)TicketBooking.ois.readObject();
							
							bookno = Integer.parseInt(pass4book.getText());
							aadhar = Integer.parseInt(pass4aadhar.getText());							
						
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
		
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelTicket.this.setVisible(false);
			}
		});
		
	}

}
