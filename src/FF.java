import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import Flight.Flight;
import Hotel.Hotel;
import Hotel.Room;
import com.main.java.controller.CartController;
import com.main.java.controller.SearchController;
import com.toedter.calendar.JDateChooser;

import DayTrip.klasar.Trip;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.GridLayout;

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
    private String flightFrom;
    private String flightTo;
	private boolean roundTrip;
	private int numPeople;
	private int price;
	private String[] interests = new String[]{ "Golfing", "Relaxing", "Party", "Sunshine", "Shopping" };
	private boolean flex;
    CartController cart;

	private ArrayList<String> search;
	private JTextField TextFieldFlightFrom;
	private JTextField TextFieldFlightTo;
	
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;

	static FF frame;
	private JPanel panelResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// TODO Add-a scrollbar i leitarnidurstöðulistann
	// TODO Láta leitarniðurstöðurnar vera flottar.
	/**
	 * Create the frame.
	 */
	public FF() {
		setIconImage(
			new ImageIcon(getClass().getResource("/7.png")).getImage()
		);
		setTitle("Home");
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
		lblForFlight1.setBounds(16, 409, 77, 16);

		contentPane.add(lblForFlight1);
		
		JRadioButton rdbtnOneWay = new JRadioButton(Messages.getString("FF.OneWay")); //$NON-NLS-1$
		rdbtnOneWay.setBackground(new Color(173, 216, 230));
		rdbtnOneWay.setBounds(16, 425, 97, 25);
		contentPane.add(rdbtnOneWay);
		
		JRadioButton rdbtnBothWays = new JRadioButton(Messages.getString("FF.BothWays")); //$NON-NLS-1$
		rdbtnBothWays.setBackground(new Color(173, 216, 230));
		rdbtnBothWays.setBounds(16, 447, 105, 25);
		contentPane.add(rdbtnBothWays);
		
		ButtonGroup radioButtonGroupRoundTrip=new ButtonGroup();
		radioButtonGroupRoundTrip.add(rdbtnOneWay);
		radioButtonGroupRoundTrip.add(rdbtnBothWays);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(16, 340, 77, 22);
		contentPane.add(spinner);
		

		JLabel lblAdaults = new JLabel(Messages.getString("FF.Adults")); //$NON-NLS-1$
		lblAdaults.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblAdaults.setBounds(18, 322, 77, 16);
		contentPane.add(lblAdaults);
		
		JLabel lblChildrens = new JLabel(Messages.getString("FF.Children")); //$NON-NLS-1$
		lblChildrens.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblChildrens.setBounds(12, 344, 77, 16);
		
		JLabel lblChildrens1 = new JLabel("Childrens:");
		lblChildrens1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChildrens1.setBounds(16, 362, 77, 16);
		contentPane.add(lblChildrens1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_1.setBounds(16, 380, 77, 22);
		contentPane.add(spinner_1);
		

		JLabel lblInterests = new JLabel(Messages.getString("FF.Interests")); //$NON-NLS-1$
		lblInterests.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblInterests.setBounds(12, 391, 77, 25);
		

		JLabel lblDateFrom = new JLabel(Messages.getString("FF.DateFrom")); //$NON-NLS-1$
		lblDateFrom.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblDateFrom.setBounds(12, 122, 99, 16);

		JLabel lblDateFrom1 = new JLabel("Date from:");
		lblDateFrom1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateFrom1.setBounds(16, 211, 99, 16);
		contentPane.add(lblDateFrom1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(17, 227, 76, 22);
		contentPane.add(dateChooser);
		

		JLabel lblDateTo = new JLabel(Messages.getString("FF.DateTo")); //$NON-NLS-1$
		lblDateTo.setFont(new Font("Tahoma", Font.BOLD, 14)); //$NON-NLS-1$
		lblDateTo.setBounds(12, 173, 56, 16);

		JLabel lblDateTo1 = new JLabel("Date to:");
		lblDateTo1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateTo1.setBounds(16, 246, 56, 16);
		contentPane.add(lblDateTo1);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(16, 263, 76, 22);
		contentPane.add(dateChooser_1);
		
		JButton btnAddToCart = new JButton(Messages.getString("FF.AddToCart")); //$NON-NLS-1$
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage(); //$NON-NLS-1$
		btnAddToCart.setIcon(new ImageIcon(imgLogin));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println( "Daytrip size " + cart.getDayTripOrders().GetDayTrip().size() );
				System.out.println( "Hotel size " + cart.getHotelOrders().GetHotel().size() );
				//System.out.println( "Flight no 0 " + cart.getFlightOrders().GetFlight()[0].getFlightNo());
				//System.out.println( "Flight no 1 " + cart.getFlightOrders().GetFlight()[1].getFlightNo());
				Cart AddtoCart = new Cart( cart );
				AddtoCart.setVisible(true);
				//dispose();
			}
		});
		btnAddToCart.setBounds(347, 565, 162, 33);
		contentPane.add(btnAddToCart);
		
		SearchTextfield = new JTextField();
		SearchTextfield.setBounds(120, 43, 549, 25);
		contentPane.add(SearchTextfield);
		SearchTextfield.setColumns(10);



		panelResult = new JPanel();
		panelResult.setBackground(new Color(176, 224, 230));
		panelResult.setBounds(125, 123, 598, 431);
		contentPane.add(panelResult);

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
		lblLocation.setBounds(16, 169, 77, 16);

		contentPane.add(lblLocation);
		
		txtLocation = new JTextField();
		txtLocation.setBounds(16, 186, 105, 25);
		txtLocation.setColumns(10);
		contentPane.add(txtLocation);
		
		JSpinner spinnerPrice = new JSpinner();
		spinnerPrice.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerPrice.setBounds(18, 142, 77, 22);
		contentPane.add(spinnerPrice);
		
		JLabel labelPrice = new JLabel("Price");
		labelPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPrice.setBounds(18, 123, 77, 16);
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
		
		JCheckBox chckbxFlexibleDates = new JCheckBox(Messages.getString("FF.chckbxFlexibleDates.text")); //$NON-NLS-1$
		chckbxFlexibleDates.setBackground(new Color(173, 216, 230));
		chckbxFlexibleDates.setBounds(12, 294, 113, 23);
		contentPane.add(chckbxFlexibleDates);
		
		JButton ButtonSearch = new JButton(""); //$NON-NLS-1$
		Image imgSearch = new ImageIcon(this.getClass().getResource("/search.png")).getImage(); //$NON-NLS-1$
		ButtonSearch.setIcon(new ImageIcon(imgSearch));
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResult.removeAll();
                validate();
                repaint();
				System.out.println("ButtonSeasrched1 clicked");
				search = new ArrayList<String> (Arrays.asList(SearchTextfield.getText().split("\\s*,\\s*")));
				loc = txtLocation.getText();
				dateFrom = dateChooser.getDate();
				dateTo = dateChooser_1.getDate();
				roundTrip = rdbtnBothWays.isSelected();
                flightFrom = TextFieldFlightFrom.getText();
                flightTo = TextFieldFlightTo.getText();
				price = (Integer)spinnerPrice.getValue();
				numPeople = (Integer)spinner.getValue() + (Integer)spinner_1.getValue();
				flex = chckbxFlexibleDates.isSelected();
				

                //The method Search(int, ArrayList<String>, String, Date, Date, int, boolean, int) in the type SearchController is not applicable for the arguments
                //                  int, ArrayList<String>, String, String, String, Date, Date, int, boolean, int)
				List res;
				try {
					res = SearchController.Search( typeSelected, search, loc, flightFrom, flightTo, dateFrom, dateTo, price, roundTrip, numPeople, flex );
	                if( res.size() > 0 ){
	                    JPanel[] resPanel = new JPanel[res.size()];
	                    for ( int i = 0; i < res.size(); i++ ) {
	                        resPanel[i] = createJPanel( typeSelected, res.get( i ) );
	                        panelResult.add( resPanel[i] );
	                        //scrollPane.add( resPanel[i]);
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		ButtonSearch.setBounds(670, 42, 47, 25);
		contentPane.add(ButtonSearch);

		JButton btnSpecificHotelSearch = new JButton(Messages.getString("FF.btnSpecificHotelSearch.text")); //$NON-NLS-1$
		btnSpecificHotelSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HotelFF HotelSpec = new HotelFF( frame );
				HotelSpec.setVisible(true);
				//dispose();
			}
		});
		btnSpecificHotelSearch.setBounds(12, 565, 162, 29);
		contentPane.add(btnSpecificHotelSearch);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"River Rafting", "Sightseeing", "Hiking"}));
		comboBox.setBounds(16, 495, 97, 22);
		contentPane.add(comboBox);

		JLabel lblForDayTrip = new JLabel(Messages.getString("FF.lblForDayTrip.text")); //$NON-NLS-1$
		lblForDayTrip.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForDayTrip.setBounds(16, 473, 81, 16);
		contentPane.add(lblForDayTrip);

		JLabel lblForHotel = new JLabel(Messages.getString("FF.lblForHotel.text")); //$NON-NLS-1$
		lblForHotel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForHotel.setBounds(16, 547, 77, 16);
		contentPane.add(lblForHotel);

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
        
        panel.add( new JLabel( flight.getAirline() ) );
        panel.add( new JLabel( flight.getFlightNo() ) );
        panel.add( new JLabel( "From: " + flight.getdestFrom() ) );
		panel.add( new JLabel( "To: " + flight.getdestTo() ) );
        panel.add( new JLabel( "Price: " + flight.getPrice() ) );
        panel.add( new JLabel( "Departure: " + flight.getDeparture() ) );
        panel.add( new JLabel( "Dep time: " + flight.getDepTime() ) );

        JButton addToCart = new JButton( "Add to Cart" );
        addToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO L�ta vera flug heim e�a �t?
            	if( flightFrom.equals( flight.getdestFrom() ) ){
                	System.out.println( "Flight from" );
                	cart.AddFlightOutToBooking( flight );
            	}
            	else if( flightTo.equals( flight.getdestFrom() ) ){
                	System.out.println( "Flight to" );
            		cart.AddFlightHomeToBooking( flight );
            	}
            }
        });
        panel.add( addToCart );
        return panel;
    }

    private JPanel hotelPanel( Hotel hotel ){
        JPanel panel = new JPanel();

        panel.add( new JLabel( hotel.getName() ) );
        panel.add( new JLabel( hotel.getAddress() ) );
        panel.add( new JLabel( Double.toString( hotel.getRating() ) ) );
        panel.add( new JLabel( hotel.getDescription() ) );

        hotel.getRoomsFromDB();
        JPanel[] rooms = new JPanel[ hotel.getRooms().length ];
    	System.out.println( rooms.length );
        
        for( int i = 0; i < rooms.length; i++ ){
        	System.out.println( hotel.getRooms()[i].getRoomNumber() );
            rooms[i] = roomPanel( hotel, hotel.getRooms()[i] );
            panel.add( rooms[i] );
        }
        return panel;
    }

    private JPanel roomPanel( Hotel hotel, Room room ){
        JPanel panel = new JPanel();

        panel.add( new JLabel( Double.toString( room.getRoomPrice() ) ) );
        panel.add( new JLabel( Double.toString( room.getMaxGuests() ) ) );
        panel.add( new JLabel( Double.toString( room.getNumberOfBeds() ) ) );
        panel.add( new JLabel( room.getDescription() ) );
        panel.add( new JLabel( room.getTypeOfBathroom() ) );

        JButton addToCart = new JButton( "Add to Cart" );
        addToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println( hotel.getName() );
                cart.AddHotelToBooking( hotel, room );
				cart.getHotelOrders().setDate( dateChooser.getDate(), dateChooser_1.getDate() );
            }
        });
        panel.add( addToCart );
        return panel;
    }

    private JPanel daytripPanel( DayTrip daytrip ){
        JPanel panel = new JPanel();
        // S�na daytrip sem �� getur vali�
        // DayTrip valinn -> Birta allar trips sem eru undir 

        panel.add( new JLabel( daytrip.getName() ) );
        panel.add( new JLabel( daytrip.getLocation() ) );
        panel.add( new JLabel( daytrip.getType() ) );
        panel.add( new JLabel( Integer.toString( daytrip.getPrice() ) ) );

        JButton addToCart = new JButton( "Select this type" );
        addToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

				tripPanels( daytrip );
			}
        });
        panel.add( addToCart );
        return panel;
    }

    private void tripPanels( DayTrip.klasar.DayTrip daytrip ){

		panelResult.removeAll();
        validate();
        repaint();
    	DayTrip.klasar.SearchController search = new DayTrip.klasar.SearchController();
    	List<DayTrip.klasar.Trip> trips = search.oneDayTrip( daytrip );
    	System.out.println(trips.size());
    	for( int i = 0; i < trips.size(); i++ ){
    		panelResult.add( tripPanel(trips.get(i)) );
    	}
    	validate();
        repaint();

    }

    private JPanel tripPanel( DayTrip.klasar.Trip trip ){
    	JPanel panel = new JPanel();

    	panel.add( new JLabel( trip.getDayTrip() ));
    	Date datefrom = trip.getDate()[0];
    	String date1 = datefrom.getYear()+"-"+(datefrom.getMonth()+1)+"-"+datefrom.getDate();
    	Date dateto = trip.getDate()[1];
    	String date2 = dateto.getYear()+"-"+(dateFrom.getMonth()+1)+"-"+dateto.getDate();

    	panel.add( new JLabel( date1 ) );
    	panel.add( new JLabel( date2 ) );
    	panel.add( new JLabel( "Size: " + trip.getSize() ) );

        JButton addToCart = new JButton( "Add to Cart" );
        addToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	cart.AddTripToBooking( trip );
            }
        });
        panel.add( addToCart );

    	return panel;
    }
}
