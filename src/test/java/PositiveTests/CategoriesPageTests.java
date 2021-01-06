package PositiveTests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPageTests extends TestBase {


    @BeforeTest
    public void BeforeAction(){
        String Phone = "+11111111111";
        String Password = "qwerty";
        loginPage.open().
                typeUserName(Phone).
                typePassword(Password).
                ClickOnLoginButton();
       categoriesPage.GotoGategoriesTab();
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }
    @Test
    public void AddCategory() {
        int Random = (int) (Math.random() *10);
        String Title = "Created by autotest" + Random;
        categoriesPage.ClcikOnAddCategoryButton().
                EnterTitle(Title).
                AddCoverImage().
                AddCategoryIcon().
                ClickOnCreateCategoryButton();
        Assert.assertTrue(categoriesPage.IS_CategoryWas_Created());
    }
    @Test
    public void EditCategory(){
        String NewTitle = "New Category Title";
          categoriesPage.ClcikOnEditCategoryButton().
                  EnterTitle(NewTitle).
                  ClcikOnTheUpdateCategoryButton();
          Assert.assertTrue(categoriesPage.IS_Category_Wa_Updated());

    }
    @Test
    public void DeleteCategory(){
        int numberOfCategory = 1;
        categoriesPage.ClickOnDeleteCategoryButton(numberOfCategory);
        Assert.assertTrue(categoriesPage.IS_Category_Was_Deleted());

    }
}
