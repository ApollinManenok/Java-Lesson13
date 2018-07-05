package by.itacademy.lesson13.runnable;

import by.itacademy.lesson13.builders.ProductInstantiationException;
import by.itacademy.lesson13.domain.BuyerQueue;


public class Consumerizer implements Runnable {
    private BuyerQueue buyers;
    private int buyersAmount;

    public Consumerizer(BuyerQueue buyers, int buyersAmount) {
        this.buyers = buyers;
        this.buyersAmount = buyersAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < buyersAmount; i++) {
            try {
                buyers.addRandomBuyer();
            } catch (ProductInstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
