import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class FF extends JFrame {

	private JPanel contentPane;
	private JTextField SearchTextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FF frame = new FF();
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
	public FF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 672);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmPreviousOrders = new JMenuItem("Previous orders");
		mntmPreviousOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderLogin OrderLog=new OrderLogin();
				OrderLog.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmPreviousOrders);
		
		JMenuItem mntmFaq = new JMenuItem("FAQ");
		mntmFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAQ FreqAQ=new FAQ();
				FreqAQ.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmFaq);
		
		JMenuItem mntmAboutUs = new JMenuItem("About us");
		mntmAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs About=new AboutUs();
				About.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmAboutUs);
		
		JMenuItem mntmCart = new JMenuItem("Cart");
		mntmCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart YourCart=new Cart();
				YourCart.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmCart);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblForFlight = new JLabel("For flight");
		lblForFlight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForFlight.setBounds(12, 78, 77, 16);
		contentPane.add(lblForFlight);
		
		JRadioButton rdbtnOneWay = new JRadioButton("One way");
		rdbtnOneWay.setBackground(new Color(173, 216, 230));
		rdbtnOneWay.setBounds(8, 94, 127, 25);
		contentPane.add(rdbtnOneWay);
		
		JRadioButton rdbtnBothWays = new JRadioButton("Both ways");
		rdbtnBothWays.setBackground(new Color(173, 216, 230));
		rdbtnBothWays.setBounds(8, 117, 127, 25);
		contentPane.add(rdbtnBothWays);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnOneWay);
		group.add(rdbtnBothWays);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(12, 184, 77, 22);
		contentPane.add(spinner);
		
		JLabel lblAdaults = new JLabel("Adaults:");
		lblAdaults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdaults.setBounds(12, 166, 77, 16);
		contentPane.add(lblAdaults);
		
		JLabel lblChildrens = new JLabel("Childrens:");
		lblChildrens.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChildrens.setBounds(12, 219, 77, 16);
		contentPane.add(lblChildrens);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_1.setBounds(12, 238, 77, 22);
		contentPane.add(spinner_1);
		
		JLabel lblInterests = new JLabel("Interests:");
		lblInterests.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInterests.setBounds(12, 273, 77, 25);
		contentPane.add(lblInterests);
		
		JRadioButton rdbtnGolfing = new JRadioButton("Golfing");
		rdbtnGolfing.setBackground(new Color(173, 216, 230));
		rdbtnGolfing.setBounds(12, 298, 127, 25);
		contentPane.add(rdbtnGolfing);
		
		JRadioButton rdbtnRelaxing = new JRadioButton("Relaxing");
		rdbtnRelaxing.setBackground(new Color(173, 216, 230));
		rdbtnRelaxing.setBounds(12, 320, 127, 25);
		contentPane.add(rdbtnRelaxing);
		
		JRadioButton rdbtnParty = new JRadioButton("Party");
		rdbtnParty.setBackground(new Color(173, 216, 230));
		rdbtnParty.setBounds(12, 342, 127, 25);
		contentPane.add(rdbtnParty);
		
		JRadioButton rdbtnSunshine = new JRadioButton("Sunshine");
		rdbtnSunshine.setBackground(new Color(173, 216, 230));
		rdbtnSunshine.setBounds(12, 364, 127, 25);
		contentPane.add(rdbtnSunshine);
		
		JRadioButton rdbtnShopping = new JRadioButton("Shopping");
		rdbtnShopping.setBackground(new Color(173, 216, 230));
		rdbtnShopping.setBounds(12, 385, 127, 25);
		contentPane.add(rdbtnShopping);
		
		JLabel lblDateFrom = new JLabel("Date from:");
		lblDateFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateFrom.setBounds(12, 436, 99, 16);
		contentPane.add(lblDateFrom);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(12, 452, 76, 22);
		contentPane.add(dateChooser);
		
		JLabel lblDateTo = new JLabel("Date to:");
		lblDateTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateTo.setBounds(12, 494, 56, 16);
		contentPane.add(lblDateTo);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(13, 510, 76, 22);
		contentPane.add(dateChooser_1);
		
		JCheckBox chckbxFlight = new JCheckBox("Flight");
		chckbxFlight.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxFlight.setBackground(new Color(173, 216, 230));
		chckbxFlight.setBounds(184, 9, 113, 25);
		contentPane.add(chckbxFlight);
		
		JCheckBox chckbxHotel = new JCheckBox("Hotel");
		chckbxHotel.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxHotel.setBackground(new Color(173, 216, 230));
		chckbxHotel.setBounds(351, 9, 113, 25);
		contentPane.add(chckbxHotel);
		
		JCheckBox chckbxDaytrip = new JCheckBox("Daytrip");
		chckbxDaytrip.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxDaytrip.setBackground(new Color(173, 216, 230));
		chckbxDaytrip.setBounds(543, 9, 113, 25);
		contentPane.add(chckbxDaytrip);
		
		JButton btnAddToCart = new JButton("Add to cart");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnAddToCart.setIcon(new ImageIcon(imgLogin));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart AddtoCart=new Cart();
				AddtoCart.setVisible(true);
				dispose();
			}
		});
		btnAddToCart.setBounds(338, 542, 138, 33);
		contentPane.add(btnAddToCart);
		
		SearchTextfield = new JTextField();
		SearchTextfield.setBounds(167, 43, 496, 25);
		contentPane.add(SearchTextfield);
		SearchTextfield.setColumns(10);
		
		JButton ButtonSearch = new JButton("");
		Image imgSearch = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		ButtonSearch.setIcon(new ImageIcon(imgSearch));
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonSearch.setBounds(670, 42, 47, 25);
		contentPane.add(ButtonSearch);
	}
}
