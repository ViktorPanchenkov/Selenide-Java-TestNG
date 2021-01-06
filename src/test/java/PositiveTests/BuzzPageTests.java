package PositiveTests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuzzPageTests extends TestBase {



    @BeforeMethod
    public void BeforeAction(){
        String Phone = "+11111111111";
        String Password = "qwerty";
        loginPage.open().
                typeUserName(Phone).
                typePassword(Password).
                ClickOnLoginButton();
        buzzPage.GotoBuzzTab();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test(priority = 2)
    public void FindBuzz(){
        String NameOfBuzz = "QA";
      buzzPage.
              SearchBuzz(NameOfBuzz);
        Assert.assertTrue(buzzPage.Is_Buzz_WasFound(NameOfBuzz));
    }
    @Test(priority = 1)
    public void AddBuzz(){
        int Random = (int) (Math.random() * 10);
        String Title = "Buzz created by automation test" + Random;
        String Description = "Description of Buzz";
        String URL = "http://google.com";
        buzzPage.ClcikOnTheAddBuzzButton().
                EnterTitle(Title).
                EnterDescription(Description).
                EnterURL(URL).
                AddCoverImage().
                ClcikOnSaveButton();
        Assert.assertTrue(buzzPage.IS_BuzzCreated(Title,Description));
    }
    @Test(priority = 3)
    public void EditBuzz(){
        int Random = (int) (Math.random() * 10);
        String NewBuzzTitle = "Updated by Selenium";
        String NewDescription = "Description By Selenium";
        buzzPage.GoToRandomBuzz().
                GotoEditBuzzScreen().
                EnterTitle(NewBuzzTitle).
                EnterDescription(NewDescription).
                ClcikOnSaveButton();
        Assert.assertTrue(buzzPage.IS_Buzz_Was_Updated(NewBuzzTitle));
    }
    @Test(priority = 4)
    public void DeleteBuzz(){
        String NameOfBuzz = "Updated by Selenium";
        buzzPage.SearchBuzz(NameOfBuzz).
                ClickOnDeleteBuzzButton();
        Assert.assertTrue(buzzPage.IS_Buzz_Was_Removed());
    }

}
