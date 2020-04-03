package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

  private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"index","index.html","/",""})
    public String getIndexPage(){
        Optional<Category> category= categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure =unitOfMeasureRepository.findByUof("Teaspoon");

        System.out.println("Category is : " +category);
        System.out.println("Unit Of Measure  is : " +unitOfMeasure);
        return "index";
    }
}
