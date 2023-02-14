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
public class Booking {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Integer numberOfSeats;
	
	@Column
	private String timeStamp;
	
	@Column
	private String status;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="show_id")
	private Show show;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="user_id")
	private User user;

	@OneToMany(mappedBy="booking",cascade=CascadeType.ALL)
	private List<ShowSeat> showSeatList=new ArrayList<ShowSeat>();
	
	@OneToOne(mappedBy = "booking",cascade=CascadeType.ALL)
    private Payment payment;
	
	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		showSeat.setBooking(this);
		showSeatList.add(showSeat);
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
