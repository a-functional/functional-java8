package makingjava8functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidationFunctionalCleaner {
    static Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    public static Function<String, ResultCleaner<String>> emailChecker = s -> {
        if (s == null) {
            return ResultCleaner.failure("email must not be null");
        } else if (s.length() == 0) {
            return ResultCleaner.failure("email must not be empty");
        } else if (emailPattern.matcher(s).matches()) {
            return ResultCleaner.success(s);
        } else {
            return ResultCleaner.failure("email " + s + " is invalid.");
        }
    };

    public static void main(String... args) {
        emailChecker.apply("this.is@my.email").bind(success, failure);
        emailChecker.apply(null).bind(success, failure);
        emailChecker.apply("").bind(success, failure);
        emailChecker.apply("john.doe@acme.com").bind(success, failure);
    }

    public static Consumer<String> success = s ->
            System.out.println("Mail sent to " + s);

    public static Consumer<String> failure = s ->
            System.err.println("Error message logged: " + s);

}
