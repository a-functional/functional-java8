package workshop.fp;

import static workshop.fp.Discount.DISCOUNTS;

import java.util.OptionalDouble;

/**
 * Given Item Price to be 100
 * And Given quantity as number
 * Then calculate total price by applying discount as per the following rules:
 * Quantity       Discount
 * 0-9               0
 * 10-19             10
 * 20-49             20
 * 50-99             30
 * 100 or more       40
 */
public class DiscountCalculatorFP {

    private static final int ITEM_PRICE = 100;

    public double calculateDiscountedPrice(final int quantity) {
        OptionalDouble result = DISCOUNTS.stream()
            .filter(discount -> discount.getRule().test(quantity))
            .mapToDouble(discount -> calculateDiscountedPrice(quantity, discount))
            .findFirst();
        return result.getAsDouble();
    }

    private static double calculateDiscountedPrice(int quantity, Discount discount) {
        double totalCost = totalPrice(quantity);
        double discountAmount = calculateDiscountAmount(discount.getDiscount(), totalCost);
        return totalCost - discountAmount;
    }


    private static double calculateDiscountAmount(double discount, double totalCost) {
        return (discount * totalCost) / 100.0;
    }

    private static double totalPrice(int quantity) {
        return quantity * ITEM_PRICE;
    }
}
