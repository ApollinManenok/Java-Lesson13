package by.itacademy.lesson13.runnable;

import by.itacademy.lesson13.buyerqueue.BuyerQueue;
import by.itacademy.lesson13.domain.Buyer;
import by.itacademy.lesson13.runnable.service.ConsumerAdder;


public class ConsumerAddingRunnable implements Runnable {
    private ConsumerAdder adder;
    private BuyerQueue queue;
    private int consumersAmount;

    public ConsumerAddingRunnable(ConsumerAdder adder, BuyerQueue queue, int consumersAmount) {
        this.adder = adder;
        this.queue = queue;
        this.consumersAmount = consumersAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < consumersAmount; i++) {
            queue.waitingFull();
            Buyer buyer = adder.create();
            if (buyer != null)
                queue.addBuyer(buyer);
        }
    }
}