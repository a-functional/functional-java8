package makingjava8functional;

/**
 * Handles results of a computation
 */
public interface Result {

    class Success implements Result {
    }

    class Failure implements Result {
        private final String errorMessage;

        public Failure(String s) {
            this.errorMessage = s;
        }

        public String getMessage() {
            return errorMessage;
        }
    }

}
