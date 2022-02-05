package com.sezo.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sezo.demo.entity.Room;
import com.sezo.demo.service.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomApiController {

	private final RoomService roomService;

	@Autowired
	public RoomApiController(RoomService roomService) {
		this.roomService = roomService;
	}

	@GetMapping("/all")
	public List<Room> getGuests() {
		return roomService.getRooms();
	}

}
