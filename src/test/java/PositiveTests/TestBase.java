package PositiveTests;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;

import Pages.BuzzPage;
import Pages.CategoriesPage;
import Pages.CommunitiesPage;
import Pages.LoginPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {


    BuzzPage buzzPage;
    LoginPage loginPage;
    CategoriesPage categoriesPage;
    CommunitiesPage communitiesPage;



    @BeforeMethod
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        loginPage = new LoginPage();
        buzzPage = new BuzzPage();
        categoriesPage = new CategoriesPage();
        communitiesPage = new CommunitiesPage();
      //  baseUrl = "http://192.168.88.89";
        browser = "chrome";
       // Selenide.open(baseUrl);
    }
    @AfterMethod
    public void Close(){
        WebDriverRunner.getWebDriver().quit();
    }
}
