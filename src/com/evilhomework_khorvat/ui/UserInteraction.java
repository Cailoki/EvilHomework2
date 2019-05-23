package com.evilhomework_khorvat.ui;

import com.evilhomework_khorvat.data.ShelterData;
import com.evilhomework_khorvat.utilities.GenerateReport;
import java.util.Scanner;

public class UserInteraction{
    ShelterData data;

    public UserInteraction(ShelterData instance) {
        this.data = instance;
    }

    public void runCommand(){
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Choice ->");
        int choice = inputReader.nextInt();
        switch (choice){
            case 1:
                feedAnimals();
                runCommand();
            case 2:
                restockStorage();
                runCommand();
            case 3:
                generateReportAction();
                runCommand();
            case 4:
                System.exit(0);
            default: {
                System.out.println("Invalid choice, please try again!");
                runCommand();
            }
        }
    }

    private void restockStorage(){
        System.out.println("How much food is added to the storage?");
        Scanner inputReader = new Scanner(System.in);
        data.setFoodReserve(inputReader.nextInt());
    }

    private void feedAnimals(){
        for(int i = 0; i < data.getDogs().size(); ++i){
            int dogNeed = (data.getDogs().get(i).feed());
            data.setFoodReserve(-dogNeed);
       }
    }

    private void generateReportAction(){
        System.out.println(GenerateReport.generateWeeklyReport(data.getDogs(), data.getFoodReserve()));
    }


}
