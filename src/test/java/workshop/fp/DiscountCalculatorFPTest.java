package workshop.fp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountCalculatorFPTest {

    private DiscountCalculatorFP calculator;

    @BeforeEach
    void setUp() {
        calculator = new DiscountCalculatorFP();
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_0() {
        double actualPrice = calculator.calculateDiscountedPrice(5);

        assertThat(actualPrice).isEqualTo(500);
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_10() {
        double actualPrice = calculator.calculateDiscountedPrice(10);

        assertThat(actualPrice).isEqualTo(900);
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_20() {
        double actualPrice = calculator.calculateDiscountedPrice(20);

        assertThat(actualPrice).isEqualTo(1600);
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_30() {
        double actualPrice = calculator.calculateDiscountedPrice(50);

        assertThat(actualPrice).isEqualTo(3500);
    }

    @Test
    void given_quantity_calculates_costPrice_with_discount_40() {
        double actualPrice = calculator.calculateDiscountedPrice(100);

        assertThat(actualPrice).isEqualTo(6000);
    }
}