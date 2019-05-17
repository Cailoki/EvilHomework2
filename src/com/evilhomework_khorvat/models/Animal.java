package com.evilhomework_khorvat.models;

public abstract class Animal {
    private String name;
    private Integer age;

    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void onBeingFed(){
        System.out.println(this.name + " is fed.");
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
