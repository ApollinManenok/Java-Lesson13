package by.itacademy.lesson13.domain.product;

public class ComputerMouse extends Product {
    public ComputerMouse() {
        super(320);
    }

    public ComputerMouse(int cost) {
        super(cost);
    }

    @Override
    public String typo() {
        return "Computer mouse";
    }
}
