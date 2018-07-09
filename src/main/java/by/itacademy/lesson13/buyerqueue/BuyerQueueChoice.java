package by.itacademy.lesson13.buyerqueue;

import by.itacademy.lesson13.inputable.IntegerInput;

import java.util.ArrayList;
import java.util.List;

public class BuyerQueueChoice {
    private List<BuyerQueue> queues = new ArrayList<>();

    {
        queues.add(new SimpleBuyerQueue());
        queues.add(new ReentrantLockBuyerQueue());
        queues.add(new SemaphoreBuyerQueue());
        queues.add(new BlockingBuyerQueue());
    }

    public BuyerQueue choose() throws RangeException {
        System.out.println("Menu list:");
        for (int i = 0; i < queues.size(); i++) {
            System.out.println(i + ". " + queues.get(i).typo());
        }
        int index = new IntegerInput().getValue("Enter menu number");
        if (index < 0 || index > this.queues.size())
            throw new RangeException("Index out of list range");
        return queues.get(index);
    }
}
