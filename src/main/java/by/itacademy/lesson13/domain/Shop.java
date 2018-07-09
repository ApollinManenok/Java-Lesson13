package by.itacademy.lesson13.domain;

import by.itacademy.lesson13.buyerqueue.BuyerQueue;
import by.itacademy.lesson13.runnable.CashBoxRunnable;
import by.itacademy.lesson13.runnable.ConsumerAddingRunnable;
import by.itacademy.lesson13.runnable.service.CashBox;
import by.itacademy.lesson13.runnable.service.ConsumerAdder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Shop {
    private BuyerQueue queue;

    public Shop(BuyerQueue queue) {
        this.queue = queue;
    }

    public void service() {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new CashBoxRunnable(queue, new CashBox()));
        service.execute(new CashBoxRunnable(queue, new CashBox()));
        service.execute(new CashBoxRunnable(queue, new CashBox()));
        service.execute(new ConsumerAddingRunnable(new ConsumerAdder(), queue, 20));
    }
}
