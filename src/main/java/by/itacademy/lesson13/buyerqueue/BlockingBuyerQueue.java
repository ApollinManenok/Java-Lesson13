package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.domain.Buyer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlockingBuyerQueue implements BuyerQueue {
    private static final Logger LOGGER = Logger.getLogger(BlockingBuyerQueue.class.getName());
    private final Queue<Buyer> buyers = new LinkedList<>();

    @Override
    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
        System.out.println("Buyer has come!");
    }

    @Override
    public Buyer getBuyer() {
        Buyer buyer;
        do {
            buyer = buyers.poll();
        } while (buyer == null);
        return buyer;
    }

    @Override
    public void waitingEmpty() {
        synchronized (buyers) {
            try {
                while (buyers.isEmpty()) {
                    buyers.notifyAll();
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
                    buyers.notifyAll();
                    buyers.wait();
                }
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    @Override
    public String typo() {
        return "Blocking queue synchronization type";
    }
}
