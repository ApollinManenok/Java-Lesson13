package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.domain.Buyer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SemaphoreBuyerQueue implements BuyerQueue {
    private Semaphore addSemaphore = new Semaphore(1);
    private Semaphore getSemaphore = new Semaphore(0);
    private final Queue<Buyer> buyers = new LinkedList<>();

    @Override
    public void addBuyer(Buyer buyer) {
        try {
            addSemaphore.acquireUninterruptibly();
            buyers.add(buyer);
            System.out.println("Buyer has come!");
        } finally {
            getSemaphore.release();
        }
    }

    @Override
    public Buyer getBuyer() {
        try {
            getSemaphore.acquireUninterruptibly();
            return buyers.poll();
        } finally {
            addSemaphore.release();
        }
    }


    @Override
    public void waitingEmpty() {

    }

    @Override
    public void waitingFull() {

    }

    @Override
    public String typo() {
        return "Semaphore synchronization type";
    }
}
