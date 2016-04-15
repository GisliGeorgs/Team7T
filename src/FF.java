import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import DayTrip.DayTrip;
import Flight.Flight;
import Hotel.Hotel;
import com.main.java.controller.CartController;
import com.main.java.controller.SearchController;
import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FF extends JFrame {

	private JPanel contentPane;
	private JTextField SearchTextfield;
	private JTextField txtLocation;
	private final ButtonGroup radioButtonGroupType = new ButtonGroup();
	
	/**
	 * 0 = flight
	 * 1 = hotel
	 * 2 = daytrip
	 */
	private int typeSelected;
	
	private String loc;
	private Date dateFrom;
	private Date dateTo;
	private boolean roundTrip;
	private int numPeople;
	private int price;
	private String[] interests = new String[]{ "Golfing", "Relaxing", "Party", "Sunshine", "Shopping" };
    CartController cart;

	private ArrayList<String> search;

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
		
		typeSelected = 0;
		cart = new CartController();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmPreviousOrders = new JMenuItem("Previous orders");
		mntmPreviousOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderLogin OrderLog=new OrderLogin();
				OrderLog.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmPreviousOrders);
		
		JMenuItem mntmFaq = new JMenuItem("FAQ");
		mntmFaq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FAQ FreqAQ=new FAQ();
				FreqAQ.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmFaq);
		
		JMenuItem mntmAboutUs = new JMenuItem("About us");
		mntmAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUs About=new AboutUs();
				About.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmAboutUs);
		
		JMenuItem mntmCart = new JMenuItem("Cart");
		mntmCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart YourCart=new Cart();
				YourCart.setVisible(true);
				//dispose();
			}
		});
		menuBar.add(mntmCart);
		
		JMenuItem mntmUser = new JMenuItem("User");
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
		
		JLabel lblForFlight = new JLabel("For flight");
		lblForFlight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForFlight.setBounds(14, 263, 77, 16);
		contentPane.add(lblForFlight);
		
		JRadioButton rdbtnOneWay = new JRadioButton("One way");
		rdbtnOneWay.setBackground(new Color(173, 216, 230));
		rdbtnOneWay.setBounds(14, 276, 77, 25);
		contentPane.add(rdbtnOneWay);
		
		JRadioButton rdbtnBothWays = new JRadioButton("Both ways");
		rdbtnBothWays.setBackground(new Color(173, 216, 230));
		rdbtnBothWays.setBounds(14, 304, 84, 25);
		contentPane.add(rdbtnBothWays);
		
		ButtonGroup radioButtonGroupRoundTrip=new ButtonGroup();
		radioButtonGroupRoundTrip.add(rdbtnOneWay);
		radioButtonGroupRoundTrip.add(rdbtnBothWays);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(12, 356, 77, 22);
		contentPane.add(spinner);
		
		JLabel lblAdaults = new JLabel("Adults");
		lblAdaults.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdaults.setBounds(12, 336, 77, 16);
		contentPane.add(lblAdaults);
		
		JLabel lblChildrens = new JLabel("Childrens:");
		lblChildrens.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChildrens.setBounds(12, 378, 77, 16);
		contentPane.add(lblChildrens);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_1.setBounds(12, 396, 77, 22);
		contentPane.add(spinner_1);
		
		JLabel lblInterests = new JLabel("Interests:");
		lblInterests.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInterests.setBounds(12, 418, 77, 25);
		contentPane.add(lblInterests);
		
		JRadioButton rdbtnGolfing = new JRadioButton("Golfing");
		rdbtnGolfing.setBackground(new Color(173, 216, 230));
		rdbtnGolfing.setBounds(12, 438, 107, 25);
		contentPane.add(rdbtnGolfing);
		
		JRadioButton rdbtnRelaxing = new JRadioButton("Relaxing");
		rdbtnRelaxing.setBackground(new Color(173, 216, 230));
		rdbtnRelaxing.setBounds(12, 466, 109, 25);
		contentPane.add(rdbtnRelaxing);
		
		JRadioButton rdbtnParty = new JRadioButton("Party");
		rdbtnParty.setBackground(new Color(173, 216, 230));
		rdbtnParty.setBounds(12, 494, 99, 25);
		contentPane.add(rdbtnParty);
		
		JRadioButton rdbtnSunshine = new JRadioButton("Sunshine");
		rdbtnSunshine.setBackground(new Color(173, 216, 230));
		rdbtnSunshine.setBounds(12, 522, 99, 25);
		contentPane.add(rdbtnSunshine);
		
		JRadioButton rdbtnShopping = new JRadioButton("Shopping");
		rdbtnShopping.setBackground(new Color(173, 216, 230));
		rdbtnShopping.setBounds(12, 550, 99, 25);
		contentPane.add(rdbtnShopping);
		
		JLabel lblDateFrom = new JLabel("Date from:");
		lblDateFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateFrom.setBounds(14, 183, 99, 16);
		contentPane.add(lblDateFrom);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(14, 202, 76, 22);
		contentPane.add(dateChooser);
		
		JLabel lblDateTo = new JLabel("Date to:");
		lblDateTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateTo.setBounds(14, 224, 56, 16);
		contentPane.add(lblDateTo);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(14, 241, 76, 22);
		contentPane.add(dateChooser_1);
		
		JButton btnAddToCart = new JButton("Add to cart");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
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
		
		JButton ButtonSearch = new JButton("");
		Image imgSearch = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		ButtonSearch.setIcon(new ImageIcon(imgSearch));
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search = new ArrayList<String> (Arrays.asList(SearchTextfield.getText().split("\\s*,\\s*")));
				loc = txtLocation.getText();
				dateFrom = dateChooser.getDate();
				dateTo = dateChooser_1.getDate();
				roundTrip = rdbtnBothWays.isSelected(); 
				// TODO laga �etta
				price = 1000000;//(Integer)spinnerPrice.getValue();
				numPeople = (Integer)spinner.getValue() + (Integer)spinner_1.getValue();
				
				List res = SearchController.Search( typeSelected, search, loc, dateFrom, dateTo, price, roundTrip, numPeople );
                JPanel[] resPanel = new JPanel[res.size()];
				for ( int i = 0; i < res.size(); i++ ) {
					resPanel[i] = createJPanel( typeSelected, res.get( i ) );
					///////////
					/*resPanel[i] = new JPanel();
                    final int index = i;
                    resPanel[i].add( new JLabel( ( "Hlutur " + typeSelected + " numer: " + i ) ) );
                    JButton addToCart = new JButton( "Add to Cart" );
                    addToCart.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            if( typeSelected == 0 ) cart.AddFlightToBooking( (Flight.Flight)res.get( index ) );
                            if( typeSelected == 1 ) cart.AddHotelToBooking( (Hotel.Hotel)res.get( index ) );
                            if( typeSelected == 2 ) cart.AddDayTripToBooking( (DayTrip) res.get( index ) );
                        }
                    });
                    resPanel[i].add( addToCart );
                    */
					validate();
                    repaint();
				}
                panelResult.add( resPanel );
                validate();
                repaint();
			}
		});
		ButtonSearch.setBounds(670, 42, 47, 25);
		contentPane.add(ButtonSearch);
		
		JPanel panelResult = new JPanel();
		panelResult.setBackground(new Color(176, 224, 230));
		panelResult.setBounds(120, 89, 597, 437);
		contentPane.add(panelResult);
		
		JButton EnglishButton = new JButton("");
		EnglishButton.setBackground(new Color(173, 216, 230));
		Image imgEnglish = new ImageIcon(this.getClass().getResource("/britain.png")).getImage();
		EnglishButton.setIcon(new ImageIcon(imgEnglish));
		EnglishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		EnglishButton.setBounds(691, 9, 34, 24);
		contentPane.add(EnglishButton);
		
		JButton IcelandicButton = new JButton("");
		IcelandicButton.setBackground(new Color(173, 216, 230));
		Image imgIcelandic = new ImageIcon(this.getClass().getResource("/Icelandic.png")).getImage();
		IcelandicButton.setIcon(new ImageIcon(imgIcelandic));
		IcelandicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		IcelandicButton.setBounds(737, 9, 34, 24);
		contentPane.add(IcelandicButton);
		
		JRadioButton rdbtnFlight = new JRadioButton("Flight");
		rdbtnFlight.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if( rdbtnFlight.isSelected() ){
					typeSelected = 0;					
				}
			}
		});
		radioButtonGroupType.add(rdbtnFlight);
		rdbtnFlight.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnFlight.setBackground(new Color(173, 216, 230));
		rdbtnFlight.setBounds(153, 9, 127, 25);
		rdbtnFlight.setSelected(true);
		contentPane.add(rdbtnFlight);
		
		JRadioButton rdbtnHotel = new JRadioButton("Hotel");
		rdbtnHotel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnHotel.isSelected()){
					typeSelected = 1;
				}
			}
		});
		radioButtonGroupType.add(rdbtnHotel);
		rdbtnHotel.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnHotel.setBackground(new Color(173, 216, 230));
		rdbtnHotel.setBounds(324, 9, 127, 25);
		contentPane.add(rdbtnHotel);
		
		JRadioButton rdbtnDaytrip = new JRadioButton("Daytrip");
		rdbtnDaytrip.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnDaytrip.isSelected()){
					typeSelected = 2;					
				}
			}
		});
		radioButtonGroupType.add(rdbtnDaytrip);
		rdbtnDaytrip.setBackground(new Color(173, 216, 230));
		rdbtnDaytrip.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnDaytrip.setBounds(485, 9, 127, 25);
		contentPane.add(rdbtnDaytrip);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocation.setBounds(14, 135, 77, 16);
		contentPane.add(lblLocation);
		
		txtLocation = new JTextField();
		txtLocation.setBounds(14, 152, 105, 25);
		contentPane.add(txtLocation);
		txtLocation.setColumns(10);
		
		JSpinner spinnerPrice = new JSpinner();
		spinnerPrice.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerPrice.setBounds(14, 102, 77, 22);
		contentPane.add(spinnerPrice);
		
		JLabel labelPrice = new JLabel("Price");
		labelPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPrice.setBounds(14, 85, 77, 16);
		contentPane.add(labelPrice);
	}

    private JPanel createJPanel( int type, Object object ){
        if( type == 0 ){
            return flightPanel( (Flight)object );
        }
        else if( type == 1 ){
            return hotelPanel( (Hotel)object );
        }
        else if( type == 2 ){
            return daytripPanel( (DayTrip)object );
        }
        else{
            return null;
        }
    }

    private JPanel flightPanel( Flight flight ){
        JPanel panel = new JPanel();

        panel.add( new JLabel( "Flug .1.1.1." ) );

        JButton addToCart = new JButton( "Add to Cart" );
        addToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cart.AddFlightToBooking( flight );
            }
        });
        return panel;
    }

    private JPanel hotelPanel( Hotel hotel ){
        JPanel panel = new JPanel();

        panel.add( new JLabel( hotel.getName() ) );
        panel.add( new JLabel( hotel.getAddress() ) );
        panel.add( new JLabel( Double.toString( hotel.getRating() ) ) );
        panel.add( new JLabel( hotel.getDescription() ) );

        JButton addToCart = new JButton( "Add to Cart" );
        addToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cart.AddHotelToBooking( hotel );
            }
        });
        return panel;
    }

    private JPanel daytripPanel( DayTrip daytrip ){
        JPanel panel = new JPanel();

        panel.add( new JLabel( daytrip.getName() ) );
        panel.add( new JLabel( daytrip.getLocation() ) );
        panel.add( new JLabel( daytrip.getType() ) );
        panel.add( new JLabel( Integer.toString( daytrip.getPrice() ) ) );

        JButton addToCart = new JButton( "Add to Cart" );
        addToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { cart.AddDayTripToBooking( daytrip ); }
        });
        return panel;
    }
}
