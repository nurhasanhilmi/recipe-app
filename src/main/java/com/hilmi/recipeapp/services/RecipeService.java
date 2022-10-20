package com.hilmi.recipeapp.services;

import com.hilmi.recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
