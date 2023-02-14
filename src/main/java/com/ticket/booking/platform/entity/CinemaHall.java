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
public class CinemaHall {
  
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
		
	@Column
	private Integer totalSeats;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="cinema_id")
	private Cinema cinema;
	
	@OneToMany(mappedBy="cinemaHall",cascade=CascadeType.ALL)
    private List<CinemaSeat> cinemaSeatList=new ArrayList<CinemaSeat>();
	
	@OneToOne(mappedBy = "cinemaHall",cascade=CascadeType.ALL)
    private Show show;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Long getId() {
		return id;
	}

	public List<CinemaSeat> getCinemaSeatList() {
		return cinemaSeatList;
	}

	public void addCinemaSeat(CinemaSeat cinemaSeat) {
	    if(Objects.isNull(cinemaSeatList))
	    	cinemaSeatList=new ArrayList<CinemaSeat>();
	    cinemaSeat.setCinemaHall(this);
	    cinemaSeatList.add(cinemaSeat);
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
}
