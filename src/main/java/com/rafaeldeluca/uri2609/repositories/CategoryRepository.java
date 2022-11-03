package com.rafaeldeluca.uri2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaeldeluca.uri2609.dto.CategorySumDTO;
import com.rafaeldeluca.uri2609.dto.CategoryCountDTO;
import com.rafaeldeluca.uri2609.entities.Category;
import com.rafaeldeluca.uri2609.projections.CategorySumProjection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery=true, value= "SELECT categories.name, SUM(products.amount) "
			+ "FROM products "
			+ "INNER JOIN categories "
			+ "ON categories.id= products.id_categories "
			+ "GROUP BY categories.name")	
	List<CategorySumProjection> search01();
	
	@Query("SELECT new com.rafaeldeluca.uri2609.dto.CategorySumDTO(objeto.category.name, SUM(objeto.amount)) "
			+ "FROM Product objeto "		// usar o nome da entidade ao invés da tabela do banco	
			+ "GROUP BY objeto.category.name")
	List<CategorySumDTO> searchJPQL01();
	
	@Query("SELECT new com.rafaeldeluca.uri2609.dto.CategoryCountDTO(objeto.category.name, COUNT(objeto.id)) "
			+ "FROM Product objeto "			
			+ "GROUP BY objeto.category.name")
	List<CategoryCountDTO> searchJPQL02();
	
}
