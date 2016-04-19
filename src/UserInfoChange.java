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
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class UserInfoChange extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	
	private com.main.java.form.User user;
	private JTextField txtFirstName;
	private JTextField txtLastname;
	private JTextField txtCountry;
	private JTextField txtPhonenumber;
	private JTextField CardNumber;
	private JTextField CVCtextfield;
	private JTextField txtPassportnumber;

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
		user = new com.main.java.form.User();
		setIconImage(
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
		setTitle("Team 7T - User");
		getContentPane().setBackground(new Color(173, 216, 230));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 672);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
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
		btnSaveUser.setBounds(65, 578, 127, 33);
		contentPane.add(btnSaveUser);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(248, 248, 255));
		rdbtnMale.setBounds(31, 253, 127, 25);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(248, 248, 255));
		rdbtnFemale.setBounds(31, 283, 127, 25);
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
		btnCancel.setBounds(218, 578, 127, 33);
		contentPane.add(btnCancel);
		
		email = new JTextField();
		email.setBounds(31, 196, 141, 22);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(31, 180, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(31, 228, 56, 16);
		contentPane.add(lblGender);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(31, 124, 56, 16);
		contentPane.add(lblAge);
		
		JLabel lblUserInformation = new JLabel("User Information");
		lblUserInformation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserInformation.setBounds(115, 13, 253, 33);
		contentPane.add(lblUserInformation);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(31, 73, 86, 16);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(31, 89, 141, 22);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(194, 73, 105, 16);
		contentPane.add(lblLastName);
		
		txtLastname = new JTextField();
		txtLastname.setBounds(192, 89, 141, 22);
		contentPane.add(txtLastname);
		txtLastname.setColumns(10);
		
		JSpinner Agespinner = new JSpinner();
		Agespinner.setModel(new SpinnerNumberModel(0, 0, 120, 1));
		Agespinner.setBounds(31, 141, 49, 22);
		contentPane.add(Agespinner);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCountry.setBounds(194, 125, 75, 16);
		contentPane.add(lblCountry);
		
		txtCountry = new JTextField();
		txtCountry.setBounds(194, 141, 139, 22);
		contentPane.add(txtCountry);
		txtCountry.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNumber.setBounds(194, 181, 139, 16);
		contentPane.add(lblPhoneNumber);
		
		txtPhonenumber = new JTextField();
		txtPhonenumber.setBounds(194, 196, 116, 22);
		contentPane.add(txtPhonenumber);
		txtPhonenumber.setColumns(10);
		txtPhonenumber.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(txtPhonenumber.getText().length()>=7&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		
		JLabel lblCreditcardNumber = new JLabel("Creditcard number");
		lblCreditcardNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreditcardNumber.setBounds(31, 317, 141, 16);
		contentPane.add(lblCreditcardNumber);
		
		CardNumber = new JTextField();
		CardNumber.setBounds(31, 334, 141, 22);
		contentPane.add(CardNumber);
		CardNumber.setColumns(10);
		CardNumber.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(CardNumber.getText().length()>=16&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		
		JLabel lblExpirationDate = new JLabel("Expiration date");
		lblExpirationDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpirationDate.setBounds(31, 369, 127, 16);
		contentPane.add(lblExpirationDate);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(28, 387, 64, 22);
		contentPane.add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(92, 387, 51, 22);
		contentPane.add(yearChooser);
		
		JLabel lblCvc = new JLabel("CVC");
		lblCvc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCvc.setBounds(31, 422, 56, 16);
		contentPane.add(lblCvc);
		
		CVCtextfield = new JTextField();
		CVCtextfield.setBounds(31, 437, 56, 22);
		contentPane.add(CVCtextfield);
		CVCtextfield.setColumns(10);
		CVCtextfield.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(CVCtextfield.getText().length()>=3&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		
		JLabel lblPassportNumber = new JLabel("Passport number");
		lblPassportNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassportNumber.setBounds(31, 473, 141, 16);
		contentPane.add(lblPassportNumber);
		
		txtPassportnumber = new JTextField();
		txtPassportnumber.setBounds(31, 491, 141, 22);
		contentPane.add(txtPassportnumber);
		txtPassportnumber.setColumns(10);
		txtPassportnumber.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(txtPassportnumber.getText().length()>=3&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
	}
}
