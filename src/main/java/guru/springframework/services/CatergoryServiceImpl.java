package guru.springframework.services;

import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CatergoryServiceImpl implements  CatergoryService {

    private CategoryRepository categoryRepository;

    public CatergoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getCategories() {
        Set<Category> categories=new HashSet<>();
       categoryRepository.findAll().iterator().forEachRemaining(categories ::add);
       return categories;
    }
}
