package com.swaglabs.testRunner;

import com.swaglabs.manager.DriverManager;
import com.swaglabs.manager.ServerManager;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import lombok.Getter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class baseRunner {
    @Getter
    private static TestNGCucumberRunner testNGCucumberRunner;
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws MalformedURLException {
        ServerManager.startServer();
        DriverManager.initializeAndroidDriver();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDownClass() {
        if (testNGCucumberRunner != null) {
            testNGCucumberRunner.finish();
        }
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
        if (ServerManager.getServer() != null) {
            ServerManager.getServer().stop();
        }
    }
}
