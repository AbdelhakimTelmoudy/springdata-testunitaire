package org.telmoudy.springdatajpaebank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.telmoudy.springdatajpaebank.entities.Customer;
import org.telmoudy.springdatajpaebank.repositories.CustomerRepository;

import java.util.List;

@SpringBootApplication
public class SpringdatajpaEbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaEbankApplication.class, args);
	}

	@Bean
	@Profile("!test")
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			List<Customer> customers = List.of(
					Customer.builder()
							.firstName("Mohamed").lastName("Youssfi").email("med@gmail.com").build(),
					Customer.builder()
							.firstName("Ahmed").lastName("Yassine").email("ahmed@gmail.com").build(),
					Customer.builder()
							.firstName("Hanane").lastName("yamal").email("hanane@gmail.com").build()
			);
			customerRepository.saveAll(customers);
		};
	}
}
