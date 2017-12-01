package functions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryingExample {
    public static BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;

    public static Function<Integer, Function<Integer, Integer>> currier = a -> b -> adder.apply(a, b);
    public static Function<Integer, Function<Integer, Integer>> currier2 = a -> b -> a + b;

    //Returns a function f(b) = 4 + a
    public static Function<Integer, Integer> add4 = currier.apply(4);
    //Returns a function f(b) = 4 + a
    public static Function<Integer, Integer> add4_x = currier2.apply(4);
    public static Function<Integer, Integer> add9 = currier.apply(9);
}
