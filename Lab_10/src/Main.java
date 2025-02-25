import java.io.*;
class Philosopher extends Thread {
    public final int id;
    private int riceCount;
    private final Object plateLock = new Object();//блокировка тарелки

    public Philosopher(int id) {
        this.id = id;
        this.riceCount = 0;
    }
    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking");
        Thread.sleep((long) (Math.random() * 1000));
    }
    private void eat() throws InterruptedException {
        synchronized (plateLock) {

            riceCount++;
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("Philosopher " + id + " is eating");
            System.out.println("Philosopher " + id + " finished eating");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getRiceCount() {
        return riceCount;
    }
}
public class Main {
    public static void main(String[] args){
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i);
            philosophers[i].start();
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Philosopher philosopher : philosophers) {
            System.out.println("Philosopher " + philosopher.id+ "==" + philosopher.getRiceCount() + " rice");
            philosopher.interrupt();
        }
    }
}