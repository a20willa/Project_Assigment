package com.example.projectassigment;

public class Locations {
    //Strings som används av JSON filen (variablerna har samma namn som taggarna)
    private String id;
    private int size;
    private String location;
    private String name;
    private int cost;
    private String auxdata;


    //Generate Constructor
    public Locations(String name, String location, int size) {
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
    @Override
    public String toString() {
        return name;
    }
}
