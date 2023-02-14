package com.ticket.booking.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.booking.platform.entity.CinemaSeat;

@Repository
public interface CinemaSeatRepository extends JpaRepository<CinemaSeat,Long>{
	
	CinemaSeat findBySeatNumberAndTypeAndCinemaHallId(Integer seatNumber,String type,Long cinemaHallId);
}