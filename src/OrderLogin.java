import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class OrderLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField inputOrderNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderLogin OrderLog = new OrderLogin();
					OrderLog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderLogin() {
		setIconImage(
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
		setTitle("Team 7T - Order Number");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 240);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFrame frame = new JFrame();
		frame.setBounds(-10009, -10038, 0, 0);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 26, 88, 121);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(221, 59, 165, 37);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("Login");
		button.setBounds(94, 122, 115, 37);
		frame.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("Order number");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(112, 61, 97, 31);
		frame.getContentPane().add(label_1);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(221, 122, 115, 37);
		frame.getContentPane().add(button_1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//contentPane.add(frame);
		
		JButton LoginOrderButton = new JButton("Login");
		LoginOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderNumber YourOrders = new OrderNumber();
				YourOrders.setVisible(true);
				dispose();
			}
		});
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		LoginOrderButton.setIcon(new ImageIcon(imgLogin));
		LoginOrderButton.setBounds(120, 124, 106, 33);
		contentPane.add(LoginOrderButton);
		
		JButton CancelLoginButton = new JButton("Cancel");
		Image imgCancel = new ImageIcon(this.getClass().getResource("/Close-2-icon.png")).getImage();
		CancelLoginButton.setIcon(new ImageIcon(imgCancel));
		CancelLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FF Front=new FF();
				Front.setVisible(true);
				dispose();
			}
		});
		CancelLoginButton.setBounds(261, 123, 106, 35);
		contentPane.add(CancelLoginButton);
		
		JLabel LoginOrderNumber = new JLabel("Order Number");
		LoginOrderNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		LoginOrderNumber.setBounds(120, 54, 104, 33);
		contentPane.add(LoginOrderNumber);
		
		inputOrderNumber = new JTextField();
		inputOrderNumber.setBounds(246, 55, 136, 33);
		contentPane.add(inputOrderNumber);
		inputOrderNumber.setColumns(10);
		
		JLabel LoginPhoto = new JLabel("");
		Image imgTicket = new ImageIcon(this.getClass().getResource("/ticket.png")).getImage();
		LoginPhoto.setIcon(new ImageIcon(imgTicket));
		LoginPhoto.setBounds(12, 48, 96, 109);
		contentPane.add(LoginPhoto);
	}

}
