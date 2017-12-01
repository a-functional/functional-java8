package functions;


import org.junit.Test;

import java.util.List;

import static functions.FunctionExamples.*;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;


public class FunctionExamplesTest {

    @Test
    public void add() throws Exception {
        Integer actual = addUsingPartial.apply(1).apply(2);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void addUsingBinary() throws Exception {
        Integer actual = addUsingBinary.apply(1, 2);

        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void multiplyUsingBinary() throws Exception {
        Integer actual = multiplyUsingBinary.apply(2, 2);

        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void isGreaterThan50_filterPredicate() throws Exception {
        List<Integer> sampleNumbers = testNumbers.get();
        List<Integer> actual = sampleNumbers.stream()
                .filter(isGreaterThan50)
                .collect(toList());

        assertThat(actual).hasSize(1);
        assertThat(actual).contains(56);
    }

    @Test
    public void isGreaterThan50_filterPredicate_withCascadingLambdas() throws Exception {
        List<Integer> sampleNumbers = testNumbers.get();
        List<Integer> actual = sampleNumbers.stream()
                .filter(isGreaterThan.apply(50))
                .collect(toList());

        assertThat(actual).hasSize(1);
        assertThat(actual).contains(56);
    }

    @Test
    public void isOdd_filterPredicate() throws Exception {
        List<Integer> sampleNumbers = testNumbers.get();
        List<Integer> actual = sampleNumbers.stream()
                .filter(isOdd)
                .collect(toList());

        assertThat(actual).hasSize(2);
        assertThat(actual).contains(1, 37);
    }

    @Test
    public void isEqual_filterBiPredicate() throws Exception {
        List<Integer> sampleNumbers = testNumbers.get();
        List<Integer> actual = sampleNumbers.stream()
                .filter(n -> isEqual.test(n, 10))
                .collect(toList());

        assertThat(actual).hasSize(1);
        assertThat(actual).contains(10);
    }

    @Test
    public void printMessage() throws Exception {
        printMessage.accept("Just do it.");
    }

    @Test
    public void biPrintMessage() throws Exception {
        biPrintMessage.accept("The number is", 100);
    }

    @Test
    public void addUsingBiFunction() throws Exception {
        Integer actual = addUsingBiFunction.apply(100, 200);

        assertThat(actual).isEqualTo(300);
    }

    @Test
    public void addUsingBinaryOperator() throws Exception {
        Integer actual = addUsingBinaryOperator.apply(100, 200);

        assertThat(actual).isEqualTo(300);
    }

    @Test
    public void squareOperator() throws Exception {
        Double actual = square.apply(5d);

        assertThat(actual).isEqualTo(25d);
    }

    @Test
    public void squareUnaryOperator() throws Exception {
        Double actual = squareUnaryOperator.apply(5d);

        assertThat(actual).isEqualTo(25d);
    }
}