package makingjava8functional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class EmailValidationImperativeTest {

    private EmailValidationImperative emailValidationImperative;

    @BeforeEach
    void setUp() {
        emailValidationImperative = new EmailValidationImperative();
    }

    @Test
    @Disabled
    public void testMail() {
        emailValidationImperative.testMail("");
        emailValidationImperative.testMail(null);
        emailValidationImperative.testMail("a@z.com");
    }
}