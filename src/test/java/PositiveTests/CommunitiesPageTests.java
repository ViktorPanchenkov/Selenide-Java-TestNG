package PositiveTests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommunitiesPageTests extends TestBase {


    @BeforeMethod
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
    @Test(priority = 6)
    public void SearchCommunity(){
        String NameOFCommunity = "14 Soviet army";
        communitiesPage.SearchCommunity(NameOFCommunity);
        Assert.assertTrue(communitiesPage.IS_Community_Was_Found(NameOFCommunity));
    }

    @Test(priority = 1)
    public void AddCommunity(){
        int Random = (int) (Math.random() *10);
        int NumberOfCategory = 2;
        String CommunityTitle = "Created by Selenide";
        String CommunityDescription = "Description by Selenide";
        communitiesPage.ClcikOnAddCommunityButton().
                EnterTitle(CommunityTitle).
                EnterDescription(CommunityDescription).
                SelectCategory(2).
                AddImage().
                ClcikOnCreateCommunityButton();
        Assert.assertTrue(communitiesPage.IS_Community_Created());
    }
    @Test(priority = 2)
    public  void  EditCommunity(){
        String CommunityTitle = "Created by Selenide";
        String CommunityDescription = "Description by Selenide";
        String NewCommunityTitle = "Updated by Selenide";
        communitiesPage.SearchCommunity(CommunityTitle).
                ClcikOnEditCommunityButton().
                EnterTitle(NewCommunityTitle).
                EnterDescription(CommunityDescription).
                ClcikOnUpdateCommunityButton();
        Assert.assertTrue(communitiesPage.IS_Community_Was_Updated());

    }
    @Test(priority = 3)
    public void DeleteCommunity(){
        String CommunityTitle = "Updated by Selenide";
        communitiesPage.SearchCommunity(CommunityTitle).
                ClcikOnDeleteCommunityButton();
        Assert.assertTrue(communitiesPage.IS_Community_Deleted());
    }
    @Test(priority = 7)
    public void GotoFollowersTab(){
        communitiesPage.GotoCommunityFromList(5).
      GotoFollowersTab();
      Assert.assertTrue(communitiesPage.IS_ListOf_Users_Displayed());
    }
    @Test(priority = 8)
    public void GotoModeratorsTab(){
        communitiesPage.GotoCommunityFromList(3).
        GotoModeratorsTab();
        Assert.assertTrue(communitiesPage.IS_ListOf_Users_Displayed());
    }
    @Test(priority = 9)
    public void DeactivateNews(){
        communitiesPage.GotoCommunityFromList(0).
                GotoActiveNewsTab();
        Assert.assertTrue(communitiesPage.DeactivateNews());
    }
    @Test(priority = 10)
    public void ActivateNews(){
        communitiesPage.GotoCommunityFromList(0).
                GotoInactiveNewsTab();
        Assert.assertTrue(communitiesPage.ActivateNews());
    }
    @Test(priority = 11)
    public void CreateActiveNews(){
        String NewsTitle = "Active News by autotest";
        String NewsDescription = "Description by autotest";
     communitiesPage.GotoCommunityFromList(0).
           GotoActiveNewsTab().
             ClcikOnCreateNewsButton().
             EnterTitle(NewsTitle).
             EnterDescription(NewsDescription).
             AddImage().
             ClcikOnCreateNewsButton();
     Assert.assertTrue(communitiesPage.IS_News_Was_Created());
    }
    @Test(priority = 12)
    public void CreateInactiveNews(){
        String NewsTitle = "Active News by autotest";
        String NewsDescription = "Description by autotest";
        communitiesPage.GotoCommunityFromList(0).
               GotoInactiveNewsTab().
                ClcikOnCreateNewsButton().
                EnterTitle(NewsTitle).
                EnterDescription(NewsDescription).
                AddImage().
                ClcikOnCreateNewsButton();
        Assert.assertTrue(communitiesPage.IS_News_Was_Created());
    }
    @Test(priority = 13)
    public void DeleteInactiveNews(){
        communitiesPage.GotoCommunityFromList(0).
                GotoInactiveNewsTab().
                GotoInactiveNews().
                ClickOnDeleteNewsButton();
        Assert.assertTrue(communitiesPage.IS_News_Was_Deleted());

    }
    @Test(priority = 4)
    public void BlockCommunity(){
        communitiesPage.GotoCommunityFromList(8).
                ClickOnTheBlockCommunityButton();
        Assert.assertTrue(communitiesPage.IS_Community_Was_Bloked());
    }
    @Test(priority = 5)
    public void UnblockCommunity(){
        communitiesPage.GotoCommunityFromList(8).
                ClickOnTheUnblockCommunityButton();
      Assert.assertTrue(communitiesPage.IS_CommunityWas_Unbloked());
    }
}
