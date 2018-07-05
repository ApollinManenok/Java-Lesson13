package by.itacademy.lesson13.runnable;

import by.itacademy.lesson13.domain.BuyerQueue;

public class Cashbox implements Runnable {
    private BuyerQueue buyers;

    public Cashbox(BuyerQueue buyers) {
        this.buyers = buyers;
    }

    @Override
    public void run() {
        do {
            System.out.println(Thread.currentThread().getName() + " served: " + buyers.getBuyer());
        }
        while (buyers.getSize() > 0);
    }
}
