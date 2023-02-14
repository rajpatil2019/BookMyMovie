package com.ticket.booking.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.platform.dao.CityRepository;
import com.ticket.booking.platform.dao.MovieRepository;
import com.ticket.booking.platform.dto.CinemaPayloadDTO;
import com.ticket.booking.platform.entity.Cinema;
import com.ticket.booking.platform.entity.CinemaHall;
import com.ticket.booking.platform.entity.CinemaSeat;
import com.ticket.booking.platform.entity.City;
import com.ticket.booking.platform.entity.Movie;
import com.ticket.booking.platform.entity.Show;
import com.ticket.booking.platform.service.IConfigureCinema;

import jakarta.transaction.Transactional;

@Service
public class ConfigureCinemaServiceImpl implements IConfigureCinema {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	@Transactional
	public void configure(CinemaPayloadDTO payload) {
		
		Movie movie=configureMovie(payload);
		
		City city=configureCity(payload);
		
		Cinema cinema=configureCinema(payload);
		city.addCinema(cinema);
		
		for(int i=1;i<=cinema.getTotalCinemaHalls();i++) {
			CinemaHall cinemaHall=configureCinemaHall("INOX_"+i,10);
			cinema.addCinemaHall(cinemaHall);
		} 
		
		cinema.getCinemaHallList().forEach(cinemaHall ->{
			configureCinemaSeatWithCinema(cinemaHall);
		});
		cityRepository.save(city);
		
		cinema.getCinemaHallList().forEach(cinemaHall ->{
			configureShow(movie,cinemaHall,payload);
		});
		
		movieRepository.save(movie);
	}
	
	private void configureShow(Movie movie,CinemaHall cHall, CinemaPayloadDTO payload) {
	
		payload.getShowDtoList().stream().forEach(dto ->{
			Show show=new Show();
			show.setDateTime(dto.getDateTime());
			show.setStartTime(dto.getStartTime());
			show.setEndTime(dto.getEndTime());
			show.setCinemaHall(cHall);
			
			movie.addShow(show);
		});
		
	}

	private Movie configureMovie(CinemaPayloadDTO payload) {
		Movie movie=new Movie();
		movie.setCountry(payload.getCountry());
		movie.setDescription(payload.getDescription());
		movie.setDuration(payload.getDuration());
		movie.setGenre(payload.getGenre());
		movie.setLanguage(payload.getLanguage());
		movie.setReleaseDate(payload.getReleaseDate());
		movie.setTitle(payload.getTitle());
		
		return movie;
	}
	private void configureCinemaSeatWithCinema(CinemaHall cinemaHall){
		CinemaSeat cinemaSeat=new CinemaSeat();		
		cinemaSeat.setCinemaHall(cinemaHall);
		cinemaSeat.setSeatNumber(10);
		cinemaSeat.setType("Balcony");
		cinemaHall.addCinemaSeat(cinemaSeat);
		
		cinemaSeat=new CinemaSeat();		
		cinemaSeat.setCinemaHall(cinemaHall);
		cinemaSeat.setSeatNumber(11);
		cinemaSeat.setType("Balcony");
		cinemaHall.addCinemaSeat(cinemaSeat);
		
		cinemaSeat=new CinemaSeat();		
		cinemaSeat.setCinemaHall(cinemaHall);
		cinemaSeat.setSeatNumber(12);
		cinemaSeat.setType("Balcony");
		cinemaHall.addCinemaSeat(cinemaSeat);
		
		cinemaSeat=new CinemaSeat();		
		cinemaSeat.setCinemaHall(cinemaHall);
		cinemaSeat.setSeatNumber(13);
		cinemaSeat.setType("Balcony");
		cinemaHall.addCinemaSeat(cinemaSeat);
		
	}
	private City configureCity(CinemaPayloadDTO payload) {
		City city=new City();
		
		city.setName(payload.getCity());
		city.setState(payload.getState());
		city.setZipcode(payload.getZipcode());
		return city;
	}
	
	private Cinema configureCinema(CinemaPayloadDTO payload) {
		
		Cinema cinema=new Cinema();
		cinema.setName(payload.getTitle());
		cinema.setTotalCinemaHalls(2);
		
		return cinema;
	}
	
	private CinemaHall configureCinemaHall(String cinemaHallName,Integer totalSeats){
		CinemaHall cinemaHall=new CinemaHall();
		cinemaHall.setName(cinemaHallName);
		cinemaHall.setTotalSeats(totalSeats);
		return cinemaHall;
	}
}
