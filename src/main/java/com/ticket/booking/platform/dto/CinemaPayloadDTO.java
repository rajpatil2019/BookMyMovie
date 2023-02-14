package com.ticket.booking.platform.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;

public class CinemaPayloadDTO {

	private String city;
	private String state;
	private Integer zipcode;
	
	// Cinema details
    private String title;
	private String description;
	private Integer duration;
	private String language;
	private String releaseDate;
	private String country;
	private String genre;
	
	private List<ShowDTO> showDtoList=new ArrayList<ShowDTO>();
	private BookingDTO bookingDto;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<ShowDTO> getShowDtoList() {
		return showDtoList;
	}
	public void addShowDto(ShowDTO showDTO) {
		if(Objects.isNull(showDtoList))
			this.showDtoList = new ArrayList<ShowDTO>();
		showDtoList.add(showDTO);
		
	}
	public BookingDTO getBookingDto() {
		return bookingDto;
	}
	public void setBookingDto(BookingDTO bookingDto) {
		this.bookingDto = bookingDto;
	}
}
