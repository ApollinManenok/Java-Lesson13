package by.itacademy.lesson13.builders;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductBuilder<T> {
    private static final Logger LOGGER = Logger.getLogger(ProductBuilder.class.getName());
    private Random random = new Random();
    private Class<T> clazz;
    private int costBound;

    public ProductBuilder(Class<T> clazz) {
        this.clazz = clazz;
    }

    public ProductBuilder(Class<T> clazz, int costBound) {
        this.clazz = clazz;
        this.costBound = costBound;
    }

    public T build() throws ProductInstantiationException {
        T product;
        try {
            product = clazz.newInstance();
            if (costBound != 0)
                clazz.getSuperclass().getMethod("setCost", int.class).invoke(product, random.nextInt(costBound));
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            throw new ProductInstantiationException("Can't create product");
        }
        return product;
    }
}
