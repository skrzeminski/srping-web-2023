package guru.springframework.repository.controller;

import guru.springframework.repository.dto.RecipeDto;
import guru.springframework.repository.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeRepository) {
        this.recipeService = recipeRepository;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<RecipeDto>> getRecipes() {
        List<RecipeDto> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RecipeDto> getRecipe(@PathVariable("id") long id) {
        RecipeDto recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRecipe(@PathVariable("id") long id) {
        recipeService.deleteRecipeById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateRecipe(@PathVariable("id") long id, @RequestBody RecipeDto recipeDto) {
        RecipeDto updatedRecipe = recipeService.updateRecipe(recipeDto);
        return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
    }
}
