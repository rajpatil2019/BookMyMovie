package com.ticket.booking.platform.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Integer amount;
	
	@Column 
	private String timestamp;
	
	@Column
	private Integer discountCouponId;
	
	@Column
	private Integer remoteTransactionId;
	
	@Column
	private String paymentMethod;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "booking_id", referencedColumnName = "id")
	private Booking booking;
	
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getDiscountCouponId() {
		return discountCouponId;
	}

	public void setDiscountCouponId(Integer discountCouponId) {
		this.discountCouponId = discountCouponId;
	}

	public Integer getRemoteTransactionId() {
		return remoteTransactionId;
	}

	public void setRemoteTransactionId(Integer remoteTransactionId) {
		this.remoteTransactionId = remoteTransactionId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Long getId() {
		return id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
