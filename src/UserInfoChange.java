import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class UserInfoChange extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfoChange UI = new UserInfoChange();
					UI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInfoChange() {
		setIconImage(
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
		setTitle("Team 7T - User");
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 445, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSaveUser = new JButton("Save");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnSaveUser.setIcon(new ImageIcon(imgLogin));
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OrderNumber OrderN=new OrderNumber();
				//OrderN.setVisible(true);
				dispose();
			}
		});
		btnSaveUser.setBounds(45, 337, 127, 33);
		contentPane.add(btnSaveUser);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(173, 216, 230));
		rdbtnMale.setBounds(45, 237, 127, 25);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(173, 216, 230));
		rdbtnFemale.setBounds(45, 267, 127, 25);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnFemale);
		group.add(rdbtnMale);
		
		JButton btnCancel = new JButton("Cancel");
		Image imgCancel = new ImageIcon(this.getClass().getResource("/Close-2-icon.png")).getImage();
		btnCancel.setIcon(new ImageIcon(imgCancel));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//OrderNumber OrderN=new OrderNumber();
				//OrderN.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(194, 337, 127, 33);
		contentPane.add(btnCancel);
		
		email = new JTextField();
		email.setBounds(45, 100, 116, 22);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(45, 85, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(45, 215, 56, 16);
		contentPane.add(lblGender);
		
		age = new JTextField();
		age.setBounds(45, 162, 116, 22);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(45, 146, 56, 16);
		contentPane.add(lblAge);
		
		JLabel lblUserInformation = new JLabel("User Information");
		lblUserInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblUserInformation.setBounds(115, 13, 253, 33);
		contentPane.add(lblUserInformation);
		
		JTextArea Interests = new JTextArea();
		Interests.setBounds(226, 100, 165, 96);
		contentPane.add(Interests);
		
		JLabel lblInterests = new JLabel("Interests");
		lblInterests.setBounds(226, 85, 56, 16);
		contentPane.add(lblInterests);
	}
}
