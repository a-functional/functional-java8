package optionals;

import java.time.Instant;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class OptionalsExamplesTest {

    @Test
    void test1() {
        Optional<Long> maybe;
        String result;

        Long now = Instant.now().getEpochSecond();
        if (Instant.now().getEpochSecond() % 2 == 0) {
            maybe = Optional.of(now);
        } else {
            maybe = Optional.empty();
        }

        // Bad idea! Don't call .get() on an optional if you are not sure that it exists.
        result = "i exist: " + maybe.get();

        System.out.println(result);
    }

    @Test
    void test2() {
        Optional<Long> maybe;
        String result;

        Long now = Instant.now().getEpochSecond();
        if (Instant.now().getEpochSecond() % 2 == 0) {
            maybe = Optional.of(now);
        } else {
            maybe = Optional.empty();
        }

        // This .get() is safe since it is wrapped in an .isPresent() check...
        // ...but this isn't any better than an old-fashioned null-check.
        if (maybe.isPresent()) {
            result = "i exist: " + maybe.get();
        } else {
            result = "nope";
        }

        System.out.println(result);
    }

    @Test
    void test3() {
        Optional<Long> maybe;
        String result;

        Long now = Instant.now().getEpochSecond();
        if (Instant.now().getEpochSecond() % 2 == 0) {
            maybe = Optional.of(now);
        } else {
            maybe = Optional.empty();
        }

        // Use a streams-style chain instead (usually using .map() and/or .filter()):
        result = maybe
            .map(seconds -> "i exist: " + seconds)
            .orElse("nope");

        System.out.println(result);
    }
}
