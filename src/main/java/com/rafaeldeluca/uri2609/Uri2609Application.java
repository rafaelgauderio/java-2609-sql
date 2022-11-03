package com.rafaeldeluca.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaeldeluca.uri2609.dto.CategorySumDTO;
import com.rafaeldeluca.uri2609.projections.CategorySumProjection;
import com.rafaeldeluca.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<CategorySumProjection> list1 = repository.search01();
		//convertendo para dto
		List<CategorySumDTO> result1 = list1.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());
		
		System.out.println("\nCONSULTAS SQL RAIZ\\n");
		
		for (CategorySumDTO nickname : result1) {
			System.out.println(nickname);
		}
		

	}
}
