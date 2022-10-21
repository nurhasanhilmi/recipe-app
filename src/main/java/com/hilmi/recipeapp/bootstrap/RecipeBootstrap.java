package com.hilmi.recipeapp.bootstrap;

import com.hilmi.recipeapp.model.*;
import com.hilmi.recipeapp.repositories.CategoryRepository;
import com.hilmi.recipeapp.repositories.RecipeRepository;
import com.hilmi.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        Map<String, UnitOfMeasure> units = new HashMap<>();
        unitOfMeasureRepository.findAll().forEach(unitOfMeasure -> units.put(unitOfMeasure.getName(), unitOfMeasure));

        Category mexican = categoryRepository.findByName("Mexican").orElseThrow(NoSuchElementException::new);
        Category american = categoryRepository.findByName("American").orElseThrow(NoSuchElementException::new);

        Recipe guacamole = new Recipe();
        guacamole.setDescription("How to Make the Best Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setServings(4);
        guacamole.setSource("Simply Recipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("1. Cut the avocado:\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2. Mash the avocado flesh:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3. Add the remaining ingredients to taste:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chillis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4. Serve immediately:\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "\n" +
                "Refrigerate leftover guacamole up to 3 days.");

        guacamole.getCategories().add(mexican);
        guacamole.getCategories().add(american);

        guacamole.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), units.get("Each")));
        guacamole.addIngredient(new Ingredient("kosher salt, plus more to taste", new BigDecimal(".25"), units.get("Teaspoon")));
        guacamole.addIngredient(new Ingredient("fresh lime or lemon juice", new BigDecimal(1), units.get("Tablespoon")));
        guacamole.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(4), units.get("Tablespoon")));
        guacamole.addIngredient(new Ingredient("serrano (or jalapeño) chillis, stems and seeds removed, minced", new BigDecimal(2), units.get("Each")));
        guacamole.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), units.get("Tablespoon")));
        guacamole.addIngredient(new Ingredient("ripe tomato, chopped (optional)", new BigDecimal(".5"), units.get("Each")));

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.");

        guacamole.setNotes(guacamoleNotes);

        recipes.add(guacamole);


        Recipe tacos = new Recipe();
        tacos.setDescription("Spicy Grilled Chicken Tacos");
        tacos.setPrepTime(20);
        tacos.setCookTime(15);
        tacos.setServings(6);
        tacos.setSource("Simply Recipes");
        tacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacos.setDifficulty(Difficulty.MODERATE);
        tacos.setDirections("1. Prepare the grill:\n" +
                "Prepare either a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2. Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3. Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165°F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4. Thin the sour cream with milk:\n" +
                "Stir together the sour cream and milk to thin out the sour cream to make it easy to drizzle.\n" +
                "\n" +
                "5. Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "6. Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.");

        tacos.getCategories().add(american);

        tacos.addIngredient(new Ingredient("small corn tortillas", new BigDecimal(8), units.get("Each")));
        tacos.addIngredient(new Ingredient("packed baby arugula (3 ounces)", new BigDecimal(3), units.get("Cup")));
        tacos.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), units.get("Each")));
        tacos.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), units.get("Each")));
        tacos.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), units.get("Pint")));
        tacos.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), units.get("Each")));
        tacos.addIngredient(new Ingredient("sour cream", new BigDecimal(".5"), units.get("Cup")));
        tacos.addIngredient(new Ingredient("milk", new BigDecimal(".25"), units.get("Cup")));
        tacos.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(1), units.get("Each")));

        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");

        tacos.setNotes(tacosNotes);

        recipes.add(tacos);

        return recipes;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }
}
