package functions;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PartiallyAppliedFunctionExamplesTest {

    @Test
    void addTax_calculatesTaxes_given_rate_and_price() throws Exception {
        Double actualPrice = PartiallyAppliedFunctionExamples.addTax.apply(9d).apply(100d);

        assertThat(actualPrice).isEqualTo(109d);
    }

    @Test
    void addTaxRateOf9_calculatesTaxes_given_price_applyingTaxRateOf9() throws Exception {
        Double actualPrice = PartiallyAppliedFunctionExamples.addTaxRateOf9.apply(100d);

        assertThat(actualPrice).isEqualTo(109d);
    }

    @Test
    void addTaxRateOf6_calculatesTaxes_given_price_applyingTaxRateOf6() throws Exception {
        Double actualPrice = PartiallyAppliedFunctionExamples.addTaxRateOf6.apply(100d);

        assertThat(actualPrice).isEqualTo(106d);
    }
}