package com.example.mylearnenglish;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class loadFile {
    private static List<String>data = new ArrayList();

    public static void loadDataFile() throws IOException {
        try {
            String file = "src/main/java/com/example/data/english_learnListening_cleanned.txt";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                data.add(currentLine);
                currentLine = reader.readLine();
            }
            reader.close();
        } catch (IOException ioException) {
            System.out.println("Error!");
        }
    }

    public static String randomWord() {
        Random random = new Random();
        int index = random.nextInt(data.size());
        return loadFile.data.get(index);
    }
}
