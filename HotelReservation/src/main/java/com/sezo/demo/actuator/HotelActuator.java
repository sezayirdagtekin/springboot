package com.sezo.demo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "hotelstatus")
public class HotelActuator {

	@ReadOperation
	public String checkHotelStatus() {
		return "Hotel is working. Status is : UP";
	}

}
