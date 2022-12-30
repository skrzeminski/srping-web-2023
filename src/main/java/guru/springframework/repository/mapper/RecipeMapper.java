package guru.springframework.repository.mapper;

import guru.springframework.repository.dto.IngredientDto;
import guru.springframework.repository.dto.RecipeDto;
import guru.springframework.repository.model.Ingredient;
import guru.springframework.repository.model.Recipe;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {IngredientMapper.class})
public interface RecipeMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "prepTime", target = "prepTime")
    @Mapping(source = "cookTime", target = "cookTime")
    @Mapping(source = "servings", target = "servings")
    @Mapping(source = "source", target = "source")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "directions", target = "directions")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "notes.recipeNotes", target = "recipeNotes")
    @Mapping(source = "ingredients", target = "ingredients")
    @Mapping(source = "difficulty", target = "difficulty")
    RecipeDto toDto(Recipe recipe);

    @InheritInverseConfiguration
    Recipe toEntity(RecipeDto ingredient);
}
