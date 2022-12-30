package guru.springframework.repository.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class NotesDto {

    private Long id;
    private RecipeDto recipe;
    private String recipeNotes;
}
