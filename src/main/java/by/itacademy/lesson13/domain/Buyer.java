package by.itacademy.lesson13.domain;

import by.itacademy.lesson13.domain.product.Product;

import java.util.HashSet;
import java.util.Set;

public class Buyer {
    private String name;
    private int cash;
    private Set<Product> products = new HashSet<>();

    public Buyer(String name, int cash) {
        this.name = name;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean moneyRequest(int cost) {
        boolean result = cash >= cost;
        cash = (result) ? (cash - cost) : (cash);
        return result;
    }

    @Override
    public String toString() {
        return name + " products: " + products;
    }
}
