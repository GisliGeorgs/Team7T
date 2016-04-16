import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class testLang extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testLang frame = new testLang();
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
	public testLang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCool = new JLabel(Messages.getString("testLang.lblCool")); //$NON-NLS-1$
		lblCool.setBounds(35, 39, 56, 16);
		contentPane.add(lblCool);
		
		JLabel lblDouble = new JLabel(Messages.getString("testLang.lclDouble")); //$NON-NLS-1$
		lblDouble.setBounds(35, 99, 56, 16);
		contentPane.add(lblDouble);
		
		JButton btnEn = new JButton(Messages.getString("testLang.btnEn")); //$NON-NLS-1$
		btnEn.setBounds(258, 30, 97, 25);
		contentPane.add(btnEn);
		
		JButton btnIce = new JButton(Messages.getString("testLang.btnIce")); //$NON-NLS-1$
		btnIce.setBounds(258, 95, 97, 25);
		contentPane.add(btnIce);
	}
}
