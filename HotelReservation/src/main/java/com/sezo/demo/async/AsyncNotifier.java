package com.sezo.demo.async;

import java.util.random.RandomGenerator;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sezo.demo.config.RabbitMqProperties;

@Component
public class AsyncNotifier implements CommandLineRunner {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private RabbitMqProperties properties;


	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			RandomGenerator generator = RandomGenerator.getDefault();
			Payload paylod = new Payload();
			paylod.setId(generator.nextLong(0,100));
			paylod.setModel("ROOM");

			rabbitTemplate.convertAndSend(properties.getExchange(), properties.getRoutingKey(),
					mapper.writeValueAsString(paylod));

		}

	}

}
