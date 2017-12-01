package functions;

import java.util.function.*;
import java.util.stream.IntStream;

public class DesignExamples {

    public static int product(int n) {
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= i;
        }
        return product;
    }

    public static int sum(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }

    public static final void example() {
        IntStream intStream = IntStream.range(0, 11);
        int sum = reducer(intStream, (x, y) -> x + y);
        int product = reducer(intStream, (x, y) -> x * y);
        System.out.println(sum);
        System.out.println(product);


        Integer sum1 = reducerFn.apply(intStream, (x, y) -> x + y);
        Integer product1 = reducerFn.apply(intStream, (x, y) -> x * y);
        System.out.println(sum1);
        System.out.println(product1);

        Integer sum2 = reducerFn.apply(intStream, sumOperator);
        Integer product2 = reducerFn.apply(intStream, productOperator);
        System.out.println(sum2);
        System.out.println(product2);
    }

    /**
    This is how you would think imperatively...but his method cannot be assigned like a type......
     */
    public static int reducer(IntStream intRange, IntBinaryOperator action) {
        return intRange.reduce(action).getAsInt();
    }

    /**
     * This is how you would think functionally...reducerFn now is a type
     * Which mean i can use functions as data that can be passed around
     */
    public static BiFunction<IntStream, IntBinaryOperator, Integer> reducerFn = (intStream, action) -> intStream.reduce(action).getAsInt();

    public static IntBinaryOperator sumOperator = (x, y) -> x + y;
    public static IntBinaryOperator productOperator = (x, y) -> x * y;

}
