package com.sid.customerservice;

import com.sid.customerservice.entities.Customer;
import com.sid.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration){
//		pour exposer les id de injecter repositoryRestConfiguration
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		return  args -> {
			customerRepository.saveAll(
					List.of(
							Customer.builder().name("hassan").email("hassan@gamil.com").build(),
							Customer.builder().name("youness").email("youness@gamil.com").build(),
							Customer.builder().name("karim").email("karim@gamil.com").build()
					)
			);
			customerRepository.findAll().forEach(c -> {
				System.out.println(c);
			});
		};

	}

}
