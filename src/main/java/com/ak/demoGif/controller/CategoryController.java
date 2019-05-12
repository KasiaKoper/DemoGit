package com.ak.demoGif.controller;

import com.ak.demoGif.model.Category;
import com.ak.demoGif.model.repository.CategoryRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller             //to  lub @Repository musi być żeby adnotacja @Autowired zadzialala w Controllerze
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

   @RequestMapping("/categories")
   public String gitCategories(ModelMap modelMap){

       List<Category> categoryList = categoryRepository.getAllCategories();

       //2. przekazanie obiektow do widoku
       modelMap.put("categories",categoryList);     //pierwszy argument bierzemy z pliku categories.html, nazwa po dolarze ($)

       return "categories";
   }



}
