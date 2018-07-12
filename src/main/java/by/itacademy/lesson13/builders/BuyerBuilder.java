package by.itacademy.lesson13.builders;

import by.itacademy.lesson13.domain.Buyer;
import by.itacademy.lesson13.domain.product.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuyerBuilder {
    private static final Logger LOGGER = Logger.getLogger(BuyerBuilder.class.getName());
    private Random random = new Random();
    private ArrayList<ProductBuilder<? extends Product>> productBuilders = new ArrayList<>();

    {
        productBuilders.add(new ProductBuilder<>(Battery.class, 200));
        productBuilders.add(new ProductBuilder<>(ComputerMouse.class, 350));
        productBuilders.add(new ProductBuilder<>(Headphones.class, 270));
        productBuilders.add(new ProductBuilder<>(Laptop.class, 2000));
        productBuilders.add(new ProductBuilder<>(Phone.class, 1300));
        productBuilders.add(new ProductBuilder<>(TV.class, 3600));
    }

    public BuyerBuilder() {
    }

    public BuyerBuilder addProductType(ProductBuilder<? extends Product> productBuilder) {
        productBuilders.add(productBuilder);
        return this;
    }

    public Buyer build(String name, int productsBound) throws BuyerInstantiationException {
        Buyer buyer = new Buyer(name, random.nextInt(5000));
        try {
            buyer.setProducts(getProducts(random.nextInt(productsBound)));
        } catch (ProductInstantiationException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw new BuyerInstantiationException("Can't build buyer \"" + name + "\" because of product instantiation exception");
        }
        return buyer;
    }

    private Set<Product> getProducts(int bound) throws ProductInstantiationException {
        Set<Product> tempSet = new HashSet<>();
        for (int i = 0; i < bound + 1; i++) {
            tempSet.add(productBuilders.get(random.nextInt(productBuilders.size())).build());
        }
        return tempSet;
    }
}
