package com.swaglabs.pageObject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends ProductsPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.\"]")
    private WebElement secondProductDetailsInfo;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]")
    private WebElement addToCartFromProductDetailsBtn;

    public String getSecondProductDetails() {
        return getText(secondProductDetailsInfo, "Verify Second Product Details Info");
    }

    public void scrollToAddToCart() throws InterruptedException {
        scrollUntilVisible("ADD TO CART", "down");
    }

    public void tapAddToCartFromProductDetailsBtn() {
        click(addToCartFromProductDetailsBtn, "Tap Add To Cart Button");
    }
}
