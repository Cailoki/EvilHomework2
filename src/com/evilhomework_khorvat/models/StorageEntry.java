package com.evilhomework_khorvat.models;

public class StorageEntry {
    private String breed;
    private Integer foodReserve;

    public StorageEntry(String breed, Integer foodReserve) {
        this.breed = breed;
        this.foodReserve = foodReserve;
    }

    public String getBreed() {
        return breed;
    }

    public Integer getFoodReserve() {
        return foodReserve;
    }
}
