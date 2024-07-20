package stepDefinitions;

import com.swaglabs.pageObject.CheckoutOverviewPage;
import io.cucumber.java.en.Then;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;

public class checkoutWithInvalidFirstNameSteps {
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    @Then("Continue checkout is failed with an error {string}")
    public void userFirstNameIncorrect(String errMsg) {
        Assert.assertEquals(checkoutOverviewPage.getFirstNameErrMsg(), errMsg);
    }
}
