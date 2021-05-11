package com.example.projectassigment;

public class Locations {
    //Strings som används av JSON filen (variablerna har samma namn som taggarna)
    private String id;
    private int size;
    private String location;
    private String name;
    private int cost;


    //Generate Constructor
    public Locations(String name, String location, int size) {
        this.id = id;
        this.size = size;
        this.location = location;
        this.name = name;
        this.cost = cost;
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

    //Generate toString()
    //Formatet här bestämmer hur den returnerade datan ser ut.
    @Override
    public String toString() {
        return name;
    }
}
