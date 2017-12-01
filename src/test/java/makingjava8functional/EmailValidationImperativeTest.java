package makingjava8functional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EmailValidationImperativeTest {

    private EmailValidationImperative emailValidationImperative;

    @Before
    public void setUp() throws Exception {
        emailValidationImperative = new EmailValidationImperative();
    }

    @Test
    @Ignore
    public void testMail() throws Exception {
        emailValidationImperative.testMail("");
        emailValidationImperative.testMail(null);
        emailValidationImperative.testMail("a@z.com");
    }
}