package by.itacademy.lesson13.domain.product;

public class TV extends Product {
    public TV() {
        super(0);
    }

    public TV(int cost) {
        super(cost);
    }

    @Override
    public String toString() {
        return "TV cost: " + getCost();
    }
}
