package PositiveTests;

import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginPageTests extends TestBase {



    @Test
    public void LoginAsOCTAdmin(){
        String Phone = "+11111111111";
        String Password = "qwerty";
    loginPage.open().
            typeUserName(Phone).
            typePassword(Password).
            ClickOnLoginButton().
            ProccedToProfile();
        Assert.assertTrue(loginPage.IS_User_LoggedAs_Oct_Admin());
    }
    @Test
    public void LoginAsOctModerator(){
        String Phone = "+11111111112";
        String Password = "qwerty";
        loginPage.open().
                typeUserName(Phone).
                typePassword(Password).
                ClickOnLoginButton().
                ProccedToProfile();
        Assert.assertTrue(loginPage.IS_User_Logged_As_OCT_Moderator());
    }
    @Test
    public void LoginByEmail(){
        String Email = "octadmin@crowdthinc.com";
        String Password = "qwerty";
        loginPage.open().
                typeUserName(Email).
                typePassword(Password).
                ClickOnLoginButton();
         Assert.assertTrue(loginPage.IS_Login_By_Email_Sucsasfull());
    }
    @Test
    public void GotoForgotPasswordScreen(){
        loginPage.open().
                ProccedToForgotPasswordScreen();
        Assert.assertTrue(loginPage.IS_ForgotPasswordScreen_Dispalyed());
    }


}
