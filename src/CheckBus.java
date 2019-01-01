import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CheckBus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 676653507316723434L;
	private JPanel contentPane;
	private JTextField textFieldgetno;
	private JLabel lblNewLabel;
	private JButton btnSubmit;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBus frame = new CheckBus();
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
	public CheckBus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Enter bus number");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(32, 154, 201, 52);
		contentPane.add(lblNewLabel);
		
		textFieldgetno = new JTextField();
		textFieldgetno.setBounds(303, 172, 114, 19);
		contentPane.add(textFieldgetno);
		textFieldgetno.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
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
		btnSubmit.setBounds(268, 317, 117, 25);
		contentPane.add(btnSubmit);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckBus.this.setVisible(false);
			}
		});
		btnBack.setBounds(71, 317, 117, 25);
		contentPane.add(btnBack);
	}
}
