package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        if(recipeRepository!=null){
           if(recipeRepository.findAll() !=null){
               if(recipeRepository.findAll().iterator()!=null) {
                   recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
               }
            }
        }

        return recipeSet;
    }
}
