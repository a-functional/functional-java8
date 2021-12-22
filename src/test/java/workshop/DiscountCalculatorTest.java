package workshop;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workshop.imperative.DiscountCalculator;

class DiscountCalculatorTest {

    private DiscountCalculator discountCalculator;

    @BeforeEach
    void setUp() {
        discountCalculator = new DiscountCalculator();
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_0() {
        double actualPrice = discountCalculator.calculate(5);

        assertThat(actualPrice).isEqualTo(500);
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_10() {
        double actualPrice = discountCalculator.calculate(10);

        assertThat(actualPrice).isEqualTo(900);
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_20() {
        double actualPrice = discountCalculator.calculate(20);

        assertThat(actualPrice).isEqualTo(1600);
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_30() {
        double actualPrice = discountCalculator.calculate(50);

        assertThat(actualPrice).isEqualTo(3500);
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_40() {
        double actualPrice = discountCalculator.calculate(100);

        assertThat(actualPrice).isEqualTo(6000);
    }
}