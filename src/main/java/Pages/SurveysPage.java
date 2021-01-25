package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.commands.As;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SurveysPage extends BasePage {

    By SurveysTab = By.xpath("//span[contains(text(),'Surveys')]");
    By Search = By.xpath("//input[@placeholder='Search...']");
    By AddOfficialSurveyButton = By.xpath("//div[@class='search-block f-c-s']/button");
    By Title = By.xpath("//input[@name='title']");
    By Description = By.xpath("//textarea[@name='description']");
    By CategorySelection = By.xpath("//div[@class=' css-1hwfws3']");
    By CreateSurveyButton = By.xpath("//span[contains(text(),'Create Survey')]");
    By UsersSurveyTab = By.xpath("//h3[contains(text(),'User Surveys')]");
    By BackToLiveButton = By.xpath("//span[contains(text(),'Back to Live')]");
    By CompleteSurveyButton = By.xpath("//span[contains(text(),'Complete Survey')]");
    By DeleteSurveyButton = By.xpath("//span[contains(text(),'Delete survey')]");
    By CloneSurveyButton = By.xpath("//span[contains(text(),'Clone survey')]");
    By PublishDraftButton = By.xpath("//span[contains(text(),'Publish Draft')]");
    By EditDraftButton = By.xpath("//span[contains(text(),'Edit Draft')]");
    By PulseTab = By.xpath("//h3[contains(text(),'Pulses')]");
    By AddPulseButton = By.xpath("//span[contains(text(),'Add New Pulse')]");
    By CreatePulseButton = By.xpath("//span[contains(text(),'Create Pulse')]");
    By DeletePulseButton = By.xpath("//span[contains(text(),'Delete pulse')]");


    public SurveysPage GotoSurveysTab(){
        $(SurveysTab).click();
        return new SurveysPage();
    }
    public SurveysPage SearchSurvey(String NameOfSurvey) {
        $(Search).shouldBe(Condition.visible).sendKeys(NameOfSurvey);
        try {
            WebElement FoundSurvey = $(By.xpath("//span[contains(text(),'" + NameOfSurvey + "')]"));
            FoundSurvey.click();
        } catch (AssertionError AssertError) {
            Assert.fail("There is no survey with such title!");
        }
        return this;
    }

    public SurveysPage ClcikOnAddOfficialSurveyButton(){
        $(AddOfficialSurveyButton).click();
        return this;
    }
    public SurveysPage EnterTitle(String SurveyTitle){
        $(Title).clear();
        $(Title).sendKeys(SurveyTitle);
        return this;
    }
    public SurveysPage EnterDescription(String SurveyDescription){
        $(Description).clear();
        $(Description).sendKeys(SurveyDescription);
        return this;
    }
    public SurveysPage EnterTextToAnswerOption(String Answer1,String Answer2){

        WebElement AnswerOption1 = $(By.xpath("//input[@name='questionDtoList[0].optionList[0].text']"));
        WebElement AnswerOption2 = $(By.xpath("//input[@name='questionDtoList[0].optionList[1].text']"));
        AnswerOption1.sendKeys(Answer1);
        AnswerOption2.sendKeys(Answer2);
        return this;
    }
    public SurveysPage ClcikOnCreateSurveyButton(){
       $(CreateSurveyButton).click();
        return this;
    }
    public SurveysPage SelectCategory(int CategoryNumber) {
        $(CategorySelection).click();
        $(By.xpath("//div[@id='react-select-2-option-" + CategoryNumber + "']")).click();
        return this;
    }
    public SurveysPage EnterFirstQuestion(String QuestionText){
        WebElement FirstQuestionFiled = $(By.xpath("//input[@name='questionDtoList[0].question']"));
        FirstQuestionFiled.clear();
        FirstQuestionFiled.sendKeys(QuestionText);
        return this;

    }

    public SurveysPage ClickOnDeleteSurveyButton(){
        $(DeleteSurveyButton).click();
        WebElement DeleteConfirmation = $(By.xpath("//span[contains(text(),'Yes, Delete it!')]"));
        DeleteConfirmation.click();
        return this;
    }
    public SurveysPage ClcikOnEditDraftButton(){
        $(EditDraftButton).click();
        return this;
    }

    public SurveysPage ClickOnTheCloneSurveyButton(){
       $(CloneSurveyButton).click();
       WebElement CloneConfirmation = $(By.xpath("//span[contains(text(),'Clone!')]"));
       CloneConfirmation.click();
       return this;
    }

    public SurveysPage ClickOnPublishDraftButton(){
        $(PublishDraftButton).click();
        return this;
    }

    public SurveysPage GotoUsersSurveysTab(){
        $(UsersSurveyTab).click();
        return this;
    }
    public SurveysPage GotoCompletedSurvey(){
        try {
            WebElement SurveyWithCompletedStatus = $(By.xpath("//span[contains(text(),'Completed')]")).shouldBe(Condition.visible);
            ElementsCollection ListOfCompletedSurvey = $$(By.xpath("//span[contains(text(),'Completed')]"));
        //   List<WebElement> ListOfCompletedSurvey = $$(By.xpath("//span[contains(text(),'Completed')]"));
            ListOfCompletedSurvey.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any completed survey!");
        }
        return this;
    }
    public SurveysPage GotoCompletedPulse(){
        try {
            WebElement PulseWithCompletedStatus = $(By.xpath("//span[contains(text(),'completed')]")).shouldBe(Condition.visible);
            ElementsCollection ListOfCompletedPulses = $$(By.xpath("//span[contains(text(),'completed')]"));
            ListOfCompletedPulses.get(0).click();
        } catch (AssertionError assertionError){
            Assert.fail("There is no any Completed Survey!");
        }
        return this;
    }
    public SurveysPage GotoPulseTab(){
        $(PulseTab).click();
        return this;
    }
    public SurveysPage ClickOnAddPulseButton(){
        $(AddPulseButton).click();
        return this;
    }
    public SurveysPage ClickOnTheDeletePulseButton(){
        $(DeletePulseButton).click();
        WebElement DeleteConfirmation = $(By.xpath("//span[contains(text(),'Yes, Delete it!')]"));
        DeleteConfirmation.click();
        return this;
    }
    public SurveysPage ClickOnCreatePulseButton(){
        $(CreatePulseButton).click();
        return this;
    }
    public SurveysPage GotoLiveSurvey(){
        WebElement SurveyWithLiveStatus = $(By.xpath("//span[contains(text(),'Live')]")).shouldBe(Condition.visible);
        ElementsCollection ListOFLiveSurveys = $$(By.xpath("//span[contains(text(),'Live')]"));
        ListOFLiveSurveys.get(0).click();
        return this;
    }
    public SurveysPage ClickOnBackToLiveButton(){
        $(BackToLiveButton).click();
        WebElement ReOpenConfirmation = $(By.xpath("//span[contains(text(),'Re-open!')]"));
        ReOpenConfirmation.click();
        return this;
    }
    public SurveysPage ClickOnTheCompleteSurveyButton(){
        try {
            $(CompleteSurveyButton).click();
            WebElement CompleteConfirmation = $(By.xpath("//span[contains(text(),'Complete!')]"));
            CompleteConfirmation.click();

        } catch (AssertionError AssertError){
            Assert.fail("There is no any Live Survey");
        }
        return this;
    }


    public boolean IS_Survey_Was_Found(String TitleOFFoundSurvey){
        try {
            WebElement SurveyTitle = $(By.xpath("//h2")).shouldHave(Condition.text(TitleOFFoundSurvey));
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("The Survey was not found!");
            return false;
        }
    }

    public boolean IS_Survey_Created(){
        try {
            WebElement SurveyCreatedPopUP = $(By.xpath("//span[contains(text(),'Your survey was cuccessfully created!')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("The Survey was not created!");
            return false;
        }
    }
    public boolean IS_Survey_ReturnedToLive(){
        try {
            WebElement SurveyUpdatedPopUP = $(By.xpath("//span[contains(text(),'Status updated successfully')]")).shouldBe(Condition.visible);
            $(CompleteSurveyButton).shouldBe(Condition.visible);
            WebElement LiveStatus = $(By.xpath("//span[contains(text(),'Live')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError AssertError){
            Assert.fail("Survey was not returned to Live");
            return false;
        }
    }
    public boolean IS_Survey_Was_Completed(){
        try {
           WebElement CompletedStatus = $(By.xpath("//span[contains(text(),'Completed')]")).shouldBe(Condition.visible);
           $(BackToLiveButton).shouldBe(Condition.visible);
           return true;
        } catch (AssertionError AssertError){
            Assert.fail("The Survey was not Completed!");
            return false;
        }
    }

    public boolean IS_Survey_Was_Deleted(){
        try {
            WebElement SurveyDeletedPopUP = $(By.xpath("//span[contains(text(),'Survey removed successfully')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError assertionError){
            Assert.fail("Survey Was not Deleted");
            return false;
        }
    }
    public boolean IS_Draft_Was_Published(){
        try {
            WebElement DraftWasPublishedPopUP = $(By.xpath("//span[contains(text(),'Survey edited successfully')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError assertionError){
            Assert.fail("Survey was not Cloned!");
            return false;
        }
    }
    public boolean IS_Pulse_Was_Created(){
        try {
            WebElement PulseCreatedPopUP = $(By.xpath("//span[contains(text(),'Your pulse was cuccessfully created!')]")).shouldBe(Condition.visible);
            return true;
        } catch (AssertionError assertionError){
            Assert.fail("Pulse was not created!");
            return false;
        }
    }


}
