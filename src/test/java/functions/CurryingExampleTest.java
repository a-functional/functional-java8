package functions;

import org.junit.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;

public class CurryingExampleTest {

    @Test
    public void add4_curried_function() throws Exception {
        //Just for representation purposes
        Function<Integer, Integer> add4 = CurryingExample.add4;
        Integer actual = add4.apply(4);

        assertThat(actual).isEqualTo(8);
    }

    @Test
    public void add9_curried_function() throws Exception {
        Function<Integer, Integer> add9 = CurryingExample.add9;
        Integer actual = add9.apply(9);

        assertThat(actual).isEqualTo(18);
    }
}