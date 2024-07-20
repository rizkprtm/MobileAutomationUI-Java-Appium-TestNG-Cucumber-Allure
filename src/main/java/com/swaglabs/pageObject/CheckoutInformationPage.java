package com.swaglabs.pageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutInformationPage extends CartPage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
    private WebElement userFirstNameCheckout;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
    private WebElement userLastNameCheckout;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
    private WebElement userPostalCodeCheckout;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    private WebElement continueCheckoutBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"First Name is required\"]")
    private WebElement userInfoErrMsg;

    public void enterFirstName(String firstName) {
        clear(userFirstNameCheckout);
        sendKeys(userFirstNameCheckout,firstName, "FirstName is" + firstName);
    }

    public void enterLastName(String lastName) {
        clear(userLastNameCheckout);
        sendKeys(userLastNameCheckout,lastName, "LastName is" + lastName);
    }

    public void enterPostalCode(String postal_code) {
        clear(userPostalCodeCheckout);
        sendKeys(userPostalCodeCheckout,postal_code, "Postal Code is" + postal_code);
    }

    public void enterUserCheckoutInformation(String firstName, String lastName, String postal_code){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postal_code);
    }

    public CheckoutOverviewPage tapContinueCheckout(){
        click(continueCheckoutBtn, "Tap Continue Checkout");
        return new CheckoutOverviewPage();
    }

    public String getFirstNameErrMsg() {
        return getText(userInfoErrMsg, "Error Message Is" + userInfoErrMsg);
    }
}
