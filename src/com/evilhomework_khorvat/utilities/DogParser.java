package com.evilhomework_khorvat.utilities;

import com.evilhomework_khorvat.models.Dog;
import com.evilhomework_khorvat.interfaces.Parser;

public class DogParser implements Parser<Dog> {
    @Override
    public Dog parse(String line){
        String[] parts = line.split(";");
        return new Dog(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
    }
}
