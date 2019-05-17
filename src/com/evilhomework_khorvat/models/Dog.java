package com.evilhomework_khorvat.models;

public class Dog extends Animal {
    private String breed;
    private Integer dailyNeed;

    public Dog(String name, Integer age, String breed, Integer dailyNeed) {
        super(name, age);
        this.breed = breed;
        this.dailyNeed = dailyNeed;
    }

    @Override
    public void onBeingFed() {
        System.out.println(this.getName() + " is fed and barking happily.");
    }

    public Integer feed(){
        onBeingFed();
        return dailyNeed;
    }

    public String getBreed() {
        return breed;
    }

    public Integer getDailyNeed() {
        return dailyNeed;
    }
}
