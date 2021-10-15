package com.spark.client;

import com.spark.servidor.ExceptionHandler;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 5555);

        System.out.println("Connection open");

        Thread threadSendCommand = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    Scanner keyboard = new Scanner(System.in);
                    while(keyboard.hasNextLine()) {
                        String line = keyboard.nextLine();
                        if (line.trim().equals("")) {
                            break;
                        }
                        out.println(line);
                    }
                    out.close();
                    keyboard.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadSendCommand.setUncaughtExceptionHandler(new ExceptionHandler());
        threadSendCommand.start();
        Thread threadReceiveResponse = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Scanner serverResponse = new Scanner(socket.getInputStream());
                    while(serverResponse.hasNextLine()) {
                        String line = serverResponse.nextLine();
                        System.out.println(line);
                    }
                    serverResponse.close();
                } catch(IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        threadReceiveResponse.start();

        threadReceiveResponse.join();

        socket.close();

    }
}
