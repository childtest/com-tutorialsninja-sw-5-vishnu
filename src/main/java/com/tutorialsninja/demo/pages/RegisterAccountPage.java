package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class RegisterAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement phoneNumber;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subScribe;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement btnContinue;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement confirmationMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueConfirmation;


    public String getRegisterAccountTitle() {
        Reporter.log("get register account page title");
        CustomListeners.test.log(Status.PASS, "get register account page title");
        return getTextFromElement(pageTitle);
    }

    public void enterFirstName(String fName) {
        Reporter.log("Enter first name : "+ fName);
        CustomListeners.test.log(Status.PASS, "Enter first name : "+ fName);
        sendTextToElement(firstName, fName);
    }

    public void enterLastName(String lNmae) {
        Reporter.log("Enter last name : "+ lNmae);
        CustomListeners.test.log(Status.PASS, "Enter last name : "+ lNmae);
        sendTextToElement(lastName, lNmae);
    }

    public void enterEmail(String mail) {
        Reporter.log("Enter email : "+ mail);
        CustomListeners.test.log(Status.PASS, "Enter email : "+ mail);
        sendTextToElement(email, mail);
    }

    public void enterPhoneNumber(String number) {
        Reporter.log("Enter phone number : "+ number);
        CustomListeners.test.log(Status.PASS, "Enter phone number : "+ number);
        sendTextToElement(phoneNumber, number);
    }

    public void enterPassword(String pass) {
        Reporter.log("Enter password : "+ pass);
        CustomListeners.test.log(Status.PASS, "Enter password : "+ pass);
        sendTextToElement(password, pass);
    }

    public void enterConfirmPassword(String cPass) {
        Reporter.log("Enter confirm password : "+ cPass);
        CustomListeners.test.log(Status.PASS, "Enter confirm password : "+ cPass);
        sendTextToElement(confirmPassword, cPass);
    }

    public void selectSubscribe(String option) {
        Reporter.log("select Subscribe as : "+option);
        CustomListeners.test.log(Status.PASS, "select Subscribe as : "+option);
        selectByContainsTextFromListOfElements(subScribe, option);
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log("Click On Privacy Policy CheckBox");
        CustomListeners.test.log(Status.PASS, "Click On Privacy Policy CheckBox");
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click On Continue Button");
        CustomListeners.test.log(Status.PASS, "Click On Continue Button");
        clickOnElement(btnContinue);
    }

    public String getAccountRegistrationConformationMessage() {
        Reporter.log("Get Account Registration Conformation Message");
        CustomListeners.test.log(Status.PASS, "Get Account Registration Conformation Message");
        return getTextFromElement(confirmationMessage);
    }

    public void clickOnContinueWithConfirmation() {
        Reporter.log("Click On Continue button With Confirmation");
        CustomListeners.test.log(Status.PASS, "Click On Continue button With Confirmation");
        clickOnElement(continueConfirmation);
    }

}
