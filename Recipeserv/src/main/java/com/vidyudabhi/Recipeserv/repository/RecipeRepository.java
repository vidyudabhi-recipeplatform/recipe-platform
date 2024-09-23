package com.vidyudabhi.Recipeserv.repository;

import com.vidyudabhi.Recipeserv.domain.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
