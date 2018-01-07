package com.projekt.zespolowy.DTO;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
    private String name;
    private String description;
    private Integer ingredientId;
    private Integer amount;
    private List<IngredientDTO> ingredientIds;

    public RecipeDTO() {
        ingredientIds = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IngredientDTO> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<IngredientDTO> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void addIngredient(String name) {
        IngredientDTO dto = new IngredientDTO();
        dto.setName(name);
        dto.setAmount(this.getAmount());
        dto.setId(this.getIngredientId());
        this.getIngredientIds().add(dto);
        this.setAmount(null);
        this.setIngredientId(null);
    }
}
