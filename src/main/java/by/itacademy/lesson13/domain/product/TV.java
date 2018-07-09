package by.itacademy.lesson13.domain.product;

public class TV extends Product {
    public TV() {
        super(4000);
    }

    public TV(int cost) {
        super(cost);
    }

    @Override
    public String typo() {
        return "TV";
    }
}
