import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import com.main.java.form.*;

public class Cart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
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
	public Cart() {
		setTitle("Team 7T - Cart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourCart = new JLabel("Your Cart");
		lblYourCart.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourCart.setBounds(256, 13, 138, 25);
		contentPane.add(lblYourCart);
		
		JButton btnFinsihOrder = new JButton("Finnish Order");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnFinsihOrder.setIcon(new ImageIcon(imgLogin));
		btnFinsihOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				boolean UserExists = user.GetEmail().isEmpty();
				if (UserExists ){
					Pay Payment=new Pay();
					Payment.setVisible(true);
					dispose();	
				}
				else{
					UserInfoNew uin = new UserInfoNew();
					uin.setVisible( true );
					dispose();
				}
			}
		});
		btnFinsihOrder.setBounds(148, 458, 174, 39);
		contentPane.add(btnFinsihOrder);
		
		JButton btngobacktoSearch = new JButton("Go back to search");
		Image imgLogin2 = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		btngobacktoSearch.setIcon(new ImageIcon(imgLogin2));
		btngobacktoSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FF FrontFr=new FF();
				FrontFr.setVisible(true);
				dispose();
			}
		});
		btngobacktoSearch.setBounds(334, 459, 174, 36);
		contentPane.add(btngobacktoSearch);
	}

}
