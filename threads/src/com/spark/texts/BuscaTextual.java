package com.spark.texts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscaTextual implements Runnable {
    private String fileName;
    private String nome;

    public BuscaTextual(String fileName, String nome) {
        this.fileName = fileName;
        this.nome = nome;
    }
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int i = 1;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(nome)) {
                    System.out.printf("%s - %s found in line %d\n", fileName, line, i);
                }
                i += 1;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
