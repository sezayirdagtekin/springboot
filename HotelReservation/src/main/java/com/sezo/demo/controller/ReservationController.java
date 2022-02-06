package com.sezo.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sezo.demo.dto.RoomReservation;
import com.sezo.demo.service.ReservationService;

@Controller
@RequestMapping("/rezervations")
public class ReservationController {

	private final ReservationService reservationService;

	@Autowired
	public ReservationController(ReservationService reservationService) {

		this.reservationService = reservationService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getRoomReservationsByDate(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate date,Model model) {

		List<RoomReservation> rezervations = reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", rezervations);
		return "reservation-template";
	}

}
