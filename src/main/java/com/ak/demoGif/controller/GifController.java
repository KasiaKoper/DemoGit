package com.ak.demoGif.controller;

import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class GifController {

            // Adnotacja @Autowired przywiązuje nam klasę do klasy GifRepository, gdzie mam metody
            // dzieki temu mozemy korzystac z tej metody (nawet jesli nie jest public static)
            // czyli to jest alternatywa, do tworzenia nowego obiektu aby wywolac na nim metode

    @Autowired                  //ta adnotacja musi być w tym miejscu, czyli przed repozytorium, bo to chcemy wiązać
            GifRepository gifRepository;

    @RequestMapping("/showGifsInBrowser")
    @ResponseBody
    public String showGifsInBrowser() {
        return gifRepository.getGifsNames();
    }

    //domyslne zachowanie poniższej metody w Controllerze, jest takie, że on zwraca plik html !!
    @RequestMapping("/")
    public String listGifs(ModelMap modelMap){
         //1.wyciaganie gifow
        List<Gif> gifList =gifRepository.getGifs();

        //2. przekazanie gifa do view - korzystamy z ModelMap, aby począczyć się do frontendu
        //we front-endzie (plik html) szukamy nazwy zmiennej, która potrzebna jest jako pierwszy argument w modelmap
        // poprzedza ją zawsze $ (dollar) w pliku html

        modelMap.put("gifs",gifList);

        //3. Zwracanie widoku

        return "home";              //nazwa pliku html
    }


    @RequestMapping("/favorites")
    public String gifFavorites(ModelMap modelMap) {

        //1.pobieramy liste (tylko ulubionych)
        List<Gif> favoriteGifList=gifRepository.getFavoritesGifs();         //metody są trzymane w repozytorium !!

        //2. Przekazanie gifów do widoku
        modelMap.put("gifs",favoriteGifList);

        //3. Informacja: widok nazywa sie favorites.html

        return "favorites";
    }

    @RequestMapping("/gif/{name}")
    public String gifNames(@PathVariable String name, ModelMap modelMap){

        Gif gif=gifRepository.getGifByName(name);

        modelMap.put("gif",gif);

        return "gif-details";               // tą nazwę bierzemy z nazwy templatu czyli nazwa pliku html
    }


}
