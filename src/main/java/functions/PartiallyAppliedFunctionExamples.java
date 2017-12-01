package functions;

import java.util.function.Function;

public class PartiallyAppliedFunctionExamples {

    /**
     * Partially Applied function
     * Also an example of Currying
     */
    public static final Function<Double, Function<Double, Double>> addTax = x -> y -> y + y / 100 * x;

    public static final Function<Double, Double> addTaxRateOf9 = addTax.apply(9d);
    public static final Function<Double, Double> addTaxRateOf6 = addTax.apply(6d);
}
