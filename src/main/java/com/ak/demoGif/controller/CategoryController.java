package com.ak.demoGif.controller;

import com.ak.demoGif.model.Category;
import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.CategoryRepository;
import com.ak.demoGif.model.repository.GifRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller             //to  lub @Repository musi być żeby adnotacja @Autowired zadzialala w Controllerze
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired                      //dodawaj ta adnotację przed każdą zmienna, żeby mieć pewność, że się powiąże
    GifRepository gifRepository;

   @RequestMapping("/categories")
   public String gitCategories(ModelMap modelMap){

       List<Category> categoryList = categoryRepository.getAllCategories();

       //2. przekazanie obiektow do widoku
       modelMap.put("categories",categoryList);     //pierwszy argument bierzemy z pliku categories.html, nazwa po dolarze ($)

       return "categories";
   }
                                                //potrzebna jest tu adnotacja @PathCategory, żeby wiedział, że nasz parametr ID to endpoint?
    @RequestMapping("/category/{id}")           //podajemy zmienna w wąsach, bo mamy kilka kategorii i każda ma inny adres URL
    public String gifsCategory(@PathVariable int id, ModelMap modelMap){

       //1.pobieranie gifów z ID danej categorii
        List<Gif> gifsByCategory=gifRepository.getGifsByCategoryId(id);

        //2.pobieranie kategorii po ID
        Category category=categoryRepository.getCategoryById(id);

        //przekazanie do widoku
        modelMap.put("gifs",gifsByCategory);
        modelMap.put("category",category);

        return "category";
    }

}
