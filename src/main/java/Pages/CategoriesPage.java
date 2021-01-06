package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLPortType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CategoriesPage extends BasePage {

    By CategoriesTab = By.xpath("//span[contains(text(),'Categories')]");
    By AddCategoryButton = By.xpath("//span[contains(text(),'Add New Category')]");
    By Title = By.xpath("//input[@name='categoryName']");
    By CreateCategoryButton = By.xpath("//span[contains(text(),'Create Category')]");
    By DeleteCategoryButton = By.xpath("//span[contains(text(),'Delete')]");
    By EditCategoryButton = By.xpath("//span[contains(text(),'Edit')]");
    By UpdateCategoryButton = By.xpath("//div[@class='ant-modal-footer']/button[2]");
    By CoverImageInput = By.xpath("//div[contains(@class,'ant-modal-body')]//div[2]//div[1]//div[1]//div[1]//div[2]//input[1]");
    By CategoryIconInput = By.xpath("//div//div[3]//div[1]//div[1]//div[1]//div[2]//input[1]");

    public CategoriesPage GotoGategoriesTab(){
        $(CategoriesTab).shouldBe(Condition.visible).click();
        return new CategoriesPage();
    }

    public CategoriesPage ClcikOnAddCategoryButton(){
        $(AddCategoryButton).shouldBe(Condition.visible).click();
        return this;
    }
    public CategoriesPage EnterTitle(String CategoryTitle){
        $(Title).shouldBe(Condition.visible).clear();
        $(Title).sendKeys(CategoryTitle);

        return this;
    }

    public CategoriesPage AddCoverImage(){
        $(CoverImageInput).sendKeys("/home/user/Desktop/гребля.jpg");
        WebElement PopUP = $(By.xpath("//div[@class='ant-modal-content']")).shouldBe(Condition.visible);
        WebElement CroupButton = $(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")).shouldBe(Condition.visible);
        CroupButton.click();
        WebElement AddedImage = $(By.xpath("//div[contains(@class,'preview-block f-s-sb')]//img")).shouldBe(Condition.visible);
        return this;
    }
    public CategoriesPage AddCategoryIcon() {
        $(CategoryIconInput).sendKeys("/home/user/Desktop/гребля.jpg");
        WebElement PopUP = $(By.xpath("//div[@class='ant-modal-content']")).shouldBe(Condition.visible);
        if(PopUP.isDisplayed()){
            WebElement CroupButton = $(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/button[2]")).shouldBe(Condition.visible);
            CroupButton.click();
        }
        WebElement Img2 = $(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[3]/div/div/div[2]/div")).waitUntil(Condition.visible,5000);
        return this;
    }
    public CategoriesPage ClickOnCreateCategoryButton(){

        $(CreateCategoryButton).shouldBe(Condition.visible).click();
        return this;
    }
    public CategoriesPage ClcikOnEditCategoryButton(){
        $(EditCategoryButton).shouldBe(Condition.visible);
        ElementsCollection ListOfEditbuttons = $$(By.xpath("//span[contains(text(),'Edit')]"));
        ListOfEditbuttons.get(1).click();
        return this;
    }
    public CategoriesPage ClcikOnTheUpdateCategoryButton(){
        $(UpdateCategoryButton).shouldBe(Condition.visible).click();
        return this;
    }

    public CategoriesPage ClickOnDeleteCategoryButton(int numberOFCategory){
        $(DeleteCategoryButton).shouldBe(Condition.visible);
        ElementsCollection ListOfDeleteButtons = $$(By.xpath("//span[contains(text(),'Delete')]"));
        ListOfDeleteButtons.get(numberOFCategory).click();
        WebElement DeleteConfirmation = $(By.xpath("//div[@class='ant-modal-footer']/button[2]")).shouldBe(Condition.visible);
        DeleteConfirmation.click();
        return this;
    }

    public boolean IS_CategoryWas_Created(){
        try {
            WebElement CategoryCreatedPopUP = $(By.xpath("//span[contains(text(),'Category created successfully')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Category was not created!");
            return false;
        }
    }

    public boolean IS_Category_Wa_Updated(){
        try {
            WebElement CategoryUpdatedPopUP = $(By.xpath("//span[contains(text(),'Category updated successfully')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Category was not updated!");
            return false;
        }
    }
    public boolean IS_Category_Was_Deleted(){
        try {
            WebElement CategoryWasDeletedText = $(By.xpath("//span[contains(text(),'Category deleted successfully')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Category was not deleted!");
            return false;
        }
    }

}
