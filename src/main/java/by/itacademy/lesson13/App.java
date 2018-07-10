package by.itacademy.lesson13;

import by.itacademy.lesson13.buyerqueue.BuyerQueueChoice;
import by.itacademy.lesson13.buyerqueue.RangeException;
import by.itacademy.lesson13.domain.Shop;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            Shop shop = new Shop(new BuyerQueueChoice().choose());
            shop.service();
        } catch (RangeException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
