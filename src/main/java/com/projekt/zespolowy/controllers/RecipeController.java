package com.projekt.zespolowy.controllers;

import java.util.List;
import java.util.Map;

import com.projekt.zespolowy.DTO.RecipeDTO;
import com.projekt.zespolowy.models.Ingredient;
import com.projekt.zespolowy.repositories.IngredientRepository;
import com.projekt.zespolowy.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.projekt.zespolowy.models.Recipe;
import com.projekt.zespolowy.repositories.RecipeRepository;

@Controller
public class RecipeController {

	@Autowired
	RecipeRepository repo;

	@Autowired
	IngredientRepository ingredientRepository;

	@Autowired
	RecipeService recipeService;

	@RequestMapping(value= "/recipes")
	public String recipes(Map<String,Object> map) {
		List<Recipe> recipeList = repo.findAll();
		map.put("recipeList", recipeList);
		return "recipes";
	}
	
	@RequestMapping(value="/recipe")
	public String recipe(@RequestParam(value="nr", required=true) String nr,
						Map<String,Object> map) {
		
		long id = Long.valueOf(nr);
		Recipe recipe = repo.findById(id);
		map.put("recipe", recipe);
		return "recipe";
	}

	@GetMapping(value = "/recipe/add")
	public String getAddRecipeView(Map<String, Object> map, @ModelAttribute("recipe") RecipeDTO dto) {
		map.put("ingredients", ingredientRepository.findAll());
		return "add-recipe";
	}

	@PostMapping(value = "/recipe/add")
	public String addRecipe(@ModelAttribute("recipe") RecipeDTO dto) {
		recipeService.addRecipe(dto);
		return "redirect:/recipes";
	}

	@PostMapping(value = "/recipe/ingredient/add")
	public String addIngredient(Map<String, Object> map, @ModelAttribute("recipe") RecipeDTO dto) {
		List<Ingredient> ingredients = ingredientRepository.findAll();
		map.put("ingredients", ingredients);
		dto = recipeService.addIngredient(ingredients, dto);
		System.out.println(dto.getIngredientIds().size());
		return "add-recipe";
	}
}
