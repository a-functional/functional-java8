package makingjava8functional;

import org.junit.Test;

public class EmailValidationFunctionalTest {

    @Test
    public void validate() throws Exception {
        EmailValidationFunctional.validate("this.is@my.email");
        EmailValidationFunctional.validate(null);
        EmailValidationFunctional.validate("");
        EmailValidationFunctional.validate("john.doe");
    }
}