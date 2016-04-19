import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import DayTrip.klasar.*;
import Flight.*;
import Hotel.*;
import com.main.java.controller.CartController;
import com.main.java.form.*;
import com.main.java.form.User;

public class Cart extends JFrame {

	private JPanel contentPane;
    CartController cartController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    // TODO Láta hlutina líta flott út.

	/**
	 * Create the frame.
	 */
	public Cart( CartController cart ) {
        cartController = cart;
        Setup();
	}
    public Cart(){
    	//cartController = new CartController();
        Setup();
    }
    JPanel panelCart;
    private void Setup(){
    	setIconImage(
    			new ImageIcon(getClass().getResource("/7.png")).getImage()
    		);
        setTitle("Cart");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 656, 557);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(248, 248, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblYourCart = new JLabel("Your Cart");
        lblYourCart.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblYourCart.setBounds(256, 13, 138, 25);
        contentPane.add(lblYourCart);

        JButton btnFinishOrder = new JButton("Finish Order");
        Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
        btnFinishOrder.setIcon(new ImageIcon(imgLogin));
        btnFinishOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                if( user.GetEmail() == null ){
                    Pay Payment=new Pay( cartController );
                    Payment.setVisible(true);
                    dispose();                	
                }
                else{
                    UserInfoChange uin = new UserInfoChange( cartController );
                    uin.setVisible( true );
                    dispose();
                }
            }
        });
        btnFinishOrder.setBounds(148, 458, 174, 39);
        contentPane.add(btnFinishOrder);

        JButton btngobacktoSearch = new JButton("Go back to search");
        Image imgLogin2 = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
        btngobacktoSearch.setIcon(new ImageIcon(imgLogin2));
        btngobacktoSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //FF FrontFr=new FF();
                //FrontFr.setVisible(true);
                dispose();
            }
        });
        btngobacktoSearch.setBounds(334, 459, 174, 36);
        contentPane.add(btngobacktoSearch);


        panelCart = new JPanel();
        panelCart.setBounds(65, 49, 510, 393);
        panelCart.setLayout( new GridLayout( 0, 1 ));
        UpdateCart();
        contentPane.add(panelCart);
    }

    private void UpdateCart(){
        /*panelCart.removeAll();
        panelCart.revalidate();
        panelCart.repaint();*/
    	JPanel toadd;
        System.out.println( "updatecart1" );
        if( cartController.getFlightOrders().GetFlight()[0] != null ){
        	toadd = flightPanel( cartController.getFlightOrders().GetFlight()[0], 0 );
            if( toadd != null ){
            	panelCart.add( toadd );
                panelCart.revalidate();
                panelCart.repaint();
            }            	
        }
        System.out.println( "updatecart2" );
        if( cartController.getFlightOrders().GetFlight()[1] != null ){        	
            toadd = flightPanel( cartController.getFlightOrders().GetFlight()[1], 1 );
            if( toadd != null ){
            	panelCart.add( toadd );
                panelCart.revalidate();
                panelCart.repaint();            	
            }
        }
        System.out.println( "updatecart3" );
        if( !(cartController.getHotelOrders().GetHotel() == null) && cartController.getHotelOrders().GetHotel().size() > 0 ){
            for ( int i = 0; i < cartController.getHotelOrders().GetHotel().size(); i++ ) {
            	toadd = hotelPanel( cartController.getHotelOrders().GetHotel().get( i ) );
                if( toadd != null ){
                	panelCart.add( toadd );
                    panelCart.revalidate();
                    panelCart.repaint();
                }                	
            }
        }
        System.out.println( "updatecart4" );
        if( !(cartController.getDayTripOrders().GetDayTrip() == null) && cartController.getDayTripOrders().GetDayTrip().size() > 0 ){
            for ( int i = 0; i < cartController.getDayTripOrders().GetDayTrip().size(); i++ ) {
                toadd =  daytripPanel( cartController.getDayTripOrders().GetDayTrip().get( i ), cartController.getDayTripOrders().getTrips().get(i) );
                if( toadd != null ){
                	panelCart.add( toadd );
                    panelCart.revalidate();
                    panelCart.repaint();
                }                	
            }
        }
        panelCart.revalidate();
        panelCart.repaint();
    }


	private JPanel flightPanel( Flight flight, int index ){
        JPanel panel = new JPanel();        

        panel.add( new JLabel( flight.getAirline() ) );
        panel.add( new JLabel( flight.getFlightNo() ) );
        panel.add( new JLabel( "From: " + flight.getdestFrom() ) );
		panel.add( new JLabel( "To: " + flight.getdestTo() ) );
        panel.add( new JLabel( "Price: " + flight.getPrice() ) );
        panel.add( new JLabel( "Departure: " + flight.getDeparture() ) );
        panel.add( new JLabel( "Dep time: " + flight.getDepTime() ) );

		JButton removeFromCart = new JButton( "Remove from cart" );
		removeFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( index == 0 ){
					cartController.RemoveOutFlight();
				}
				if( index == 1 ){
					cartController.RemoveHomeFlight();
				}
			}
		});
		panel.add( removeFromCart );
		return panel;
	}

	private JPanel hotelPanel( Hotel hotel ){
		JPanel panel = new JPanel();
		System.out.println(hotel.getName() + hotel.getAddress() );
		panel.add( new JLabel( hotel.getName() ) );
		panel.add( new JLabel( hotel.getAddress() ) );
		panel.add( new JLabel( Double.toString( hotel.getRating() ) ) );
		panel.add( new JLabel( hotel.getDescription() ) );
		JButton addToCart = new JButton( "Remove" );
		addToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
                cartController.RemoveHotelFromBooking( hotel );
			}
		});
		panel.add(addToCart);
		return panel;
	}

	private JPanel daytripPanel( DayTrip daytrip, Trip trip  ){
		JPanel panel = new JPanel();

		panel.add( new JLabel( daytrip.getName() ) );
        panel.add( new JLabel( daytrip.getTravelAgency() ) );
		panel.add( new JLabel( Integer.toString( daytrip.getPrice() ) ) );
        String datefrom =  trip.getDate()[0].getYear() + "-"+ trip.getDate()[0].getMonth()+1+"-"+ trip.getDate()[0].getDate();
        String dateto =  trip.getDate()[0].getYear() + "-"+ trip.getDate()[0].getMonth()+1+"-"+ trip.getDate()[0].getDate();

        panel.add( new JLabel( datefrom ) );
        panel.add( new JLabel( dateto ) );

		JButton removeFromCart = new JButton( "Remove" );
		removeFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                cartController.RemoveTripFromBooking( trip );
                cartController.RemoveDayTripFromBooking( daytrip );
            }
		});
		panel.add( removeFromCart );
		return panel;
	}
}
