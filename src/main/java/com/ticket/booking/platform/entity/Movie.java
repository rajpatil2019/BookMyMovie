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
public class Movie {

	@Id
	@GeneratedValue
	private Long movieId;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	//@Column
	//private LocalTime duration;
	
	@Column
	private Integer duration;
	
	@Column
	private String language;
	
	@Column
	private String releaseDate;
	
	@Column
	private String country;
	
	@Column
	private String genre;
	
	@OneToMany(mappedBy="movie",cascade=CascadeType.ALL)
    private List<Show> showList=new ArrayList<Show>();

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

	public Long getMovieId() {
		return movieId;
	}

	public List<Show> getShowList() {
		return showList;
	}

	public void addShow(Show show) {
		if(Objects.isNull(showList))
			showList=new ArrayList<Show>();
		show.setMovie(this);
		showList.add(show);			
	}
	
	
}
