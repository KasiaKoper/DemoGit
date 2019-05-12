package com.ak.demoGif.model.repository;

import com.ak.demoGif.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository         //gdy dodajemy to mamy tzw BEANa (ziarno), związaliśmy klasę, Spring będzie nam tworzył sam obiekty tej klasy
                    //to musi być żeby adnotacja @Autowired zadzialala w Controllerze (podobnie działa @Component, ale są jakieś różnice)
public class GifRepository {

    private static List<Gif> ALL_GIFS = Arrays.asList(new Gif("android-explosion", "mols", true,1),
            new Gif("ben-and-mike", "mika", true,2),
            new Gif("book-dominos", "mem", false,0),
            new Gif("compiler-bot", "bot", true,1),
            new Gif("cowboy-coder", "code", false,1),
            new Gif("infinite-andrew", "andrew", true,2));

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


    public List<Gif> getGifsByCategoryId(int id){

        List<Gif> gifsByCategoryId =new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if(gif.getCategoryId()==id){
                    gifsByCategoryId.add(gif);
            }
        }
        return gifsByCategoryId;
    }


}
