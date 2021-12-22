package streams;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StreamWorkshopTest {

    /**
     * Create a pipeline of operations:
     * 1. first filter high-calorie dishes. (Any dish greater than 300 calories)
     * 2. Get the names of the dishes.
     * 3. Sort the names of the dishes
     * 4. Select only the first three.
     */
    @Test
    @Disabled
    public void filterMapSortAndLimitDishes_as_per_requirements_above() throws Exception {
        List<Dish> dishes = DishHelper.menu.get();

        //TODO: Satisfy above requirements
        List<String> actual = Arrays.asList();


        assertThat(actual).hasSize(3);
        assertThat(actual).containsExactly("beef", "chicken", "french fries");

    }
}
