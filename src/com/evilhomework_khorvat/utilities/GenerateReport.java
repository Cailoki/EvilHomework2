package com.evilhomework_khorvat.utilities;
import com.evilhomework_khorvat.models.Dog;

import java.util.List;

public final class GenerateReport {
    //Private constructor for utility class with static methods
    private GenerateReport() {}

    public static String generateWeeklyReport(List<Dog> dogs, Integer foodReserve){
        String foodReportFileName = "weekly_food_report.txt";
        Integer totalDailyNeeds = 0;

        //StringBuilder over string +=
        StringBuilder foodReport = new StringBuilder();
        foodReport.append("---------- Weekly Food Report ----------\n");

        //Foreach loop
        for (Dog dog : dogs) {
            int dailyNeed = dog.getDailyNeed();
            totalDailyNeeds += dailyNeed;

            foodReport.append(dog.getBreed()).append(" food requirements: ").append(dailyNeed * 7).append("kg.\n");
        }

        //Add info about remaining food reserve
        foodReport.append(foodReportXDays(1, totalDailyNeeds, foodReserve));
        foodReport.append(foodReportXDays(7,totalDailyNeeds,foodReserve));

        //Save food report to a file
        TextToFile.saveTextToFile(foodReport.toString(), foodReportFileName);

        return foodReport.toString();
    }

    private static String foodReportXDays(int days, Integer totalDailyNeeds, Integer foodReserve){
        if(foodReserve > totalDailyNeeds*days)
            return "Note: There is enough food to feed all animals for " + days + "day/s. (Reserve: " +
                    foodReserve + " Need: " + totalDailyNeeds*days + ")\n";
        else
            return "Warning: There is NOT enough food to feed all animals for " + days + "day/s! (Reserve: " +
                    foodReserve + " Need: " + totalDailyNeeds*days + ")\n";
    }
}
