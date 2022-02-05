package com.sezo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sezo.demo.entity.Guest;
import com.sezo.demo.service.GuestService;

@Controller
@RequestMapping("/guests")
public class GuestController {

	private final GuestService guestService;

	@Autowired
	public GuestController(GuestService guestService) {
		this.guestService = guestService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getGuests(Model model) {

		List<Guest> guests = guestService.getGuests();
		model.addAttribute("guests", guests);
		return "guest-template";
	}

}
