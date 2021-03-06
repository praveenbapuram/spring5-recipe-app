package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
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

            log.debug("enter into getRecipes()");
           if(recipeRepository.findAll() !=null){
               if(recipeRepository.findAll().iterator()!=null) {
                   recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
               }
            }
        }

        return recipeSet;
    }
}
