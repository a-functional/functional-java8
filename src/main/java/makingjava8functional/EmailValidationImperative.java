package makingjava8functional;


import java.util.regex.Pattern;

public class EmailValidationImperative {
    final Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    void testMail(String email) {
        if (emailPattern.matcher(email).matches()) {
            sendVerificationMail(email);
        } else {
            logError("email " + email + " is invalid.");
        }
    }

    void sendVerificationMail(String s) {
        System.out.println("Verification mail sent to " + s);
    }

    private static void logError(String s) {
        System.out.print("Logging the error message : " + s);
    }
}