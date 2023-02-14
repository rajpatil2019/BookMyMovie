package com.ticket.booking.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.booking.platform.entity.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {

}
