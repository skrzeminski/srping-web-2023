package guru.springframework.repository.mapper;

import guru.springframework.repository.dto.IngredientDto;
import guru.springframework.repository.model.Ingredient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "uom.description", target = "uom")
    IngredientDto toDto(Ingredient ingredient);

    @InheritInverseConfiguration
    Ingredient toEntity(IngredientDto ingredient);
}
