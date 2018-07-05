package by.itacademy.lesson13.domain.product;

public abstract class Product {
    private int cost;

    public Product(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
