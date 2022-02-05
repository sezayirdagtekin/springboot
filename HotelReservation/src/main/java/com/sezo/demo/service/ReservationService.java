package com.sezo.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezo.demo.entity.Guest;
import com.sezo.demo.entity.Reservation;
import com.sezo.demo.entity.Room;
import com.sezo.demo.repository.GuestRepository;
import com.sezo.demo.repository.ReservationRepository;
import com.sezo.demo.repository.RoomRepository;

@Service
public class ReservationService {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;

	@Autowired
	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {

		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}

	public List<RoomReservation> getRoomReservationsForDate(LocalDate date) {
		Map<Long, RoomReservation> roomReservationMap = getRoomReservationMap();

		getReservationByDate(date, roomReservationMap);

		List<RoomReservation> roomReservations = sortReservartion(roomReservationMap);
		return roomReservations;
	}

	private List<RoomReservation> sortReservartion(Map<Long, RoomReservation> roomReservationMap) {
		List<RoomReservation> roomReservations = new ArrayList<>();
		roomReservationMap
		.entrySet()
		.stream()
		.forEach(e -> roomReservations.add(e.getValue()));

		roomReservations.sort((RoomReservation o1, RoomReservation o2) -> {
			if (o1.getRoomName().equals(o2.getRoomName())) {
				return o1.getRoomNumber().compareTo(o2.getRoomNumber());
			}
			return o1.getRoomName().compareTo(o2.getRoomName());
		});
		return roomReservations;
	}

	private void getReservationByDate(LocalDate date, Map<Long, RoomReservation> roomReservationMap) {
		Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(date);
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			roomReservation.setDate(date);
			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			roomReservation.setGuestId(guest.getGuestId());
		});
	}

	private Map<Long, RoomReservation> getRoomReservationMap() {
		Iterable<Room> rooms = this.roomRepository.findAll();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservationMap.put(room.getId(), roomReservation);
		});
		return roomReservationMap;
	}
}
