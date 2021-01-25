package NegativeTests;

import Pages.*;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Configuration.browser;

public class TestBaseNegative {

    BuzzPage buzzPage;
    LoginPage loginPage;
    CategoriesPage categoriesPage;
    CommunitiesPage communitiesPage;
    SurveysPage surveysPage;



    @BeforeMethod
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        loginPage = new LoginPage();
        buzzPage = new BuzzPage();
        categoriesPage = new CategoriesPage();
        communitiesPage = new CommunitiesPage();
        surveysPage = new SurveysPage();
        //  baseUrl = "http://192.168.88.89";
        browser = "chrome";
        // Selenide.open(baseUrl);
    }
    @AfterMethod
    public void Close(){
        WebDriverRunner.getWebDriver().quit();
    }
}

