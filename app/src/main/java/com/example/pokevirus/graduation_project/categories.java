package com.example.pokevirus.graduation_project;

/**
 * Created by pokevirus on 15/11/16.
 */

public class categories {
    private String name;
    private String image;

    public categories(){}
    public categories(String name, String image)
    {
        this.name=name;
        this.image=image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage(){return image;}
    public void setImage(String image){this.image=image;}





}
