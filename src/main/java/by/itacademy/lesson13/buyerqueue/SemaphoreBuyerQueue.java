package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.domain.Buyer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemaphoreBuyerQueue implements BuyerQueue {
    private static final Logger LOGGER = Logger.getLogger(SemaphoreBuyerQueue.class.getName());

    private Semaphore addSemaphore = new Semaphore(1);
    private Semaphore getSemaphore = new Semaphore(1);
    private final Queue<Buyer> buyers = new LinkedList<>();

    @Override
    public void addBuyer(Buyer buyer) {
        try {
            addSemaphore.acquire();
            buyers.add(buyer);
            System.out.println("Buyer has come!");
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            getSemaphore.release();
        }
    }

    @Override
    public Buyer getBuyer() {
        Buyer buyer = null;
        try {
            getSemaphore.acquire();
            if (!buyers.isEmpty())
                buyer = buyers.poll();
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            addSemaphore.release();
        }
        return buyer;
    }


    @Override
    public void waitingEmpty() {
        try {
            getSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (buyers.isEmpty()) {
            addSemaphore.release();
        } else {
            getSemaphore.release();
        }
    }

    @Override
    public void waitingFull() {
        try {
            addSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!buyers.isEmpty()) {
            getSemaphore.release();
        } else {
            addSemaphore.release();
        }
    }

    @Override
    public String typo() {
        return "Semaphore synchronization type";
    }
}
