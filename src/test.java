import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDraslTilA = new JLabel("Drasl til a\u00F0 pr\u00F3fa stuff \u00E1 \u00E1n \u00FEess a\u00F0 fokka \u00F6llu upp");
		lblDraslTilA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDraslTilA.setBounds(12, 33, 393, 173);
		frame.getContentPane().add(lblDraslTilA);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
