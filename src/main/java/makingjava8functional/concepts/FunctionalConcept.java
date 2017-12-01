package makingjava8functional.concepts;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FunctionalConcept {

    public static final BinaryOperator<Integer> sum = (x, y) -> x + y;

    /**
     * (define (square x) (* x x))
     */
    public static final Function<Integer, Integer> square = x -> x * x;

    /**
     (define (sum-of-squares x y)
        (+ (square x) (square y)))
     */
    public static final BinaryOperator<Integer> squareAndSum = (x, y) -> square.apply(x) + square.apply(y);

}
