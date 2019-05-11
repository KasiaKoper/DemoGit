package com.ak.demoGif.controller;

import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class GifController {

    //@Autowired          // to przywiązuje nam klasę do klasy GifRepository, gdzie mam metody
            // dzieki temu mozemy korzystac z tej metody (nawet jesli nie jest public static)
            // czyli to jest alternatywa, do tworzenia nowego obiektu aby wywolac na nim metode

            GifRepository gifRepository;

    @RequestMapping("/showGifsInBrowser")
    @ResponseBody
    public String showGifsInBrowser() {
        return gifRepository.getGifsNames();
    }

}
