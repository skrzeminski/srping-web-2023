package guru.springframework.repository.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class IngredientDto {

    private Long id;
    private String description;
    private BigDecimal amount;
    private String uom;
}
