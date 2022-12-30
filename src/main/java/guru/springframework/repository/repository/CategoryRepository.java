package guru.springframework.repository.repository;

import guru.springframework.repository.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository  extends CrudRepository<Category, Long> {
}
