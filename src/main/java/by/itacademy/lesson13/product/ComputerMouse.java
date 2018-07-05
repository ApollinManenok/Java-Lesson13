package by.itacademy.lesson13.product;

public class ComputerMouse extends Product {
    public ComputerMouse() {
        super(0);
    }

    public ComputerMouse(int cost) {
        super(cost);
    }

    @Override
    public String toString() {
        return "Computer mouse cost: " + getCost();
    }
}
