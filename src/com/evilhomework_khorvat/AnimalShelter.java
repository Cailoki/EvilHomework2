package com.evilhomework_khorvat;

import com.evilhomework_khorvat.ui.ConsoleUI;
import com.evilhomework_khorvat.ui.GraphicsUI;

public class AnimalShelter {
    //args[0] dogs.csv, args[1] storage.csv
    public static void main(String[] args){

        //Initiate shelter application
        ShelterData shelterInstance = new ShelterData().loadData(args);
        UserInterface userInterface = new UserInterface<>(new GraphicsUI()).drawInterface();
        UserInteraction actions = new UserInteraction(shelterInstance);
        actions.runCommand();
    }
}