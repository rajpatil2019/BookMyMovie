package com.ticket.booking.platform.dto;

import java.io.Serializable;

public class ShowDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5699290587087001869L;
	Long showId;
	String showDate;
	String showSatrtTime;
	String showEndTime;	
	String cityName;
	String cinemaName;
	
	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getShowSatrtTime() {
		return showSatrtTime;
	}
	public void setShowSatrtTime(String showSatrtTime) {
		this.showSatrtTime = showSatrtTime;
	}
	public String getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(String showEndTime) {
		this.showEndTime = showEndTime;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
}	
		
