package workshop.fp;

import static workshop.fp.DiscountPredicates.BETWEEN;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.function.IntPredicate;

public class Discount {

    public static final Discount ZERO_DISCOUNT =
        new Discount(0, BETWEEN.apply(0, 9));

    public static final Discount TEN_DISCOUNT =
        new Discount(10, BETWEEN.apply(10, 19));

    public static final Discount TWENTY_DISCOUNT =
        new Discount(20, BETWEEN.apply(20, 49));

    public static final Discount THIRTY_DISCOUNT =
        new Discount(30, BETWEEN.apply(50, 99));

    public static final Discount FORTY_DISCOUNT =
        new Discount(40, DiscountPredicates.GREATER_THAN_OR_EQUAL_TO.apply(100));

    public static final List<Discount> DISCOUNTS = Lists.newArrayList(
        ZERO_DISCOUNT,
        TEN_DISCOUNT,
        TWENTY_DISCOUNT,
        THIRTY_DISCOUNT,
        FORTY_DISCOUNT

    );

    private int discount;
    private IntPredicate rule;

    public Discount(int discount, IntPredicate rule) {
        this.discount = discount;
        this.rule = rule;
    }

    public int getDiscount() {
        return discount;
    }

    public IntPredicate getRule() {
        return rule;
    }
}
