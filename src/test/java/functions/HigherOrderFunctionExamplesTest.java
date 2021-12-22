package functions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HigherOrderFunctionExamplesTest {

    @Test
    void tripleAndThenSquareCompose() throws Exception {
        Integer actual = HigherOrderFunctionExamples.composeTripleAndSquare.apply(2);

        assertThat(actual).isEqualTo(36);
    }

    @Test
    void squareAndTripleCompose() throws Exception {
        Integer actual = HigherOrderFunctionExamples.composeSquareAndTriple.apply(2);

        assertThat(actual).isEqualTo(12);
    }

    @Test
    void squareAndThenTriple() throws Exception {
        Integer actual = HigherOrderFunctionExamples.squareAndThenTriple.apply(2);
        //(2x2)x3

        assertThat(actual).isEqualTo(12);
    }

    @Test
    void composeWithDifferentTypes() throws Exception {
        Integer actual = HigherOrderFunctionExamples.composeWithDifferentTypes.apply(2l);

        assertThat(actual).isEqualTo(12);
    }

    @Test
    void composeSquareAndTripleAndNegateExact() throws Exception {
        Integer actual = HigherOrderFunctionExamples.composeSquareAndTripleAndNegateExact.apply(3);

        assertThat(actual).isEqualTo(27);
    }

}