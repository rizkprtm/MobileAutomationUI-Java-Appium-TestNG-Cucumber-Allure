package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (features ="src/test/resources/features",
                glue ="stepDefinitions",
                tags = "@CheckoutValidUser",
                monochrome = true,
                plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                        "html:Cucumber-Results/cucumber.html"})
public class endToEndCheckoutRunner extends baseRunner {

}
