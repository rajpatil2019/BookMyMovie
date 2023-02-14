package com.ticket.booking.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.google.gson.Gson;
import com.ticket.booking.platform.dao.MyRepository;
import com.ticket.booking.platform.dao.UserRepository;
import com.ticket.booking.platform.dto.BookingDTO;
import com.ticket.booking.platform.dto.CinemaPayloadDTO;
import com.ticket.booking.platform.dto.CinemaSeatDTO;
import com.ticket.booking.platform.dto.ShowDTO;
import com.ticket.booking.platform.dto.ShowDetailsDTO;
import com.ticket.booking.platform.entity.User;
import com.ticket.booking.platform.service.IBookingService;
import com.ticket.booking.platform.service.IConfigureCinema;

@SpringBootApplication
@EnableJpaRepositories
public class MovieTicketBookingPlatformApplication implements CommandLineRunner{

	@Autowired
	MyRepository myRepository;
	
	@Autowired
	private IConfigureCinema configureCinemaService;
	
	@Autowired
	private IBookingService iBookingService;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingPlatformApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		CinemaPayloadDTO payLoadDTO=new CinemaPayloadDTO();
		payLoadDTO.setCity("Bangalore");
		payLoadDTO.setState("Karnataka");
		payLoadDTO.setZipcode(560086);
		
		payLoadDTO.setTitle("KGF 2");
		payLoadDTO.setCountry("India");
		payLoadDTO.setDescription("Moview Description");
		payLoadDTO.setDuration(2);
		payLoadDTO.setGenre("Action Movie");
		payLoadDTO.setLanguage("Kannada");
		payLoadDTO.setReleaseDate("12/02/2023");
		
		ShowDTO showDto=new ShowDTO();
		showDto.setDateTime("01/02/2023");
		showDto.setStartTime("09:00 AM");
		showDto.setEndTime("11:00 AM");
		
		payLoadDTO.addShowDto(showDto);
					
		//browseShowDetails_1();
		
		BookingDTO bookingDto=new BookingDTO();
		bookingDto.setEmail("xyz@gmail.com");
		bookingDto.setNumberOfSeats(3);
		bookingDto.setPrice(1200);
		bookingDto.setShowId(1l);
		
		CinemaSeatDTO csDTO=new CinemaSeatDTO();
		csDTO.setSeatNumber(10);
		csDTO.setType("Balcony");
		bookingDto.getCinemaSeatList().add(csDTO);
		
		csDTO=new CinemaSeatDTO();
		csDTO.setSeatNumber(11);
		csDTO.setType("Balcony");
		bookingDto.getCinemaSeatList().add(csDTO);
		
		csDTO=new CinemaSeatDTO();
		csDTO.setSeatNumber(13);
		csDTO.setType("Balcony");
		bookingDto.getCinemaSeatList().add(csDTO);
		payLoadDTO.setBookingDto(bookingDto);
		
		registerUser();
		configureCinemaService.configure(payLoadDTO);	
		showBooking(bookingDto);
	}

	private void browseShowDetails() {
		List<ShowDetailsDTO> detailsDTOList=myRepository.getShowDetailsDTO("Bangalore");
		System.out.println("************************ SIZE DTO ****************************************");
		
		System.out.println("SIze : "+detailsDTOList.size());
		
		detailsDTOList.stream().forEach(dto ->{
			System.out.println(dto.getCinemaName()+" _ "+dto.getCityName());
			
		});
		System.out.println("************************ DTO END ****************************************");
		
		Gson gson=new Gson();
		String json=gson.toJson(detailsDTOList);
		System.out.println("json ::::::::::::::: ");
		System.out.println(json);
		
	}
	
	public void showBooking(BookingDTO bookingDto) {		
		
		iBookingService.bookShow(bookingDto);
	}
	
	public void registerUser() {
		User user=new User();
		user.setEmail("xyz@gmail.com");
		user.setName("Robert");
		user.setPassword("abcxyz");
		user.setPhone(9900178125l);
		userRepository.save(user);
	}

}
