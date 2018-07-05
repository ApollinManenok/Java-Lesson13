package by.itacademy.lesson13.domain;

import by.itacademy.lesson13.product.Product;

import java.util.Set;

public class Buyer {
    private String name;
    private Set<Product> products;

    public Buyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buyer(Set<Product> products) {
        this.products = products;
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

    @Override
    public String toString() {
        return name+" products: " + products;
    }
}
