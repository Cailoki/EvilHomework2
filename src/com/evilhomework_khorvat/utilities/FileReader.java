package com.evilhomework_khorvat.utilities;

import com.evilhomework_khorvat.interfaces.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader<T extends Parser<T>> {
    private T model;

    public FileReader(T model) {
        this.model = model;
    }

    public List<T> readFromFile(String path){
        Scanner reader = null;
        List<T> data = new ArrayList<T>();
        try {
            reader = new Scanner(new File(path));
            while (reader.hasNext()) {
                data.add(model.parse(reader.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return data;
    }
}
