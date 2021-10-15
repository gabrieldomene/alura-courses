package com.spark.conflicts;

public class Restroom {
    private boolean isDirty = true;
    public void takeOne() {

        synchronized (this) {
            String name = Thread.currentThread().getName();
            System.out.printf("entering 1 - %s\n", name);
            while (isDirty) waitOutside(name);
            waitSleep(1000);
            this.isDirty = true;
            System.out.printf("exiting 1 - %s\n", name);
        }
    }

    private void waitSleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void takeTwo() {
        synchronized (this) {
            String name = Thread.currentThread().getName();
            System.out.printf("entering 2 - %s\n", name);
            while (isDirty) waitOutside(name);

            waitSleep(2500);
            this.isDirty = true;
            System.out.printf("exiting 2 - %s\n", name);
        }
    }

    public void waitOutside(String name) {
        System.out.printf("%s, is dirty\n", name);
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clean() {
        String name = Thread.currentThread().getName();

        System.out.printf("%s knocking\n", name);

        synchronized (this) {
            System.out.printf("%s entering\n", name);
            if (!this.isDirty) {
                System.out.printf("%s not dirty, leaving\n", name);
                return;
            }

            System.out.printf("%s cleaning\n", name);
            this.isDirty = false;

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.notifyAll();
            System.out.printf("%s leaving\n", name);
        }
    }
}
