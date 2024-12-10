package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginPageTile;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement btnLogin;

    public String getLoginPageTitle() {
        Reporter.log("get login page title");
        CustomListeners.test.log(Status.PASS, "get login page title");
        return getTextFromElement(loginPageTile);
    }

    public void enterEmail(String mail) {
        Reporter.log("Enter email : " + mail);
        CustomListeners.test.log(Status.PASS, "Enter email : " + mail);
        sendTextToElement(email, mail);
    }

    public void enterPassword(String pass) {
        Reporter.log("Enter password : " + pass);
        CustomListeners.test.log(Status.PASS, "Enter password : " + pass);
        sendTextToElement(password, pass);
    }

    public void clickOnLogInButton() {
        Reporter.log("Click on log in button");
        CustomListeners.test.log(Status.PASS, "Click on log in button");
        clickOnElement(btnLogin);
    }
}
