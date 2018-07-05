package by.itacademy.lesson13;

import by.itacademy.lesson13.domain.BuyerQueue;
import by.itacademy.lesson13.runnable.Cashbox;
import by.itacademy.lesson13.runnable.Consumerizer;

public class App {
    public static void main(String[] args) {
        BuyerQueue buyers = new BuyerQueue();
        Thread consumerizer = new Thread(new Consumerizer(buyers, 20, 5));
        consumerizer.start();
        for (int i = 0; i < 3; i++) {
            Thread cashbox = new Thread(new Cashbox(buyers, 0));
            cashbox.setDaemon(true);
            cashbox.setName("Cashbox " + (i + 1));
            cashbox.start();
        }
        new Thread(new Consumerizer(buyers, 20, 5)).start();
    }
}
