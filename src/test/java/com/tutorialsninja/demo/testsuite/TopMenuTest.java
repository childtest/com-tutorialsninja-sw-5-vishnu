package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends BaseTest {

    HomePage homePage;
    DesktopsPage desktopsPage;
    LaptopsAndNotebooksPage notebooksPage;
    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        notebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = homePage.getTopMenuList();
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = homePage.getTopMenuList();
        }

        //  homePage.clickOnMenuOption(menu);

    }

    @Test(groups = "sanity")
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnDesktop();
        Thread.sleep(2000);
        selectMenu("Show AllDesktops");
        Assert.assertEquals(desktopsPage.getDesktopPageTitle(), "Desktops",
                "Not navigate to Desktop page");
    }

    @Test(groups = "smoke")
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopAndNotBook();
        selectMenu("Show AllLaptops & Notebooks");
        Assert.assertEquals(notebooksPage.getTitleOfLaptopAndNotBookPage(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponents();
        selectMenu("Show AllComponents");
        Assert.assertEquals(componentsPage.getPageTitleOfComponents(), "Components",
                "Not navigate to Components page");
    }

}
