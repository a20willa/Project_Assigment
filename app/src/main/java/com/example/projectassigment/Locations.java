package com.example.projectassigment;

import org.jetbrains.annotations.NotNull;

public class Locations {
    //Strings som används av JSON filen (variablerna har samma namn som taggarna)
    private final String id;
    private final int size;
    private final String location;
    private final String name;
    private final int cost;
    private final String auxdata;


    //Generate Constructor
    public Locations(String id, int size, String location, String name, int cost, String auxdata) {
        this.id = id;
        this.size = size;
        this.location = location;
        this.name = name;
        this.cost = cost;
        this.auxdata = auxdata;
    }

    //Generate Getter


    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getAuxdata(){return auxdata;}

    //Generate toString()
    //Formatet här bestämmer hur den returnerade datan ser ut.
    @NotNull
    @Override
    public String toString() {
        return name;
    }
}
