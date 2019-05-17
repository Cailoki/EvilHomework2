package com.evilhomework_khorvat;

import com.evilhomework_khorvat.models.ShelterData;
import com.evilhomework_khorvat.utilities.GenerateReport;

import java.util.Scanner;

public class ShelterUI extends ShelterData {

    private void runCommand(){
        Scanner inputReader = new Scanner(System.in);
        int choice = inputReader.nextInt();
        switch (choice){
            case 1:
                feedAnimals();
                showMenu();
                break;
            case 2:
                restockStorage();
                showMenu();
                break;
            case 3:
                generateReportAction();
                showMenu();
                break;
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
        this.setFoodReserve(inputReader.nextInt());
    }

    private void feedAnimals(){
        for(int i = 0; i < this.getDogs().size(); ++i){
            int dogNeed = (this.getDogs().get(i).feed());
            this.setFoodReserve(-dogNeed);
        }
    }

    private void generateReportAction(){
        System.out.println(GenerateReport.generateWeeklyReport(this.getDogs(), this.getFoodReserve()));
    }

    private void showMenu(){
        System.out.println("Action menu: enter number for the action you want to perform:\n" +
                "1. Feed Animals  2. Restock Storage  3. Generate Food Report  4. Exit Application");
        runCommand();
    }

    public void loadUserInterface(){
        System.out.println("\n---------- Welcome to animal shelter! ----------");
        showMenu();
    }
}
