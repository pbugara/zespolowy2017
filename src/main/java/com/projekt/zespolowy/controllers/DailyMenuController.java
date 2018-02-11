package com.projekt.zespolowy.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projekt.zespolowy.DTO.DailyMenuDTO;
import com.projekt.zespolowy.DTO.StringDTO;
import com.projekt.zespolowy.models.DailyMenu;
import com.projekt.zespolowy.models.Recipe;
import com.projekt.zespolowy.models.User;
import com.projekt.zespolowy.repositories.DailyMenuRepository;
import com.projekt.zespolowy.repositories.RecipeRepository;
import com.projekt.zespolowy.services.DailyMenuService;
import com.projekt.zespolowy.services.UserServiceImpl;

@Controller
public class DailyMenuController {

	@Autowired 
	RecipeRepository recipeRepository;
	
	@Autowired
	DailyMenuRepository dailyMenuRepository;
	
	@Autowired
	DailyMenuService dailyMenuService;
	
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping(value = "/dailymenu/add")
	public String getAddDailyMenuView(Map<String, Object> map, @ModelAttribute("dto") StringDTO recipeId, 
			@ModelAttribute("menudto") DailyMenuDTO menudto) {
		List<Recipe> recipeList = recipeRepository.findAll();
		map.put("recipeList", recipeList);
		return "adddailymenu";
	}
	
	@GetMapping(value = "/dailymenus")
	public String getDailyMenusView(Map<String, Object> map) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.login(auth.getName());
		List<DailyMenu> menulist= dailyMenuRepository.findByUser(user);
		map.put("menulist", menulist);
		return "dailymenus";
	}
	
	@GetMapping(value = "/menu")
	public String getDailyMenuView(Map<String, Object> map, @RequestParam(value="nr", required=true) String nr) {
		Long id = Long.valueOf(nr);
		DailyMenu menu = dailyMenuRepository.findById(id);
		map.put("menu", menu);
		return "dailymenu";
	}
	
	@PostMapping(value = "/dailymenu/add")
	public String saveDailyMenu(Map<String, Object> map, @ModelAttribute("dto") StringDTO recipeId) {
		List<Recipe> recipeList = recipeRepository.findAll();
		map.put("recipeList", recipeList);
		return "adddailymenu";
	}
	
	@PostMapping(value = "/dailymenu/recipe/add")
	public String addRecipeToDailyMenu(Map<String, Object> map, @ModelAttribute("dto") StringDTO recipeId,
			@ModelAttribute("menudto") DailyMenuDTO menudto) {
		List<Recipe> recipeList = recipeRepository.findAll();
		for(StringDTO i: menudto.getRecipeIds()) {
			menudto.addRecipe(recipeRepository.findById(Integer.valueOf(i.toString())));
		}
		menudto.addRecipe(recipeRepository.findById(menudto.getRecipeIdToAdd().intValue()));
		menudto.setRecipeIdToAdd(null);
		map.put("recipeList", recipeList);
		return "adddailymenu";
	}
	
	@PostMapping(value = "/dailymenu/recipe/remove")
	public String removeRecipeFromDailyMenu(Map<String, Object> map,
											@ModelAttribute("menudto") DailyMenuDTO menudto) {
		List<Recipe> recipeList = recipeRepository.findAll();
		for(StringDTO i: menudto.getRecipeIds()) {
			int recipeId = Integer.valueOf(i.toString());
			if(recipeId != menudto.getRecipeIdToAdd().intValue()) {
				menudto.addRecipe(recipeRepository.findById(recipeId));
			}		
		}
		menudto.setRecipeIdToAdd(null);
		map.put("recipeList", recipeList);
		return "adddailymenu";
	}
	
	@PostMapping(value = "/dailymenu/save")
	public String saveDailyMenu(@ModelAttribute("menudto") DailyMenuDTO menudto) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.login(auth.getName());
		dailyMenuService.saveDailyMenu(menudto, user);
		return "adddailymenu";
	}
}
