package com.ak.demoGif.model.repository;

import com.ak.demoGif.model.Gif;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Repository         //gdy dodajemy to mamy tzw BINa, związaliśmy klasę, Spring będzie nam tworzył sam obiekty tej klasy
public class GifRepository {

    private static List<Gif> ALL_GIFS = Arrays.asList(new Gif("android-explosion", "mols", true),
            new Gif("ben-and-mike", "mika", true),
            new Gif("book-dominos", "mem", false),
            new Gif("compiler-bot", "bot", true),
            new Gif("cowboy-coder", "code", false),
            new Gif("infinite-andrew", "andrew", true));

    public String getGifsNames() {
        String result="";

        for (Gif allGif : ALL_GIFS) {
            result+=allGif.getName();
        }
        return result;
    }

    public static List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public static void setAllGifs(List<Gif> allGifs) {
        ALL_GIFS = allGifs;
    }
}
