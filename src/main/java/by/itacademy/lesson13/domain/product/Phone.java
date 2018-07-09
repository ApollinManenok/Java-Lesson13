package by.itacademy.lesson13.domain.product;

public class Phone extends Product {
    public Phone() {
        super(350);
    }

    public Phone(int cost) {
        super(cost);
    }

    @Override
    public String typo() {
        return "Phone";
    }
}
