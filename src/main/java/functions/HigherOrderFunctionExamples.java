package functions;


import java.util.function.Function;

public class HigherOrderFunctionExamples {

    public  static final Function<Integer, Integer> triple = x -> x * 3;
    public  static final Function<Integer, Integer> square = x -> x * x;

    /**
     * Compose works from Right to Left
     */
    public  static final Function<Integer, Integer> composeTripleAndSquare = square.compose(triple);
    public  static final Function<Integer, Integer> composeSquareAndTriple = triple.compose(square);
    /**
     * andThen
     */
    public  static final Function<Integer, Integer> squareAndThenTriple = square.andThen(triple);

    /**
     * Java 8 also brings method references, which is a syntax that can
     be used to replace a lambda when the lambda implementation consists of a method
     call with a single argument.
     */
    public  static final Function<Integer, Integer> composeSquareAndTripleAndNegateExact = triple.compose(square).compose(Math::negateExact);

    /** Composing functions with differing types
     * The output of the first function matches the input of the second function
     * */
    public  static final Function<Double, Integer> f = a -> (int) (a * 3);
    public  static final Function<Long, Double> g = a -> a + 2.0;
    public  static final Function<Long, Integer> composeWithDifferentTypes = f.compose(g);

}
