package PositiveTests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SurveysPageTests extends TestBase {


    @BeforeMethod
    public void BeforeAction(){
        String Phone = "+11111111111";
        String Password = "qwerty";
        loginPage.open().
                typeUserName(Phone).
                typePassword(Password).
                ClickOnLoginButton();
        surveysPage.GotoSurveysTab();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    @Test
    public void SearchSurvey(){
     String SurveyTitle = "Survey With Yes/No Question";
     surveysPage.SearchSurvey(SurveyTitle);
        Assert.assertTrue(surveysPage.IS_Survey_Was_Found(SurveyTitle));
    }
    @Test
    public void AddOfficialSurvey(){
        String SurveyTitle = "Created By Selenide";
        String SurveyDescription = "Description By Autotest";
        String QuestionText = "Text Of Question?";
        String Answer1 = "One";
        String Answer2 = "Not one";
        int CategoryNumber = 4;
        surveysPage.ClcikOnAddOfficialSurveyButton().
                EnterTitle(SurveyTitle).
                EnterDescription(SurveyDescription).
                SelectCategory(CategoryNumber).
                EnterFirstQuestion(QuestionText).
                EnterTextToAnswerOption(Answer1,Answer2).
                ClcikOnCreateSurveyButton();
        Assert.assertTrue(surveysPage.IS_Survey_Created());
    }
    @Test
    public void BackToLiveUserSurvey(){
        surveysPage.GotoUsersSurveysTab().
                GotoCompletedSurvey().
                ClickOnBackToLiveButton();
        Assert.assertTrue(surveysPage.IS_Survey_ReturnedToLive());
    }
    @Test
    public void CompleteOfficialSurvey(){
        surveysPage.GotoLiveSurvey().
                ClickOnTheCompleteSurveyButton();
        Assert.assertTrue(surveysPage.IS_Survey_Was_Completed());
    }
    @Test
    public void DeleteCompletedSurvey(){
       surveysPage.GotoCompletedSurvey().
               ClickOnDeleteSurveyButton();
       Assert.assertTrue(surveysPage.IS_Survey_Was_Deleted());
    }
    @Test
    public void CloneSurvey(){
        String Title = "Cloned Survey";
        String Description = "Cloned Description";
        surveysPage.GotoCompletedSurvey().
                ClickOnTheCloneSurveyButton().
                ClcikOnEditDraftButton().
                EnterTitle(Title).
                EnterDescription(Description).
                ClickOnPublishDraftButton();
        Assert.assertTrue(surveysPage.IS_Draft_Was_Published());
    }
    @Test
    public void AddPulseSurvey(){
        String PulseTitle = "Pulse Created By automation test";
        String PulseDescription = "Description By Autotest";
        String QuestionText = "Does automation test works well?";
        String Answer1 = "Yes";
        String Answer2 = "No, it is a bad solution.";
        surveysPage.GotoPulseTab().
                ClickOnAddPulseButton().
                EnterTitle(PulseTitle).
                EnterDescription(PulseDescription).
                EnterFirstQuestion(QuestionText).
                SelectCategory(4).
                EnterTextToAnswerOption(Answer1,Answer2).
                ClickOnCreatePulseButton();
        Assert.assertTrue(surveysPage.IS_Pulse_Was_Created());
    }
    @Test
    public void DeletePulse(){
        surveysPage.GotoPulseTab().
                GotoCompletedPulse().
                ClickOnTheDeletePulseButton();
        Assert.assertTrue(surveysPage.IS_Survey_Was_Deleted());
    }
}
