package com.ticket.booking.platform.service;

import java.time.LocalDate;

public interface BrowseMovieService {

	void browseTheatres(String movie, LocalDate showDate);
}
