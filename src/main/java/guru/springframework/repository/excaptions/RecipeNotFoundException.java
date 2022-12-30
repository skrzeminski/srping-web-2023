package guru.springframework.repository.excaptions;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException() {
        super();
    }

    public RecipeNotFoundException(String message) {
        super(message);
    }
}
