package com.spark.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class TaskServer {

    private ServerSocket server;
    private ExecutorService threadPool;
    private AtomicBoolean isRunning;
    private BlockingQueue<String> commandQueue;

    public TaskServer() throws IOException {
        System.out.println("server starting");
        this.server = new ServerSocket(5555);
        this.threadPool = Executors.newFixedThreadPool(4, new FactoryThread());
        this.isRunning = new AtomicBoolean(true);
        this.commandQueue = new ArrayBlockingQueue<>(2);
        startConsumers();
    }

    public void rodar() throws  IOException {
        while(this.isRunning.get()) {
            try {
                Socket socket = this.server.accept();
                System.out.printf("New client on port %d\n", socket.getPort());

                threadPool.execute(new TaskDistributor(threadPool, socket, this, commandQueue));
            } catch (SocketException e) {
                System.out.printf("SocketException Running %s", this.isRunning.get());
            }
        }
    }

    private void startConsumers() {
        int numberConsumers = 2;
        for (int i = 0; i < numberConsumers; i++) {
            TaskConsumer task = new TaskConsumer(commandQueue);
            this.threadPool.execute(task);
        }
    }

    public void parar() throws IOException {
        this.isRunning.set(false);
        this.threadPool.shutdown();
        this.server.close();
    }
    public static void main(String[] args) throws IOException {
        TaskServer server = new TaskServer();
        server.rodar();
    }
}
