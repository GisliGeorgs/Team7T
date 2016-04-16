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
	private JTextField TextFieldFlightFrom;
	private JTextField TextFieldFlightTo;

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
		setIconImage(
			new ImageIcon(getClass().getResource("/7.png")).getImage()
		);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 672);
		
		typeSelected = 0;
		cart = new CartController();

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
				Cart YourCart=new Cart( cart );
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

		JLabel lblForFlight1 = new JLabel("For flight");
		lblForFlight1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForFlight1.setBounds(14, 258, 77, 16);

		contentPane.add(lblForFlight1);
		
		JRadioButton rdbtnOneWay = new JRadioButton(Messages.getString("FF.OneWay")); //$NON-NLS-1$
		rdbtnOneWay.setBackground(new Color(173, 216, 230));
		rdbtnOneWay.setBounds(14, 274, 97, 25);
		contentPane.add(rdbtnOneWay);
		
		JRadioButton rdbtnBothWays = new JRadioButton(Messages.getString("FF.BothWays")); //$NON-NLS-1$
		rdbtnBothWays.setBackground(new Color(173, 216, 230));
		rdbtnBothWays.setBounds(14, 304, 105, 25);
		contentPane.add(rdbtnBothWays);
		
		ButtonGroup radioButtonGroupRoundTrip=new ButtonGroup();
		radioButtonGroupRoundTrip.add(rdbtnOneWay);
		radioButtonGroupRoundTrip.add(rdbtnBothWays);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(12, 356, 77, 22);
		contentPane.add(spinner);
		

		JLabel lblAdaults = new JLabel(Messages.getString("FF.Adults")); //$NON-NLS-1$
		lblAdaults.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblAdaults.setBounds(14, 338, 77, 16);
		contentPane.add(lblAdaults);
		
		JLabel lblChildrens = new JLabel(Messages.getString("FF.Children")); //$NON-NLS-1$
		lblChildrens.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblChildrens.setBounds(12, 344, 77, 16);
		
		JLabel lblChildrens1 = new JLabel("Childrens:");
		lblChildrens1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChildrens1.setBounds(12, 378, 77, 16);
		contentPane.add(lblChildrens1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_1.setBounds(12, 396, 77, 22);
		contentPane.add(spinner_1);
		

		JLabel lblInterests = new JLabel(Messages.getString("FF.Interests")); //$NON-NLS-1$
		lblInterests.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblInterests.setBounds(12, 391, 77, 25);

		JLabel lblInterests1 = new JLabel("Interests:");
		lblInterests1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInterests1.setBounds(12, 418, 77, 25);
		contentPane.add(lblInterests1);
		
		JRadioButton rdbtnGolfing = new JRadioButton(Messages.getString("FF.Golf")); //$NON-NLS-1$
		rdbtnGolfing.setBackground(new Color(173, 216, 230));
		rdbtnGolfing.setBounds(12, 438, 107, 25);
		contentPane.add(rdbtnGolfing);
		
		JRadioButton rdbtnRelaxing = new JRadioButton(Messages.getString("FF.Relax")); //$NON-NLS-1$
		rdbtnRelaxing.setBackground(new Color(173, 216, 230));
		rdbtnRelaxing.setBounds(12, 466, 109, 25);
		contentPane.add(rdbtnRelaxing);
		
		JRadioButton rdbtnParty = new JRadioButton(Messages.getString("FF.Party")); //$NON-NLS-1$
		rdbtnParty.setBackground(new Color(173, 216, 230));
		rdbtnParty.setBounds(12, 494, 99, 25);
		contentPane.add(rdbtnParty);
		
		JRadioButton rdbtnSunshine = new JRadioButton(Messages.getString("FF.Sunshine")); //$NON-NLS-1$
		rdbtnSunshine.setBackground(new Color(173, 216, 230));
		rdbtnSunshine.setBounds(12, 522, 99, 25);
		contentPane.add(rdbtnSunshine);
		
		JRadioButton rdbtnShopping = new JRadioButton(Messages.getString("FF.Shop")); //$NON-NLS-1$
		rdbtnShopping.setBackground(new Color(173, 216, 230));
		rdbtnShopping.setBounds(12, 550, 99, 25);
		contentPane.add(rdbtnShopping);
		

		JLabel lblDateFrom = new JLabel(Messages.getString("FF.DateFrom")); //$NON-NLS-1$
		lblDateFrom.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblDateFrom.setBounds(12, 122, 99, 16);

		JLabel lblDateFrom1 = new JLabel("Date from:");
		lblDateFrom1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateFrom1.setBounds(14, 178, 99, 16);
		contentPane.add(lblDateFrom1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(15, 194, 76, 22);
		contentPane.add(dateChooser);
		

		JLabel lblDateTo = new JLabel(Messages.getString("FF.DateTo")); //$NON-NLS-1$
		lblDateTo.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblDateTo.setBounds(12, 173, 56, 16);

		JLabel lblDateTo1 = new JLabel("Date to:");
		lblDateTo1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateTo1.setBounds(14, 213, 56, 16);
		contentPane.add(lblDateTo1);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(14, 230, 76, 22);
		contentPane.add(dateChooser_1);
		
		JButton btnAddToCart = new JButton(Messages.getString("FF.AddToCart")); //$NON-NLS-1$
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage(); //$NON-NLS-1$
		btnAddToCart.setIcon(new ImageIcon(imgLogin));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart AddtoCart=new Cart( cart );
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



		JPanel panelResult = new JPanel();
		panelResult.setBackground(new Color(176, 224, 230));
		panelResult.setBounds(119, 125, 598, 401);
		contentPane.add(panelResult);

		
		
		JButton ButtonSearch = new JButton(""); //$NON-NLS-1$
		Image imgSearch = new ImageIcon(this.getClass().getResource("/search.png")).getImage(); //$NON-NLS-1$
		ButtonSearch.setIcon(new ImageIcon(imgSearch));
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ButtonSeasrched1 clicked");
				search = new ArrayList<String> (Arrays.asList(SearchTextfield.getText().split("\\s*,\\s*")));
				loc = txtLocation.getText();
				dateFrom = dateChooser.getDate();
				dateTo = dateChooser_1.getDate();
				roundTrip = rdbtnBothWays.isSelected(); 
				// TODO laga �etta
				price = 1000000;//(Integer)spinnerPrice.getValue();
				numPeople = (Integer)spinner.getValue() + (Integer)spinner_1.getValue();
				
				List res = SearchController.Search( typeSelected, search, loc, dateFrom, dateTo, price, roundTrip, numPeople );
                if( res.size() > 0 ){
                    JPanel[] resPanel = new JPanel[res.size()];
                    for ( int i = 0; i < res.size(); i++ ) {
                        resPanel[i] = createJPanel( typeSelected, res.get( i ) );
                        panelResult.add( resPanel[i] );
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
                }
				
			}
		});
		ButtonSearch.setBounds(670, 42, 47, 25);
		contentPane.add(ButtonSearch);
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

		
		JButton ButtonSearch1 = new JButton("");
		Image imgSearch1 = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		ButtonSearch1.setIcon(new ImageIcon(imgSearch1));
		ButtonSearch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ButtonSearch1.setBounds(670, 42, 47, 25);
		contentPane.add(ButtonSearch1);
		
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
		
		JRadioButton rdbtnFlight1 = new JRadioButton("Flight");
		rdbtnFlight1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if( rdbtnFlight1.isSelected() ){
					typeSelected = 0;					
				}
			}
		});
		radioButtonGroupType.add(rdbtnFlight1);
		rdbtnFlight1.setFont(new Font("Tahoma", Font.BOLD, 16));

		rdbtnFlight1.setBackground(new Color(173, 216, 230));
		rdbtnFlight1.setBounds(153, 9, 127, 25);
		rdbtnFlight1.setSelected(true);
		contentPane.add(rdbtnFlight1);
		

		JRadioButton rdbtnHotel = new JRadioButton(Messages.getString("FF.HotelCheck")); //$NON-NLS-1$
		rdbtnHotel.setFont(new Font("Tahoma", Font.BOLD, 16)); //$NON-NLS-1$

		JRadioButton rdbtnHotel1 = new JRadioButton("Hotel");
		rdbtnHotel1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnHotel1.isSelected()){
					typeSelected = 1;
				}
			}
		});
		radioButtonGroupType.add(rdbtnHotel1);
		rdbtnHotel1.setFont(new Font("Tahoma", Font.BOLD, 16));

		rdbtnHotel1.setBackground(new Color(173, 216, 230));
		rdbtnHotel1.setBounds(324, 9, 127, 25);
		contentPane.add(rdbtnHotel1);
		

		JRadioButton rdbtnDaytrip = new JRadioButton(Messages.getString("FF.DayTripCheck")); //$NON-NLS-1$

		JRadioButton rdbtnDaytrip1 = new JRadioButton("Daytrip");
		rdbtnDaytrip1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(rdbtnDaytrip1.isSelected()){
					typeSelected = 2;					
				}
			}
		});
		radioButtonGroupType.add(rdbtnDaytrip1);

		rdbtnDaytrip1.setBackground(new Color(173, 216, 230));
		rdbtnDaytrip1.setFont(new Font("Tahoma", Font.BOLD, 16)); //$NON-NLS-1$
		rdbtnDaytrip1.setBounds(485, 9, 127, 25);
		contentPane.add(rdbtnDaytrip1);
		

		JLabel lblLocation = new JLabel(Messages.getString("FF.Location")); //$NON-NLS-1$
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblLocation.setBounds(12, 70, 77, 16);

		JLabel lblLocation1 = new JLabel("Location:");
		lblLocation1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLocation1.setBounds(14, 134, 77, 16);

		contentPane.add(lblLocation1);
		
		txtLocation = new JTextField();
		txtLocation.setBounds(14, 152, 105, 25);
		contentPane.add(txtLocation);
		txtLocation.setColumns(10);
		
		JSpinner spinnerPrice = new JSpinner();
		spinnerPrice.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerPrice.setBounds(14, 100, 77, 22);
		contentPane.add(spinnerPrice);
		
		JLabel labelPrice = new JLabel("Price");
		labelPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPrice.setBounds(14, 81, 77, 16);
		contentPane.add(labelPrice);
		
		JLabel lblFlightFrom = new JLabel(Messages.getString("FF.lblFlightFrom.text")); //$NON-NLS-1$
		lblFlightFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFlightFrom.setBounds(120, 70, 97, 16);
		contentPane.add(lblFlightFrom);
		
		TextFieldFlightFrom = new JTextField();
		TextFieldFlightFrom.setText(Messages.getString("")); //$NON-NLS-1$
		TextFieldFlightFrom.setBounds(120, 90, 241, 22);
		contentPane.add(TextFieldFlightFrom);
		TextFieldFlightFrom.setColumns(10);
		
		JLabel lblFlightTo = new JLabel(Messages.getString("FF.lblFlightTo.text")); //$NON-NLS-1$
		lblFlightTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFlightTo.setBounds(397, 70, 85, 16);
		contentPane.add(lblFlightTo);
		
		TextFieldFlightTo = new JTextField();
		TextFieldFlightTo.setText(Messages.getString("")); //$NON-NLS-1$
		TextFieldFlightTo.setBounds(397, 90, 272, 22);
		contentPane.add(TextFieldFlightTo);
		TextFieldFlightTo.setColumns(10);

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
