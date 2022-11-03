package com.rafaeldeluca.uri2609.dto;

import com.rafaeldeluca.uri2609.projections.CategoryCountProjection;

public class CategoryCountDTO {
	
	private String name;
	private Long count;	
	
	
	public CategoryCountDTO () {
		
	}

	
	
	public CategoryCountDTO(String name, Long count) {
		super();
		this.name = name;
		this.count = count;
	}



	public CategoryCountDTO(CategoryCountProjection projection) {
		
		name = projection.getName();
		count = projection.getCount();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Long getCount() {
		return count;
	}



	public void setCount(Long count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "Contagem de Lançamentos [Categoria = " + name + ", número de lançamentos = " + count + "]";
	}
}
