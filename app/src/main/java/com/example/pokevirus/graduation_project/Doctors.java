package com.example.pokevirus.graduation_project;

/**
 * Created by medos on 9/30/2016.
 */
public class Doctors {
    private String name;

    private String spesific;


    public String getSpecialist() {
        return spesific;
    }

    public void setSpecialist(String spesific) {
        spesific = spesific;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Doctors( ) {
    }
    public Doctors(String name, String Specialist ) {
        this.name = name;
    }
}
