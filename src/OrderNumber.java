import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class OrderNumber extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderNumber OrderN = new OrderNumber();
					OrderN.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderNumber() {
		setTitle("Team 7T - Your orders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton HotelRadioButton = new JRadioButton("Hotel");
		HotelRadioButton.setBackground(new Color(173, 216, 230));
		HotelRadioButton.setBounds(45, 237, 127, 25);
		contentPane.add(HotelRadioButton);
		
		JRadioButton FlightRadioButton_1 = new JRadioButton("Flight");
		FlightRadioButton_1.setBackground(new Color(173, 216, 230));
		FlightRadioButton_1.setBounds(45, 278, 127, 25);
		contentPane.add(FlightRadioButton_1);
		
		JRadioButton DayTripRadioButton_2 = new JRadioButton("Daytrip");
		DayTripRadioButton_2.setBackground(new Color(173, 216, 230));
		DayTripRadioButton_2.setBounds(45, 319, 127, 25);
		contentPane.add(DayTripRadioButton_2);
		
		JButton btnCancel = new JButton("Cancel");
		Image imgCancel = new ImageIcon(this.getClass().getResource("/Close-2-icon.png")).getImage();
		btnCancel.setIcon(new ImageIcon(imgCancel));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your Order has been canceled!","Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnCancel.setBounds(407, 491, 176, 49);
		contentPane.add(btnCancel);
		
		JButton DoneViewingOrder = new JButton("Finished");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		DoneViewingOrder.setIcon(new ImageIcon(imgLogin));
		DoneViewingOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrontFrame FF=new FrontFrame();
				FF.setVisible(true);
			}
		});
		DoneViewingOrder.setBounds(196, 491, 176, 49);
		contentPane.add(DoneViewingOrder);
		
		JLabel lblYourOrders = new JLabel("Your Orders");
		lblYourOrders.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblYourOrders.setBounds(331, 0, 116, 57);
		contentPane.add(lblYourOrders);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfo UI=new UserInfo();
				UI.setVisible(true);
				dispose();
			}
		});
		btnUser.setBounds(663, 35, 116, 39);
		contentPane.add(btnUser);
		
		JButton btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart YourCart=new Cart();
				YourCart.setVisible(true);
				dispose();
			}
		});
		btnCart.setBounds(663, 87, 116, 32);
		contentPane.add(btnCart);
	}
}
