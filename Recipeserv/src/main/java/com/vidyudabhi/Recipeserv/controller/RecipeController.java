package com.vidyudabhi.Recipeserv.controller;

import com.vidyudabhi.Recipeserv.constants.ApiEndpoints;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {

    @GetMapping(ApiEndpoints.ALL_RECIPES)
    public ResponseEntity<Object> getAllRecipes(
            @Valid @Min(value = 0) @RequestParam(name = "page", defaultValue = "0") int page,
            @Valid @Positive @RequestParam(name = "size", defaultValue = "12") int size
    ){
        return new ResponseEntity<>("INSIDE VIEW ALL", HttpStatus.OK);
    }

    @GetMapping(ApiEndpoints.SINGLE_RECIPE)
    public ResponseEntity<?> findRecipeById(@Valid @Positive @PathVariable("id") Long id) {
        return new ResponseEntity<>("INSIDE VIEW SINGLE RECIPE", HttpStatus.OK);
    }

    @PostMapping(ApiEndpoints.SINGLE_RECIPE)
    public ResponseEntity<String> addRecipe(
    ){
        return  ResponseEntity.ok("ADD API");
    }

    @PutMapping(ApiEndpoints.SINGLE_RECIPE)
    public ResponseEntity<Object> updateRecipe(
            @Positive @Valid @PathVariable("id") Long id
    ){
        return ResponseEntity.ok("UPDATE API");
    }

    @DeleteMapping(ApiEndpoints.SINGLE_RECIPE)
    public ResponseEntity<String> deleteRecipe(
            @Valid @Positive @PathVariable("id") Long id
    ){
        return ResponseEntity.ok("DELETE API");
    }

    @GetMapping(ApiEndpoints.SEARCH_RECIPES)
    public ResponseEntity<String> searchRecipes(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String category,
                                      @RequestParam(required = false) String cuisine) {
        return ResponseEntity.ok("SEARCH API");
    }


}
