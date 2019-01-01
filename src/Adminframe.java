import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class Adminframe extends JFrame {

	private static final long serialVersionUID = 3886386553114404324L;
	private JPanel contentPane;
	private JPanel addbus;
	private JLabel lblAdminServices;
	private JButton btnAddBus;
	private JButton btnCancelBus;
	private JButton btnBack;
	private JButton btnShowBuses;
	private JPanel cancelbus;
	private JPanel checkbus;
	private JLabel lblEnterSource;
	private JLabel lblEnterDestination;
	private JButton btnNewButton;
	//private JButton btnBack2;
	private JTextField textFieldfr;
	private JLabel lblEnterDate;
	private JLabel lblEnterFare;
	private JComboBox combo1;
	private JComboBox combo2;
	private String source = "";
	private String destination = "";
	private String date = "";
	private JSplitPane splitPane;
	private JTable jtable1;
	private JTable jtable2;
	private JTextField textFieldgetcno;
	private JTextField textFieldgetno;
	private JLabel lblNewLabel;
	private JButton btnSubmit;
	private JButton btnCheckBus;
	private JButton btnSubmit1;
	private JLabel lblenterbus;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminframe frame = new Adminframe();
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
	public Adminframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(200, 200, 450, 450);
		setSize(800,600);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setSize(300,600);
		addbus = new JPanel();
		checkbus = new JPanel();
		cancelbus = new JPanel();
		addbus.setSize(500,600);
		cancelbus.setSize(500,600);
		checkbus.setSize(500,600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		addbus.setBorder(new EmptyBorder(5,5,5,5));
		cancelbus.setBorder(new EmptyBorder(5,5,5,5));
		checkbus.setBorder(new EmptyBorder(5,5,5,5));
		addbus.setLayout(null);
		contentPane.setVisible(true);
		//admin.setVisible(true);
		
		splitPane = new JSplitPane();
        splitPane.setSize(800,600);
        splitPane.setDividerSize(1);
        splitPane.setDividerLocation(0.0);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(contentPane);
        splitPane.setRightComponent(null);

        getContentPane().add(splitPane);
		contentPane.setLayout(null);
		
		lblAdminServices = new JLabel("Admin Services");
		lblAdminServices.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAdminServices.setBounds(49,50, 140, 30);
		contentPane.add(lblAdminServices);
		
		btnAddBus = new JButton("Add Bus");
		btnAddBus.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAddBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        splitPane.setDividerLocation(300);
				splitPane.setRightComponent(addbus);
			}
		});
		btnAddBus.setBounds(45,100,140, 30);
		contentPane.add(btnAddBus);
		
		
		String[][] data = new String[10][4];
		String colnames[] = {"Bus number","Source","Destination","Date"};
		btnCancelBus = new JButton("Cancel Bus");
		btnCancelBus.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCancelBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int i = 0, j = 0;
				TicketBooking.oos.writeObject(10);
				@SuppressWarnings("unchecked")
				Set<Bus> buses = (Set<Bus>) TicketBooking.ois.readObject();
				System.out.println(buses.size());
				
				for(Bus b : buses) {
					data[i][j] = Integer.toString(b.busno);
					data[i][++j] = b.source;
					data[i][++j] = b.destination;
					data[i][++j] = b.date;
					i++;
					j=0;
					System.out.println(b.busno);
				}
				splitPane.setDividerLocation(300);
				splitPane.setRightComponent(cancelbus);
				cancelbus.setVisible(true);
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCancelBus.setBounds(45, 200, 140, 30);
		contentPane.add(btnCancelBus);
				
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminframe.this.setVisible(false);
			}
		});
		btnBack.setBounds(45,500, 71, 27);
		contentPane.add(btnBack);
		
		btnShowBuses = new JButton("Show Buses");
		btnShowBuses.setFont(new Font("Dialog", Font.BOLD, 14));
		btnShowBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TicketBooking.oos.writeObject(3);
					String businfo = "Busno" + "\t" + "Availablility" + "\t" + "Source" + "\t" + "Destination" + "\t" + "Date" + "\t" + "Fare" + "\n";
					int n = (int) TicketBooking.ois.readObject();
					//System.out.println(n);
					for(int i = 0 ; i < n; i++) {
						Bus b = (Bus)TicketBooking.ois.readObject();
						businfo += b.busno + "\t" +b.availcount + "\t" + b.source + "\t" + b.destination + "\t" + b.date + "\t" + b.fare + "\n";
					}
					JOptionPane.showMessageDialog(null,new JTextArea(businfo));
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowBuses.setBounds(45, 300, 140, 30);
		contentPane.add(btnShowBuses);
		
		btnCheckBus = new JButton("Check Bus");
		btnCheckBus.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCheckBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int i = 0, j = 0;
					TicketBooking.oos.writeObject(10);
					@SuppressWarnings("unchecked")
					Set<Bus> buses = (Set<Bus>) TicketBooking.ois.readObject();
					System.out.println(buses.size());
					for(Bus b : buses) {
						data[i][j] = Integer.toString(b.busno);
						data[i][++j] = b.source;
						data[i][++j] = b.destination;
						data[i][++j] = b.date;
						i++;
						j=0;
						System.out.println(b.busno);
					}
					splitPane.setDividerLocation(300);
					splitPane.setRightComponent(checkbus);
					checkbus.setVisible(true);
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnCheckBus.setBounds(45,400, 140, 30);
		contentPane.add(btnCheckBus);
		
		jtable1 = new JTable(data,colnames);
		jtable1.setBounds(30,30,500,200);
		JScrollPane sp1 = new JScrollPane(jtable1);
		cancelbus.add(sp1);
		lblenterbus = new JLabel("Enter bus number to be cancelled");
		lblenterbus.setFont(new Font("Dialog", Font.BOLD, 16));
		lblenterbus.setBounds(67, 163, 163, 52);
		cancelbus.add(lblenterbus);
		
		
		jtable2 = new JTable(data,colnames);
		jtable2.setBounds(30,30,500,200);
		JScrollPane sp2 = new JScrollPane(jtable2);
		checkbus.add(sp2);
		lblNewLabel = new JLabel("Enter bus number to be checked");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 163, 163, 52);
		
		lblEnterSource = new JLabel("Enter source");
		lblEnterSource.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterSource.setBounds(120,100, 172, 15);
		addbus.add(lblEnterSource);
		
		checkbus.add(lblNewLabel);
		
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
		addbus.add(combo1);
		
		combo2.setBounds(300,170,150,25);
		addbus.add(combo2);
		
		lblEnterDestination = new JLabel("Enter destination");
		lblEnterDestination.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterDestination.setBounds(120, 170, 161, 27);
		addbus.add(lblEnterDestination);
		
		
		//Booking bk = new Booking();
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fare = textFieldfr.getText();
				if(fare.equals("") || source.equals("") || destination.equals("") || date.equals("")) {
					JOptionPane.showMessageDialog(null,"Fields empty");
				}
				else {
				try {
					int fre = Integer.parseInt(fare);
					TicketBooking.oos.writeObject(1);
					int bno = 0;
					Bus b = new Bus(bno,source,destination,date,fre);
					TicketBooking.oos.writeObject(b);
					JOptionPane.showMessageDialog(null,new JTextArea((String) TicketBooking.ois.readObject()));
				} catch (IOException | HeadlessException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//bk.addbus(bno,src,dest);
				//create new object of bus and add to HashSet buses
				}
			}
		});
		btnNewButton.setBounds(300, 470, 117, 25);
		addbus.add(btnNewButton);
		
		lblEnterDate = new JLabel("Enter date");
		lblEnterDate.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterDate.setBounds(120, 240, 172, 15);
		addbus.add(lblEnterDate);
		
		lblEnterFare = new JLabel("Enter fare");
		lblEnterFare.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnterFare.setBounds(120, 310, 161, 15);
		addbus.add(lblEnterFare);
		
		textFieldfr = new JTextField();
		textFieldfr.setBounds(300, 310, 150, 25);
		addbus.add(textFieldfr);
		textFieldfr.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		
		dateChooser.setBounds(300, 234, 150, 25);
		addbus.add(dateChooser);
		
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
		
		
		
		textFieldgetcno = new JTextField();
		textFieldgetcno.setBounds(306, 181, 114, 19);
		cancelbus.add(textFieldgetcno);
		textFieldgetcno.setColumns(10);
		
		textFieldgetno = new JTextField();
		textFieldgetno.setBounds(306, 181, 114, 19);
		checkbus.add(textFieldgetno);
		textFieldgetno.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(textFieldgetcno.getText());
				try {
					TicketBooking.oos.writeObject(2);
					TicketBooking.oos.writeObject(no);
					String mess = (String)TicketBooking.ois.readObject();
					JOptionPane.showMessageDialog(null,mess);
					try {
						int i = 0, j = 0;
						@SuppressWarnings("unchecked")
						Set<Bus> buses = (Set<Bus>) TicketBooking.ois.readObject();
						System.out.println(buses.size());
						for(Bus b : buses) {
							data[i][j] = Integer.toString(b.busno);
							data[i][++j] = b.source;
							data[i][++j] = b.destination;
							data[i][++j] = b.date;
							i++;
							j=0;
							System.out.println(b.busno + " " + b.source + " " + b.destination);
						}
						splitPane.setDividerLocation(300);
						splitPane.setRightComponent(cancelbus);
						cancelbus.setVisible(true);
						}
						catch(Exception e1) {
							e1.printStackTrace();
						}
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(276, 316, 117, 25);
		cancelbus.add(btnSubmit);
		
		btnSubmit1 = new JButton("Submit");
		btnSubmit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TicketBooking.oos.writeObject(7);
					int no = Integer.parseInt(textFieldgetno.getText());
					TicketBooking.oos.writeObject(no);
					String businfo = (String)TicketBooking.ois.readObject();					
					JOptionPane.showMessageDialog(null,new JTextArea(businfo));
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnSubmit1.setBounds(268, 317, 117, 25);
		checkbus.add(btnSubmit1);
	}

}
