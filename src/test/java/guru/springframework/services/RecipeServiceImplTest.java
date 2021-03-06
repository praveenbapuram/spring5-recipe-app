package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService=new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe=new Recipe();
        recipe.setId(1L);
        recipe.setDescription("Description");


        Set<Recipe> set=new HashSet();
        set.add(recipe);
        when(recipeRepository.findAll()).thenReturn(set);

        Set<Recipe> recipes= recipeService.getRecipes();
        assertEquals(1,recipes.size());
        verify(recipeRepository,times(3)).findAll();
    }

}