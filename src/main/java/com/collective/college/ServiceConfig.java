package com.collective.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import cc.repository.init.DataInitializer;

@Configuration
public class ServiceConfig {

	@Autowired
	private DataInitializer dataInitializer;

	@EventListener({ContextRefreshedEvent.class})
	public void contextRefreshedEvent() {
		dataInitializer.initialize();
	}
}