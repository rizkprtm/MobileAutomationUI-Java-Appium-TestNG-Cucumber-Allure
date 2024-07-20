package stepDefinitions;

import com.swaglabs.pageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;

public class loginWithInvalidUserCredentialsSteps {
    LoginPage loginPage = new LoginPage();

    @Given("User enter username as {string} and password as {string}")
    public void user_enter_invalid_user_credentials(String invalidUsername, String invalidPassword) {
        loginPage.loginInvalidUser(invalidUsername, invalidPassword);
    }

    @When("User tap login button")
    public void user_tap_login_button() {
        loginPage.tapLoginBtn();
    }

    @Then("Login failed with an error {string}")
    public void login_failed_with_an_error(String errMsg) {
        Assert.assertEquals(loginPage.getErrMsg(), errMsg);
    }
}
