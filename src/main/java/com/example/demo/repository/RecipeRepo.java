package com.example.demo.repository;

import com.example.demo.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByDescription(String description);
}
