package com.ticket.booking.platform.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.booking.platform.entity.Booking;

@Repository
public interface BookingServiceRepository extends JpaRepository<Booking,Long>{

}
