package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.CatergoryService;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    IndexController indexController;
    @Mock
    RecipeService  recipeService;

    @Mock
    CatergoryService catergoryService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController=new IndexController(recipeService,catergoryService);
    }

    @Test
    public  void testMockMvc() throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }

    @Test
    public void getIndexPage() {

        Set<Recipe> recipes=new HashSet<>();

        Recipe recipe=new Recipe(); recipe.setId(1L);
        Recipe recipe1=new Recipe();recipe1.setId(2L);

        recipes.add(recipe);
        recipes.add(recipe1);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor=ArgumentCaptor.forClass(Set.class);

        when(model.addAttribute(anyString(),any(Object.class))).thenReturn(model);
        assertEquals("index",indexController.getIndexPage(model));
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());
    }
}