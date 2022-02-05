package com.sezo.demo.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sezo.demo.service.ReservationService;
import com.sezo.demo.service.RoomReservation;

@RestController
@RequestMapping("/api")
public class ReservationApiController {

	private final ReservationService reservationService;

	@Autowired
	public ReservationApiController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@RequestMapping(path = "/reservations", method = RequestMethod.GET)
	public List<RoomReservation> getRoomReservationsByDate(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		LocalDate reservationDate = date == null ? LocalDate.now() : date;
		return reservationService.getRoomReservationsForDate(reservationDate);
	}

}
