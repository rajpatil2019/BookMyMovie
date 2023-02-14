package com.ticket.booking.platform.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

@Entity
public class ShowSeat {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column 
	private String status;
	
	@Column
	private Integer price;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="cinema_seat_id")
	private CinemaSeat cinemaSeat;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="show_id")
	private Show show;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="booking_id")
	private Booking booking;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public CinemaSeat getCinemaSeat() {
		return cinemaSeat;
	}

	public void setCinemaSeat(CinemaSeat cinemaSeat) {
		this.cinemaSeat = cinemaSeat;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Long getId() {
		return id;
	}
		
}
