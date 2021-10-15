package com.spark.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TaskDistributor implements Runnable{
    private final ExecutorService threadPool;
    private Socket socket;
    private TaskServer server;
    private BlockingQueue commandQueue;
    public TaskDistributor(ExecutorService threadPool,
                           Socket socket,
                           TaskServer taskServer,
                           BlockingQueue commandQueue) {
        this.socket = socket;
        this.server = taskServer;
        this.threadPool = threadPool;
        this.commandQueue = commandQueue;
    }

    @Override
    public void run() {

        try {
            System.out.printf("Releasing tasks %s\n", socket);
            Scanner inClient = new Scanner(socket.getInputStream());
            PrintStream outClient = new PrintStream(socket.getOutputStream());
            while (inClient.hasNextLine()) {
                String command = inClient.nextLine();

                if (command.startsWith("c")) {
                    CommandC1 c1 = new CommandC1(outClient);
                    this.threadPool.execute(c1);
                } else if (command.startsWith("d")) {
                    CommandC2 c2 = new CommandC2(outClient);
                    CommandDBAccess banco = new CommandDBAccess(outClient);
                    Future<String> futureC2 = this.threadPool.submit(c2);
                    Future<String> futureBanco = this.threadPool.submit(banco);

                    this.threadPool.submit(new JoinFutureResults(futureC2, futureBanco, outClient));

                } else if (command.equals("exit")) {
                    server.parar();
                    break;
                } else {
                    this.commandQueue.put(command);
                    outClient.println("command added to queue");
                }

                System.out.println(command);
            }
            inClient.close();
            outClient.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
