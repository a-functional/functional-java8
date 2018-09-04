package functions;


import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * The following are examples of Java lambda expressions:
 * n -> n % 2 != 0;
 * (char c) -> c == 'y';
 * (x, y) -> x + y;
 * (int a, int b) -> a * a + b * b;
 * () -> 42
 * () -> { return 3.14 };
 * (String s) -> { System.out.println(s); };
 * () -> { System.out.println("Hello World!"); };
 */
public class FunctionExamples {

    /**
     * Partial Functions
     * When you see two right-arrows, treat everything to the right of the first arrow as a black box:
     * a lambda expression returned by the outer lambda expression.
     */
    public static final Function<Integer, Function<Integer, Integer>> addUsingPartial = x -> y -> y + x;

    /**
     * Add using BiFunctions. Generally used when the input types and result types are not the same
     */
    public static final BiFunction<Integer, Integer, Integer> addUsingBiFunction = (x, y) -> x + y;

    /**
     * Add using BinaryOperator...If the two input types and return type is the same
     */
    public static final BinaryOperator<Integer> addUsingBinaryOperator = (x, y) -> x + y;

    /**
     * Example of compose
     */
    public static final Function<Double, Double> square = x -> x * x;
    /** If input and out put types are same then u can use the UnaryOperator it is
     * equivalent to the above Function */
    public static final UnaryOperator<Double> squareUnaryOperator = x -> x * x;

    public static final Function<Double, Double> squareAndAbs = square.compose(Math::abs);
    //Why can't we do this???? Can u explain
//    public static final BinaryOperator<Integer> addAndMultiply = (x, y) -> addUsingBinary.andThen(multiplyUsingBinary);

    public static final BinaryOperator<Integer> addUsingBinary = (x, y) -> x + y;

    public static final BinaryOperator<Integer> multiplyUsingBinary = (x, y) -> x * y;

    /**
     * The word predicate is used for procedures that return true or false
     */
    public static final Predicate<Integer> isGreaterThan50 = n -> n > 50;
    public static final Predicate<Integer> isOdd = n -> n % 2 != 0;
    /** Partial Predicate with cascading lambda's (Partially Applied Functions)*/
    public static final Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> candidate -> candidate > pivot;
    public static final Predicate<Integer> isGreaterThan50PartiallyApplied = isGreaterThan.apply(50);

    public static final Supplier<List<Integer>> testNumbers = () -> Arrays.asList(37, 10, 1, 56, 40);
    public static final Consumer<String> printMessage = s -> System.out.println(s);
    public static final BiConsumer<String, Integer> biPrintMessage = (s, n) -> System.out.println(s + " : " + n);

    public static final BiPredicate<Integer, Integer> isEqual = (n1, n2) -> n1.equals(n2);
}
