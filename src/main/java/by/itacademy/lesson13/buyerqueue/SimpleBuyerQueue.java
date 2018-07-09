package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.domain.Buyer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleBuyerQueue implements BuyerQueue {
    private static final Logger LOGGER = Logger.getLogger(SimpleBuyerQueue.class.getName());
    private final Queue<Buyer> buyers = new LinkedList<>();

    @Override
    public void addBuyer(Buyer buyer) {
        synchronized (buyers) {
            buyers.add(buyer);
            System.out.println("Buyer has come!");
            buyers.notifyAll();
        }
    }

    @Override
    public Buyer getBuyer() {
        synchronized (buyers) {
            buyers.notify();
            return buyers.poll();
        }
    }

    @Override
    public void waitingEmpty() {
        synchronized (buyers) {
            try {
                while (buyers.isEmpty()) {
                    buyers.wait();
                }
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    @Override
    public void waitingFull() {
        synchronized (buyers) {
            try {
                while (buyers.size() >= 5) {
                    buyers.wait();
                }
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    @Override
    public String typo() {
        return "Simple synchronization type";
    }
}
