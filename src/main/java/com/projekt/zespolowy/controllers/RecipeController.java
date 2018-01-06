package com.projekt.zespolowy.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projekt.zespolowy.models.Recipe;
import com.projekt.zespolowy.repositories.RecipeRepository;

@Controller
public class RecipeController {

	@Autowired
	RecipeRepository repo;
	
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
}
