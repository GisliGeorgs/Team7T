import com.main.java.controller.CartController;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInfoNew extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField age;
	private JTextField Interests;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfoNew frame = new UserInfoNew();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    CartController cart;
	/**
	 * Create the frame.
	 */
	public UserInfoNew() {
<<<<<<< HEAD
		setIconImage(
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 419, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserInformation = new JLabel("User Information");
		lblUserInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserInformation.setBounds(107, 28, 188, 26);
		contentPane.add(lblUserInformation);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(39, 101, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(39, 183, 56, 16);
		contentPane.add(lblAge);
		
		email = new JTextField();
		email.setBounds(39, 122, 116, 22);
		contentPane.add(email);
		email.setColumns(10);
		
		age = new JTextField();
		age.setBounds(39, 209, 116, 22);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblInterests = new JLabel("Interests:");
		lblInterests.setBounds(203, 101, 56, 16);
		contentPane.add(lblInterests);
		
		Interests = new JTextField();
		Interests.setBounds(203, 122, 161, 115);
		contentPane.add(Interests);
		Interests.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(39, 244, 56, 16);
		contentPane.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(173, 216, 230));
		rdbtnMale.setBounds(39, 261, 127, 25);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(173, 216, 230));
		rdbtnFemale.setBounds(39, 283, 127, 25);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		
		JButton btnSave = new JButton("Save");
		Image imgSave = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnSave.setIcon(new ImageIcon(imgSave));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(143, 342, 97, 25);
		contentPane.add(btnSave);
=======
		Setup();
>>>>>>> 95a8bd66a4fcfea064c2f27c7e54941138da8b76
	}
    public UserInfoNew( CartController cart ) {
        this.cart = cart;
        Setup();
    }

    private void Setup(){

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 419, 453);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(173, 216, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUserInformation = new JLabel("User Information");
        lblUserInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUserInformation.setBounds(107, 28, 188, 26);
        contentPane.add(lblUserInformation);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(39, 101, 56, 16);
        contentPane.add(lblEmail);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(39, 183, 56, 16);
        contentPane.add(lblAge);

        email = new JTextField();
        email.setBounds(39, 122, 116, 22);
        contentPane.add(email);
        email.setColumns(10);

        age = new JTextField();
        age.setBounds(39, 209, 116, 22);
        contentPane.add(age);
        age.setColumns(10);

        JLabel lblInterests = new JLabel("Interests:");
        lblInterests.setBounds(203, 101, 56, 16);
        contentPane.add(lblInterests);

        Interests = new JTextField();
        Interests.setBounds(203, 122, 161, 115);
        contentPane.add(Interests);
        Interests.setColumns(10);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(39, 244, 56, 16);
        contentPane.add(lblGender);

        JRadioButton rdbtnMale = new JRadioButton("Male");
        rdbtnMale.setBackground(new Color(173, 216, 230));
        rdbtnMale.setBounds(39, 261, 127, 25);
        contentPane.add(rdbtnMale);

        JRadioButton rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setBackground(new Color(173, 216, 230));
        rdbtnFemale.setBounds(39, 283, 127, 25);
        contentPane.add(rdbtnFemale);

        ButtonGroup group=new ButtonGroup();
        group.add(rdbtnMale);
        group.add(rdbtnFemale);

        JButton btnSave = new JButton("Save");
        Image imgSave = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
        btnSave.setIcon(new ImageIcon(imgSave));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnSave.setBounds(143, 342, 97, 25);
        contentPane.add(btnSave);
    }
}
