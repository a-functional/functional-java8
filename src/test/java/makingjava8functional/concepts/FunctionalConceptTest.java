package makingjava8functional.concepts;

import org.junit.Test;

import static makingjava8functional.concepts.FunctionalConcept.square;
import static makingjava8functional.concepts.FunctionalConcept.squareAndSum;
import static makingjava8functional.concepts.FunctionalConcept.sum;
import static org.assertj.core.api.Assertions.*;

public class FunctionalConceptTest {

    @Test
    public void sum() throws Exception {
        assertThat(sum.apply(2, 2)).isEqualTo(4);
        assertThat(sum.apply(3,7)).isEqualTo(10);
        assertThat(sum.apply(5,10)).isEqualTo(15);
        assertThat(sum.apply(1,4)).isEqualTo(5);
    }

    @Test
    public void square() throws Exception {
        assertThat(square.apply(2)).isEqualTo(4);
        assertThat(square.apply(10)).isEqualTo(100);
        assertThat(square.apply(5)).isEqualTo(25);
        assertThat(square.apply(3)).isEqualTo(9);
    }

    @Test
    public void squareAndSum() throws Exception {
        assertThat(squareAndSum.apply(1,1)).isEqualTo(2);
        assertThat(squareAndSum.apply(2,2)).isEqualTo(8);
        assertThat(squareAndSum.apply(3,3)).isEqualTo(18);
        assertThat(squareAndSum.apply(4,4)).isEqualTo(32);
        assertThat(squareAndSum.apply(5,5)).isEqualTo(50);
    }
}