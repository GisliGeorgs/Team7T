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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 754, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		Image imgCancel = new ImageIcon(this.getClass().getResource("/Close-2-icon.png")).getImage();
		btnCancel.setIcon(new ImageIcon(imgCancel));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your Order has been canceled!","Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnCancel.setBounds(399, 416, 176, 49);
		contentPane.add(btnCancel);
		
		JButton DoneViewingOrder = new JButton("Finished");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		DoneViewingOrder.setIcon(new ImageIcon(imgLogin));
		DoneViewingOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FF FrontF=new FF();
				FrontF.setVisible(true);
				dispose();
			}
		});
		DoneViewingOrder.setBounds(177, 416, 176, 49);
		contentPane.add(DoneViewingOrder);
		
		JLabel lblYourOrders = new JLabel("Your Orders");
		lblYourOrders.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblYourOrders.setBounds(283, 0, 116, 57);
		contentPane.add(lblYourOrders);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfoChange UI=new UserInfoChange();
				UI.setVisible(true);
				dispose();
			}
		});
		btnUser.setBounds(608, 10, 116, 39);
		contentPane.add(btnUser);
		
		JPanel PanelSeeYourOrders = new JPanel();
		PanelSeeYourOrders.setBackground(new Color(176, 224, 230));
		PanelSeeYourOrders.setBounds(80, 74, 571, 329);
		contentPane.add(PanelSeeYourOrders);
	}
}
