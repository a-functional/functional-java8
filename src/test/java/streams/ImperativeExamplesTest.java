package streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ImperativeExamplesTest {

    @Test
    public void filterByHighCalorie() throws Exception {
        List<Dish> dishes = DishHelper.menu.get();

        List<String> highCaloricDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() > 300) {
                highCaloricDishes.add(dish.getName());
            }
        }

        assertThat(highCaloricDishes).hasSize(7);
        assertThat(highCaloricDishes).containsExactlyInAnyOrder("sandwich", "beef", "chicken", "french fries", "rice", "pizza", "salmon");
    }

    @Test
    public void mapToDishNames() throws Exception {
        List<Dish> dishes = DishHelper.menu.get();

        List<String> dishNames = new ArrayList<>();
        for (Dish dish : dishes) {
            dishNames.add(dish.getName());
        }

        assertThat(dishNames).hasSize(9);
        assertThat(dishNames).containsExactlyInAnyOrder("sandwich", "beef", "chicken", "french fries", "rice", "season fruit", "pizza", "prawns", "salmon");
    }
}