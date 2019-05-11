package com.ak.demoGif.controller;

import com.ak.demoGif.model.Gif;
import com.ak.demoGif.model.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class GifController {

    @RequestMapping("/showGifsInBrowser")
    @ResponseBody

    public String showGifsInBrowser(){
        return "gifs";
    }

}
