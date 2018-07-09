package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.domain.Buyer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReentrantLockBuyerQueue implements BuyerQueue {
    private static final Logger LOGGER = Logger.getLogger(ReentrantLockBuyerQueue.class.getName());
    private final Queue<Buyer> buyers = new LinkedList<>();
    private ReentrantLock locker = new ReentrantLock();
    private Condition isEmpty = locker.newCondition();
    private Condition isFull = locker.newCondition();

    @Override
    public void addBuyer(Buyer buyer) {
        locker.lock();
        try {
            buyers.add(buyer);
            System.out.println("Buyer has come!");
            isEmpty.signalAll();
        } finally {
            locker.unlock();
        }
    }

    @Override
    public Buyer getBuyer() {
        locker.lock();
        Buyer buyer;
        try {
            buyer = buyers.poll();
            isFull.signal();
        } finally {
            locker.unlock();
        }
        return buyer;
    }

    @Override
    public void waitingEmpty() {
        locker.lock();
        try {
            while (buyers.isEmpty()) {
                isEmpty.await();
            }
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public void waitingFull() {
        locker.lock();
        try {
            while (buyers.size() >= 5) {
                isFull.await();
            }
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            locker.unlock();
        }
    }

    @Override
    public String typo() {
        return "Reentrant lock synchronization type";
    }
}
