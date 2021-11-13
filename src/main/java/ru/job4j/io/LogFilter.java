package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


public class LogFilter {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }

    public static List<String> filter(String file) {
        List<String> list = null;
        try (BufferedReader readerFile = new BufferedReader(new FileReader(file))) {
            list = readerFile.lines().filter(srt -> srt.contains(" 404 ")).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void save(List<String> list, String filter) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filter)))) {
            for (String str : list) {
                printWriter.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
