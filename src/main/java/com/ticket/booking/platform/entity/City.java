package com.ticket.booking.platform.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class City {

	@Id
	@GeneratedValue
	private Long cityId;
	
	@Column
	private String name;
	
	@Column
	private String state;
	
	@Column
	private Integer zipcode;
	
	@OneToMany(mappedBy="city",cascade=CascadeType.ALL)
	private List<Cinema> cinemaList=new ArrayList<Cinema>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public Long getCityId() {
		return cityId;
	}
	
	public List<Cinema> getCinemaList() {
		return cinemaList;
	}
	
	public void addCinema(Cinema cinema) {
		
		if(Objects.isNull(cinemaList))
			cinemaList=new ArrayList<Cinema>();
		cinema.setCity(this);
		cinemaList.add(cinema);		
	}
}
