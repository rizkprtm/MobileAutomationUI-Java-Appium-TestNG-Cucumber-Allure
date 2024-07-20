package testRunner;

import com.swaglabs.manager.DriverManager;
import com.swaglabs.manager.ServerManager;
import io.cucumber.testng.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.net.MalformedURLException;

public class baseRunner {

    TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true)
    public void createSession() throws MalformedURLException {
        ServerManager.startServer();
        DriverManager.initializeAndroidDriver();
    }
    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) {
        XmlTest currentXmlTest = context.getCurrentXmlTest();
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        if(testNGCucumberRunner == null){
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();

    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }
    @AfterSuite
    public void endSession() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
        if (ServerManager.getServer() != null) {
            ServerManager.getServer().stop();
        }
    }
}
