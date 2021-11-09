package ru.job4j.io;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class WriteResultTiFile {
    public static void main(String[] args) {

        try (OutputStream outputStream = new FileOutputStream("result.txt")) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    outputStream.write(((i * j) + " ").getBytes());
                }
                outputStream.write(System.lineSeparator().getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}