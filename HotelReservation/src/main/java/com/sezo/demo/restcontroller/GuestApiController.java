package com.sezo.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sezo.demo.entity.Guest;
import com.sezo.demo.service.GuestService;

@RestController
@RequestMapping("/api/guest")
public class GuestApiController {

	private final GuestService guestService;

	@Autowired
	public GuestApiController(GuestService guestService) {
		this.guestService = guestService;
	}

	@GetMapping("/all")
	public List<Guest> getGuests() {
		return guestService.getGuests();

	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public  void getGuests(@RequestBody Guest guest) {
		guestService.save(guest);
	}
}
