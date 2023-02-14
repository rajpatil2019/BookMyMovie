package com.ticket.booking.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.booking.platform.dao.BookingServiceRepository;
import com.ticket.booking.platform.dao.CinemaHallRepository;
import com.ticket.booking.platform.dao.CinemaSeatRepository;
import com.ticket.booking.platform.dao.ShowRepository;
import com.ticket.booking.platform.dao.UserRepository;
import com.ticket.booking.platform.dto.BookingDTO;
import com.ticket.booking.platform.entity.Booking;
import com.ticket.booking.platform.entity.CinemaSeat;
import com.ticket.booking.platform.entity.Payment;
import com.ticket.booking.platform.entity.Show;
import com.ticket.booking.platform.entity.ShowSeat;
import com.ticket.booking.platform.entity.User;
import com.ticket.booking.platform.service.IBookingService;


@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private BookingServiceRepository bookingServiceRepository;
	
	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CinemaHallRepository cinemaHallRepository;
	
	@Autowired
	private CinemaSeatRepository cinemaSeatRepository;
	
    @Transactional
	@Override
	public void bookShow(BookingDTO bookingInfo) {
				
		User user=userRepository.findByEmail("xyz@gmail.com");
		Show show=showRepository.getReferenceById(bookingInfo.getShowId());
						
		Booking booking=new Booking();
		booking.setNumberOfSeats(bookingInfo.getNumberOfSeats());
		booking.setShow(show);
		booking.setUser(user);
		booking.setStatus("booked");
		booking.setTimeStamp("01/02/2023 2:00 PM");
		
		bookingInfo.getCinemaSeatList().forEach(dto ->{
			
			CinemaSeat cinemaSeat=cinemaSeatRepository.findBySeatNumberAndTypeAndCinemaHallId(dto.getSeatNumber(), dto.getType(),show.getCinemaHall().getId());
			
		   	ShowSeat showSeat=new ShowSeat();
			showSeat.setStatus("Reserved");
			showSeat.setPrice(400);
			showSeat.setBooking(booking);
			showSeat.setShow(show);
			showSeat.setCinemaSeat(cinemaSeat);
			booking.addShowSeat(showSeat);
		});	
				
		Payment payment=new Payment();
		payment.setAmount(bookingInfo.getPrice());
		payment.setBooking(booking);
		payment.setPaymentMethod("PhonePe");
		payment.setRemoteTransactionId(123456789);
		payment.setTimestamp("01/02/2023 02:30 PM");
		booking.setPayment(payment);
		
		bookingServiceRepository.save(booking);
	}

}
