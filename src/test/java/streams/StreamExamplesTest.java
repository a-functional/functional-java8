package streams;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class StreamExamplesTest {

    @Test
    void chaining() {
        List<Integer> integers = StreamExamples.INTS.get();

        List<String> actual = integers.stream()
                .filter(n -> n % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .map(String::valueOf)
                .collect(toList());

        assertThat(actual).hasSize(5);
    }

    @Test
    void mapToHashMap1() {
        Map<Integer, String> actual = StreamExamples.HOSTINGS.get()
                .stream()
                .collect(toMap(StreamExamples.Hosting::getId, StreamExamples.Hosting::getName));

        assertThat(actual).hasSize(5);
    }

    @Test
    void mapToHashMap2() {
        Map<String, Long> actual = StreamExamples.HOSTINGS.get()
                .stream()
                .collect(toMap(StreamExamples.Hosting::getName, StreamExamples.Hosting::getWebsites));

        assertThat(actual).hasSize(5);
    }
}