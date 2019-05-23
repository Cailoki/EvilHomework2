package com.evilhomework_khorvat.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public final class TextToFile {
    private TextToFile() { }

    public static void saveTextToFile(String text, String fileName){
        try {
            String path = "src\\com\\evilhomework_khorvat\\" + fileName;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                writer.write(text);
            }
            System.out.println("Report saved successfully to project root.");
        }
        catch (IOException e){
            System.out.println(e);
        }
}
}
