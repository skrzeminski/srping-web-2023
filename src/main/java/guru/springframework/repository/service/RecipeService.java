package guru.springframework.repository.service;

import guru.springframework.repository.dto.RecipeDto;
import guru.springframework.repository.excaptions.RecipeNotFoundException;
import guru.springframework.repository.mapper.RecipeMapper;
import guru.springframework.repository.model.Notes;
import guru.springframework.repository.model.Recipe;
import guru.springframework.repository.repository.RecipeRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private RecipeMapper recipeMapper;

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeMapper recipeMapper, RecipeRepository recipeRepository) {
        this.recipeMapper = recipeMapper;
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipes::add);
        List<RecipeDto> recipeDtoList = recipes.stream()
                .map(object -> recipeMapper.toDto(object))
                .collect(Collectors.toList());
        return recipeDtoList;
    }

    public RecipeDto getRecipeById(long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        Recipe recipe = recipeOptional.orElseThrow(() -> new RecipeNotFoundException("Recipe Not Found"));
        RecipeDto recipeDto = recipeMapper.toDto(recipe);
        return recipeDto;
    }

    public void deleteRecipeById(long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        recipeOptional.orElseThrow(() -> new RecipeNotFoundException("Recipe Not Found"));
        recipeOptional.ifPresent(uniqueId -> recipeRepository.deleteById(id));
    }

    public RecipeDto updateRecipe(RecipeDto recipeDto) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeDto.getId());
        Recipe recipe = recipeOptional.orElseThrow(() -> new RecipeNotFoundException("Recipe Not Found"));
        recipe.setDescription(recipeDto.getDescription());
        recipe.setPrepTime(recipeDto.getPrepTime());
        recipe.setCookTime(recipeDto.getCookTime());
        recipe.setServings(recipeDto.getServings());
        recipe.setSource(recipeDto.getSource());
        recipe.setUrl(recipeDto.getUrl());
        recipe.setDirections(recipeDto.getDirections());
        recipe.setImage(recipeDto.getImage());
        String recipeNotes = recipeDto.getRecipeNotes();
        if(!StringUtils.isEmpty(recipeNotes)){
            Optional<Notes> optionalNotes = Optional.ofNullable(recipe.getNotes());
            Notes notes = optionalNotes.orElse(new Notes());
            notes.setRecipeNotes(recipeNotes);
            recipe.setNotes(notes);
        }
        recipe.setDifficulty(recipeDto.getDifficulty());
        Recipe savedRecipe = recipeRepository.save(recipe);
        RecipeDto updatedRecipeDto = recipeMapper.toDto(savedRecipe);
        return updatedRecipeDto;
    }
}
