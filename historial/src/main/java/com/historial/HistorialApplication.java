package com.historial;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class HistorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistorialApplication.class, args);
	}

	@Bean
	public JavaTimeModule javaTimeModule() {
		return new JavaTimeModule();
	}
}
