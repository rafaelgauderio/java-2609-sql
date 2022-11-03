package com.rafaeldeluca.uri2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaeldeluca.uri2609.entities.Category;
import com.rafaeldeluca.uri2609.projections.CategorySumProjection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery=true, value= "SELECT categories.name, SUM(products.amount) "
			+ "FROM products "
			+ "INNER JOIN categories "
			+ "ON categories.id= products.id_categories "
			+ "GROUP BY categories.name")	
	List<CategorySumProjection> search01();
	
}
