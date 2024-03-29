package com.turkcell.rentacar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RentacarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentacarApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	//todo: Fuel, Tranmission, Model nesneleri için CRUD operasyonlarını yazınız. Brand için CRUD tamamlayınız. add update delete getall getById sadece nameleri var

}
