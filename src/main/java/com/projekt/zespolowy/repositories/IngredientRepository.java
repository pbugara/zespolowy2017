package com.projekt.zespolowy.repositories;

import com.projekt.zespolowy.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    public Ingredient findById(Long id);
}
