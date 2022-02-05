package com.sezo.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sezo.demo.entity.Reservation;

@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Long>{
	
	List<Reservation> findReservationByReservationDate(LocalDate date);

}
