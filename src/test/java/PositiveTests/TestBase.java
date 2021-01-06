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
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {


    BuzzPage buzzPage;
    LoginPage loginPage;
    CategoriesPage categoriesPage;
    CommunitiesPage communitiesPage;



    @Before
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
}
