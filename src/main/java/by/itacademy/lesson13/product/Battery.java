package by.itacademy.lesson13.product;

public class Battery extends Product {
    public Battery() {
        super(0);
    }

    public Battery(int cost) {
        super(cost);
    }

    @Override
    public String toString() {
        return "Battery cost: "+getCost();
    }
}
