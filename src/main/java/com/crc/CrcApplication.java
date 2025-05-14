package com.crc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CrcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrcApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductService productService) {
		return args -> {
			Stream.of(
					new Product(),
					new Product("name1", 50.1, "desc 1"),
					new Product("name2", 50.1, "desc 2"),
					new Product("name3", 50.1, "desc 3"),
					new Product("name4", 50.1, "desc 4"),
					new Product("name5", 50.1, "desc 5"),
					new Product("Other product", 100.0, "longer description than expected longer description than expected"))
					.forEach(productService::createProduct);
			productService.getAllProducts().forEach(System.out::println);
		};
	}
}
