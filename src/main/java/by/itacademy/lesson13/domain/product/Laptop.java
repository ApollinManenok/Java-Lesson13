package by.itacademy.lesson13.domain.product;

public class Laptop extends Product {
    public Laptop()  {
        super(0);
    }

    public Laptop(int cost) {
        super(cost);
    }

    @Override
    public String toString() {
        return "Laptop cost: " + getCost();
    }
}
