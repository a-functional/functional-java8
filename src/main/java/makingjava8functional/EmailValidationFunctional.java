package makingjava8functional;


import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidationFunctional {

    static Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");


    public static void main(String... args) {
        validate("this.is@my.email");
        validate(null);
        validate("");
        validate("john.doe@acme.com");
    }

    static Function<String, Result> emailChecker = s -> {
        if (s == null) {
            return new Result.Failure("email must not be null");
        } else if (s.length() == 0) {
            return new Result.Failure("email must not be empty");
        } else if (emailPattern.matcher(s).matches()) {
            return new Result.Success();
        } else {
            return new Result.Failure("email " + s + " is invalid.");
        }
    };

    private static void logError(String s) {
        System.err.println("Error message logged: " + s);
    }

    private static void sendVerificationMail(String s) {
        System.out.println("Mail sent to " + s);
    }

    static void validate(String s) {
        Result result = emailChecker.apply(s);
        if (result instanceof Result.Success) {
            sendVerificationMail(s);
        } else {
            logError(((Result.Failure) result).getMessage());
        }
    }

}