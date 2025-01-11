package Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static Util.Hooks.log4j;
public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public ElementHelper(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);

    }
    public void click(WebElement key){
        key.click();
    }
    public void sendKeys(WebElement key, String text){
        key.sendKeys(text);
    }

    public void waitUntilClickable(WebElement key){//Öğenin tıklanabilir hale gelmesi
        wait.until(ExpectedConditions.elementToBeClickable(key));
    }

    public void waitUntilVisible(WebElement key){//Öğenin görünür olması
        wait.until(ExpectedConditions.visibilityOf(key));
    }
    public void waitUntilPresent(WebElement key) { //Öğenin mevcut olması
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(key.getAttribute("id"))));
    }
    public void waitUntilInvisible(WebElement key) { //Öğenin görünmez olmasını bekler
        wait.until(ExpectedConditions.invisibilityOf(key));
    }
    public void waitUntilTextContains(WebElement key, String text){// Belirtilen metnin öğenin içinde bulunmasını bekler
        wait.until(ExpectedConditions.textToBePresentInElement(key, text));
    }





}