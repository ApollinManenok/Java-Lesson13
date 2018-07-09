package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.domain.Buyer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class SemaphoreBuyerQueue implements BuyerQueue {
    private static final Logger LOGGER = Logger.getLogger(SemaphoreBuyerQueue.class.getName());
    private Semaphore gettingSemaphore = new Semaphore(2);
    private Semaphore addingSemaphore = new Semaphore(2);
    private final Queue<Buyer> buyers = new LinkedList<>();

    @Override
    public void addBuyer(Buyer buyer) {
        addingSemaphore.acquireUninterruptibly();
        try {
            buyers.add(buyer);
            System.out.println("Buyer has come!");
        } finally {
            gettingSemaphore.release();
        }
    }

    @Override
    public Buyer getBuyer() {
        gettingSemaphore.acquireUninterruptibly();
        Buyer buyer;
        try {
            do {
                buyer = buyers.poll();
            } while (buyer == null);
        } finally {
            addingSemaphore.release();
        }
        return buyer;
    }


    @Override
    public void waitingEmpty() {
        while (buyers.isEmpty()) {
            addingSemaphore.release();
        }
    }

    @Override
    public void waitingFull() {
        while (buyers.size() >= 5) {
            gettingSemaphore.release();
        }
    }

    @Override
    public String typo() {
        return "Semaphore synchronization type";
    }
}
