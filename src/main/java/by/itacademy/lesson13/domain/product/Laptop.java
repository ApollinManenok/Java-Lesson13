package by.itacademy.lesson13.domain.product;

public class Laptop extends Product {
    public Laptop() {
        super(4300);
    }

    public Laptop(int cost) {
        super(cost);
    }

    @Override
    public String typo() {
        return "Laptop";
    }
}
