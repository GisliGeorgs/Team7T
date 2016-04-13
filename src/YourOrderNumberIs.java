import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YourOrderNumberIs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YourOrderNumberIs frame = new YourOrderNumberIs();
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
	public YourOrderNumberIs() {
		setTitle("Team 7T - Your order number");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 255);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourOrderNumber = new JLabel("Your Order Number is:");
		lblYourOrderNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblYourOrderNumber.setBounds(24, 25, 264, 39);
		contentPane.add(lblYourOrderNumber);
		
		JButton btnHome = new JButton("Home");
		Image imgLogin2 = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		btnHome.setIcon(new ImageIcon(imgLogin2));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FF FrontFr=new FF();
				FrontFr.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(162, 170, 97, 25);
		contentPane.add(btnHome);
	}

}
