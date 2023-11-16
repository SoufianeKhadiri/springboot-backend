package com.skha.springbootbackend.model;

import java.util.List;

public class Tshirt extends Item {

    public Tshirt() {
    }

    public Tshirt(String name, String brand, String price, String size, List<String> fotos, String description) {
        super(name, brand, price, size, fotos, description);
    }
}

