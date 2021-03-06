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
		this.ff = ff;
		buttons = new ArrayList<JCheckBox>();
		SetUp();
	}
	
	public HotelFF(){
		buttons = new ArrayList<JCheckBox>();
		SetUp();
	}
	
	public void SetUp()
	{
		setIconImage(
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 706, 457);
			setTitle("Hotel specific search");
			contentPane = new JPanel();
			contentPane.setBackground(new Color(248, 248, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JCheckBox rdbtnWheelchairAccess = new JCheckBox("wheelchair access");
			rdbtnWheelchairAccess.setBackground(new Color(248, 248, 255));
			rdbtnWheelchairAccess.setBounds(39, 316, 138, 25);
			contentPane.add(rdbtnWheelchairAccess);
			buttons.add(rdbtnWheelchairAccess);
			
			JCheckBox rdbtnWifi = new JCheckBox("Wifi");
			rdbtnWifi.setBackground(new Color(248, 248, 255));
			rdbtnWifi.setBounds(193, 225, 127, 25);
			contentPane.add(rdbtnWifi);
			buttons.add(rdbtnWifi);
			
			JCheckBox rdbtnTv = new JCheckBox("TV");
			rdbtnTv.setBackground(new Color(248, 248, 255));
			rdbtnTv.setBounds(193, 255, 127, 25);
			contentPane.add(rdbtnTv);
			buttons.add(rdbtnTv);
			
			JCheckBox rdbtnMinibar = new JCheckBox("Mini-bar");
			rdbtnMinibar.setBackground(new Color(248, 248, 255));
			rdbtnMinibar.setBounds(193, 105, 127, 25);
			contentPane.add(rdbtnMinibar);
			buttons.add(rdbtnMinibar);
			
			JCheckBox rdbtnSafetyDepositBox = new JCheckBox("Safety deposit box");
			rdbtnSafetyDepositBox.setBackground(new Color(248, 248, 255));
			rdbtnSafetyDepositBox.setBounds(193, 135, 138, 25);
			contentPane.add(rdbtnSafetyDepositBox);
			buttons.add(rdbtnSafetyDepositBox);
			
			JCheckBox rdbtnRoomService = new JCheckBox("Room service");
			rdbtnRoomService.setBackground(new Color(248, 248, 255));
			rdbtnRoomService.setBounds(193, 165, 138, 25);
			contentPane.add(rdbtnRoomService);
			buttons.add(rdbtnRoomService);
			
			JCheckBox rdbtnSmoking = new JCheckBox("Smoking");
			rdbtnSmoking.setBackground(new Color(248, 248, 255));
			rdbtnSmoking.setBounds(193, 195, 127, 25);
			contentPane.add(rdbtnSmoking);
			buttons.add(rdbtnSmoking);
			
			JCheckBox rdbtnGym = new JCheckBox("Gym");
			rdbtnGym.setBackground(new Color(248, 248, 255));
			rdbtnGym.setBounds(39, 105, 127, 25);
			contentPane.add(rdbtnGym);
			buttons.add(rdbtnGym);
			
			JCheckBox rdbtnBar = new JCheckBox("Bar");
			rdbtnBar.setBackground(new Color(248, 248, 255));
			rdbtnBar.setBounds(39, 135, 127, 25);
			contentPane.add(rdbtnBar);
			buttons.add(rdbtnBar);
			
			JCheckBox rdbtnSpa = new JCheckBox("Spa");
			rdbtnSpa.setBackground(new Color(248, 248, 255));
			rdbtnSpa.setBounds(39, 165, 127, 25);
			contentPane.add(rdbtnSpa);
			buttons.add(rdbtnSpa);
			
			JCheckBox rdbtnBreakfast = new JCheckBox("Breakfast");
			rdbtnBreakfast.setBackground(new Color(248, 248, 255));
			rdbtnBreakfast.setBounds(39, 195, 127, 25);
			contentPane.add(rdbtnBreakfast);
			buttons.add(rdbtnBreakfast);
			
			JCheckBox rdbtnVegan = new JCheckBox("Vegan");
			rdbtnVegan.setBackground(new Color(248, 248, 255));
			rdbtnVegan.setBounds(39, 255, 127, 25);
			contentPane.add(rdbtnVegan);
			buttons.add(rdbtnVegan);
			
			JCheckBox rdbtnNoCancellationFee = new JCheckBox("No cancellation fee");
			rdbtnNoCancellationFee.setBackground(new Color(248, 248, 255));
			rdbtnNoCancellationFee.setBounds(39, 225, 150, 25);
			contentPane.add(rdbtnNoCancellationFee);
			buttons.add(rdbtnNoCancellationFee);
			
			JCheckBox rdbtnConferenceRoom = new JCheckBox("Conference room");
			rdbtnConferenceRoom.setBackground(new Color(248, 248, 255));
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
			rdbtnYouth.setBackground(new Color(248, 248, 255));
			rdbtnYouth.setBounds(360, 105, 127, 25);
			contentPane.add(rdbtnYouth);
			buttons.add(rdbtnYouth);
			
			JCheckBox rdbtnBusiness = new JCheckBox("Business");
			rdbtnBusiness.setBackground(new Color(248, 248, 255));
			rdbtnBusiness.setBounds(360, 135, 127, 25);
			contentPane.add(rdbtnBusiness);
			buttons.add(rdbtnBusiness);
			
			JCheckBox rdbtnRomantic = new JCheckBox("Romantic");
			rdbtnRomantic.setBackground(new Color(248, 248, 255));
			rdbtnRomantic.setBounds(360, 165, 127, 25);
			contentPane.add(rdbtnRomantic);
			buttons.add(rdbtnRomantic);
			
			JCheckBox rdbtnRelaxation = new JCheckBox("Relaxation");
			rdbtnRelaxation.setBackground(new Color(248, 248, 255));
			rdbtnRelaxation.setBounds(360, 195, 127, 25);
			contentPane.add(rdbtnRelaxation);
			buttons.add(rdbtnRelaxation);
			
			JCheckBox rdbtnFamilyFriendly = new JCheckBox("Family friendly");
			rdbtnFamilyFriendly.setBackground(new Color(248, 248, 255));
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
							System.out.println(buttons.get(i).getText());
							ff.AddCheckbox( buttons.get(i).getText() );
						}					
					}
					ff.AddCheckbox( (String)comboBox.getSelectedItem());
					ff.ChangeToArray();						
					
					dispose();
				}
			});
			btnFinish.setBounds(288, 372, 97, 25);
			contentPane.add(btnFinish);
	}
}
