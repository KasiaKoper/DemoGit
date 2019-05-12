package com.ak.demoGif.model.repository;

import com.ak.demoGif.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public List<Gif> getGifs() {
        return ALL_GIFS;
    }


    public List<Gif> getFavoritesGifs() {

        List<Gif> favoriteGifList=new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.isFavorite()) {
                favoriteGifList.add(gif);
            }
        }
        return favoriteGifList;
    }

}
