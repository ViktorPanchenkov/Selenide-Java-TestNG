package Pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.As;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class BuzzPage extends BasePage {


    By BuzzTab = By.xpath("//span[contains(text(),'The Buzz')]");
    By Search = By.xpath("//input[@placeholder='Search...']");
    By AddBuzzButton = By.xpath("//*[@id=\"root\"]/section/section/main/div/div[2]/button");
    By Title = By.xpath("//input[@name='title']");
    By Description = By.xpath("//textarea[@name='description']");
    By CoverImageButton = By.xpath("//div[contains(@class,'cropper-cmp')]//input");
    By SaveButton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button");
    By DeleteBuzzButton = By.xpath("//span[contains(text(),'Delete The Buzz')]");
    By EditBuzzButton = By.xpath("//span[contains(text(),'Edit The Buzz')]");
    By URlFiled = By.xpath("//input[@name='webURL']");



    public BuzzPage GotoBuzzTab(){
        $(BuzzTab).shouldBe(Condition.visible).click();
        return new BuzzPage();
    }
    public BuzzPage SearchBuzz(String NameOfBuzz){
        $(Search).shouldBe(Condition.visible).sendKeys(NameOfBuzz);
        try {
            WebElement FoundBuzz = $(By.xpath("//span[contains(text(),'" +NameOfBuzz+ "')]")).shouldBe(Condition.visible);
            FoundBuzz.click();
        } catch (AssertionError AssertEror){
            Assert.fail("There is no Buzz with Such name");
        }
        return this;
    }
    public BuzzPage ClcikOnTheAddBuzzButton(){
       $(AddBuzzButton).shouldHave(Condition.visible).click();
        return this;
    }
    public BuzzPage EnterTitle(String BuzzTitle){
        $(Title).shouldBe(Condition.visible).clear();
        $(Title).sendKeys(BuzzTitle);
        return this;
    }
    public BuzzPage EnterDescription(String BuzzDescription){
       $(Description).shouldBe(Condition.visible).clear();
       $(Description).sendKeys(BuzzDescription);
       return this;
    }
    public BuzzPage EnterURL(String URL){
       $(URlFiled).shouldBe(Condition.visible).clear();
       $(URlFiled).sendKeys(URL);
        return this;
    }
    public BuzzPage ClcikOnSaveButton(){
        $(SaveButton).shouldBe(Condition.visible).click();
        return this;
    }
    public BuzzPage ClickOnDeleteBuzzButton(){
        $(DeleteBuzzButton).click();
        WebElement DeleteConfirmation = $(By.xpath("//span[contains(text(),'Yes, Delete it!')]"));
        DeleteConfirmation.click();
        return this;
    }
    public BuzzPage AddCoverImage(){
        $(CoverImageButton).sendKeys("/home/user/Desktop/гребля.jpg");
        WebElement popup = $(By.xpath("//div[@class='ant-modal-content']")).shouldBe(Condition.visible);
        if(popup.isDisplayed()){
            WebElement CroupButton =  $(By.xpath("//div[@class='ant-modal-footer']/button[2]"));
            CroupButton.click();
           $(By.xpath("//div[contains(@class,'preview-block f-s-sb')]")).shouldBe(Condition.visible);
        }
        return this;
    }
    public BuzzPage GoToRandomBuzz() {
        int Random = (int) (Math.random() * 10);
        $(AddBuzzButton).shouldBe(Condition.visible);
        List<WebElement> ListOfBuzzes = new ArrayList<WebElement>();
        System.out.println(Random);
        for (int i = 1; i < 10; i++) {
            ListOfBuzzes.add($(By.xpath("//tr[" + i + "]//td[2]")));

        }
        ListOfBuzzes.get(Random).click();
        return this;
    }
    public BuzzPage GotoEditBuzzScreen(){
        $(EditBuzzButton).click();
        return this;
    }


    public boolean Is_Buzz_WasFound(String NameOfBuzz){
        try {
            $(DeleteBuzzButton).shouldBe(Condition.visible);
            $(By.xpath("//h2")).shouldHave(Condition.text(NameOfBuzz));
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Buzz was not found");
            return false;
        }
    }

    public boolean IS_BuzzCreated(String nameOfBuzz, String buzzDescription){
        try {
            WebElement BuzzCreatedText = $(By.xpath("//span[contains(text(),'Buzz created successfully')]"));
            SearchBuzz(nameOfBuzz);
            $(By.xpath("//span[contains(text(),'" + buzzDescription+ "')]")).shouldHave(Condition.text(buzzDescription));
            return true;
        } catch (AssertionError AssertErr){
            Assert.fail("Buzz was not created!");
            return false;
        }
    }
    public boolean IS_Buzz_Was_Updated(String BuzzTitle){
        try {
            WebElement BuzzWasEditedText = $(By.xpath("//span[contains(text(),'Buzz edited successfully')]")).shouldBe(Condition.visible);
            WebElement UpdatedBuzzTitle = $(By.xpath("//h2")).shouldHave(Condition.text(BuzzTitle));
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Buzz was not updated!");
            return false;
        }
    }

    public boolean IS_Buzz_Was_Removed(){
        try {
            WebElement BuzzRemovedText = $(By.xpath("//span[contains(text(),'Buzz removed successfully')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Buzz was not removed!");
            return false;
        }
    }



}
