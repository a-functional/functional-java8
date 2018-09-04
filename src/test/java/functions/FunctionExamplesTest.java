package functions;


import static functions.FunctionExamples.addUsingBiFunction;
import static functions.FunctionExamples.addUsingBinary;
import static functions.FunctionExamples.addUsingBinaryOperator;
import static functions.FunctionExamples.addUsingPartial;
import static functions.FunctionExamples.biPrintMessage;
import static functions.FunctionExamples.isEqual;
import static functions.FunctionExamples.isGreaterThan;
import static functions.FunctionExamples.isGreaterThan50;
import static functions.FunctionExamples.isGreaterThan50PartiallyApplied;
import static functions.FunctionExamples.isOdd;
import static functions.FunctionExamples.multiplyUsingBinary;
import static functions.FunctionExamples.printMessage;
import static functions.FunctionExamples.square;
import static functions.FunctionExamples.squareUnaryOperator;
import static functions.FunctionExamples.testNumbers;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;


public class FunctionExamplesTest {

    @Test
    public void add() {
        Integer actual = addUsingPartial.apply(1).apply(2);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void addUsingBinary() {
        Integer actual = addUsingBinary.apply(1, 2);

        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void multiplyUsingBinary() {
        Integer actual = multiplyUsingBinary.apply(2, 2);

        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void isGreaterThan50_filterPredicate() {
        List<Integer> sampleNumbers = testNumbers.get();
        List<Integer> actual = sampleNumbers.stream()
            .filter(isGreaterThan50)
            .collect(toList());

        assertThat(actual).hasSize(1);
        assertThat(actual).contains(56);
    }

    @Test
    public void isGreaterThan50_filterPredicate_withCascadingLambdas() {
        List<Integer> sampleNumbers = testNumbers.get();
        List<Integer> actual = sampleNumbers.stream()
            .filter(isGreaterThan.apply(50))
            .collect(toList());

        assertThat(actual).hasSize(1);
        assertThat(actual).contains(56);
    }

    @Test
    public void isOdd_filterPredicate() {
        List<Integer> sampleNumbers = testNumbers.get();
        List<Integer> actual = sampleNumbers.stream()
            .filter(isOdd)
            .sorted()
            .collect(toList());

        assertThat(actual).hasSize(2);
        assertThat(actual).containsExactly(1, 37);
    }

    @Test
    public void isEqual_filterBiPredicate() {
        List<Integer> sampleNumbers = testNumbers.get();
        List<Integer> actual = sampleNumbers.stream()
            .filter(n -> isEqual.test(n, 10))
            .collect(toList());

        assertThat(actual).hasSize(1);
        assertThat(actual).contains(10);
    }

    @Test
    public void isGreaterThan50PartiallyApplied() {
        assertThat(isGreaterThan50PartiallyApplied.test(50)).isFalse();
        assertThat(isGreaterThan50PartiallyApplied.test(-1)).isFalse();
        assertThat(isGreaterThan50PartiallyApplied.test(51)).isTrue();
        assertThat(isGreaterThan50PartiallyApplied.test(60)).isTrue();
        assertThat(isGreaterThan50PartiallyApplied.test(1001)).isTrue();
        assertThat(isGreaterThan50PartiallyApplied.test(2022)).isTrue();
    }

    @Test
    public void printMessage() {
        printMessage.accept("Just do it.");
    }

    @Test
    public void biPrintMessage() {
        biPrintMessage.accept("The number is", 100);
    }

    @Test
    public void addUsingBiFunction() {
        Integer actual = addUsingBiFunction.apply(100, 200);

        assertThat(actual).isEqualTo(300);
    }

    @Test
    public void addUsingBinaryOperator() {
        Integer actual = addUsingBinaryOperator.apply(100, 200);

        assertThat(actual).isEqualTo(300);
    }

    @Test
    public void squareOperator() {
        Double actual = square.apply(5d);

        assertThat(actual).isEqualTo(25d);
    }

    @Test
    public void squareUnaryOperator() {
        Double actual = squareUnaryOperator.apply(5d);

        assertThat(actual).isEqualTo(25d);
    }
}