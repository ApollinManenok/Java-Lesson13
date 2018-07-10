package by.itacademy.lesson13.runnable;

import by.itacademy.lesson13.buyerqueue.BuyerQueue;
import by.itacademy.lesson13.domain.Buyer;
import by.itacademy.lesson13.runnable.service.CashBox;

public class CashBoxRunnable implements Runnable {
    private CashBox cashbox;
    private BuyerQueue queue;

    public CashBoxRunnable(BuyerQueue queue, CashBox cashbox) {
        this.cashbox = cashbox;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.waitingEmpty();
            Buyer buyer = queue.getBuyer();

            cashbox.serve(buyer);

        }
    }
}
