import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FAQ extends JFrame {

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAQ frame = new FAQ();
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
	public FAQ() {
		setIconImage(
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
		setTitle("FAQ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFrequentlyAskedQuestions = new JLabel("Frequently Asked Questions");
		lblFrequentlyAskedQuestions.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFrequentlyAskedQuestions.setBounds(135, 0, 241, 40);
		contentPane.add(lblFrequentlyAskedQuestions);
		
		JButton btnHome = new JButton("Home");
		Image imgLogin2 = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		btnHome.setIcon(new ImageIcon(imgLogin2));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHome.setBounds(211, 398, 97, 25);
		contentPane.add(btnHome);
		
		JLabel lblHereIsA = new JLabel("Here is a question");
		lblHereIsA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHereIsA.setBounds(37, 95, 204, 16);
		contentPane.add(lblHereIsA);
		
		JLabel lblHereIsAn = new JLabel("Here is an answer");
		lblHereIsAn.setBounds(37, 124, 200, 16);
		contentPane.add(lblHereIsAn);
		
		JLabel lblHereIsA_1 = new JLabel("Here is a common question");
		lblHereIsA_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHereIsA_1.setBounds(32, 210, 199, 16);
		contentPane.add(lblHereIsA_1);
		
		JLabel lblHereIsA_2 = new JLabel("Here is a really good answer to the question");
		lblHereIsA_2.setBounds(32, 239, 289, 16);
		contentPane.add(lblHereIsA_2);
	}
}
