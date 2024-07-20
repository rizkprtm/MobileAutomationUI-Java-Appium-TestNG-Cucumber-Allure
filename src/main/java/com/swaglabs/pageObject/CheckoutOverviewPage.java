package com.swaglabs.pageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends CheckoutInformationPage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SauceCard #31337\"]")
    private WebElement paymentConfirmation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FREE PONY EXPRESS DELIVERY!\"]")
    private WebElement shippingInformation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Item total: $57.980000000000004\"]")
    private WebElement subTotalItemPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tax: $4.64\"]")
    private WebElement taxPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Total: $62.62\"]")
    private WebElement totalItemPrice;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    private WebElement finishCheckoutBtn;

    public String getPaymentConfirmation(){
        return getText(paymentConfirmation, "Payment Confirmation is");
    }

    public String getShippingInformation(){
        return getText(shippingInformation, "Shipping Information is");
    }

    public String getSubTotalItemPrice() {
        return getText(subTotalItemPrice, "Sub Total Item Price is");
    }

    public String getTaxPrice() {
        return getText(taxPrice, "Tax Price is");
    }

    public String getTotalItemPrice() {
        return getText(totalItemPrice, "Total Item Price is");
    }

    public void scrollToPaymentInformation() {
        scrollToView("Payment Information:");
    }

    public void scrollToShippingInformation() {
        scrollToView("Shipping Information:");
    }

    public void scrollToPriceInformation() throws InterruptedException {
        scrollUntilVisible("Total", "down");
    }

    public void scrollToFinishCheckoutBtn() {
        scrollToView("FINISH");
    }

    public CheckoutCompletePage tapFinishCheckout() {
        click(finishCheckoutBtn);
        return new CheckoutCompletePage();
    }
}
