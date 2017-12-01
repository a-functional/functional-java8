package streams;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamExamplesTest {

    @Test
    public void chaining() throws Exception {
        List<Integer> integers = StreamExamples.INTS.get();

        List<String> actual = integers.stream()
                .filter(n -> n % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .map(n -> String.valueOf(n))
                .collect(toList());

        assertThat(actual).hasSize(5);
    }

    @Test
    public void mapToHashMap1() throws Exception {
        Map<Integer, String> actual = StreamExamples.HOSTINGS.get()
                .stream()
                .collect(toMap(StreamExamples.Hosting::getId, StreamExamples.Hosting::getName));

        assertThat(actual).hasSize(5);
    }

    @Test
    public void mapToHashMap2() throws Exception {
        Map<String, Long> actual = StreamExamples.HOSTINGS.get()
                .stream()
                .collect(toMap(StreamExamples.Hosting::getName, StreamExamples.Hosting::getWebsites));

        assertThat(actual).hasSize(5);
    }
}