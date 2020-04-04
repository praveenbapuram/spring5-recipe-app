package guru.springframework.services;

import guru.springframework.domain.Category;

import java.util.Set;

public interface CatergoryService {
    Set<Category> getCategories();
}
