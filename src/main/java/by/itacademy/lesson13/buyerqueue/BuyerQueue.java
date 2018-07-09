package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.domain.Buyer;


public interface BuyerQueue {
    void addBuyer(Buyer buyer);

    Buyer getBuyer();

    void waitingEmpty();

    void waitingFull();

    String typo();
}
