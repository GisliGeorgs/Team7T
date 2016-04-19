import com.main.java.controller.CartController;
import  com.main.java.form.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class OrderNumber extends JFrame {

	private JPanel contentPane;
	User user;
    // TODO Birta bara eina pÃ¶ntun og alla hluti hennar Ã­ staÃ°inn fyrir aÃ° birta bara Ã¶ll pÃ¶ntunarnÃºmer. ÃžaÃ° er vÃ¦ntanlega auÃ°veldara aÃ° cancela einum hlut Ã­ einu en aÃ° cancela heilli master pÃ¶ntun.
    //
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderNumber OrderN = new OrderNumber( new User() );
					OrderN.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JPanel panelOrders;
	public OrderNumber( User user ) {
		this.user = user;
		setIconImage(
				new ImageIcon(getClass().getResource("/7.png")).getImage()
			);
		setTitle("Your orders");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 754, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		Image imgCancel = new ImageIcon(this.getClass().getResource("/Close-2-icon.png")).getImage();
		btnCancel.setIcon(new ImageIcon(imgCancel));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your Order has been canceled!","Message", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnCancel.setBounds(399, 416, 176, 49);
		contentPane.add(btnCancel);
		
		JButton DoneViewingOrder = new JButton("Finished");
		Image imgLogin = new ImageIcon(this.getClass().getResource("/Ok-icon.png")).getImage();
		DoneViewingOrder.setIcon(new ImageIcon(imgLogin));
		DoneViewingOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FF FrontF=new FF();
				FrontF.setVisible(true);
				dispose();
			}
		});
		DoneViewingOrder.setBounds(177, 416, 176, 49);
		contentPane.add(DoneViewingOrder);
		
		JLabel lblYourOrders = new JLabel("Your Orders");
		lblYourOrders.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblYourOrders.setBounds(283, 0, 116, 57);
		contentPane.add(lblYourOrders);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfoChange UI=new UserInfoChange();
				UI.setVisible(true);
				dispose();
			}
		});
		btnUser.setBounds(608, 10, 116, 39);
		contentPane.add(btnUser);
		
		panelOrders = new JPanel();
		panelOrders.setBackground(new Color(240, 240, 240));
		panelOrders.setBounds(80, 74, 571, 329);
		contentPane.add(panelOrders);
		
		String hotelid = user.getHotelId();
		String flightid = user.getFlightId();
		String tripid = user.getTripId();
		
		if( hotelid != null && hotelid != "" ){
			Hotel.BookingController contr = new Hotel.BookingController();
			Hotel.Booking book;
			try {
				book = contr.getBooking( hotelid );
				panelOrders.add( hotelPanel( book ) );
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if( flightid != null && flightid != "" ){
			Flight.Booking book = new Flight.Booking( Integer.parseInt(flightid ) );
			JPanel flights = new JPanel();
			for( int i = 0; i < 2; i++ ){
				if( null != book.getFlights()[i]){
					flights.add( flightPanel( book, i ));
				}				
			}
	        JButton remove = new JButton( "Cancel" );
	        remove.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	book.cancel();
	            }
	        });
	        flights.add( remove );
						
			panelOrders.add(flights);
		}	
		// TODO implement me.
		if( tripid != null && tripid != "" ){	
			
		}
	}
    private JPanel flightPanel( Flight.Booking book, int index ){
    	Flight.Flight flight = book.getFlights()[index];
        JPanel panel = new JPanel();
        
        //panel.add( new JLabel( book.getUsers()[0].getFirst() + " " + book.getUsers()[0].getLast() ) );
        
        panel.add( new JLabel( flight.getAirline() ) );
        panel.add( new JLabel( flight.getFlightNo() ) );
        panel.add( new JLabel( "From: " + flight.getdestFrom() ) );
		panel.add( new JLabel( "To: " + flight.getdestTo() ) );
        panel.add( new JLabel( "Price: " + flight.getPrice() ) );
        panel.add( new JLabel( "Departure: " + flight.getDeparture() ) );
        panel.add( new JLabel( "Dep time: " + flight.getDepTime() ) );
        return panel;
    }
	
	private JPanel hotelPanel( Hotel.Booking book ){
		JPanel panel = new JPanel();

        //panel.add( new JLabel( book.getCustomerName() ) );

        panel.add( new JLabel( book.getStartDate() ) );
        panel.add( new JLabel( book.getEndDate() ) );
				
        panel.add( new JLabel( book.getHotel().getName() ) );
        panel.add( new JLabel( book.getHotel().getAddress() ) );
        panel.add( new JLabel( book.getHotel().getDescription() ) );
        panel.add( new JLabel( book.getHotel().getType() ) );
        panel.add( new JLabel( Double.toString( book.getHotel().getRating() ) ) );
        for( int i = 0; i < book.getHotel().getRooms().length; i++ ){
        	JPanel roomp = new JPanel();
        	Hotel.Room room = book.getHotel().getRooms()[i];
        	roomp.add( new JLabel( room.getDescription() ) );
        	roomp.add( new JLabel( room.getTypeOfBathroom() ) );
        	roomp.add( new JLabel( Integer.toString( room.getNumberOfBeds() ) ) );
        	roomp.add( new JLabel( Double.toString( room.getRoomPrice() ) ) ); 
        	panel.add(roomp);
        }        
        JButton cancel = new JButton( "Cancel" );
        cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel.BookingController contr = new Hotel.BookingController();
				contr.deleteBooking( book.getId() );
			}
        });
        panel.add(cancel);
		return panel;
	}
	
	// TODO Daytrip

}
