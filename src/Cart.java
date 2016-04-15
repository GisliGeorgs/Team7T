import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import DayTrip.DayTrip;
import Flight.Flight;
import Hotel.Hotel;
import com.main.java.controller.CartController;
import com.main.java.form.*;

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

	/**
	 * Create the frame.
	 */
	public Cart( CartController cart ) {
        cartController = cart;
        Setup();
	}
    public Cart(){
        Setup();
    }

    private void Setup(){
        setTitle("Team 7T - Cart");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 656, 557);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(173, 216, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblYourCart = new JLabel("Your Cart");
        lblYourCart.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblYourCart.setBounds(256, 13, 138, 25);
        contentPane.add(lblYourCart);

        JButton btnFinsihOrder = new JButton("Finnish Order");
        Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
        btnFinsihOrder.setIcon(new ImageIcon(imgLogin));
        btnFinsihOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                boolean UserExists = user.GetEmail().isEmpty();
                if (UserExists ){
                    Pay Payment=new Pay();
                    Payment.setVisible(true);
                    dispose();
                }
                else{
                    UserInfoNew uin = new UserInfoNew();
                    uin.setVisible( true );
                    dispose();
                }
            }
        });
        btnFinsihOrder.setBounds(148, 458, 174, 39);
        contentPane.add(btnFinsihOrder);

        JButton btngobacktoSearch = new JButton("Go back to search");
        Image imgLogin2 = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
        btngobacktoSearch.setIcon(new ImageIcon(imgLogin2));
        btngobacktoSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FF FrontFr=new FF();
                FrontFr.setVisible(true);
                dispose();
            }
        });
        btngobacktoSearch.setBounds(334, 459, 174, 36);
        contentPane.add(btngobacktoSearch);

        JPanel panelCart = new JPanel();
        panelCart.setBounds(65, 49, 510, 393);
        contentPane.add(panelCart);

        for ( int i = 0; i < cartController.getFlightOrders().GetFlight().size(); i++ ) {
            panelCart.add( flightPanel( cartController.getFlightOrders().GetFlight().get( i ) ) );
        }
        for ( int i = 0; i < cartController.getHotelOrders().GetHotel().size(); i++ ) {
            panelCart.add( hotelPanel( cartController.getHotelOrders().GetHotel().get( i ) ) );
        }
        for ( int i = 0; i < cartController.getDayTripOrders().GetDayTrip().size(); i++ ) {
            panelCart.add( daytripPanel( cartController.getDayTripOrders().GetDayTrip().get( i ) ) );
        }
    }


	private JPanel flightPanel( Flight flight ){
		JPanel panel = new JPanel();

		panel.add( new JLabel( "Flug .1.1.1." ) );

		JButton addToCart = new JButton( "Add to Cart" );
		addToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                cartController.RemoveFlightFromBooking( flight );
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
                cartController.RemoveHotelFromBooking( hotel );
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
			public void actionPerformed(ActionEvent arg0) { cartController.RemoveDayTripFromBooking( daytrip ); }
		});
		return panel;
	}
}
