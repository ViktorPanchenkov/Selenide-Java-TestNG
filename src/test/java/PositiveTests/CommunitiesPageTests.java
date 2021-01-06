package PositiveTests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommunitiesPageTests extends TestBase {


    @Before
    public void BeforeAction(){
        String Phone = "+11111111111";
        String Password = "qwerty";
        loginPage.open().
                typeUserName(Phone).
                typePassword(Password).
                ClickOnLoginButton();
        communitiesPage.GotoCommunitiesTab();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    @Test
    public void SearchCommunity(){
        String NameOFCommunity = "14 Soviet army";
        communitiesPage.SearchCommunity(NameOFCommunity);
        Assert.assertTrue(communitiesPage.IS_Community_Was_Found(NameOFCommunity));
    }

    @Test
    public void AddCommunity(){
        int Random = (int) (Math.random() *10);
        int NumberOfCategory = 2;
        String CommunityTitle = "Created by autotest" + Random;
        String CommunityDescription = "Description";
        communitiesPage.ClcikOnAddCommunityButton().
                EnterTitle(CommunityTitle).
                EnterDescription(CommunityDescription).
                SelectCategory(2).
                AddImage().
                ClcikOnCreateCommunityButton();
        Assert.assertTrue(communitiesPage.IS_Community_Created());
    }
    @Test
    public void GotoFollowersTab(){
        communitiesPage.GotoCommunityFromList(5).
      GotoFollowersTab();
      Assert.assertTrue(communitiesPage.IS_ListOf_Users_Displayed());
    }
    @Test
    public void GotoModeratorsTab(){
        communitiesPage.GotoCommunityFromList(3).
        GotoModeratorsTab();
        Assert.assertTrue(communitiesPage.IS_ListOf_Users_Displayed());
    }
    @Test
    public void DeactivateNews(){
        communitiesPage.GotoCommunityFromList(0).
                GotoActiveNewsTab();
        Assert.assertTrue(communitiesPage.DeactivateNews());
    }
    @Test
    public void ActivateNews(){
        communitiesPage.GotoCommunityFromList(0).
                GotoInactiveNewsTab();
        Assert.assertTrue(communitiesPage.ActivateNews());
    }
    @Test
    public void CreateActiveNews(){

    }
}
