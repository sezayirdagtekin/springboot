package com.sezo.demo.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sezo.demo.async.AscyncListener;

@Configuration
public class RabbitMQConfig {

	@Autowired
	private RabbitMqProperties properties;

	@Bean
	public TopicExchange getExchangeName() {
		return new TopicExchange(properties.getExchange());
	}

	@Bean
	public Queue getQueueName() {
		return new Queue(properties.getQueue());
	}

	@Bean
	public Binding declareBinding() {
		return BindingBuilder.bind(getQueueName()).to(getExchangeName())
				.with(properties.getRoutingKey());
	}

	@Bean
	public MessageListenerAdapter  listenerAdapter(AscyncListener listener) {
		return  new MessageListenerAdapter(listener, "receiveMessage");
		
	}
	
	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory  connectionFactory, MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container= new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setMessageListener(listenerAdapter);
		container.setQueueNames(properties.getQueue());
		return container;
		
	}
	


}