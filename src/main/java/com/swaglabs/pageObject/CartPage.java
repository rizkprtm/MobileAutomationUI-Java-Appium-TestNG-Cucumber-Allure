package com.swaglabs.pageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CartPage extends ProductsPage {

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]")
    private WebElement cartFirstItem;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[2]")
    private WebElement cartSecondItem;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]")
    private WebElement continueShoppingBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    private WebElement checkoutBtn;

    public boolean verifyCartFirstItem() {
        return isElementDisplayed(cartFirstItem);
    }

    public boolean verifyCartSecondItem() {
        return isElementDisplayed(cartSecondItem);
    }

    public void scrollToContinueShoppingBtn(){
        scrollToView("CONTINUE SHOPPING");
    }
    public ProductsPage navigateToProductListFromCartPage() {
        click(continueShoppingBtn, "Tap Continue Shopping Button To Navigate");
        return new ProductsPage();
    }

    public void scrollToCheckoutBtn() {
        scrollToView("CHECKOUT");
    }
    public CheckoutInformationPage navigateToCheckoutInformationPage() {
        click(checkoutBtn);
        return new CheckoutInformationPage();
    }

}
