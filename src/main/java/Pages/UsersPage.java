package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.forward;

public class UsersPage {

    By UsersTab = By.xpath("//span[contains(text(),'Users')]");
    By SearchFiled = By.xpath("//input[@placeholder='Search...']");
    By BanUserButton = By.xpath("//span[contains(text(),'Ban User')]");
    By UnbunUserButton = By.xpath("//span[contains(text(),'Unban User')]");
    By NotifyEvereoneButton = By.xpath("//span[contains(text(),'Notify everyone')]");
    By ImputForGlobalNotification = By.xpath("//textarea[@name='message']");
    By CreateNotificationButton = By.xpath("//span[contains(text(),'Create Notification')]");
    By UserCommunitiesTab = By.xpath("//div[@class='category-header-cmp-tabs f-c-s']/h3[2]");
    By UserSurveysTab = By.xpath("//div[@class='category-header-cmp-tabs f-c-s']/h3[3]");


    public UsersPage GotoUsersTab(){
      $(UsersTab).click();
      return this;
    }
    public UsersPage SearchUser(String UserName){
        $(SearchFiled).sendKeys(UserName);
        try {
            WebElement FoundUser = $(By.xpath("//span[contains(text(),'" + UserName + "')]"));
            FoundUser.click();
        }catch (AssertionError AssertError){
            Assert.fail("There is no any user with such name!");
        }
        return this;
    }
    public UsersPage GotoRandomUserProfile(int numberOfUser){
        WebElement UserProfile = $(By.xpath("//tbody/tr[1]/td[2]")).shouldBe(Condition.visible);
        List<WebElement> ListOfUsers = new ArrayList();
        for(int i =0; i < 10; i++){
           ListOfUsers.add($(By.xpath("//tbody/tr["+ i+ "]/td[2]")));
        }
        ListOfUsers.get(numberOfUser).click();
        return this;
    }
     public UsersPage GotoUserCommunitiesTab(){
        $(UserCommunitiesTab).click();
        return this;
     }

}
