package com.sezo.demo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component(value = "hotelhealthcheck")
public class HealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		
		if(check()!=1) {
			return  Health.down().build();
		}
		return Health.up().build();
	}

	
	 public int check() {
	    	// Our logic to check health
	    	return 1;
	    }
}
