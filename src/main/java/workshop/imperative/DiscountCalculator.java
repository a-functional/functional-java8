package workshop.imperative;


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
public class DiscountCalculator {

    private static final int ITEM_PRICE = 100;

    public double calculate(int quantity) {
        int discount = figureDiscount(quantity);
        double totalCost = totalPrice(quantity);
        double discountAmount = calculateDiscountAmount(discount, totalCost);
        return totalCost - discountAmount;
    }

    private int figureDiscount(int quantity) {
        if (quantity >= 0 && quantity <= 9) {
            return 0;
        }
        if (quantity >= 10 && quantity <= 19) {
            return 10;
        }
        if (quantity >= 20 && quantity <= 49) {
            return 20;
        }
        if (quantity >= 50 && quantity <= 99) {
            return 30;
        }
        if (quantity >= 100) {
            return 40;
        }
        return 0;
    }

    private double calculateDiscountAmount(double discount, double total_cost) {
        return (discount * total_cost) / 100.0;
    }

    private double totalPrice(int quantity) {
        return quantity * ITEM_PRICE;
    }

}
