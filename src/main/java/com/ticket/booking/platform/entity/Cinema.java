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
public class Cinema {

	@Id
	@GeneratedValue
	private Long cinemaId;
	
	@Column
	private String name;
	
	@Column
	private Integer totalCinemaHalls;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToMany(mappedBy="cinema",cascade=CascadeType.ALL)
    private List<CinemaHall> cinemaHallList=new ArrayList<CinemaHall>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Long getCinemaId() {
		return cinemaId;
	}

	public Integer getTotalCinemaHalls() {
		return totalCinemaHalls;
	}

	public void setTotalCinemaHalls(Integer totalCinemaHalls) {
		this.totalCinemaHalls = totalCinemaHalls;
	}

	public List<CinemaHall> getCinemaHallList() {
		return cinemaHallList;
	}

	public void addCinemaHall(CinemaHall cinemaHall) {
		if(Objects.isNull(cinemaHallList))
			cinemaHallList=new ArrayList<CinemaHall>();
		cinemaHall.setCinema(this);
		cinemaHallList.add(cinemaHall);
	}
	
}
