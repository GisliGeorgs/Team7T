import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class HotelFF extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelFF frame = new HotelFF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	FF ff;
	private ArrayList<JCheckBox> buttons;
	/**
	 * Create the frame.
	 */
	public HotelFF(FF ff ){
		SetUp();
	}
	
	public HotelFF(){
		SetUp();
	}
	
	public void SetUp()
	{
		setIconImage(
<<<<<<< HEAD
			new ImageIcon(getClass().getResource("/7.png")).getImage()
		);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 706, 457);
		setTitle("Hotel specific search");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnWheelchairAccess = new JRadioButton("wheelchair access");
		rdbtnWheelchairAccess.setBackground(new Color(173, 216, 230));
		rdbtnWheelchairAccess.setBounds(39, 316, 138, 25);
		contentPane.add(rdbtnWheelchairAccess);
		
		JRadioButton rdbtnWifi = new JRadioButton("Wifi");
		rdbtnWifi.setBackground(new Color(173, 216, 230));
		rdbtnWifi.setBounds(193, 225, 127, 25);
		contentPane.add(rdbtnWifi);
		
		JRadioButton rdbtnTv = new JRadioButton("TV");
		rdbtnTv.setBackground(new Color(173, 216, 230));
		rdbtnTv.setBounds(193, 255, 127, 25);
		contentPane.add(rdbtnTv);
		
		JRadioButton rdbtnMinibar = new JRadioButton("Mini-bar");
		rdbtnMinibar.setBackground(new Color(173, 216, 230));
		rdbtnMinibar.setBounds(193, 105, 127, 25);
		contentPane.add(rdbtnMinibar);
		
		JRadioButton rdbtnSafetyDepositBox = new JRadioButton("Safety deposit box");
		rdbtnSafetyDepositBox.setBackground(new Color(173, 216, 230));
		rdbtnSafetyDepositBox.setBounds(193, 135, 138, 25);
		contentPane.add(rdbtnSafetyDepositBox);
		
		JRadioButton rdbtnRoomService = new JRadioButton("Room service");
		rdbtnRoomService.setBackground(new Color(173, 216, 230));
		rdbtnRoomService.setBounds(193, 165, 138, 25);
		contentPane.add(rdbtnRoomService);
		
		JRadioButton rdbtnSmoking = new JRadioButton("Smoking");
		rdbtnSmoking.setBackground(new Color(173, 216, 230));
		rdbtnSmoking.setBounds(193, 195, 127, 25);
		contentPane.add(rdbtnSmoking);
		
		JRadioButton rdbtnGym = new JRadioButton("Gym");
		rdbtnGym.setBackground(new Color(173, 216, 230));
		rdbtnGym.setBounds(39, 105, 127, 25);
		contentPane.add(rdbtnGym);
		
		JRadioButton rdbtnBar = new JRadioButton("Bar");
		rdbtnBar.setBackground(new Color(173, 216, 230));
		rdbtnBar.setBounds(39, 135, 127, 25);
		contentPane.add(rdbtnBar);
		
		JRadioButton rdbtnSpa = new JRadioButton("Spa");
		rdbtnSpa.setBackground(new Color(173, 216, 230));
		rdbtnSpa.setBounds(39, 165, 127, 25);
		contentPane.add(rdbtnSpa);
		
		JRadioButton rdbtnBreakfast = new JRadioButton("Breakfast");
		rdbtnBreakfast.setBackground(new Color(173, 216, 230));
		rdbtnBreakfast.setBounds(39, 195, 127, 25);
		contentPane.add(rdbtnBreakfast);
		
		JRadioButton rdbtnVegan = new JRadioButton("Vegan");
		rdbtnVegan.setBackground(new Color(173, 216, 230));
		rdbtnVegan.setBounds(39, 255, 127, 25);
		contentPane.add(rdbtnVegan);
		
		JRadioButton rdbtnNoCancellationFee = new JRadioButton("No cancellation fee");
		rdbtnNoCancellationFee.setBackground(new Color(173, 216, 230));
		rdbtnNoCancellationFee.setBounds(39, 225, 150, 25);
		contentPane.add(rdbtnNoCancellationFee);
		
		JRadioButton rdbtnConferenceRoom = new JRadioButton("Conference room");
		rdbtnConferenceRoom.setBackground(new Color(173, 216, 230));
		rdbtnConferenceRoom.setBounds(39, 286, 127, 25);
		contentPane.add(rdbtnConferenceRoom);
		
		JLabel lblHotelSpecificSearch = new JLabel("Hotel specific search");
		lblHotelSpecificSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHotelSpecificSearch.setBounds(261, 13, 202, 34);
		contentPane.add(lblHotelSpecificSearch);
		
		JLabel lblTypeOfAcomodation = new JLabel("Type of acomodation");
		lblTypeOfAcomodation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeOfAcomodation.setBounds(519, 82, 146, 25);
		contentPane.add(lblTypeOfAcomodation);
		
		JLabel lblTypeOfClientele = new JLabel("Type of clientele");
		lblTypeOfClientele.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeOfClientele.setBounds(360, 86, 127, 16);
		contentPane.add(lblTypeOfClientele);
		
		JLabel lblRooms = new JLabel("Rooms");
		lblRooms.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRooms.setBounds(193, 86, 56, 16);
		contentPane.add(lblRooms);
		
		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGeneral.setBounds(39, 86, 56, 16);
		contentPane.add(lblGeneral);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hotel", "Hostel", "Motel"}));
		comboBox.setBounds(519, 106, 106, 22);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnYouth = new JRadioButton("Youth");
		rdbtnYouth.setBackground(new Color(173, 216, 230));
		rdbtnYouth.setBounds(360, 105, 127, 25);
		contentPane.add(rdbtnYouth);
		
		JRadioButton rdbtnBusiness = new JRadioButton("Business");
		rdbtnBusiness.setBackground(new Color(173, 216, 230));
		rdbtnBusiness.setBounds(360, 135, 127, 25);
		contentPane.add(rdbtnBusiness);
		
		JRadioButton rdbtnRomantic = new JRadioButton("Romantic");
		rdbtnRomantic.setBackground(new Color(173, 216, 230));
		rdbtnRomantic.setBounds(360, 165, 127, 25);
		contentPane.add(rdbtnRomantic);
		
		JRadioButton rdbtnRelaxation = new JRadioButton("Relaxation");
		rdbtnRelaxation.setBackground(new Color(173, 216, 230));
		rdbtnRelaxation.setBounds(360, 195, 127, 25);
		contentPane.add(rdbtnRelaxation);
		
		JCheckBox rdbtnFamilyFriendly = new JCheckBox("Family friendly");
		rdbtnFamilyFriendly.setBackground(new Color(173, 216, 230));
		rdbtnFamilyFriendly.setBounds(360, 225, 127, 25);
		contentPane.add(rdbtnFamilyFriendly);
		
		JButton btnFinish = new JButton("Finish");
		Image imgFinish = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage(); //$NON-NLS-1$
		btnFinish.setIcon(new ImageIcon(imgFinish));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ff.SetHotelBlah();
				dispose();
			}
		});
		btnFinish.setBounds(288, 372, 97, 25);
		contentPane.add(btnFinish);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(53, 360, 113, 25);
		contentPane.add(chckbxNewCheckBox);
