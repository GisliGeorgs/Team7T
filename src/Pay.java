import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.main.java.controller.CartController;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import Hotel.Booking;
import Hotel.BookingController;
import com.main.java.form.User;

public class Pay extends JFrame {

	private JPanel contentPane;
	private JTextField Cardnum;
	private JTextField CVCnum;

	private User user;
	private CartController cart;
    // TODO Fara í gegnum listana 3 og summa verð og birta.
    // TODO Actually að bóka hlutina í hinum componentunum.
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pay frame = new Pay( );
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
	public Pay(){
		this.cart = new CartController();
		this.user = new User();
		Setup();
	}

	public Pay( CartController cart, User user ) {
        this.cart = cart;
        this.user = user;
        Setup();
	}
	
	private void Setup(){

		setIconImage(
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
		setTitle("Team 7T - Payments");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 358);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayments = new JLabel("Payments");
		lblPayments.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPayments.setBounds(160, 0, 100, 26);
		contentPane.add(lblPayments);
		
		JButton btnPay = new JButton("Pay");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		btnPay.setIcon(new ImageIcon(imgLogin));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ordernum = cart.CreateCartOrder();
				
				YourOrderNumberIs YONI=new YourOrderNumberIs( user, ordernum );
				YONI.setVisible(true);
				dispose();
			}
		});
		btnPay.setBounds(97, 256, 116, 26);
		contentPane.add(btnPay);
		
		JButton btnCancel = new JButton("Cancel");
		Image imgLogin2 = new ImageIcon(this.getClass().getResource("/Close-2-icon.png")).getImage();
		btnCancel.setIcon(new ImageIcon(imgLogin2));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart BacktoCart=new Cart( cart, user );
				BacktoCart.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(271, 257, 116, 25);
		contentPane.add(btnCancel);
		
		JLabel lblCardNumber = new JLabel("Card number");
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCardNumber.setBounds(12, 42, 100, 16);
		contentPane.add(lblCardNumber);
		
		JLabel lblExpirationDate = new JLabel("Expiration date");
		lblExpirationDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpirationDate.setBounds(12, 109, 116, 16);
		contentPane.add(lblExpirationDate);
		
		JLabel lblCvc = new JLabel("CVC");
		lblCvc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCvc.setBounds(12, 167, 56, 16);
		contentPane.add(lblCvc);
		
		Cardnum = new JTextField();
		Cardnum.setBounds(12, 68, 217, 22);
		contentPane.add(Cardnum);
		Cardnum.setColumns(10);
		Cardnum.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(Cardnum.getText().length()>=16&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		
		CVCnum = new JTextField();
		CVCnum.setBounds(12, 189, 49, 22);
		contentPane.add(CVCnum);
		CVCnum.setColumns(10);
		CVCnum.addKeyListener(new java.awt.event.KeyAdapter() {
		    public void keyTyped(java.awt.event.KeyEvent evt) {
		        if(CVCnum.getText().length()>=3&&!(evt.getKeyChar()==KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
		            getToolkit().beep();
		            evt.consume();
		         }
		     }
		});
		
		JRadioButton rdbtnVisa = new JRadioButton("");
		rdbtnVisa.setBackground(new Color(248, 248, 255));
		rdbtnVisa.setBounds(259, 39, 25, 25);
		contentPane.add(rdbtnVisa);
		
		JRadioButton rdbtnMastercard = new JRadioButton("");
		rdbtnMastercard.setBackground(new Color(248, 248, 255));
		rdbtnMastercard.setBounds(259, 100, 25, 25);
		contentPane.add(rdbtnMastercard);
		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnVisa);
		group.add(rdbtnMastercard);
		
		JLabel VisaPic = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/VisaPic.png")).getImage();
		VisaPic.setIcon(new ImageIcon(img));
		VisaPic.setBounds(292, 30, 95, 43);
		contentPane.add(VisaPic);
		
		JLabel MasterCardPic = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Master-Card.png")).getImage();
		MasterCardPic.setIcon(new ImageIcon(img2));
		MasterCardPic.setBounds(292, 86, 106, 61);
		contentPane.add(MasterCardPic);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(127, 132, 51, 22);
		contentPane.add(yearChooser);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(12, 132, 111, 22);
		contentPane.add(monthChooser);
	}
}
