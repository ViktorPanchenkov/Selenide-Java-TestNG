package NegativeTests;

import PositiveTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageNegativeTests extends TestBaseNegative {


    @Test
    public void LoginWithInvalidPhone(){
        String invalidPhone = "+1111111111";
        String password = "qwerty";
        loginPage.open().
                typeUserName(invalidPhone).
                typePassword(password).
                ClickOnLoginButton();
        Assert.assertFalse(loginPage.IS_Impossible_to_LogIn_With_Invalid_Phone());
    }
}
