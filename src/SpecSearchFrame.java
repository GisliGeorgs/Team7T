import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SpecSearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecSearchFrame frame = new SpecSearchFrame();
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
	public SpecSearchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton GolfButton = new JRadioButton("Golf");
		GolfButton.setBackground(new Color(173, 216, 230));
		GolfButton.setBounds(8, 91, 127, 25);
		contentPane.add(GolfButton);
		
		JRadioButton SunshineRadioButton_1 = new JRadioButton("Sunshine");
		SunshineRadioButton_1.setBackground(new Color(173, 216, 230));
		SunshineRadioButton_1.setBounds(8, 181, 127, 25);
		contentPane.add(SunshineRadioButton_1);
		
		JRadioButton PartyingRadioButton_2 = new JRadioButton("Partying");
		PartyingRadioButton_2.setBackground(new Color(173, 216, 230));
		PartyingRadioButton_2.setBounds(8, 121, 127, 25);
		contentPane.add(PartyingRadioButton_2);
		
		JRadioButton RelaxingRadioButton_3 = new JRadioButton("Relaxing");
		RelaxingRadioButton_3.setBackground(new Color(173, 216, 230));
		RelaxingRadioButton_3.setBounds(8, 151, 127, 25);
		contentPane.add(RelaxingRadioButton_3);
		
		JLabel JlabelFlight = new JLabel("Flight");
		JlabelFlight.setFont(new Font("Tahoma", Font.BOLD, 14));
		JlabelFlight.setBounds(542, 313, 56, 16);
		contentPane.add(JlabelFlight);
		
		JRadioButton OneWay = new JRadioButton("One way");
		OneWay.setBackground(new Color(173, 216, 230));
		OneWay.setBounds(475, 338, 86, 25);
		contentPane.add(OneWay);
		
		JRadioButton BothWays = new JRadioButton("Both ways");
		BothWays.setBackground(new Color(173, 216, 230));
		BothWays.setBounds(565, 338, 86, 25);
		contentPane.add(BothWays);
		
		JButton OrderButton = new JButton("Submit Order");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		OrderButton.setIcon(new ImageIcon(imgLogin));
		OrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//YourOrderNumberIs YONI = YourOrderNumberIs();
				//YONI.setVisible(true);
			}
		});
		OrderButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		OrderButton.setBounds(163, 419, 153, 40);
		contentPane.add(OrderButton);
		
		JLabel lblSpecificSearch = new JLabel("Specific Search");
		lblSpecificSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSpecificSearch.setBounds(241, 0, 198, 53);
		contentPane.add(lblSpecificSearch);
		
		JRadioButton ShoppingRadioButton = new JRadioButton("Shopping");
		ShoppingRadioButton.setBackground(new Color(173, 216, 230));
		ShoppingRadioButton.setBounds(8, 211, 127, 25);
		contentPane.add(ShoppingRadioButton);
		
		JLabel lblWhatDoYou = new JLabel("What do you like?");
		lblWhatDoYou.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWhatDoYou.setBounds(8, 61, 139, 25);
		contentPane.add(lblWhatDoYou);
		
		JLabel lblTicketsFor = new JLabel("Tickets for?");
		lblTicketsFor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTicketsFor.setBounds(501, 52, 127, 42);
		contentPane.add(lblTicketsFor);
		
		JRadioButton rdbtnOneAdault = new JRadioButton("One Adault");
		rdbtnOneAdault.setBackground(new Color(173, 216, 230));
		rdbtnOneAdault.setBounds(501, 86, 127, 25);
		contentPane.add(rdbtnOneAdault);
		
		JRadioButton rdbtnTwoAdaults = new JRadioButton("Two Adaults");
		rdbtnTwoAdaults.setBackground(new Color(173, 216, 230));
		rdbtnTwoAdaults.setBounds(501, 116, 127, 25);
		contentPane.add(rdbtnTwoAdaults);
		
		JRadioButton rdbtnOneChildren = new JRadioButton("One Children");
		rdbtnOneChildren.setBackground(new Color(173, 216, 230));
		rdbtnOneChildren.setBounds(501, 146, 127, 25);
		contentPane.add(rdbtnOneChildren);
		
		JRadioButton rdbtnTwoChildrens = new JRadioButton("Two Childrens");
		rdbtnTwoChildrens.setBackground(new Color(173, 216, 230));
		rdbtnTwoChildrens.setBounds(501, 176, 127, 25);
		contentPane.add(rdbtnTwoChildrens);
		
		JLabel lblOther = new JLabel("Other:");
		lblOther.setBounds(460, 215, 37, 16);
		contentPane.add(lblOther);
		
		textField = new JTextField();
		textField.setBounds(501, 212, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		Image imgCancel = new ImageIcon(this.getClass().getResource("/Close-2-icon.png")).getImage();
		btnCancel.setIcon(new ImageIcon(imgCancel));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(344, 419, 153, 40);
		contentPane.add(btnCancel);
	}

}
