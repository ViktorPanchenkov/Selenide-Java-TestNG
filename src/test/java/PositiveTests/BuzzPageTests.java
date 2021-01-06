package PositiveTests;

import Pages.BuzzPage;
import Pages.LoginPage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuzzPageTests extends TestBase {



    @Before
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

    @Test
    public void FindBuzz(){
        String NameOfBuzz = "QA";
      buzzPage.GotoBuzzTab().
              SearchBuzz(NameOfBuzz);
        Assert.assertTrue(buzzPage.Is_Buzz_WasFound(NameOfBuzz));
    }
    @Test
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
    @Test
    public void EditBuzz(){
        int Random = (int) (Math.random() * 10);
        String NewBuzzTitle = "Updated by Selenium" + Random;
        String NewDescription = "Description By Selenium";
        buzzPage.GoToRandomBuzz().
                GotoEditBuzzScreen().
                EnterTitle(NewBuzzTitle).
                EnterDescription(NewDescription).
                ClcikOnSaveButton();
        Assert.assertTrue(buzzPage.IS_Buzz_Was_Updated(NewBuzzTitle));
    }
    @Test
    public void DeleteBuzz(){
        buzzPage.GoToRandomBuzz().
                ClickOnDeleteBuzzButton();
        Assert.assertTrue(buzzPage.IS_Buzz_Was_Removed());
    }
    @Test
    public void  JustTest(){

    }
}
