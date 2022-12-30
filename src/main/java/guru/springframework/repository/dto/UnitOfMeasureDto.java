package guru.springframework.repository.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UnitOfMeasureDto {

    private Long id;

    private String description;
}
