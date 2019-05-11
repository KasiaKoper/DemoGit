package com.ak.demoGif.model;

public class Gif {

    private String name;
    private  String username;
    private boolean isFavourite;

    public Gif(String name, String username, boolean isFavourite) {
        this.name = name;
        this.username = username;
        this.isFavourite = isFavourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
