package makingjava8functional;

import org.junit.jupiter.api.Test;

class EmailValidationFunctionalTest {

    @Test
    void validate() {
        EmailValidationFunctional.validate("this.is@my.email");
        EmailValidationFunctional.validate(null);
        EmailValidationFunctional.validate("");
        EmailValidationFunctional.validate("john.doe");
    }
}