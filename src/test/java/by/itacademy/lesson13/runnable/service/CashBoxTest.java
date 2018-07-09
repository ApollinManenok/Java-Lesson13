package by.itacademy.lesson13.runnable.service;

import by.itacademy.lesson13.domain.Buyer;
import by.itacademy.lesson13.domain.product.Battery;
import by.itacademy.lesson13.domain.product.Headphones;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CashBoxTest {
    private CashBox cashbox = new CashBox();

    @Test
    public void checkBuyerCash100ProductCost100() {
        Buyer buyer = new Buyer("testBuyer", 100);
        buyer.addProduct(new Battery(100));
        assertTrue(cashbox.serve(buyer));
    }

    @Test
    public void checkBuyerCash100ProductsCost20() {
        Buyer buyer = new Buyer("testBuyer", 100);
        buyer.addProduct(new Battery(10));
        buyer.addProduct(new Headphones(10));
        assertTrue(cashbox.serve(buyer));
    }

    @Test
    public void checkBuyerCash100ProductCost200() {
        Buyer buyer = new Buyer("testBuyer", 100);
        buyer.addProduct(new Battery(200));
        assertTrue(!cashbox.serve(buyer));
    }

    @Test
    public void checkBuyerCash100ProductsCost101() {
        Buyer buyer = new Buyer("testBuyer", 100);
        buyer.addProduct(new Battery(50));
        buyer.addProduct(new Headphones(51));
        assertTrue(!cashbox.serve(buyer));
    }
}
