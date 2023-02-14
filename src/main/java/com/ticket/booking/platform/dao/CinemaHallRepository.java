package com.ticket.booking.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.booking.platform.entity.CinemaHall;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall,Long> {

}
