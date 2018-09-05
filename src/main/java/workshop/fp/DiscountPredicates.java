package workshop.fp;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class DiscountPredicates {

    public static final Function<Integer, IntPredicate> LESS_THAN_OR_EQUAL_TO =
        value -> quantity -> quantity <= value;

    public static final Function<Integer, IntPredicate> GREATER_THAN_OR_EQUAL_TO =
        value -> quantity -> quantity >= value;


    public static final BiFunction<Integer, Integer, IntPredicate> BETWEEN = (leftNum, rightNum) ->
        GREATER_THAN_OR_EQUAL_TO.apply(leftNum).and(LESS_THAN_OR_EQUAL_TO.apply(rightNum));
}
