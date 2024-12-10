package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductDetailPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {

    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductDetailPage detailPage;
    ShoppingCartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        detailPage = new ProductDetailPage();
        cartPage = new ShoppingCartPage();
    }

    @Test(groups = "sanity")
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        homePage.mouseHoverOnDesktop();
        homePage.clickOnMenuOption("Show AllDesktops");

        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListsOfProduct()) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        desktopsPage.selectSortByZToA("Name (Z - A)");

        Thread.sleep(3000);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : desktopsPage.getListsOfProductAfterFilter()) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        Assert.assertEquals(afterSortByZToAProductsName, originalProductsName,
                "Product not sorted into Z to A order");
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "productDetails", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully
            (String product, String qty, String successMessage, String productName, String model, String total) throws InterruptedException {

        homePage.mouseHoverOnCurrencyAndClickOn();
        homePage.selectCurrencyAsAPound("£Pound Sterling");
        homePage.mouseHoverOnDesktop();
        homePage.clickOnMenuOption("Show AllDesktops");
        desktopsPage.selectSortByZToA("Name (A - Z)");
        desktopsPage.clickOnYourSelectedProduct(product);

        detailPage.enterQuantity(qty);
        Thread.sleep(2000);
        detailPage.clickOnAddToCartButton();
        Thread.sleep(2000);
        Assert.assertTrue(detailPage.getProductAddToCartSuccessMessage()
                        .contains(successMessage),
                "Product not added to cart");
        Thread.sleep(2000);
        detailPage.clickOnShoppingCartLink();
        Thread.sleep(2000);
        Assert.assertTrue(cartPage.getShoppingCartPageTitle().contains("Shopping Cart"));
        Assert.assertTrue(cartPage.getProductName().equalsIgnoreCase(productName),
                "Product name not matched");
        Assert.assertTrue(cartPage.getProductModel().equalsIgnoreCase(model),
                "Model not matched");
        Assert.assertEquals(cartPage.getProductTotalPrise(), total,
                "Total not matched");
    }

}
