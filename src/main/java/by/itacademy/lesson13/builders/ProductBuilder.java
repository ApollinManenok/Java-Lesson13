package by.itacademy.lesson13.builders;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ProductBuilder<T> {
    private Random random = new Random();
    private Class<T> clazz;
    private int costBound;

    public ProductBuilder(Class<T> clazz, int costBound) {
        this.clazz = clazz;
        this.costBound = costBound;
    }

    public T build() throws ProductInstantiationException {
        T product;
        try {
            product = clazz.newInstance();
            clazz.getSuperclass().getMethod("setCost",int.class).invoke(product,random.nextInt(costBound));
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new ProductInstantiationException("Can't create product");
        }
        return product;
    }
}
