package com.example.demo.bootstrap;

import com.example.demo.model.*;
import com.example.demo.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RecipeRepo recipeRepo;

    private List<Recipe> createRecipes(){
        List<Recipe> recipes = new ArrayList<>();

        Recipe r1 = new Recipe();
        r1.setDescription("Perfect guacamole");
        Notes notes = new Notes();
        notes.setContent("lsdnvs, efkjb, efjnlg, wefj, dsvns, sdvsdv");

        notes.setRecipe(r1);
        r1.setNotes(notes);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Avocado");
        ingredient.setGrams(BigDecimal.valueOf(500));

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setUnit("gram");
        unitOfMeasure.setIngredient(ingredient);
        ingredient.setUnitOfMeasure(unitOfMeasure);

        r1.getIngredients().add(ingredient);
        ingredient.setRecipe(r1);

        Category category1 = new Category();
        category1.setCategoryName("Mexican");
        category1.getRecipes().add(r1);
        r1.getCategories().add(category1);

        recipes.add(r1);
        return recipes;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        System.out.println("context refreshed");
        recipeRepo.saveAll(createRecipes());
    }

}