=======
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 706, 457);
			setTitle("Hotel specific search");
			contentPane = new JPanel();
			contentPane.setBackground(new Color(173, 216, 230));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JCheckBox rdbtnWheelchairAccess = new JCheckBox("wheelchair access");
			rdbtnWheelchairAccess.setBackground(new Color(173, 216, 230));
			rdbtnWheelchairAccess.setBounds(39, 316, 138, 25);
			contentPane.add(rdbtnWheelchairAccess);
			buttons.add(rdbtnWheelchairAccess);
			
			JCheckBox rdbtnWifi = new JCheckBox("Wifi");
			rdbtnWifi.setBackground(new Color(173, 216, 230));
			rdbtnWifi.setBounds(193, 225, 127, 25);
			contentPane.add(rdbtnWifi);
			buttons.add(rdbtnWifi);
			
			JCheckBox rdbtnTv = new JCheckBox("TV");
			rdbtnTv.setBackground(new Color(173, 216, 230));
			rdbtnTv.setBounds(193, 255, 127, 25);
			contentPane.add(rdbtnTv);
			buttons.add(rdbtnTv);
			
			JCheckBox rdbtnMinibar = new JCheckBox("Mini-bar");
			rdbtnMinibar.setBackground(new Color(173, 216, 230));
			rdbtnMinibar.setBounds(193, 105, 127, 25);
			contentPane.add(rdbtnMinibar);
			buttons.add(rdbtnMinibar);
			
			JCheckBox rdbtnSafetyDepositBox = new JCheckBox("Safety deposit box");
			rdbtnSafetyDepositBox.setBackground(new Color(173, 216, 230));
			rdbtnSafetyDepositBox.setBounds(193, 135, 138, 25);
			contentPane.add(rdbtnSafetyDepositBox);
			buttons.add(rdbtnSafetyDepositBox);
			
			JCheckBox rdbtnRoomService = new JCheckBox("Room service");
			rdbtnRoomService.setBackground(new Color(173, 216, 230));
			rdbtnRoomService.setBounds(193, 165, 138, 25);
			contentPane.add(rdbtnRoomService);
			buttons.add(rdbtnRoomService);
			
			JCheckBox rdbtnSmoking = new JCheckBox("Smoking");
			rdbtnSmoking.setBackground(new Color(173, 216, 230));
			rdbtnSmoking.setBounds(193, 195, 127, 25);
			contentPane.add(rdbtnSmoking);
			buttons.add(rdbtnSmoking);
			
			JCheckBox rdbtnGym = new JCheckBox("Gym");
			rdbtnGym.setBackground(new Color(173, 216, 230));
			rdbtnGym.setBounds(39, 105, 127, 25);
			contentPane.add(rdbtnGym);
			buttons.add(rdbtnGym);
			
			JCheckBox rdbtnBar = new JCheckBox("Bar");
			rdbtnBar.setBackground(new Color(173, 216, 230));
			rdbtnBar.setBounds(39, 135, 127, 25);
			contentPane.add(rdbtnBar);
			buttons.add(rdbtnBar);
			
			JCheckBox rdbtnSpa = new JCheckBox("Spa");
			rdbtnSpa.setBackground(new Color(173, 216, 230));
			rdbtnSpa.setBounds(39, 165, 127, 25);
			contentPane.add(rdbtnSpa);
			buttons.add(rdbtnSpa);
			
			JCheckBox rdbtnBreakfast = new JCheckBox("Breakfast");
			rdbtnBreakfast.setBackground(new Color(173, 216, 230));
			rdbtnBreakfast.setBounds(39, 195, 127, 25);
			contentPane.add(rdbtnBreakfast);
			buttons.add(rdbtnBreakfast);
			
			JCheckBox rdbtnVegan = new JCheckBox("Vegan");
			rdbtnVegan.setBackground(new Color(173, 216, 230));
			rdbtnVegan.setBounds(39, 255, 127, 25);
			contentPane.add(rdbtnVegan);
			buttons.add(rdbtnVegan);
			
			JCheckBox rdbtnNoCancellationFee = new JCheckBox("No cancellation fee");
			rdbtnNoCancellationFee.setBackground(new Color(173, 216, 230));
			rdbtnNoCancellationFee.setBounds(39, 225, 150, 25);
			contentPane.add(rdbtnNoCancellationFee);
			buttons.add(rdbtnNoCancellationFee);
			
			JCheckBox rdbtnConferenceRoom = new JCheckBox("Conference room");
			rdbtnConferenceRoom.setBackground(new Color(173, 216, 230));
			rdbtnConferenceRoom.setBounds(39, 286, 127, 25);
			contentPane.add(rdbtnConferenceRoom);
			buttons.add(rdbtnConferenceRoom);
			
			JLabel lblHotelSpecificSearch = new JLabel("Hotel specific search");
			lblHotelSpecificSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblHotelSpecificSearch.setBounds(261, 13, 202, 34);
			contentPane.add(lblHotelSpecificSearch);
			
			JLabel lblTypeOfAcomodation = new JLabel("Type of acomodation");
			lblTypeOfAcomodation.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTypeOfAcomodation.setBounds(519, 82, 146, 25);
			contentPane.add(lblTypeOfAcomodation);
			
			JLabel lblTypeOfClientele = new JLabel("Type of clientele");
			lblTypeOfClientele.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTypeOfClientele.setBounds(360, 86, 127, 16);
			contentPane.add(lblTypeOfClientele);
			
			JLabel lblRooms = new JLabel("Rooms");
			lblRooms.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRooms.setBounds(193, 86, 56, 16);
			contentPane.add(lblRooms);
			
			JLabel lblGeneral = new JLabel("General");
			lblGeneral.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblGeneral.setBounds(39, 86, 56, 16);
			contentPane.add(lblGeneral);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hotel", "Hostel", "Motel"}));
			comboBox.setBounds(519, 106, 106, 22);
			contentPane.add(comboBox);
			
			JCheckBox rdbtnYouth = new JCheckBox("Youth");
			rdbtnYouth.setBackground(new Color(173, 216, 230));
			rdbtnYouth.setBounds(360, 105, 127, 25);
			contentPane.add(rdbtnYouth);
			buttons.add(rdbtnYouth);
			
			JCheckBox rdbtnBusiness = new JCheckBox("Business");
			rdbtnBusiness.setBackground(new Color(173, 216, 230));
			rdbtnBusiness.setBounds(360, 135, 127, 25);
			contentPane.add(rdbtnBusiness);
			buttons.add(rdbtnBusiness);
			
			JCheckBox rdbtnRomantic = new JCheckBox("Romantic");
			rdbtnRomantic.setBackground(new Color(173, 216, 230));
			rdbtnRomantic.setBounds(360, 165, 127, 25);
			contentPane.add(rdbtnRomantic);
			buttons.add(rdbtnRomantic);
			
			JCheckBox rdbtnRelaxation = new JCheckBox("Relaxation");
			rdbtnRelaxation.setBackground(new Color(173, 216, 230));
			rdbtnRelaxation.setBounds(360, 195, 127, 25);
			contentPane.add(rdbtnRelaxation);
			buttons.add(rdbtnRelaxation);
			
			JCheckBox rdbtnFamilyFriendly = new JCheckBox("Family friendly");
			rdbtnFamilyFriendly.setBackground(new Color(173, 216, 230));
			rdbtnFamilyFriendly.setBounds(360, 225, 127, 25);
			contentPane.add(rdbtnFamilyFriendly);
			buttons.add(rdbtnFamilyFriendly);
			
			JButton btnFinish = new JButton("Finish");
			Image imgFinish = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage(); //$NON-NLS-1$
			btnFinish.setIcon(new ImageIcon(imgFinish));
			btnFinish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for( int i = 0; i < buttons.size(); i++ ){
						if( buttons.get(i).isSelected() ){
							ff.AddCheckbox( buttons.get(i).getText() );
						}					
					}
					ff.ChangeToArray();
					dispose();
				}
			});
			btnFinish.setBounds(288, 372, 97, 25);
			contentPane.add(btnFinish);
>>>>>>> c1397060eefcf931ccfa92275e242b51a67de95b
	}
}
