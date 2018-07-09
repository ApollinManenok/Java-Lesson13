package by.itacademy.lesson13.runnable.service;

import by.itacademy.lesson13.domain.Buyer;
import by.itacademy.lesson13.domain.product.Product;

import java.util.Set;

public class CashBox {
    private int cash;

    public CashBox() {
        cash = 0;
    }

    public CashBox(int cash) {
        this.cash = cash;
    }

    public synchronized boolean serve(Buyer buyer) {
        int cost = countCost(buyer.getProducts());
        boolean success = buyer.moneyRequest(cost);
        cash += (success) ? (0) : (cost);
        printCheck(success, buyer, cost);
        return success;
    }

    private int countCost(Set<Product> products) {
        int total = 0;
        for (Product product : products) {
            total += product.getCost();
        }
        return total;
    }

    private void printCheck(boolean success, Buyer buyer, int cost) {
        if (success) {
            System.out.println(Thread.currentThread().getName() + " served: " + buyer.getName() +
                    " products [total cost: " + cost + "]: " + buyer.getProducts());
        } else {
            System.out.println(Thread.currentThread().getName() + " can't serve: " + buyer.getName() +
                    " can't buy products [total cost: " + cost + "]: " + buyer.getProducts());
        }
    }
}