package by.itacademy.lesson13.domain;

import by.itacademy.lesson13.builders.BuyerBuilder;
import by.itacademy.lesson13.builders.ProductBuilder;
import by.itacademy.lesson13.builders.ProductInstantiationException;
import by.itacademy.lesson13.product.Battery;
import by.itacademy.lesson13.product.ComputerMouse;
import by.itacademy.lesson13.product.Headphones;
import by.itacademy.lesson13.product.Laptop;
import by.itacademy.lesson13.product.Phone;
import by.itacademy.lesson13.product.TV;

import java.util.LinkedList;

public class BuyerQueue {
    private LinkedList<Buyer> buyers = new LinkedList<>();
    private BuyerBuilder builder = new BuyerBuilder();
    private int counter = 1;

    {
        builder.addProductType(new ProductBuilder<>(Battery.class, 200))
                .addProductType(new ProductBuilder<>(ComputerMouse.class, 350))
                .addProductType(new ProductBuilder<>(Headphones.class, 270))
                .addProductType(new ProductBuilder<>(Laptop.class, 2000))
                .addProductType(new ProductBuilder<>(Phone.class, 1300))
                .addProductType(new ProductBuilder<>(TV.class, 3600));
    }

    public synchronized Buyer getBuyer() {
        while (buyers.size() < 1) {
            notify();
            waiting();
        }
        return buyers.remove();
    }

    public synchronized int getSize() {
        return buyers.size();
    }

    public synchronized void addRandomBuyer() throws ProductInstantiationException {
        while (buyers.size() >= 10) {
            waiting();
        }
        buyers.add(builder.build("Buyer " + counter++, 5));
        System.out.println("Buyer has come!");
        notifyAll();
    }

    public synchronized void addBuyer(Buyer buyer) {
        while (buyers.size() >= 10) {
            waiting();
        }
        buyers.add(buyer);
        System.out.println("Buyer has come!");
        notifyAll();
    }

    private void waiting() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
