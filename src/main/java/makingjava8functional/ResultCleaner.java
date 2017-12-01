package makingjava8functional;

import java.util.function.Consumer;

/**
 * Handles results of a computation along with binding of the Effect (Consumer)
 */
public interface ResultCleaner<T> {
    void bind(Consumer<T> success, Consumer<String> failure);

    static <T> ResultCleaner<T> failure(String message) {
        return new Failure<>(message);
    }

    static <T> ResultCleaner<T> success(T value) {
        return new Success<>(value);
    }

    class Success<T> implements ResultCleaner<T> {
        private final T value;

        private Success(T t) {
            value = t;
        }

        @Override
        public void bind(Consumer<T> success, Consumer<String> failure) {
            success.accept(value);
        }
    }

    class Failure<T> implements ResultCleaner<T> {
        private final String errorMessage;

        private Failure(String s) {
            this.errorMessage = s;
        }

        @Override
        public void bind(Consumer<T> success, Consumer<String> failure) {
            failure.accept(errorMessage);
        }
    }
}
