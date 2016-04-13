import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class testid extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testid frame = new testid();
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
	public testid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		JTextField jtf = new JTextField(6);
        jtf.setInputVerifier(new InputVerifier()
        {   
                public boolean verify(JComponent input) 
                {   
                    JTextField tField = (JTextField) input;   
                    return (tField.getText().trim().length() == 6);
                }
        });
       
		
		textField.setBounds(75, 117, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
