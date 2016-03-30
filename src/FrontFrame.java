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

public class FrontFrame //extends javax.swing.JFrame // 
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
		SearchTextField.setBounds(80, 41, 730, 30);
		frame.getContentPane().add(SearchTextField);
		SearchTextField.setColumns(10);
		
		JLabel LastLookedAt = new JLabel("LastLookedAt");
		LastLookedAt.setBounds(12, 107, 155, 504);
		frame.getContentPane().add(LastLookedAt);
		
		JButton SearchButton = new JButton("");
		Image imgSearch = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		SearchButton.setIcon(new ImageIcon(imgSearch));
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SearchButton.setBounds(811, 41, 38, 30);
		frame.getContentPane().add(SearchButton);
		frame.setBackground(new Color(255, 182, 193));
		frame.setBounds(100, 100, 912, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem Hotel = new JMenuItem("Search");
		Hotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Hotel.setActionCommand("Search");
		menuBar.add(Hotel);
		
		JMenuItem MyOrdersNavbar = new JMenuItem("My Orders");
		MyOrdersNavbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				OrderLogin OrderL=new OrderLogin();
				OrderL.setVisible(true);
			}
		});
		menuBar.add(MyOrdersNavbar);
		
		JMenuItem AboutUs = new JMenuItem("About us");
		AboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				test tt=new test();
				tt.setVisible(true);
			}
		});
		
		JMenuItem FAQ = new JMenuItem("FAQ");
		FAQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
}
