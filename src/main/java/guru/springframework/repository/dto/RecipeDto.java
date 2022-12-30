package guru.springframework.repository.dto;

import guru.springframework.repository.model.Difficulty;
import guru.springframework.repository.model.Notes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RecipeDto {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Byte image;
    private String recipeNotes;
    private Set<IngredientDto> ingredients = new HashSet<>();
    private Difficulty difficulty;
}
