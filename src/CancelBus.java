import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CancelBus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6066658404420277264L;
	private JPanel contentPane;
	private JTextField textFieldgetcno;
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
					CancelBus frame = new CancelBus();
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
	public CancelBus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(200, 200, 450, 450);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    lblNewLabel = new JLabel("Enter bus number");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 163, 163, 52);
		contentPane.add(lblNewLabel);
		
		textFieldgetcno = new JTextField();
		textFieldgetcno.setBounds(306, 181, 114, 19);
		contentPane.add(textFieldgetcno);
		textFieldgetcno.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = Integer.parseInt(textFieldgetcno.getText());
				try {
					TicketBooking.oos.writeObject(2);
					TicketBooking.oos.writeObject(no);
					String mess = (String)TicketBooking.ois.readObject();
					JOptionPane.showMessageDialog(null,mess);
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(276, 316, 117, 25);
		contentPane.add(btnSubmit);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelBus.this.setVisible(false);
			}
		});
		btnBack.setBounds(82, 316, 117, 25);
		contentPane.add(btnBack);
	}

}
