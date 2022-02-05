package com.sezo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezo.demo.entity.Guest;
import com.sezo.demo.exception.GuestNotFoundException;
import com.sezo.demo.repository.GuestRepository;

@Service
public class GuestService {

	private final GuestRepository guestRepository;

	@Autowired
	public GuestService(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}

	public List<Guest> getGuests() {
		return guestRepository.findAll();
	}

	public void save(Guest guest) {
		if (guest == null || guest.getFirstName() == null || guest.getLastName() == null
				|| guest.getPhoneNumber() == null) {
			throw new GuestNotFoundException("Guest can not be null!!");
		}
		guestRepository.save(guest);

	}

}
