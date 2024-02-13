package com.christian.contactlistapi;

import com.christian.contactlistapi.entity.Contact;
import com.christian.contactlistapi.repositories.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactListApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args -> {
			List<Contact> contacts = Arrays.asList(
					new Contact("Carlos", "carlos@gmail.com", LocalDateTime.now()),
					new Contact("Kitian", "kitian@gmail.com", LocalDateTime.now()),
					new Contact("Juan", "juan@gmail.com", LocalDateTime.now()),
					new Contact("Marcelo", "Marcelo@gmail.com", LocalDateTime.now()),
					new Contact("Luis", "luis@gmail.com", LocalDateTime.now())
					);
			contactRepository.saveAll(contacts);
		};
	};

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
