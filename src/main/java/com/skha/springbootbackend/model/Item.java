package com.skha.springbootbackend.model;


import java.util.List;

public class Item  {

    private String name;
    private String brand;
    private String price;
    private String size;
    private List<String> fotos;

    private String description;

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Item() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public Item(String name, String brand, String price, String size, List<String> fotos, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.fotos = fotos;
        this.description = description;
    }
}


