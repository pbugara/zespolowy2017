package com.projekt.zespolowy.services;

import com.projekt.zespolowy.DTO.IngredientDTO;
import com.projekt.zespolowy.DTO.RecipeDTO;
import com.projekt.zespolowy.models.Ingredient;
import com.projekt.zespolowy.models.Recipe;
import com.projekt.zespolowy.models.RecipeIngredient;
import com.projekt.zespolowy.repositories.IngredientRepository;
import com.projekt.zespolowy.repositories.RecipeIngredientRepository;
import com.projekt.zespolowy.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    public void addRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        recipe.setPreparation(recipeDTO.getDescription());
        recipe = recipeRepository.save(recipe);

        for(IngredientDTO ingredient : recipeDTO.getIngredientIds()) {
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setRecipe(recipe);
            recipeIngredient.setIngredient(ingredientRepository.findById((long) ingredient.getId()));
            recipeIngredient.setAmount(ingredient.getAmount());
            recipe.getRecipeIngredient().add(recipeIngredient);
            recipeIngredientRepository.save(recipeIngredient);
        }
    }

    public RecipeDTO addIngredient(List<Ingredient> ingredients, RecipeDTO dto) {
        Ingredient ingredient = ingredients
                .stream()
                .filter(i -> i.getId() == dto.getIngredientId())
                .collect(Collectors.toList())
                .get(0);
        dto.addIngredient(ingredient.getName());
        return dto;
    }
}
