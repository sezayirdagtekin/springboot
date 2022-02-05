package com.sezo.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
		Iterable<Room> rooms = this.roomRepository.findAll();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservationMap.put(room.getId(), roomReservation);
		});
		Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(date);
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
			roomReservation.setDate(date);
			Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
			roomReservation.setFirstName(guest.getFirstName());
			roomReservation.setLastName(guest.getLastName());
			roomReservation.setGuestId(guest.getGuestId());
		});
		List<RoomReservation> roomReservations = new ArrayList<>();
		for (Long id : roomReservationMap.keySet()) {
			roomReservations.add(roomReservationMap.get(id));
		}
		roomReservations.sort(new Comparator<RoomReservation>() {
			@Override
			public int compare(RoomReservation o1, RoomReservation o2) {
				if (o1.getRoomName().equals(o2.getRoomName())) {
					return o1.getRoomNumber().compareTo(o2.getRoomNumber());
				}
				return o1.getRoomName().compareTo(o2.getRoomName());
			}
		});
		return roomReservations;
	}
}

