package com.swaglabs.pageObject;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    @AndroidFindBy (xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private WebElement usernameTxtFld;

    @AndroidFindBy (xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private WebElement passwordTxtFld;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private WebElement loginBtn;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement errTxt;

    public void enterValidUsername(String validUsername) {
        clear(usernameTxtFld);
        sendKeys(usernameTxtFld,validUsername, "Login With" + validUsername);
    }

    public void enterValidPassword(String validPassword) {
        clear(passwordTxtFld);
        sendKeys(passwordTxtFld,validPassword, "Password is" + validPassword);
    }

    public void tapLoginBtn() {
        click(loginBtn, "Tap Login Button");
    }

    public void loginValidUser(String validUsername, String validPassword) {
        enterValidUsername(validUsername);
        enterValidPassword(validPassword);
    }

    public void enterInvalidUsername(String invalidUsername) {
        clear(usernameTxtFld);
        sendKeys(usernameTxtFld,invalidUsername, "Login With" + invalidUsername);
    }

    public void enterInvalidPassword(String invalidPassword) {
        clear(passwordTxtFld);
        sendKeys(passwordTxtFld,invalidPassword, "Login With" + invalidPassword);
    }

    public void loginInvalidUser(String invalidUsername, String invalidPassword) {
        enterInvalidUsername(invalidUsername);
        enterInvalidPassword(invalidPassword);
    }

    public String getErrMsg() throws IllegalStateException {
        return getText(errTxt, "Error Message is" + errTxt);
    }


}

