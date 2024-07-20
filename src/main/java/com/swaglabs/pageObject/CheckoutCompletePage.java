package com.swaglabs.pageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends CheckoutOverviewPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]")
    private WebElement thankYouForYouOrder;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]")
    private WebElement backHomeBtn;

    public String verifyThankYouForYourOrder() {
        return getText(thankYouForYouOrder, "Text Element is");
    }

    public ProductsPage tapBackHomeBtn() {
        click(backHomeBtn);
        return new ProductsPage();
    }
}
