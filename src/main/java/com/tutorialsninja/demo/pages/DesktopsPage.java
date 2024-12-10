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

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopTitle;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProduct;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProductAfterFilter;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement productSorting;

    public String getDesktopPageTitle() {
        Reporter.log("get desktop page title");
        CustomListeners.test.log(Status.PASS,"get desktop page title");
        return getTextFromElement(desktopTitle);
    }

    public List<WebElement> getListsOfProduct() {
        Reporter.log("get get list od products : "+listOfProduct.toString());
        CustomListeners.test.log(Status.PASS,"get get list od products : "+listOfProduct.toString());
        return listOfProduct ;
    }

    public List<WebElement> getListsOfProductAfterFilter() {
        Reporter.log("get get list od products : "+listOfProductAfterFilter.toString());
        CustomListeners.test.log(Status.PASS,"get get list od products : "+listOfProductAfterFilter.toString());
        return listOfProductAfterFilter ;
    }

    public void selectSortByZToA(String option) {
        Reporter.log(" product sorting by : "+option);
        CustomListeners.test.log(Status.PASS," product sorting by : "+option);
        selectByVisibleTextFromDropDown(productSorting, option);
    }

    public void clickOnYourSelectedProduct(String productName) {
        Reporter.log("Click on : "+productName);
        CustomListeners.test.log(Status.PASS,"Click on : "+productName);
        clickOnElement(By.linkText(productName));
    }
}
