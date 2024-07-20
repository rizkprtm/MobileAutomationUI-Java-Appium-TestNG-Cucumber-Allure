package com.swaglabs.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private WebElement productListTitleTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private WebElement filterItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (high to low)\"]")
    private WebElement filterPriceHighToLow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
    private WebElement filterPriceLowToHigh;

    @AndroidFindBy(xpath = "xpath=//android.widget.TextView[@content-desc='test-Price")
    private String productPricesLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Onesie\"]")
    private WebElement filteredFirstProductName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$7.99\"]")
    private WebElement filteredFirstProductPrice;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
    private WebElement addToCartFromProductsListBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Fleece Jacket\"]")
    private WebElement filteredSecondProductName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$49.99\"]")
    private WebElement filteredSecondProductPrice;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup")
    private WebElement cartBtn;

    public boolean verifyOnProductsListPage() {
        return isElementDisplayed(productListTitleTxt);
    }

    public void tapFilterBtn() {
        click(filterItem, "Tap Filter Button");
    }

    public void setFilterPriceHighToLow() {
        click(filterPriceHighToLow, "Tap Filter Options");
    }

    public void setFilterPriceLowToHigh() {
        click(filterPriceLowToHigh, "Tap Filter Options");
    }


    public boolean verifyFilteredFirstProductName() {
        return isElementDisplayed(filteredFirstProductName);
    }

    public String verifyFilteredFirstProductPrice() {
        return getText(filteredFirstProductPrice, "Filtered Product Price is");
    }

    public void tapAddToCartFromProductList() {
        click(addToCartFromProductsListBtn, "Tap Add To Cart From Product List Page");
    }

    public boolean verifyFilteredSecondProductName() {
        return isElementDisplayed(filteredSecondProductName);
    }

    public String verifyFilteredSecondProductPrice() {
        return getText(filteredSecondProductPrice, "Filtered Second Product Price is");
    }

    public ProductDetailsPage navigateToSecondProductDetails() {
        click(filteredSecondProductName, "Navigate To Second Product Details");
        return new ProductDetailsPage();
    }

    public CartPage navigateToCartPage() {
        try {
            click(cartBtn, "Tap Cart Icon to Navigate");
            return new CartPage();
        }catch(StaleElementReferenceException exception) {
            cartBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup"));
            click(cartBtn, "Return Tap Cart Icon to Avoid Exception");
            return new CartPage();
        }
    }
}