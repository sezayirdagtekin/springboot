package com.sezo.demo.async;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sezo.demo.service.RoomService;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class AscyncListener {

	private final ObjectMapper mapper;
	private final RoomService roomService;

	public AscyncListener(ObjectMapper mapper, RoomService roomService) {
		this.mapper = mapper;
		this.roomService = roomService;
	}

	public void receiveMessage(String message) throws InterruptedException {
		try {
			
			Thread.sleep(1000);
			
			Payload payload = mapper.readValue(message, Payload.class);
			if ("ROOM".equals(payload.getModel())) {
				//Room room = roomService.getById(payload.getId());
				//log.info("Room {}: {} needs to be cleaned", room.getId(), room.getName());
				log.info("Room {}: {} needs to be cleaned", payload.getId(), payload.getModel());	
				}
			else {
				log.warn("Unknown model type");
			}

		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}

	}

}
