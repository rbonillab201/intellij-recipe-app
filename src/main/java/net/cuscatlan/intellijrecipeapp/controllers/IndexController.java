package net.cuscatlan.intellijrecipeapp.controllers;

import net.cuscatlan.intellijrecipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"","/"})
public class IndexController {

    RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"","/","/index","/index.hmtl"})
    String myIndex(Model model){
        model.addAttribute("title","Recipe Apps!!");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
