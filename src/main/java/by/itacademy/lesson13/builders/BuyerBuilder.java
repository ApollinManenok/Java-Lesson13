package by.itacademy.lesson13.builders;

import by.itacademy.lesson13.domain.Buyer;
import by.itacademy.lesson13.domain.product.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BuyerBuilder {
    private Random random = new Random();
    private ArrayList<ProductBuilder<? extends Product>> productBuilders = new ArrayList<>();

    public BuyerBuilder() {
    }

    public BuyerBuilder addProductType(ProductBuilder<? extends Product> productBuilder) {
        productBuilders.add(productBuilder);
        return this;
    }

    public Buyer build(String name, int productAmount) throws ProductInstantiationException {
        Buyer buyer = new Buyer(name);
        buyer.setProducts(fillBuyer(random.nextInt(productAmount)));
        return buyer;
    }
    private Set<Product> fillBuyer(int amount) throws ProductInstantiationException {
        Set<Product> temp = new HashSet<>();
        for (int i = 0; i < amount+1; i++) {
            temp.add(productBuilders.get(random.nextInt(productBuilders.size())).build());
        }
        return temp;
    }
}
