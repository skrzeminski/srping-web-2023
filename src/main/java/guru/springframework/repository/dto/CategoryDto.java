package guru.springframework.repository.dto;

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
public class CategoryDto {

    private Long id;

    private String description;

    private Set<RecipeDto> recipes = new HashSet<>();
}
