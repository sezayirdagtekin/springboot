package com.sezo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezo.demo.entity.Room;
import com.sezo.demo.repository.RoomRepository;

@Service
public class RoomService {

	private final RoomRepository roomRepository;

	@Autowired
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	public List<Room> getRooms() {
		return roomRepository.findAll();
	}

	public Room getById(Long id) {
		return roomRepository.getById(id);
	}

}
