package by.itacademy.lesson13.domain;

import java.util.LinkedList;
import java.util.Queue;

public class BuyerQueue {
    private Queue<Buyer> buyers = new LinkedList<>();

    public synchronized Buyer getBuyer() {
        return buyers.poll();
    }

    public int size() {
        return buyers.size();
    }

    public synchronized void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

}
