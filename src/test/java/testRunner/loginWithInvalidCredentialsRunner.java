package com.swaglabs.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = { "src/test/resources/features" },
                glue = { "com.swaglabs.stepsDefinitions" },
                tags ="@InvalidLogin",
                monochrome = true,
                plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumberJvm"})

public class loginWithInvalidCredentialsRunner extends baseRunner {

}
