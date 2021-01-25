package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.commands.As;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.applet.AppletSecurityException;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CommunitiesPage  extends BasePage {

    By CommunityesTab = By.xpath("//span[contains(text(),'Communities')]");
    By Search = By.xpath("//input[@placeholder='Search...']");
    By AddCommunityButton = By.xpath("//span[contains(text(),'Add community')]");
    By Title = By.xpath("//input[@name='title']");
    By Description = By.xpath("//textarea[@name='description']");
    By CategorySelection = By.xpath("//div[@class=' css-1hwfws3']");
    By ImageInput = By.xpath("//div[contains(@class,'cropper-cmp')]//input");
    By CreateCommunityButton = By.xpath("//span[contains(text(),'Create Community')]");
    By FirstCommunityFromList = By.xpath("//tr[1]//td[2]");
    By FollowersTab = By.xpath("//div[@class='category-header-cmp-tabs f-c-s']/h3[2]");
    By ModeratorsTab = By.xpath("//h3[contains(text(),'Moderators')]");
    By InactivnewsTab = By.xpath("//h3[contains(text(),'Inactive News')]");
    By ActiveNewsTab = By.xpath("//h3[contains(text(),'Active News')]");
    By CreateNewsButton = By.xpath("//span[contains(text(),'Create News')]");
    By DeleteNewsButton = By.xpath("//span[contains(text(),'Delete News')]");
    By BlockCommubityButton = By.xpath("//span[contains(text(),'block Community')]");
    By UnblockCommuntyButton = By.xpath("//span[contains(text(),'unblock Community')]");
    By EditCommunityButton = By.xpath("//span[contains(text(),'Edit Community')]");
    By AutomaticAprovalOFSurveysButton = By.xpath("//button[@name='surveyAutoReview']");
    By UpdateCommunityButton = By.xpath("//span[contains(text(),'Update Community')]");
    By DeleteCommunityButton = By.xpath("//span[contains(text(),'Delete Permanently')]");


    public CommunitiesPage GotoCommunitiesTab() {
        $(CommunityesTab).shouldBe(Condition.visible).click();
        return this;
    }

    public CommunitiesPage SearchCommunity(String NameOfCommunity) {
        $(Search).shouldBe(Condition.visible).sendKeys(NameOfCommunity);
        try {
            WebElement FoundSurvey = $(By.xpath("//span[contains(text(),'" + NameOfCommunity + "')]"));
            FoundSurvey.click();
        } catch (AssertionError AssertError) {
            Assert.fail("There is no survey with such title!");
        }
        return this;
    }

    public CommunitiesPage ClcikOnAddCommunityButton() {
        $(AddCommunityButton).shouldBe(Condition.visible).click();
        return this;
    }

    public CommunitiesPage EnterTitle(String CommunityTitle) {
        $(Title).shouldBe(Condition.visible).clear();
        $(Title).sendKeys(CommunityTitle);
        return this;
    }

    public CommunitiesPage EnterDescription(String CommunityDescription) {
        $(Description).clear();
        $(Description).sendKeys(CommunityDescription);
        return this;
    }

    public CommunitiesPage SelectCategory(int CategoryNumber) {
        $(CategorySelection).click();
        $(By.xpath("//div[@id='react-select-2-option-" + CategoryNumber + "']")).click();
        return this;
    }
    public CommunitiesPage ClcikOnEditCommunityButton(){
        $(EditCommunityButton).click();
        return this;
    }

    public CommunitiesPage AddImage() {
        $(ImageInput).sendKeys("/home/user/Desktop/гребля.jpg");
        WebElement GroupButton = $(By.xpath("//span[contains(text(),'Crop')]"));
        GroupButton.click();
        WebElement AddedImage = $(By.xpath("//div[@class='w100']/img")).shouldBe(Condition.visible);
        return this;

    }
    public CommunitiesPage ClcikOnCreateCommunityButton(){
        $(CreateCommunityButton).click();
        return this;
    }
    public CommunitiesPage GotoCommunityFromList(int communityNumber){
        $(FirstCommunityFromList).shouldBe(Condition.visible);
        List<WebElement> ListOfCommunities = new ArrayList<WebElement>();
        for(int i =1; i<10; i++){
            WebElement Community = $(By.xpath("//tr[" + i + "]//td[2]"));
            ListOfCommunities.add(Community);
        }
        ListOfCommunities.get(communityNumber).click();
        return this;
    }
    public CommunitiesPage GotoFollowersTab(){
        $(FollowersTab).click();
        return this;
    }
    public CommunitiesPage GotoModeratorsTab(){
        $(ModeratorsTab).click();
        return this;
    }

    public CommunitiesPage GotoActiveNewsTab(){
        $(ActiveNewsTab).click();
        return this;
    }
    public CommunitiesPage ClcikOnUpdateCommunityButton(){
        $(UpdateCommunityButton).click();
        return this;
    }
    public CommunitiesPage ClcikOnDeleteCommunityButton(){
        $(DeleteCommunityButton).click();
        WebElement DeleteConfirmation = $(By.xpath("//span[contains(text(),'Yes, Delete it!')]"));
        DeleteConfirmation.click();
        return this;
    }
    public CommunitiesPage GotoInactiveNewsTab(){
        $(InactivnewsTab).click();
        return this;
    }
    public CommunitiesPage ClcikOnCreateNewsButton(){
        $(CreateNewsButton).click();
        return this;
    }
    public CommunitiesPage ClickOnTheBlockCommunityButton(){
        $(BlockCommubityButton).shouldBe(Condition.visible);
        WebElement BlockButtonStatus = $(BlockCommubityButton);
        if (BlockButtonStatus.getText().equals("BLOCK COMMUNITY")){
            $(BlockCommubityButton).click();
            WebElement BlockConfirmation = $(By.xpath("//div[@class='ant-modal-footer']/button[2]"));
            BlockConfirmation.click();
        } else {
            Assert.fail("Community already Blocked!");
        }
        return this;
    }
    public CommunitiesPage ClickOnTheUnblockCommunityButton(){
        $(UnblockCommuntyButton).shouldBe(Condition.visible);
        WebElement UnblockButtonStatus = $(UnblockCommuntyButton);
        if(UnblockButtonStatus.getText().equals("UNBLOCK COMMUNITY")){
            $(UnblockCommuntyButton).click();
            WebElement UnblockConfirmation = $(By.xpath("//div[@class='ant-modal-footer']/button[2]"));
            UnblockConfirmation.click();
        } else {
            Assert.fail("Community was not blocked!");
        }
        return this;
    }
    public CommunitiesPage GotoInactiveNews(){
        try {
            WebElement InactiveNews = $(By.xpath("//tbody/tr[1]/td[2]")).shouldBe(Condition.visible);
            InactiveNews.click();
        } catch (AssertionError AssertError){
            Assert.fail("In this community no any Inactive news!");
        }
        return this;
    }
    public CommunitiesPage ClickOnDeleteNewsButton(){

            $(DeleteNewsButton).click();
            WebElement DeleteConfirmation = $(By.xpath("//div[@class='ant-modal-footer']/button[2]")).shouldBe(Condition.visible);
            DeleteConfirmation.click();
            return this;


    }
    public boolean IS_News_Was_Deleted(){
        try {
            WebElement NewsWasDeletedText = $(By.xpath("//span[contains(text(),'News deleted successfully.')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("News was not Deleted!");
            return false;
        }
    }
    public boolean IS_News_Was_Created(){
        try {
            WebElement NewsCreatedText = $(By.xpath("//span[contains(text(),'News created successfully.')]")).shouldBe(Condition.visible);
            return true;
        }catch (AssertionError AssertError){
            Assert.fail("News was not Created!");
            return false;
        }
    }
    public boolean IS_Community_Was_Bloked(){

        try {
            $(UnblockCommuntyButton).shouldBe(Condition.visible);
            WebElement CommunityUpdatedPopUp = $(By.xpath("//span[contains(text(),'Community updated successfully.')]")).shouldBe(Condition.visible);
            $(BlockCommubityButton).shouldHave(Condition.text("UNBLOCK COMMUNITY"));
            return true;
        }catch (AssertionError AssertError){
            Assert.fail("Community was not blocked!");
            return false;
        }
    }

    public boolean IS_CommunityWas_Unbloked(){

       try {
           $(UnblockCommuntyButton).shouldHave(Condition.text("BLOCK COMMUNITY"));
           return true;
       } catch (AssertionError AssertError){
           Assert.fail("Community was not unblocked!");
           return false;
       }
    }

    public boolean IS_Community_Was_Updated(){
        try {
            WebElement CommunityUpdatedPopUP = $(By.xpath("//span[contains(text(),'Community saved successfully.')]"));
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Community was not updated!");
            return false;
        }
    }



    public boolean DeactivateNews(){
        try {
            WebElement ActiveNewsButton = $(By.xpath("//span[contains(text(),'Inactive')]")).shouldBe(Condition.visible);
            ElementsCollection ListOfINActveButton = $$(By.xpath("//span[contains(text(),'Inactive')]"));
            ListOfINActveButton.get(0).click();
            WebElement NewWasUpdatedText = $(By.xpath("//span[contains(text(),'News updated successfully.')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("There is no any Active news!");
            return false;
        }
    }
    public boolean ActivateNews(){
        try {
            WebElement ActiveNewsButton = $(By.xpath("//span[contains(text(),'Active')]")).shouldBe(Condition.visible);
            ElementsCollection ListOfActveButton = $$(By.xpath("//span[contains(text(),'Active')]"));
            ListOfActveButton.get(0).click();
            try {
             //   ListOfActveButton.get(0).shouldBe(Condition.disappear);
                WebElement NewWasUpdatedText = $(By.xpath("//span[contains(text(),'News updated successfully.')]")).shouldBe(Condition.visible);
                return true;
            } catch (AssertionError AssertError){
                Assert.fail("News was not Activated!");
                return false;
            }
        } catch (AssertionError AssertError){
            Assert.fail("There is no any Inactive news!");
            return false;
        }
    }


    public boolean IS_Community_Created(){
        try {
            WebElement CommunityCreatedPopUP = $(By.xpath("//span[contains(text(),'Community created successfully.')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Community was not Created!");
            return false;
        }
    }
    public boolean IS_Community_Was_Found(String NameOfCommunity){
        try {
            WebElement CommunityTitle = $(By.xpath("//h2")).shouldHave(Condition.text(NameOfCommunity));
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Probably Community was not found");
            return false;
        }
    }
    public boolean IS_ListOf_Users_Displayed(){
        try {
            WebElement UserInList = $(By.xpath("//tbody/tr[1]/td[2]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("There is no any user in list!");
            return false;
        }
    }
    public boolean IS_Community_Deleted(){
        try {
            WebElement CommunityDeletedPoPUP = $(By.xpath("//span[contains(text(),'Community deleted successfully.')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Community was not deleted!");
            return false;
        }
    }
}
