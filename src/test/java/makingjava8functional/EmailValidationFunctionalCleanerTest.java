package makingjava8functional;

import org.junit.Test;

import static makingjava8functional.EmailValidationFunctionalCleaner.failure;
import static makingjava8functional.EmailValidationFunctionalCleaner.success;

public class EmailValidationFunctionalCleanerTest {

    @Test
    public void shouldCheckEmails_inA_cleanerWay() throws Exception {
        EmailValidationFunctionalCleaner.emailChecker.apply("this.is@my.email").bind(success, failure);
        EmailValidationFunctionalCleaner.emailChecker.apply(null).bind(success, failure);
        EmailValidationFunctionalCleaner.emailChecker.apply("").bind(success, failure);
        EmailValidationFunctionalCleaner.emailChecker.apply("john.doe@acme.com").bind(success, failure);
    }
}