package Pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {


    By UserName = By.xpath("//input[@name=\"username\"]");
    By PasswordFiled = By.xpath("//input[@name=\"password\"]");
    By LoginButton = By.xpath("//button[@type=\"submit\"]");
    By UserProfileButton = By.xpath("//a/span[2]");
    By ForgotPasswordButton = By.xpath("//span[contains(text(),'Forgot Password?')]");


    public LoginPage open() {
        Selenide.open("http://192.168.88.89");
        return this;
    }

    public LoginPage typeUserName(String username) {
        $(UserName).shouldBe(visible).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        $(PasswordFiled).shouldBe(visible).sendKeys(password);
        return this;
    }

    public LoginPage ClickOnLoginButton() {
        $(LoginButton).shouldBe(visible).click();
        return this;
    }

    public void ProccedToProfile() {
        $(UserProfileButton).shouldBe(visible).click();
    }
    public void ProccedToForgotPasswordScreen(){
        $(ForgotPasswordButton).shouldBe(visible).click();
    }

    public boolean IS_User_LoggedAs_Oct_Admin() {
        try {
            WebElement UserGroup = $(By.xpath("//span[@class='label capitalize']")).shouldHave(text("OCT Admin"));
            return true;
        } catch (AssertionError Error){
            Assert.fail("User role is not OCT Admin");
            return false;
        }
    }


    public boolean IS_User_Logged_As_OCT_Moderator(){
        try {
            WebElement UserGroup = $(By.xpath("//span[@class='label capitalize']")).shouldHave(text("OCT Moderator"));
            return true;
        } catch (AssertionError Error){
            Assert.fail("User role is not OCT Moderator");
            return false;
        }
    }
    public boolean IS_Login_By_Email_Sucsasfull(){
        try {
             $(UserProfileButton).shouldBe(visible);
             $(By.xpath("//h2[contains(text(),'Dashboard')]")).shouldBe(visible);
            return true;
        } catch (AssertionError Error){
            Assert.fail("User was not logged in!");
            return false;
        }
    }
    public boolean IS_ForgotPasswordScreen_Dispalyed(){
        try {
            $(By.xpath("//h2[contains(text(),'Forgot your Password?')]")).shouldBe(visible);
            WebElement ResetButton = $(By.xpath("//button")).shouldBe(visible);
            return true;

        } catch (AssertionError AssertEr){
            Assert.fail("Forgot password Screen is not Displayed!");
            return false;
        }
    }

    public boolean IS_Impossible_to_LogIn_With_Invalid_Phone(){

           try{
               WebElement InvalidPhoneError = $(By.xpath("//body/div[@id='root']/div[1]/div[2]/form[1]/div[1]/div[1]/span[1]/span[2]/span[1]/*[1]")).shouldBe(visible);
               return true;
           } catch (AssertionError AssertError){
               return false;
           }
    }



}
