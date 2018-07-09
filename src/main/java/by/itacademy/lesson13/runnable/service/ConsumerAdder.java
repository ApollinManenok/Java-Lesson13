package by.itacademy.lesson13.runnable.service;

import by.itacademy.lesson13.builders.BuyerBuilder;
import by.itacademy.lesson13.builders.BuyerInstantiationException;
import by.itacademy.lesson13.domain.Buyer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumerAdder {
    private static final Logger LOGGER = Logger.getLogger(ConsumerAdder.class.getName());
    private int id = 0;
    private BuyerBuilder builder = new BuyerBuilder();

    public Buyer create() {
        Buyer buyer = null;
        try {
            buyer = builder.build("Buyer " + (++id), 3);
        } catch (BuyerInstantiationException e) {
            System.out.println(e.getMessage());
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
        return buyer;
    }
}
