package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.pages.ProductDetailPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage;
    LaptopsAndNotebooksPage notebooksPage;
    ProductDetailPage detailPage;
    ShoppingCartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        notebooksPage = new LaptopsAndNotebooksPage();
        detailPage = new ProductDetailPage();
        cartPage = new ShoppingCartPage();
    }

    @Test(groups = "sanity")
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){

        homePage.mouseHoverOnLaptopAndNotBook();
        homePage.clickOnMenuOption("Show AllLaptops & Notebooks");

        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : notebooksPage.getListsOfProductPrice()) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);

        notebooksPage.selectSortByZToA("Price (High > Low)");

        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : notebooksPage.getListsOfProductPriceAfterFilter()) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(afterSortByPrice);

        Assert.assertEquals(afterSortByPrice, originalProductsPrice,
                "Product not sorted by price High to Low");

    }

    @Test(groups = "smoke")
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        homePage.mouseHoverOnCurrencyAndClickOn();
        homePage.selectCurrencyAsAPound("£Pound Sterling");

        homePage.mouseHoverOnLaptopAndNotBook();
        homePage.clickOnMenuOption("Show AllLaptops & Notebooks");
        notebooksPage.selectSortByZToA("Price (High > Low)");
        notebooksPage.clickOnYourSelectedProduct("MacBook");
        Assert.assertEquals(detailPage.getPageTitle(), "MacBook",
                "Product not display");
        Thread.sleep(200);
        detailPage.clickOnAddToCartButton();
        Thread.sleep(200);
        Assert.assertTrue(detailPage.getProductAddToCartSuccessMessage()
                        .contains("Success: You have added MacBook to your shopping cart!"),
                "Product not added to cart");
        Thread.sleep(5000);
        detailPage.clickOnShoppingCartLink();
        Thread.sleep(5000);
        Assert.assertTrue(cartPage.getShoppingCartPageTitle().contains("Shopping Cart"));
        Assert.assertEquals(cartPage.getProductName(), "MacBook",
                "Product name not matched");
        cartPage.changeQuantity("2");
        cartPage.clickOnUpdateButton();
        Assert.assertTrue(cartPage.getProductUpdateSuccessMessage().contains("Success: You have modified your shopping cart!"),
                "Cart not modified");
        Assert.assertEquals(cartPage.getProductTotalPrise(), "£737.45",
                "Total not matched");
    }

}
