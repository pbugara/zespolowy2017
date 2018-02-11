package com.projekt.zespolowy.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekt.zespolowy.DTO.DailyMenuDTO;
import com.projekt.zespolowy.DTO.StringDTO;
import com.projekt.zespolowy.models.DailyMenu;
import com.projekt.zespolowy.models.Recipe;
import com.projekt.zespolowy.models.User;
import com.projekt.zespolowy.repositories.DailyMenuRepository;
import com.projekt.zespolowy.repositories.RecipeRepository;

@Service
public class DailyMenuService {

	@Autowired
	RecipeRepository recipeRepository; 
	
	@Autowired
	DailyMenuRepository dailyMenuRepository;
	
	public void saveDailyMenu(DailyMenuDTO menudto, User user) {
		DailyMenu menu = new DailyMenu();
		menu.setName(menudto.getName());
		Set<Recipe> recipes = new HashSet<>();
		for(StringDTO i: menudto.getRecipeIds()) {
			recipes.add(recipeRepository.findById(Integer.valueOf(i.toString())));
		}
		menu.setRecipes(recipes);		
		menu.setUser(user);
		dailyMenuRepository.save(menu);
	}
}
