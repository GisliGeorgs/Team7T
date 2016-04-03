import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Team7T = new JLabel("Team 7T - Trip Planner");
		Team7T.setFont(new Font("Tahoma", Font.BOLD, 18));
		Team7T.setBounds(90, 13, 230, 29);
		contentPane.add(Team7T);
		
		JLabel lblNewLabel = new JLabel("Software Development  HBV401G \u2013 Spring 2016");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 36, 392, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblGumundurSigursonGushiis = new JLabel("Gu\u00F0mundur Sigur\u00F0son, gus97@hi.is");
		lblGumundurSigursonGushiis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGumundurSigursonGushiis.setBounds(90, 147, 292, 23);
		contentPane.add(lblGumundurSigursonGushiis);
		
		JLabel lblEgillrnSigurjnsson = new JLabel("Egill \u00D6rn Sigurj\u00F3nsson, eos21@hi.is");
		lblEgillrnSigurjnsson.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEgillrnSigurjnsson.setBounds(90, 76, 292, 23);
		contentPane.add(lblEgillrnSigurjnsson);
		
		JLabel lblGslGeorgssonGighiis = new JLabel("G\u00EDsl\u00ED Georgsson, gig26@hi.is");
		lblGslGeorgssonGighiis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGslGeorgssonGighiis.setBounds(90, 111, 292, 23);
		contentPane.add(lblGslGeorgssonGighiis);
		
		JLabel lblRnarKristjnssonRukhiis = new JLabel("R\u00FAnar Kristj\u00E1nsson, ruk7@hi.is");
		lblRnarKristjnssonRukhiis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRnarKristjnssonRukhiis.setBounds(90, 183, 292, 23);
		contentPane.add(lblRnarKristjnssonRukhiis);
		
		JLabel hiPicture = new JLabel("");
		Image imgHI = new ImageIcon(this.getClass().getResource("/hi.png")).getImage();
		hiPicture.setIcon(new ImageIcon(imgHI));
		hiPicture.setBounds(59, 210, 332, 221);
		contentPane.add(hiPicture);
	}
}
