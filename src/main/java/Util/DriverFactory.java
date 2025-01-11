package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;

    public static WebDriver initializeDriver() {
        if (driver == null) {
            properties = ConfigReader.getProperties();

            String browser = properties.getProperty("browser");
            switch (browser) {
                   case "chrome":
                   WebDriverManager.chromedriver().driverVersion("131.0.6778.265").setup(); // Burada istediğiniz sürümü belirtebilirsiniz
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

            }


            String url = properties.getProperty("url");
            int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
            int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(impWait, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(pageWait, TimeUnit.SECONDS);
        }

        return getDriver();
    }
    public static String takeScreenshot(String testName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir") + "/test-output/" + testName + ".png";
        File destFile = new File(destPath);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destPath;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void terminateDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
