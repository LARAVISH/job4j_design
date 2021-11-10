package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;


public class EvenNumberFile {
    public static void main(String[] args) throws IOException {

        try (FileInputStream input = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int count;
            while ((count = input.read()) != -1) {
                text.append((char) count);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int number = Integer.parseInt(line);
                String result = number % 2 == 0 ? "Even number " : "Not even number";
                System.out.print(result + " " + number);
                System.out.println();
            }
        }
    }
}
