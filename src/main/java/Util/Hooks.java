package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
import java.util.logging.Logger;

public class Hooks {
    WebDriver driver;
    Properties properties;
    public static Logger log4j = Logger.getLogger(Hooks.class.getName());
    private static ExtentReports extent = ExtentReportManager.getExtentReports();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Before
    public void beforeScenario(Scenario scenario) {
        // Raporlama başlatma
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);

        // Config dosyasını okuma
        properties = ConfigReader.initialize_Properties();

        // WebDriver'ı başlatma
        driver = DriverFactory.initializeDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = DriverFactory.takeScreenshot(scenario.getName());
            test.get().addScreenCaptureFromPath(screenshotPath,"Failed screenshot");
            test.get().fail("Scenario failed: " + scenario.getName());
        } else {
            test.get().pass("Scenario passed: " + scenario.getName());
        }
        // WebDriver'ı kapatma
        DriverFactory.terminateDriver();

        // Raporlama tamamlanması
        extent.flush();
    }


    public static ExtentTest getTest() {
        return test.get();
    }
}
