package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.domain.Buyer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlockingBuyerQueue implements BuyerQueue {
    private static final Logger LOGGER = Logger.getLogger(BlockingBuyerQueue.class.getName());
    private final BlockingQueue<Buyer> buyers = new LinkedBlockingQueue<>(5);

    @Override
    public void addBuyer(Buyer buyer) {
        try {
            buyers.put(buyer);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        System.out.println("Buyer has come!");
    }

    @Override
    public Buyer getBuyer() {
        Buyer buyer = null;
        try {
            buyer = buyers.take();
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return buyer;
    }

    @Override
    public void waitingEmpty() {
    }

    @Override
    public void waitingFull() {

    }

    @Override
    public String typo() {
        return "Blocking queue synchronization type";
    }
}
