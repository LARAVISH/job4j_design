package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }

    public static List<String> filter(String file) {
        List<String> list = null;
        try (BufferedReader readerFile = new BufferedReader(new FileReader(file))) {
            list = readerFile.lines().filter(srt -> srt.contains("404")).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
