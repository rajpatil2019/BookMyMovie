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

@Entity
public class CinemaSeat {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Integer seatNumber;
	
	@Column
	private String type;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="cinema_hall_id")
	private CinemaHall cinemaHall;
	
	@OneToMany(mappedBy="cinemaSeat",cascade=CascadeType.ALL)
	private List<ShowSeat> showSeatList=new ArrayList<ShowSeat>();

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<ShowSeat> getShowSeatList() {
		return showSeatList;
	}

	public void addShowSeat(ShowSeat showSeat) {
		if(Objects.isNull(showSeatList))
			showSeatList=new ArrayList<ShowSeat>();
		showSeat.setCinemaSeat(this);
		showSeatList.add(showSeat);
	}

	@Override
	public String toString() {
		return "CinemaSeat [id=" + id + ", seatNumber=" + seatNumber + ", type=" + type + "]";
	}
}
