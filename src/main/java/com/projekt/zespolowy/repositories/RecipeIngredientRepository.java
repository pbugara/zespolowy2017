package com.projekt.zespolowy.repositories;

import com.projekt.zespolowy.models.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}
