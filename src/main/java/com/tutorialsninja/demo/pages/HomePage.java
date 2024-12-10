package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//li//a")
    List<WebElement> topMenuList;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNotBook;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement btnPound;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    WebElement selectPound;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> listOfAccountOption;


    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountForLogOut;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement confirmationMsgOfLogOut;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement btnContinue;


    public List<WebElement> getTopMenuList() {
        Reporter.log("get top menu list : " + topMenuList.toString());
        CustomListeners.test.log(Status.PASS, "get top menu list : " + topMenuList.toString());
        return topMenuList;
    }

    public void clickOnMenuOption(String name) {
        Reporter.log("click on : " + name);
        CustomListeners.test.log(Status.PASS, "click on : " + name);
        clickOnElement(By.linkText(name));
    }

    public void mouseHoverOnDesktop() {
        Reporter.log("mouse hover on desktop");
        CustomListeners.test.log(Status.PASS, "mouse hover on desktop");
        mouseHoverToElement(desktop);
    }

    public void mouseHoverOnLaptopAndNotBook() {
        Reporter.log("mouse hover on laptop and not book");
        CustomListeners.test.log(Status.PASS, "mouse hover on laptop and not book");
        mouseHoverToElement(laptopAndNotBook);
    }

    public void mouseHoverOnComponents() {
        Reporter.log("mouse hover on components");
        CustomListeners.test.log(Status.PASS, "mouse hover on components");
        mouseHoverToElement(components);
    }

    public void mouseHoverOnCurrencyAndClickOn() {
        Reporter.log("Mouse Hover On Currency And Click On that");
        CustomListeners.test.log(Status.PASS, "Mouse Hover On Currency And Click On that");
        mouseHoverToElementAndClick(currency);
    }

    public void selectCurrencyAsAPound(String option) {
        Reporter.log("Select Currency As APound");
        CustomListeners.test.log(Status.PASS, "Select Currency As APound");
        // selectByContainsTextFromDropDown(selectPound, option);
        clickOnElement(btnPound);
    }

    public List<WebElement> getListOfMyAccountOption() {
        Reporter.log("get list of my account option : " + listOfAccountOption);
        CustomListeners.test.log(Status.PASS, "get list of my account option : " + listOfAccountOption);
        return listOfAccountOption;
    }

    public void clickOnMyAccount() {
        Reporter.log("Click on may account");
        CustomListeners.test.log(Status.PASS, "Click on may account");
        clickOnElement(myAccount);
    }

    public void clickOnMyAccountForLogOut() {
        Reporter.log("Click on may account");
        CustomListeners.test.log(Status.PASS, "Click on may account");
        clickOnElement(myAccountForLogOut);
    }

    public void clickOnLogOut(String txt) {
        Reporter.log("Click on log out");
        CustomListeners.test.log(Status.PASS, "Click on log out");
        driver.findElement(By.linkText(txt)).click();
    }

    public String getConfirmationMessageOfLogout() {
        Reporter.log("get log out confirmation message");
        CustomListeners.test.log(Status.PASS, "get log out confirmation message");
        return getTextFromElement(confirmationMsgOfLogOut);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button");
        CustomListeners.test.log(Status.PASS, "Click on continue button");
        clickOnElement(btnContinue);
    }

}
