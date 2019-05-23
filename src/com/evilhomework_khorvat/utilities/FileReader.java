package com.evilhomework_khorvat.utilities;

import com.evilhomework_khorvat.interfaces.Parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader<T> {
    private Parser<T> parser;

    public FileReader(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readFromFile(String path){
        List<T> data = new ArrayList<>();

        /*try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(path).toURI()))){
            lines.forEach(s -> data.add(parser.parse(s)));
        } catch (URISyntaxException e) {
            e.printStackTrace();*/

        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            lines.forEach(s -> data.add(parser.parse(s)));
        } catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
