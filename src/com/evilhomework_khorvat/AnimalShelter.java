package com.evilhomework_khorvat;

public class AnimalShelter {
    //args[0] dogs.csv, args[1] storage.csv
    public static void main(String[] args){

        //Initiate shelter application
        ShelterUI app = new ShelterUI();
        app.loadDogs(args);
        app.loadUserInterface();

    }
}
