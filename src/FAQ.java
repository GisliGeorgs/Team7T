import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import java.awt.Color;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel FAQ = new JLabel("FAQ");
		FAQ.setBounds(25, 56, 446, 416);
		contentPane.add(FAQ);
		
		JLabel lblFrequentlyAskedQuestions = new JLabel("Frequently Asked Questions");
		lblFrequentlyAskedQuestions.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFrequentlyAskedQuestions.setBounds(135, 0, 241, 40);
		contentPane.add(lblFrequentlyAskedQuestions);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(498, 0, 21, 493);
		contentPane.add(scrollBar);
	}
}
