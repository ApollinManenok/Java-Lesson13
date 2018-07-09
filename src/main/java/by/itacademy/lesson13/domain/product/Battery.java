package by.itacademy.lesson13.domain.product;

public class Battery extends Product {
    public Battery() {
        super(20);
    }

    public Battery(int cost) {
        super(cost);
    }

    @Override
    public String typo() {
        return "Battery";
    }
}
