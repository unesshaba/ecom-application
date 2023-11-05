package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		return args -> {
			 productRepository.saveAll(
					 List.of(
									 Product.builder().name("Computer").price(3456.87).quantity(1234).build(),
									 Product.builder().name("Tel").price(456.87).quantity(67).build(),
							 		 Product.builder().name("Montre").price(56.87).quantity(34).build()
					        )
			 );
		};
	}

}
