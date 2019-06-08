package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    RecipeRepo recipeRepo;

    @GetMapping("/")
    public String index(){
        Optional<Recipe> recipe = recipeRepo.findByDescription("Perfect guacamole");
        if(recipe.isPresent()){
            System.out.println("fandt " + recipe.get().getDescription());
        } else {
            System.out.println("fandt ingen opskrift");
        }
        return "index";
    }
}
