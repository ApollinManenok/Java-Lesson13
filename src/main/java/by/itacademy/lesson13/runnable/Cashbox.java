package by.itacademy.lesson13.runnable;

import by.itacademy.lesson13.domain.Buyer;
import by.itacademy.lesson13.domain.BuyerQueue;
import by.itacademy.lesson13.domain.product.Product;

import java.util.Set;

public class Cashbox implements Runnable {
    private static int shopCash = 0;
    private BuyerQueue buyers;
    private int cash;

    public Cashbox(BuyerQueue buyers, int cash) {
        this.buyers = buyers;
        this.cash = cash;
    }

    @Override
    public void run() {
        while (true) {
            Buyer buyer;
            waiting();
            synchronized (buyers) {
                buyer = buyers.getBuyer();
            }
            System.out.println("\n" + Thread.currentThread().getName() + " served: " + buyer + "\nTotal cost: "
                    + countSum(buyer.getProducts()) + "\nCash box cash: " + cash
                    + "\nTotal cash: " + shopCash + "\n");
            buyers.notify();
        }
    }

    private int countSum(Set<Product> products) {
        int sum = 0;
        for (Product product : products) {
            sum += product.getCost();
        }
        shopCash += sum;
        cash += sum;
        return sum;
    }

    private void waiting() {
        synchronized (buyers) {
            while (buyers.size() < 1) {
                try {
                    buyers.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
