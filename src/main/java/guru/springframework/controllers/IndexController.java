package guru.springframework.controllers;

import guru.springframework.services.CatergoryService;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;
    private final CatergoryService catergoryService;


    public IndexController(RecipeService recipeService, CatergoryService catergoryService) {
        this.recipeService = recipeService;
        this.catergoryService = catergoryService;
    }


    @RequestMapping({"index","index.html","/",""})
    public String getIndexPage(Model model){
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }


    @RequestMapping({"categories","categories.html","/categories"})
    public String getCategories(Model model){
        model.addAttribute("categories",catergoryService.getCategories());
        return "categories";
    }

}
