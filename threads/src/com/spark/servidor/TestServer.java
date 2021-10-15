package com.spark.servidor;

public class TestServer {

    private volatile boolean isRunning = false;

    public static void main(String[] args) throws InterruptedException {
        TestServer server = new TestServer();
        server.rodar();
        server.changeAtt();
    }

    protected void rodar() {
        try {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    System.out.printf("Server running, isRunning = %s\n", isRunning);

                    while (!isRunning) {
                    }

                    if(isRunning) {
                        throw  new RuntimeException("Error in thread");
                    }

                    System.out.printf("Server running, isRunning = %s\n", isRunning);

                    while (isRunning) {
                    }

                    System.out.printf("Server running, isRunning = %s\n", isRunning);
                }
            });

            thread.setUncaughtExceptionHandler(new ExceptionHandler());
            thread.start();
        } catch (Exception e) {
            System.out.println("Catch exception in MAIN");
        }

    }

    protected void changeAtt() throws InterruptedException {
        Thread.sleep(5000);
        System.out.printf("Main running, isRunning = %s\n", this.isRunning);
        isRunning = true;

        Thread.sleep(5000);

        System.out.printf("Main running, isRunning = %s\n", this.isRunning);
        isRunning = false;
    }
}
