package com.ticket.booking.platform.dto;

import java.io.Serializable;

public class CinemaSeatDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6010370093382514790L;
	private Integer seatNumber;
	private String type; 
	private Long cinemaHallId;
	
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
	public Long getCinemaHallId() {
		return cinemaHallId;
	}
	public void setCinemaHallId(Long cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}
	
}
