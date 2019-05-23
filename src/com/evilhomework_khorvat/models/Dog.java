package com.evilhomework_khorvat.models;

public class Dog extends Animal {
    private String breed;

    public Dog(String breed, String name, Integer age, Integer dailyNeed) {
        super(name, age, dailyNeed);
        this.breed = breed;
    }

    @Override
    public void onFinishedEating() {
        System.out.println(this.getName() + " is fed and barking happily.");
    }

    public Integer feed(){
        onFinishedEating();
        return super.getDailyNeed();
    }

    public String getBreed() {
        return breed;
    }

    public String toString(){
        return "Dog[name=" + this.getName() + ",age=" + this.getAge() + ",breed=" + this.breed + ",dailyNeed=" +
                this.getDailyNeed() + "]";
    }
}
