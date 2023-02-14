package com.ticket.booking.platform.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Show {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String dateTime;
	
	@Column
	private String startTime;
	
	@Column
	private String endTime;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cinema_hall_id", referencedColumnName = "id")
	private CinemaHall cinemaHall;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@OneToMany(mappedBy="show",cascade=CascadeType.ALL)
	private List<Booking> bookingList=new ArrayList<Booking>();
	
	@OneToMany(mappedBy="show",cascade=CascadeType.ALL)
	private List<ShowSeat> showSeatList=new ArrayList<ShowSeat>();


	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public CinemaHall getCinemaHall() {
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall) {
		this.cinemaHall = cinemaHall;
	}

	public Long getId() {
		return id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<ShowSeat> getShowSeatList() {
		return showSeatList;
	}

	public void addShowSeat(ShowSeat showSeat) {
		if(Objects.isNull(showSeatList))
			showSeatList=new ArrayList<ShowSeat>();
		showSeat.setShow(this);
		showSeatList.add(showSeat);
	}
	
}
