package com.projekt.zespolowy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekt.zespolowy.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	public Recipe findById(long id);
}
