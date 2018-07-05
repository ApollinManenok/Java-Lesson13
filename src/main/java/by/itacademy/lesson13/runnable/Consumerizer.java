package by.itacademy.lesson13.runnable;

import by.itacademy.lesson13.builders.BuyerBuilder;
import by.itacademy.lesson13.builders.ProductBuilder;
import by.itacademy.lesson13.builders.ProductInstantiationException;
import by.itacademy.lesson13.domain.Buyer;
import by.itacademy.lesson13.domain.BuyerQueue;
import by.itacademy.lesson13.domain.product.*;


public class Consumerizer implements Runnable {
    private static int counter = 0;
    private BuyerBuilder builder = new BuyerBuilder();
    private BuyerQueue buyers;
    private int buyersAmount;
    private int productBound;

    {
        builder.addProductType(new ProductBuilder<>(Battery.class, 200))
                .addProductType(new ProductBuilder<>(Battery.class, 90))
                .addProductType(new ProductBuilder<>(ComputerMouse.class, 350))
                .addProductType(new ProductBuilder<>(Headphones.class, 270))
                .addProductType(new ProductBuilder<>(Laptop.class, 2000))
                .addProductType(new ProductBuilder<>(Phone.class, 1300))
                .addProductType(new ProductBuilder<>(TV.class, 3600));
    }


    public Consumerizer(BuyerQueue buyers, int buyersAmount, int productBound) {
        this.buyers = buyers;
        this.buyersAmount = buyersAmount;
        this.productBound = productBound;
    }

    @Override
    public void run() {
        for (int i = 0; i < buyersAmount; i++) {
            try {
                counter++;
                Buyer buyer = builder.build("Buyer " + counter, productBound);
                waiting();
                synchronized (buyers) {
                    buyers.addBuyer(buyer);
                }
                System.out.println("Buyer has come!");
                buyers.notifyAll();
            } catch (ProductInstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    private void waiting() {
        synchronized (buyers) {
            while (buyers.size() >= 10) {
                try {
                    buyers.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
