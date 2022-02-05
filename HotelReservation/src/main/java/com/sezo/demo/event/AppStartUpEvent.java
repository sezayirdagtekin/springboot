package com.sezo.demo.event;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.sezo.demo.repository.GuestRepository;
import com.sezo.demo.repository.ReservationRepository;
import com.sezo.demo.repository.RoomRepository;
import com.sezo.demo.service.ReservationService;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class AppStartUpEvent implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private  RoomRepository roomRepository;
	
	@Autowired
	private  GuestRepository guestRepository;
	
	@Autowired
	private  ReservationRepository reservationRepository;
	
	@Autowired
	private ReservationService reservationService;


	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		log.info("Lets go. Everthings is ready...........");
		
		roomRepository.findAll().forEach(System.out::println);
		guestRepository.findAll().forEach(System.out::println);
		reservationRepository.findReservationByReservationDate(LocalDate.of(2022, 1, 1)).forEach(System.out::println);
		reservationService.getRoomReservationsForDate(LocalDate.of(2022, 1, 1)).forEach(System.out::println);
		
		log.info("Everthings  looks good...........");
	}

}
