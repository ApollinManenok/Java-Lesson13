package by.itacademy.lesson13.inputable;

public class IntegerInput implements Inputable<Integer> {
    @Override
    public Integer getValue(String message) {
        System.out.print(message + "\n>>> ");
        int result = scan.nextInt();
        scan.nextLine();
        return result;
    }
}
