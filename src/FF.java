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
import javax.swing.JTable;

public class FF extends JFrame {

	private JPanel contentPane;
	private JTextField SearchTextfield;
	private JTextField txtLocation;

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
		
		JMenuItem mntmPreviousOrders = new JMenuItem(Messages.getString("FF.PreOrders")); //$NON-NLS-1$
		mntmPreviousOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderLogin OrderLog=new OrderLogin();
				OrderLog.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmPreviousOrders);
		
		JMenuItem mntmFaq = new JMenuItem(Messages.getString("FF.FAQ")); //$NON-NLS-1$
		mntmFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAQ FreqAQ=new FAQ();
				FreqAQ.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmFaq);
		
		JMenuItem mntmAboutUs = new JMenuItem(Messages.getString("FF.AboutUs")); //$NON-NLS-1$
		mntmAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs About=new AboutUs();
				About.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmAboutUs);
		
		JMenuItem mntmCart = new JMenuItem(Messages.getString("FF.Cart")); //$NON-NLS-1$
		mntmCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart YourCart=new Cart();
				YourCart.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmCart);
		
		JMenuItem mntmUser = new JMenuItem(Messages.getString("FF.User")); //$NON-NLS-1$
		mntmUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInfoChange UI=new UserInfoChange();
				UI.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmUser);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblForFlight = new JLabel(Messages.getString("FF.ForFLight")); //$NON-NLS-1$
		lblForFlight.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblForFlight.setBounds(12, 218, 77, 16);
		contentPane.add(lblForFlight);
		
		JRadioButton rdbtnOneWay = new JRadioButton(Messages.getString("FF.OneWay")); //$NON-NLS-1$
		rdbtnOneWay.setBackground(new Color(173, 216, 230));
		rdbtnOneWay.setBounds(4, 235, 113, 25);
		contentPane.add(rdbtnOneWay);
		
		JRadioButton rdbtnBothWays = new JRadioButton(Messages.getString("FF.BothWays")); //$NON-NLS-1$
		rdbtnBothWays.setBackground(new Color(173, 216, 230));
		rdbtnBothWays.setBounds(4, 265, 113, 25);
		contentPane.add(rdbtnBothWays);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnOneWay);
		group.add(rdbtnBothWays);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(12, 316, 77, 22);
		contentPane.add(spinner);
		
		JLabel lblAdaults = new JLabel(Messages.getString("FF.Adults")); //$NON-NLS-1$
		lblAdaults.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblAdaults.setBounds(12, 296, 77, 16);
		contentPane.add(lblAdaults);
		
		JLabel lblChildrens = new JLabel(Messages.getString("FF.Children")); //$NON-NLS-1$
		lblChildrens.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblChildrens.setBounds(12, 344, 77, 16);
		contentPane.add(lblChildrens);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_1.setBounds(12, 362, 77, 22);
		contentPane.add(spinner_1);
		
		JLabel lblInterests = new JLabel(Messages.getString("FF.Interests")); //$NON-NLS-1$
		lblInterests.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblInterests.setBounds(12, 391, 77, 25);
		contentPane.add(lblInterests);
		
		JRadioButton rdbtnGolfing = new JRadioButton(Messages.getString("FF.Golf")); //$NON-NLS-1$
		rdbtnGolfing.setBackground(new Color(173, 216, 230));
		rdbtnGolfing.setBounds(12, 425, 107, 25);
		contentPane.add(rdbtnGolfing);
		
		JRadioButton rdbtnRelaxing = new JRadioButton(Messages.getString("FF.Relax")); //$NON-NLS-1$
		rdbtnRelaxing.setBackground(new Color(173, 216, 230));
		rdbtnRelaxing.setBounds(12, 455, 109, 25);
		contentPane.add(rdbtnRelaxing);
		
		JRadioButton rdbtnParty = new JRadioButton(Messages.getString("FF.Party")); //$NON-NLS-1$
		rdbtnParty.setBackground(new Color(173, 216, 230));
		rdbtnParty.setBounds(12, 485, 99, 25);
		contentPane.add(rdbtnParty);
		
		JRadioButton rdbtnSunshine = new JRadioButton(Messages.getString("FF.Sunshine")); //$NON-NLS-1$
		rdbtnSunshine.setBackground(new Color(173, 216, 230));
		rdbtnSunshine.setBounds(12, 515, 99, 25);
		contentPane.add(rdbtnSunshine);
		
		JRadioButton rdbtnShopping = new JRadioButton(Messages.getString("FF.Shop")); //$NON-NLS-1$
		rdbtnShopping.setBackground(new Color(173, 216, 230));
		rdbtnShopping.setBounds(12, 545, 99, 25);
		contentPane.add(rdbtnShopping);
		
		JLabel lblDateFrom = new JLabel(Messages.getString("FF.DateFrom")); //$NON-NLS-1$
		lblDateFrom.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblDateFrom.setBounds(12, 122, 99, 16);
		contentPane.add(lblDateFrom);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(13, 138, 76, 22);
		contentPane.add(dateChooser);
		
		JLabel lblDateTo = new JLabel(Messages.getString("FF.DateTo")); //$NON-NLS-1$
		lblDateTo.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblDateTo.setBounds(12, 173, 56, 16);
		contentPane.add(lblDateTo);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(12, 189, 76, 22);
		contentPane.add(dateChooser_1);
		
		JButton btnAddToCart = new JButton(Messages.getString("FF.AddToCart")); //$NON-NLS-1$
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage(); //$NON-NLS-1$
		btnAddToCart.setIcon(new ImageIcon(imgLogin));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart AddtoCart=new Cart();
				AddtoCart.setVisible(true);
				//dispose();
			}
		});
		btnAddToCart.setBounds(338, 542, 162, 33);
		contentPane.add(btnAddToCart);
		
		SearchTextfield = new JTextField();
		SearchTextfield.setBounds(120, 43, 549, 25);
		contentPane.add(SearchTextfield);
		SearchTextfield.setColumns(10);
		
		JButton ButtonSearch = new JButton(""); //$NON-NLS-1$
		Image imgSearch = new ImageIcon(this.getClass().getResource("/search.png")).getImage(); //$NON-NLS-1$
		ButtonSearch.setIcon(new ImageIcon(imgSearch));
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonSearch.setBounds(670, 42, 47, 25);
		contentPane.add(ButtonSearch);
		
		JPanel panelResault = new JPanel();
		panelResault.setBackground(new Color(176, 224, 230));
		panelResault.setBounds(120, 89, 597, 437);
		contentPane.add(panelResault);
		
		JButton EnglishButton = new JButton(""); //$NON-NLS-1$
		EnglishButton.setBackground(new Color(173, 216, 230));
		Image imgEnglish = new ImageIcon(this.getClass().getResource("/britain.png")).getImage(); //$NON-NLS-1$
		EnglishButton.setIcon(new ImageIcon(imgEnglish));
		EnglishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		EnglishButton.setBounds(691, 9, 34, 24);
		contentPane.add(EnglishButton);
		
		JButton IcelandicButton = new JButton(""); //$NON-NLS-1$
		IcelandicButton.setBackground(new Color(173, 216, 230));
		Image imgIcelandic = new ImageIcon(this.getClass().getResource("/Icelandic.png")).getImage(); //$NON-NLS-1$
		IcelandicButton.setIcon(new ImageIcon(imgIcelandic));
		IcelandicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		IcelandicButton.setBounds(737, 9, 34, 24);
		contentPane.add(IcelandicButton);
		
		JRadioButton rdbtnFlight = new JRadioButton(Messages.getString("FF.FlightCheck")); //$NON-NLS-1$
		rdbtnFlight.setFont(new Font("Tahoma", Font.BOLD, 16)); //$NON-NLS-1$
		rdbtnFlight.setBackground(new Color(173, 216, 230));
		rdbtnFlight.setBounds(153, 9, 127, 25);
		contentPane.add(rdbtnFlight);
		
		JRadioButton rdbtnHotel = new JRadioButton(Messages.getString("FF.HotelCheck")); //$NON-NLS-1$
		rdbtnHotel.setFont(new Font("Tahoma", Font.BOLD, 16)); //$NON-NLS-1$
		rdbtnHotel.setBackground(new Color(173, 216, 230));
		rdbtnHotel.setBounds(324, 9, 127, 25);
		contentPane.add(rdbtnHotel);
		
		JRadioButton rdbtnDaytrip = new JRadioButton(Messages.getString("FF.DayTripCheck")); //$NON-NLS-1$
		rdbtnDaytrip.setBackground(new Color(173, 216, 230));
		rdbtnDaytrip.setFont(new Font("Tahoma", Font.BOLD, 16)); //$NON-NLS-1$
		rdbtnDaytrip.setBounds(485, 9, 127, 25);
		contentPane.add(rdbtnDaytrip);
		
		JLabel lblLocation = new JLabel(Messages.getString("FF.Location")); //$NON-NLS-1$
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblLocation.setBounds(12, 70, 77, 16);
		contentPane.add(lblLocation);
		
		txtLocation = new JTextField();
		txtLocation.setBounds(12, 89, 105, 25);
		contentPane.add(txtLocation);
		txtLocation.setColumns(10);
	}
}
