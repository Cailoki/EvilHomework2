package com.evilhomework_khorvat.models;

public abstract class Animal {
    private String name;
    private Integer age;
    private Integer dailyNeed;

    public Animal(String name, Integer age, Integer dailyNeed) {
        this.name = name;
        this.age = age;
        this.dailyNeed = dailyNeed;
    }

    public void onFinishedEating(){
        System.out.println(this.name + " is fed.");
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getDailyNeed() { return dailyNeed; }
}
