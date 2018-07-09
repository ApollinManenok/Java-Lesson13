package by.itacademy.lesson13.domain.product;

public class Headphones extends Product {
    public Headphones() {
        super(170);
    }

    public Headphones(int cost) {
        super(cost);
    }

    @Override
    public String typo() {
        return "Headphones";
    }
}
