package com.evilhomework_khorvat.utilities;

import com.evilhomework_khorvat.models.Dog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateReport {
    public static String generateWeeklyReport(List<Dog> doggies, Integer foodReserve){
        String foodReport = "---------- Weekly Food Report ----------\n";
        Integer totalDailyNeeds = 0;

        for(int i = 0; i < doggies.size(); ++i){
            int dailyNeed = doggies.get(i).getDailyNeed();
            totalDailyNeeds += dailyNeed;
            foodReport += doggies.get(i).getBreed() + " food requirements: " + dailyNeed*7 + "kg.\n";
        }
        foodReport += foodReportXDays(1, totalDailyNeeds, foodReserve);
        foodReport += foodReportXDays(7, totalDailyNeeds, foodReserve);

        saveReport(foodReport);
        return foodReport;
    }

    public static String foodReportXDays(int days, Integer totalDailyNeeds, Integer foodReserve){
        String data = "";
        if(foodReserve > totalDailyNeeds*days)
            data += "Note: There is enough food to feed all animals for " + days + "day/s. (Reserve: " +
                    foodReserve + " Need: " + totalDailyNeeds*days + ")!\n";
        else
            data += "Warning: There is NOT enough food to feed all animals for " + days + "day/s. (Reserve: " +
                    foodReserve + " Need: " + totalDailyNeeds*days + ")!\n";
        return data;
    }

    public static void saveReport(String report){
        try {
            String fileName = "weekly_food_report.txt";
            String path = "src\\com\\evilhomework_khorvat\\data\\out\\" + fileName;
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(report);
            writer.close();
            System.out.println("Report saved successfully.");
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
