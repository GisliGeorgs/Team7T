import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JMenuBar;
import java.awt.Panel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JFormattedTextField;

public class FrontFrame extends JPanel
{

	/*public FrontFrame(){
		initComponents();  
		setIcon();
	} */
	
	private JFrame frame;
	private JTextField SearchTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontFrame window = new FrontFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrontFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.getContentPane().setLayout(null);
		
		SearchTextField = new JTextField();
		SearchTextField.setBounds(151, 41, 659, 30);
		frame.getContentPane().add(SearchTextField);
		SearchTextField.setColumns(10);
		
		JButton SearchButton = new JButton("");
		Image imgSearch = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		SearchButton.setIcon(new ImageIcon(imgSearch));
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SearchButton.setBounds(811, 41, 38, 30);
		frame.getContentPane().add(SearchButton);
		
		JButton btnAddCart = new JButton("Add to cart");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnAddCart.setIcon(new ImageIcon(imgLogin));
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart YourCart=new Cart();
				YourCart.setVisible(true);
			}
		});
		btnAddCart.setBounds(379, 546, 168, 40);
		frame.getContentPane().add(btnAddCart);
		
		JCheckBox chckbxFlight = new JCheckBox("Flight");
		chckbxFlight.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxFlight.setBackground(new Color(173, 216, 230));
		chckbxFlight.setBounds(151, 7, 113, 25);
		frame.getContentPane().add(chckbxFlight);
		
		JCheckBox chckbxHotel = new JCheckBox("Hotel");
		chckbxHotel.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxHotel.setBackground(new Color(173, 216, 230));
		chckbxHotel.setBounds(434, 7, 113, 25);
		frame.getContentPane().add(chckbxHotel);
		
		JCheckBox chckbxDaytrip = new JCheckBox("Daytrip");
		chckbxDaytrip.setFont(new Font("Tahoma", Font.BOLD, 16));
		chckbxDaytrip.setBackground(new Color(173, 216, 230));
		chckbxDaytrip.setBounds(697, 7, 113, 25);
		frame.getContentPane().add(chckbxDaytrip);
		
		JLabel lblForFlight = new JLabel("For flight");
		lblForFlight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForFlight.setBounds(12, 73, 115, 16);
		frame.getContentPane().add(lblForFlight);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(12, 170, 115, 25);
		frame.getContentPane().add(spinner);
		
		JLabel lblAdaults = new JLabel("Adaults:");
		lblAdaults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdaults.setBounds(12, 153, 115, 16);
		frame.getContentPane().add(lblAdaults);
		
		JLabel lblChildrens = new JLabel("Childrens:");
		lblChildrens.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChildrens.setBounds(12, 205, 115, 16);
		frame.getContentPane().add(lblChildrens);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_1.setBounds(12, 223, 115, 25);
		frame.getContentPane().add(spinner_1);
		
		JRadioButton rdbtnOneWay = new JRadioButton("One way");
		rdbtnOneWay.setBackground(new Color(173, 216, 230));
		rdbtnOneWay.setBounds(12, 93, 127, 25);
		frame.getContentPane().add(rdbtnOneWay);
		
		JRadioButton rdbtnBothWays = new JRadioButton("Both ways");
		rdbtnBothWays.setBackground(new Color(173, 216, 230));
		rdbtnBothWays.setBounds(12, 118, 127, 25);
		frame.getContentPane().add(rdbtnBothWays);
		
		JLabel lblInterests = new JLabel("Interests");
		lblInterests.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInterests.setBounds(12, 261, 87, 25);
		frame.getContentPane().add(lblInterests);
		
		JRadioButton rdbtnGolfing = new JRadioButton("Golfing");
		rdbtnGolfing.setBackground(new Color(173, 216, 230));
		rdbtnGolfing.setBounds(12, 284, 127, 25);
		frame.getContentPane().add(rdbtnGolfing);
		
		JRadioButton rdbtnRelaxing = new JRadioButton("Relaxing");
		rdbtnRelaxing.setBackground(new Color(173, 216, 230));
		rdbtnRelaxing.setBounds(12, 306, 127, 25);
		frame.getContentPane().add(rdbtnRelaxing);
		
		JRadioButton rdbtnParty = new JRadioButton("Party");
		rdbtnParty.setBackground(new Color(173, 216, 230));
		rdbtnParty.setBounds(12, 331, 127, 25);
		frame.getContentPane().add(rdbtnParty);
		
		JRadioButton rdbtnSunshine = new JRadioButton("Sunshine");
		rdbtnSunshine.setBackground(new Color(173, 216, 230));
		rdbtnSunshine.setBounds(12, 352, 127, 25);
		frame.getContentPane().add(rdbtnSunshine);
		
		JRadioButton rdbtnShopping = new JRadioButton("Shopping");
		rdbtnShopping.setBackground(new Color(173, 216, 230));
		rdbtnShopping.setBounds(12, 373, 127, 25);
		frame.getContentPane().add(rdbtnShopping);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(22, 407, 56, 16);
		frame.getContentPane().add(lblDate);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFrom.setBounds(12, 435, 56, 16);
		frame.getContentPane().add(lblFrom);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerDateModel(new Date(1459641600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_2.setBounds(12, 456, 115, 22);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTo.setBounds(12, 491, 56, 16);
		frame.getContentPane().add(lblTo);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerDateModel(new Date(1459641600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_3.setBounds(12, 508, 115, 22);
		frame.getContentPane().add(spinner_3);
		frame.setBackground(new Color(255, 182, 193));
		frame.setBounds(100, 100, 912, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem AboutUs = new JMenuItem("About us");
		AboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs AUs=new AboutUs();
				AUs.setVisible(true);
			}
		});
		
		JMenuItem FAQ = new JMenuItem("FAQ");
		FAQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAQ FreqAQuest=new FAQ();
				FreqAQuest.setVisible(true);
			}
		});
		
		JMenuItem mntmOrders = new JMenuItem("Orders");
		mntmOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginOrder Log=new LoginOrder();
				Log.setVisible(true);
			}
		});
		menuBar.add(mntmOrders);
		menuBar.add(FAQ);
		menuBar.add(AboutUs);
	}
	
	/*private void setIcon(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass()getResource("ticket.png")));
	}*/

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
