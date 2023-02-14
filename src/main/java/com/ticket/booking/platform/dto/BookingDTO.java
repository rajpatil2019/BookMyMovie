package com.ticket.booking.platform.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookingDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4549358110707219143L;
	private Long showId;
	private Integer numberOfSeats;
	private Integer price;
	private String email;
	
	private List<CinemaSeatDTO> cinemaSeatList=new ArrayList<CinemaSeatDTO>();
	
	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<CinemaSeatDTO> getCinemaSeatList() {
		return cinemaSeatList;
	}
	public void setCinemaSeatList(List<CinemaSeatDTO> cinemaSeatList) {
		this.cinemaSeatList = cinemaSeatList;
	}
	
}
