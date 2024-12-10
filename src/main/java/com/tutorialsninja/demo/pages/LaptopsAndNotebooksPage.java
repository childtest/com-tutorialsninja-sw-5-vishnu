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

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement LaptopAndNotBook;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> listOfProductPrice;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> listOfProductAfterFilter;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement productSorting;

    public String getTitleOfLaptopAndNotBookPage() {
        Reporter.log("Get Title Of Laptop And NotBook Page");
        CustomListeners.test.log(Status.PASS, "Get Title Of Laptop And NotBook Page");
        return getTextFromElement(LaptopAndNotBook);
    }

    public List<WebElement> getListsOfProductPrice() {
        Reporter.log("get list of product price : "+listOfProductPrice.toString());
        CustomListeners.test.log(Status.PASS, "get list of product price : "+listOfProductPrice.toString());
        return listOfProductPrice;
    }

    public List<WebElement> getListsOfProductPriceAfterFilter() {
        Reporter.log("get list of product price after filter : "+listOfProductAfterFilter.toString());
        CustomListeners.test.log(Status.PASS, "get list of product price after filter: "+listOfProductAfterFilter.toString());
        return listOfProductAfterFilter;
    }

    public void selectSortByZToA(String option) {
        Reporter.log("Product sorting by Z to A");
        CustomListeners.test.log(Status.PASS, "Product sorting by Z to A");
        selectByVisibleTextFromDropDown(productSorting, option);
    }

    public void clickOnYourSelectedProduct(String productName) {
        Reporter.log("Click on : "+productName);
        Reporter.log("Click on : "+productName);
        clickOnElement(By.linkText(productName));
    }

}
